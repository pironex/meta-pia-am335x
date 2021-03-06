# Image for assisting in hardware bringup

require pia335x-full-image.bb

IMAGE_INSTALL += " \
	matrix-gui \
	omapfbplay \
	mc \
	matrix-gui-browser matrix-gui-qt4-demos matrix-gui-armbenchmarks-demos matrix-gui-ethernet-demos matrix-gui-settings-demos \
	tslib tslib-tests tslib-calibrate qt4-embedded-plugin-mousedriver-tslib \
	icu \
"
#	qt4-embedded-demos \
#	libgles-omap3 \
#	libgles-omap3-blitwsegl \
#	libgles-omap3-flipwsegl \
#	libgles-omap3-frontwsegl \
#	libgles-omap3-linuxfbwsegl \
#	libgles-omap3-rawdemos \
#	omap3-sgx-modules \
#

RRECOMMENDS += " \
	kernel-module-8021q \
"

export IMAGE_BASENAME = "mmi-test"

