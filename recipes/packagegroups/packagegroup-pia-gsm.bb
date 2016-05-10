DESCRIPTION = "GSM/GPRS related packages for piA."
LICENSE = "MIT"

inherit packagegroup

EXTRA_DEPENDS = ""
EXTRA_DEPENDS_pia_am35x = " pia-gprs \
"

EXTRA_DEPENDS_pia += " gpsd gps-utils gpsd-machine-conf "

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
"

