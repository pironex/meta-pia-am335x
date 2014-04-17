DESCRIPTION = "Touchscreen related packages for piA images."
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
	tslib-calibrate \
	tslib-conf \
	tslib-tests \
"
