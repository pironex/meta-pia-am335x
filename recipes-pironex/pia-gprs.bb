# Bjoern Krombholz <b.krombholz@pironex.de> (c) 2012 pironex GmbH
# License: MIT
#
# Filename: pia-gprs.bb

DESCRIPTION = "GPRS init scripts and device handling for piA-AM35x boards"
LICENSE = "MIT"
PV = "0.1.0"
PR = "r011"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "pia-am35x"

RDEPENDS = "ppp-gprs"

SRC_URI = "\
  file://init.d/gprs \
  file://init.d/mkcmuxdev.sh \
  file://default/gprs \
  file://pia-gprs/src \
  file://pia-gprs/src/linux \
"

inherit update-rc.d

INITSCRIPT_NAME = "gprs"
# don't start automatically, run from network scripts
# INITSCRIPT_PARAMS = "start 99 2 3 4 5 . stop 99 0 6 ."

S = "${WORKDIR}/pia-gprs/src"

do_compile() {
        cd ${S}
        ${CC} -o cmux -I./ main.c ${LDFLAGS}
}


do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init.d/gprs ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/init.d/mkcmuxdev.sh ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/default/gprs ${D}${sysconfdir}/default/
	install -d ${D}/usr/sbin
	install -m 0755 ${S}/cmux ${D}/usr/sbin
}

FILES_${PN} = " ${sysconfdir}/init.d \
        ${sysconfdir}/init.d/gprs \
        ${sysconfdir}/init.d/mkcmuxdev.sh \
        ${sysconfdir}/default/gprs \
        /usr/sbin/cmux"

CONFFILES_${PN} = " ${sysconfdir}/init.d/gprs ${sysconfdir}/default/gprs  \
	${sysconfdir}/init.d/mkcmuxdev.sh"