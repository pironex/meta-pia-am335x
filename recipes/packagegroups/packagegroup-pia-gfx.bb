DESCRIPTION = "GUI support for LCD/DVI displays"
LICENSE = "MIT"

inherit packagegroup

MACH_PACKAGES = ""
MACH_PACKAGES_pia-am35x += " \
	pia-display-tools \
"

RDEPENDS_${PN} = " \
	${@base_contains("MACHINE_FEATURES", "sgx", "packagegroup-pia-sgx", "",d)} \
	${@base_contains("MACHINE_FEATURES", "touchscreen", "packagegroup-pia-touchsupport", "",d)} \
	packagegroup-pia-qte \
	fbset fbset-modes fb-test \
	omapfbplay mplayer \
" 