DESCRIPTION = "Extra utilities and tools for piA systems."
LICENSE = "MIT"

inherit packagegroup


DEV_PACKAGES = " \
	devmem2 \
	evtest \
	gdbserver \
	i2c-tools \
	ldd \
"

SCRIPTING_PACKAGES = " \
	bash util-linux-bash-completion \
	mc-helpers-perl \
	perl \
	python-io python-json python-fcntl \
	mc-helpers-python \
"

RDEPENDS_${PN} = " \
	${DEV_PACKAGES} \
	${SCRIPTING_PACKAGES} \
	htop \
	lrzsz \
	mc mc-fish mc-helpers \
	mosquitto \
	nano \
	picocom \
	setserial \
	sqlite3 \
	stat \
	tcpdump \
	usbutils \
	util-linux-lscpu util-linux-hwclock \
	xz \
"

#	mosquitto-clients libmosquittopp1

RRECOMMENDS_${PN} = " \
"
