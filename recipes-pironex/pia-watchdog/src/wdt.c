/*---------------------------------------------------------------------*/
/**
 * @file wdt.c
 *
 *  \brief This file contains all function implementations for accessing
 *  the watchdog DS1374 via kernel driver
 *
 * \version $Id: wdt.c  2011-11-04$
 *
 * \author Copyright (c) 2011 ml
 *
 * \remarks
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 */
 /*---------------------------------------------------------------------*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <sys/ioctl.h>
#include <errno.h>
#include <unistd.h>
#include <getopt.h>
#include "wdt.h"

static int fd;																	/* File handler for accessing the watchdog kernel driver (DS1374) */

static void print_usage(FILE * stream, char *app_name, int exit_code)
{
	fprintf(stream, "Usage: %s [options]\n", app_name);
	fprintf(stream,
	" -h  --help                Display this usage information.\n"
	" -s  --stop                Deactivate the watchdog.\n"
	" -d  --dev <device_file>   Use <device_file> as watchdog device file.\n"
	"                           The default device file is '/dev/rtc0'\n"
	" -i  --interval <interval> Change the watchdog interval time.\n"
	"                           Minimum interval time is 5 seconds,\n"
	"                           maximum interval time is 24h\n.");

	exit(exit_code);
}

static const char *const short_options = "hsd:i:";
static const struct option long_options[] = {
		{"help", 0, NULL, 'h'},
		{"stop", 0, NULL, 's'},
		{"dev", 1, NULL, 'd'},
		{"interval", 1, NULL, 'i'},
		{NULL, 0, NULL, 0},
};

enum {
	wdt_off,
	wdt_on,
}wdt_state;

int main(int argc, char **argv)
{
	int res;						/**< communication result */
	int t_sleep;					/**< sleep timer timeout*/
	int option;						/**< getopt iteration var */
	unsigned int wdt_interval_s;	/**< Watchdog timeout interval (in secs) */
	char *dev;						/**< Watchdog device file */

	/* init variables */
	res = 0;
	t_sleep = 30;
	wdt_interval_s = 0;
	dev = "/dev/rtc0";
	wdt_state = wdt_on;

	/* Parse arguments if any */
	do {
		option = getopt_long(argc, argv, short_options, long_options, NULL);
		switch (option) {
			case 'h':
				print_usage(stdout, argv[0], EXIT_SUCCESS);
				break;
			case 's':
				wdt_state = wdt_off;
				break;
			case 'd':
				dev = optarg;
				break;
			case 'i':
				wdt_interval_s = atoi(optarg);
				break;
			case '?':
				print_usage(stdout, argv[0], EXIT_FAILURE);
				break;
			case -1:   /* Done with options */
				break;
			default:   /* Unexpected stuffs */
				print_usage(stdout, argv[0], EXIT_FAILURE);
				abort();
				break;
		}
	} while (option != -1);


/********************************* disable watchdog reset *******************************************/
	if(wdt_state == wdt_off){

		int i;
		for(i = 0; i < 3; i++) {
			/* Open watchdog device file */
			fd = open(dev, O_RDWR);
			/* Jump out, if watchdog device file is open */
			if(fd >= 0)
				break;
		}

		/* Exit program, if watchdog device file could not be opened */
		if(fd < 0){
			fprintf(stderr, "Error: Could not disable watchdog : opening of watchdog device file failed after 3 tries.\n");
			exit(-1);
		}

		if(wdt_disable() == 0){
#ifdef DEBUG_ON
			fprintf(stdout, "Watchdog disabled...\n");
#endif
			/* Kill all running watchdog processes*/
			system("killall watchdog");
			exit(-1);
		}
	}
/****************************************************************************************************/


/*************************** Set timeout and enable watchdog reset **********************************/
	/* Open watchdog device file */
	fd = open(dev, O_RDWR);
	if(fd < 0) {
		fprintf(stderr,"Error: Could not open device file %s: %s\n", dev, strerror(errno));
		exit(-1);
	}

	/* set timeout to watchdog timer */
	wdt_interval_s = wdt_settimeout(wdt_interval_s);
	if(wdt_interval_s){
#ifdef DEBUG_ON
		fprintf(stdout,"Watchdog timer sucessfully initialized. Timeout set to %d seconds.\n", wdt_interval_s);
#endif
	}

	/* enable watchdog reset */
	if(wdt_enable() == 0){
#ifdef DEBUG_ON
		fprintf(stdout, "Watchdog enabled...\n");
#endif
	}

	/* close file descriptor, allow other programs to communicate with the device */
	close(fd);

/****************************************************************************************************/

	/* loop forever */
	while(1) {
		/* set timeout for sleep */
		t_sleep = wdt_interval_s - 3;

		/* ignore delivery of a signal */
		while(t_sleep > 1){
			t_sleep = sleep(t_sleep);
		}

		/* kick the watchdog */
		wdt_ping(dev);
	}

	return 0;
}

/** adjust the timeout of the watchdog timer
	\param new_timeout New timeout value for the watchdog timer.
	\return adjusted timeout value.
 */
unsigned int adjust_timeout(unsigned int new_timeout)
{
	if (new_timeout < WDT_TIMEOUT_MIN) {
		new_timeout = WDT_STD_INTERVAL_S;
#ifdef DEBUG_ON
		fprintf(stdout,"Minimum timeout is %ds. Set timeout to its minimal value (%ds)\n",WDT_TIMEOUT_MIN, WDT_TIMEOUT_MIN);
#endif
	} else if (new_timeout > WDT_TIMEOUT_MAX) {
		new_timeout = WDT_TIMEOUT_MAX;
#ifdef DEBUG_ON
		fprintf(stdout,"Maximum timeout is %ds. Set timeout to its maximum value (%ds)\n",WDT_TIMEOUT_MAX, WDT_TIMEOUT_MAX);
#endif
	}

	return new_timeout;
}

/** load new timeout value into watchdog timer
	\param wdt_interval_s Timeout value in seconds.
	\return Timeout value in seconds.
 */
int wdt_settimeout(unsigned int wdt_interval_s)
{
	/* adjust watchdog timeout */
	wdt_interval_s = adjust_timeout(wdt_interval_s);

	/* calculate value for watchdog timer (frequency of 1/4096Hz) */
	int wdt_timeout = wdt_interval_s * 4096;

	if(ioctl(fd, DS1374_WDT_SETTIMEOUT, &wdt_timeout) == -1) {
		fprintf(stderr,"Error: Failed to communicate with kernel driver: %s",strerror(errno));
		exit(-1);
	}

	return wdt_interval_s;
}

/** Enable the watchdog timer and reset.
 * \return Return value of ioctl().
 */
int wdt_enable()
{
	return ioctl(fd, DS1374_WDT_ON);
}

/** Disable the watchdog timer and reset.
 * \return Return value of ioctl().
 */
int wdt_disable()
{
	return ioctl(fd, DS1374_WDT_OFF);
}

/** Kick the watchdog to reload the timer value.
 * \param *dev Pointer to the device file.
 * \return Return value of ioctl().
 */
int wdt_ping(const char *dev)
{
#ifdef DEBUG_ON
	fprintf(stdout,"Kicking Watchdog...\n");
#endif
	int res;

	/* Open watchdog device file */
	fd = open(dev, O_RDWR);
	if(fd < 0) {
		fprintf(stderr,"Error: Could not open device file %s: %s\n", dev, strerror(errno));
		exit(-1);
	}

	res = ioctl(fd, DS1374_WDT_PING);

	/* close file descriptor, allow other programs to communicate with the device */
	close(fd);

	return res;
}


