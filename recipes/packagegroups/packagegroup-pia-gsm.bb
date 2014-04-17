DESCRIPTION = "GSM/GPRS related packages for piA."
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
	ppp ppp-tools \
	pia-gprs \
"
#	TODO libgsm1

RRECOMMENDS_${PN} = " \
 	kernel-module-option \
	kernel-module-ppp-async \
	kernel-module-ppp-generic \
	kernel-module-n-gsm \
" 