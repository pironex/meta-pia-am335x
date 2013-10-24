# Bjoern Krombholz <b.krombholz@pironex.de> (c) 2011 pironex GmbH
# License: MIT
#
# Filename: pia-led.bb

DESCRIPTION = "Status LED handling for piA-AM35x boards"
LICENSE = "MIT"
PV = "0.1.0"
PR = "r4"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "pia-am35x"

SRC_URI = "\
  file://init.d/led \
"

inherit update-rc.d

INITSCRIPT_NAME = "led"
# start/stop at end of boot/shutdown
INITSCRIPT_PARAMS = "start 99 2 3 4 5 . stop 99 0 6 ."

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init.d/led ${D}${sysconfdir}/init.d
}

FILES_${PN} = " ${sysconfdir}/init.d"

