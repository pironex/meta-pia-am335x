#!/bin/sh

if [ ! -e /etc/default/gprs ] ; then exit 0 ; fi

. /etc/default/gprs

if [ "$GPRS_ENABLED" != "true" ] ; then exit 0 ; fi

if [ "$ENABLE_PING_MONITOR" != "true" ] ; then exit 0 ; fi

SCRIPT_NAME=$(basename $0)
PPP_SERVICE="ppp.service"

MAX_FAILS=2

# URL used in ping test to verify internet connection
# can be overridden in /etc/default/gprs
ping_target=${PING_MONITOR_TARGET:-"de.pi-server.de"}

cmdkillall=/usr/bin/killall
cmdping=/bin/ping
cmdsystemctl=/bin/systemctl

failcount_file=/tmp/ppp_failcount

# create a failcounter if not there yet (in /tmp = RAM)
if [ ! -e "${failcount_file}" ] ; then
	echo 0 > "${failcount_file}"
fi

# Write log messages to syslog
log() {
  # Don't echo to stdout b/c syslog will get the message twice
  # due to auto logging of systemd scripts.
  #echo "$@"
  logger -p syslog.notice -t "${SCRIPT_NAME}" "$@"
}

# Write error log messages to syslog
err() {
  # Don't echo to stderr b/c syslog will get the message twice
  # due to auto logging of systemd scripts.
  #echo "$@" &gt;&amp;2
  logger -p syslog.error -t "${SCRIPT_NAME}" "$@"
}

#
# Main
#
log "testing inet connection status"

# is-active returns a string "active" when a service is enabled and active
# if ppp is not enabled we don't want to do anything
active_conn=$(systemctl is-active ${PPP_SERVICE})
ping -c 1 ${ping_target} 2>&1 > /dev/null && ping_success="true" || ping_success="false"

if [ "$active_conn" = "active" -a "$ping_success" != "true" ]; then
  failcount=$(( `cat "${failcount_file}"` + 1 ))
  echo $failcount > "${failcount_file}"
  log " connection exists but PING to ${ping_target} failed: " $failcount
  if [ "$failcount" -ge "$MAX_FAILS" ] ; then
    log " maximum number of ping failures reached, killing ppp service to force reconnect"
    killall pppd
    # reset counter by removing the file
    rm "${failcount_file}"
  fi
elif [ -z "$active_conn" ]; then
  log " ppp service not active!"
else
  log " PING -> PONG"
  echo 0 > "${failcount_file}"
fi
