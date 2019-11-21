DESCRIPTION = "GSM/GPRS related packages for piA."
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

EXTRA_DEPENDS = ""
EXTRA_DEPENDS_pia-am35x = " pia-gprs \
"

EXTRA_DEPENDS_pia-am335x += " gpsd gps-utils gpsd-machine-conf "

EXTRA_RRECOMMENDS = ""

EXTRA_RRECOMMENDS_pia-am335x += "pia-gprshelper"

RDEPENDS_${PN} = " \
	ppp ppp-tools \
	${EXTRA_DEPENDS} \
"

#	TODO libgsm1

RRECOMMENDS_${PN} = " \
	kernel-module-option \
	kernel-module-ppp-async \
	kernel-module-ppp-generic \
	kernel-module-n-gsm \
	${EXTRA_RRECOMMENDS} \
"

