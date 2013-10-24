/**
 * 	\mainpage Watchdog library for use with piA-AM35x and piAX-AM35x.
 *	\file wdt.h
 * 	\brief Header file for all #define constants and function prototypes
 *
 *  Created on: Nov 7, 2011
 *      Author: ml
 */

#ifndef WDT_H_
#define WDT_H_

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <sys/ioctl.h>
#include <errno.h>
#include <unistd.h>
#include <getopt.h>

/* Activate debug messages */
//#define DEBUG_ON

/**
 * Command codes for the new ioctl's of the kernel driver (DS1374).
 * See linux-omap-2.6/Documentation/ioctl/ for documentation.
 */
#define DS1374_WDT_ON			0x00005764
#define DS1374_WDT_OFF			0x00005765
#define DS1374_WDT_SETTIMEOUT	0x40045766
#define DS1374_WDT_PING			0x00005767

/**
 * Watchdog timeouts
 */
#define WDT_STD_INTERVAL_S		60				// 60s
#define WDT_TIMEOUT_MIN			5				// 5s
#define WDT_TIMEOUT_MAX			24*60*60		// 24h

/*********************** Function prototypes *******************************/

/*
 * wdt_enable()
 * Enable watchdog timer, activate watchdog reset
 */
int wdt_enable();

/*
 * wdt_disable()
 * Disable watchdog timer, deactivate watchdog reset
 */
int wdt_disable();

/*
 * wdt_settimeout()
 * Set interval of the watchdog timer
 */
int wdt_settimeout(unsigned int );

/*
 * wdt_ping()
 * Kick the watchdog...
 */
int wdt_ping(const char *dev);

#endif /* WDT_H_ */
