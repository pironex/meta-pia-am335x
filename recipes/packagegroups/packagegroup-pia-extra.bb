DESCRIPTION = "Extra utilities and tools for piA systems."
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

SCRIPTING_PACKAGES = " \
	util-linux-bash-completion \
	mc-helpers-perl \
	perl perl-modules \
	python-json \
	mc-helpers-python \
"

RDEPENDS_${PN} = " \
	${SCRIPTING_PACKAGES} \
	htop \
	ldd \
	nmon \
	procps \
	rsync \
	tmux \
"

RRECOMMENDS_${PN} = " \
	cifs-utils \
	findutils \
	iotop \
	iw rfkill wireless-tools \
	linux-firmware \
	latencytop \
	less \
	libmodbus \
	libnfc-nci \
	mosquitto \
	sqlite3 \
	wget \
"
