# Image for assisting in hardware bringup

require systemd-image.bb

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
	canutils \
	qt4-embedded-demos \
"

RRECOMMENDS += " \
	kernel-module-8021q \
"

export IMAGE_BASENAME = "e2-test"

