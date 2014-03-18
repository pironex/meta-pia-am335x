# Bjoern Krombholz <b.krombholz@pironex.de> (c) 2011 pironex GmbH
# License: MIT
#
# Filename: pia-watchdog.bb

DESCRIPTION = "Watchdog handling for piA-AM35x boards"
LICENSE = "CLOSED"
PV = "0.1.0"
PR = "r3"

COMPATIBLE_MACHINE = "pia-am35x"

SRC_URI = "\
  file://init.d/watchdog \
  file://watchdog_conf \
  file://src \
"

inherit update-rc.d

INITSCRIPT_NAME = "watchdog"
# start early, kill last
INITSCRIPT_PARAMS = "start 03 2 3 4 5 . stop 99 0 6 ."

S = "${WORKDIR}/src"

do_compile() {
	cd ${S}
	${CC} -o watchdog wdt.c ${LDFLAGS}
}

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init.d/watchdog ${D}${sysconfdir}/init.d

	install -d ${D}${sysconfdir}/default
	install -m 0644 ${WORKDIR}/watchdog_conf ${D}${sysconfdir}/default/
	
	install -d ${D}/usr/sbin
	install -m 0755 ${S}/watchdog ${D}/usr/sbin
}

FILES_${PN} = " ${sysconfdir}/init.d ${sysconfdir}/default \
  ${sysconfdir}/default/watchdog_conf /usr/sbin/watchdog"
CONFFILES_${PN} = "${sysconfdir}/default/watchdog_conf"

PACKAGE_ARCH = "${MACHINE_ARCH}"
