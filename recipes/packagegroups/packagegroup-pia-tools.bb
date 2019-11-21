DESCRIPTION = "Extra utilities and tools for piA systems."
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

DEV_PACKAGES = " \
	diffutils \
	gdbserver gdb \
	lrzsz \
	lsof \
	netcat \
	socat \
	strace \
"

HWTEST_PACKAGES = " \
	canutils \
	devmem2 \
	evtest \
	i2c-tools \
	mmc-utils \
	memtester \
"

SCRIPTING_PACKAGES = " \
	bash \
	bc \
	python-io python-fcntl \
"

RDEPENDS_${PN} = " \
	${DEV_PACKAGES} \
	${SCRIPTING_PACKAGES} \
	${HWTEST_PACKAGES} \
	coreutils \
	dosfstools \
	mc mc-fish mc-helpers \
	nano \
	net-tools \
	picocom \
	setserial \
	stat \
	tcpdump \
	usbutils \
	util-linux util-linux-lscpu util-linux-hwclock \
	bzip2 gzip xz \
"

#	mosquitto-clients libmosquittopp1

RRECOMMENDS_${PN} = " \
	can-utils \
	e2fsprogs-tune2fs e2fsprogs-resize2fs e2fsprogs-mke2fs \
	iotop \
	iputils \
	iw rfkill wireless-tools \
	openvpn \
	parted \
"
