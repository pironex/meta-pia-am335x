# Image for assisting in hardware bringup

#require systemd-image.bb
require console-image.bb

IMAGE_INSTALL += " \
	usbutils \
	i2c-tools \
	devmem2 \
	bonnie++ \
	hdparm \
	iozone3 \
	iperf \
	lmbench \
	rt-tests \
	evtest \
	memtester \
	fb-test \
	bc \
	ethtool \
	fixmac \
	iw \
	tcpdump \
	tslib \
	alsa-state \
	dbus-glib \
	glib-2.0 \
	omapfbplay \
	mc \
	qt4-embedded-demos \
	qt-tstat \
	matrix-gui \
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
	gdb gdbserver \
"

IMAGE_FEATURES += "ssh-server-openssh eclipse-debug tools-debug"
export IMAGE_BASENAME = "km-dev"

