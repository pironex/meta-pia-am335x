DESCRIPTION = "Extra utilities and tools for piA systems."
LICENSE = "MIT"

inherit packagegroup


DEV_PACKAGES = " \
	canutils \
	devmem2 \
	evtest \
	gdbserver gdb \
	i2c-tools \
	iotop \
	ldd \
	lrzsz \
	lsof \
	mmc-utils \
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
	net-tools \
	picocom \
	procps \
	setserial \
	stat \
	tcpdump \
	tmux \
	usbutils \
	util-linux util-linux-lscpu util-linux-hwclock \
	xz \
"

#	mosquitto-clients libmosquittopp1

RRECOMMENDS_${PN} = " \
	cifs-utils \
	libmodbus \
	mosquitto \
	sqlite3 \
"
