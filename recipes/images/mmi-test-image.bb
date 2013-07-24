# Image for assisting in hardware bringup

#require systemd-gnome-image.bb
require efl-nodm-image.bb

IMAGE_INSTALL += " \
	usbutils \
	i2c-tools \
	devmem2 \
	iw \
	bonnie++ \
	hdparm \
	iozone3 \
	iperf \
	rt-tests \
	evtest \
	bc \
	ethtool \
	canutils \
	qt4-embedded-demos \
	tslib \
"


RRECOMMENDS += " \
	kernel-module-8021q \
"

export IMAGE_BASENAME = "mmi-test-gnome"

