#PR_append = "+pia001"

QT_SGX_DEV_SUPPORT = " \
	qt4-embedded-gles-dev \
	libgles-omap3-dev \
"

RDEPENDS_${PN} += " \
	libsocketcan-dev \
	opencv-dev \
	dbus-c++-dev \
	libusb1-dev \
	qt4-embedded-dev \
	libpcap-dev \
	gpsd-dev \
	libmodbus-dev \
        ${@base_contains('MACHINE_FEATURES', 'sgx', '${QT_SGX_DEV_SUPPORT}', '', d)} \
"
#	libqwt-dev \
#