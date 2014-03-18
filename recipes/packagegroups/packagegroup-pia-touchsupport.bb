DESCRIPTION = "Touchscreen related packages for piA images."
LICENSE = "MIT"
PR = "r001"

inherit packagegroup

RDEPENDS_${PN} = " \
	tslib-calibrate \
	tslib-conf \
	tslib-tests \
"
