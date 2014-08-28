DESCRIPTION = "Additional packages for piA AM35x"
LICENSE = "MIT"

inherit packagegroup

SYSTOOLS_PACKAGES = " \
	bzip2 \
	coreutils \
	devmem2 \
	dosfstools \
	ethtool \
	fixmac \
	i2c-tools \
	iproute2 \
	mmc-utils \
	mtd-utils \
	net-tools \
	ntpdate \
	procps \
	tar \
	links \
	nano \
	screen \
	lmsensors-sensors \
	connman-client connman-tests connman-tools connman-angstrom-settings \
	cronie \
"

TOOLS_PACKAGES = " \
	bc \
	less \
	tcpdump \
	picocom \
"

KERNELMOD_PACKAGES = " \
	linux-firmware-ralink linux-firmware-wl12xx linux-firmware-rtl8192cu \
	linux-firmware-rtl8192ce linux-firmware-rtl8192su linux-firmware-rtl8192cu \
	linux-firmware-ath9k linux-firmware-wl12xx \
	kernel-module-g-serial \
	kernel-module-bluetooth kernel-module-hci-uart kernel-module-btwilnk \
	kernel-module-usbserial \
	kernel-module-omap-aes kernel-module-omap-sham \
	kernel-module-dm9601 \
"

MACH_PACKAGES = ""
MACH_PACKAGES_pia-am35x += " \
	pia-led \
	pia-watchdog \
"

MACH_PACKAGES_pia-am335x-apc += " \
	gpsd \
"

RDEPENDS_${PN} = ' \
	${SYSTOOLS_PACKAGES} \
	${TOOLS_PACKAGES} \
	${MACH_PACKAGES} \
	\
	tzdata tzdata-europe \
	\
	openssl openssl-engines openssl-misc \
	\
	lighttpd lighttpd-module-cgi lighttpd-module-fastcgi \
	lighttpd-module-rewrite lighttpd-module-simple-vhost \
	lighttpd-module-status \
	sqlite3 \
'

RRECOMMENDS_${PN} = ' \
	${KERNELMOD_PACKAGES} \
	busybox-hwclock \
'
# 	kernel-modules