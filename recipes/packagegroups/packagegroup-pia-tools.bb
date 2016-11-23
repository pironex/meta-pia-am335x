DESCRIPTION = "Extra utilities and tools for piA systems."
LICENSE = "MIT"

inherit packagegroup


DEV_PACKAGES = " \
	canutils \
	devmem2 \
	evtest \
	gdbserver \
	i2c-tools \
	ldd \
	lrzsz \
"

SCRIPTING_PACKAGES = " \
	bash util-linux-bash-completion \
	bc \
	mc-helpers-perl \
	perl perl-modules \
	python-io python-json python-fcntl \
	mc-helpers-python \
"

RDEPENDS_${PN} = " \
	${DEV_PACKAGES} \
	${SCRIPTING_PACKAGES} \
	htop \
	mc mc-fish mc-helpers \
	nano \
	picocom \
	setserial \
	stat \
	tcpdump \
	usbutils \
	util-linux-lscpu util-linux-hwclock \
	xz \
"

#	mosquitto-clients libmosquittopp1

RRECOMMENDS_${PN} = " \
	libmodbus \
	mosquitto \
	sqlite3 \
"
