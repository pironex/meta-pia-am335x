# Image for assisting in hardware bringup

#require systemd-image.bb
require console-image.bb

IMAGE_INSTALL += " \
	usbutils \
	i2c-tools \
	devmem2 \
	iw \
	bonnie++ \
	hdparm \
	iozone3 \
	iperf \
	lmbench \
	rt-tests \
	evtest \
	bc \
	ethtool \
	qt4-embedded-demos \
	tslib \
	matrix-gui \
	alsa-state \
	dbus-glib \
	glib-2.0 \
	omapfbplay \
	qt-tstat \
	mc \
	matrix-gui-browser matrix-gui-qt4-demos matrix-gui-armbenchmarks-demos matrix-gui-ethernet-demos matrix-gui-settings-demos \
	tslib tslib-tests tslib-calibrate qt4-embedded-plugin-mousedriver-tslib \
	icu \
"
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

export IMAGE_BASENAME = "mmi-test-console"
