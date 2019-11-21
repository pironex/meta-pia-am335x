DESCRIPTION = "WIFI related packages for piA."
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

BT_PACKAGES = " \
	obexd obex-client \
	pulseaudio-module-loopback pulseaudio-module-bluetooth-discover \
	pulseaudio-module-bluetooth-device \
	bluez4 bluez4-agent bluez-hcidump openobex openobex-apps obexftp ussp-push \
	kernel-module-bluetooth kernel-module-hci-uart kernel-module-btwilnk \
	bt-firmware \
"
#	bluez-tools bt-enable \
#

RDEPENDS_${PN} = " \
	iw wireless-tools \ 
	rfkill \
"
#	linux-firmware \
#	linux-firmware-wl12xx bt-firmware \
#

# TODO check bluetooth-gui wl1271-demo from arago

RRECOMMENDS_${PN}_omap3 = ""

RRECOMMENDS_${PN}_ti33x = " \
	wpa-supplicant \
"
#	ti-compat-wireless-wl18xx \
#
RRECOMMENDS_${PN} = " \
	kernel-module-rtlwifi kernel-module-rtl8192c-common kernel-module-rtl8192cu \
	kernel-module-rt2x00lib kernel-module-rt2x00usb \
	kernel-module-rfcomm kernel-module-rfkill \
	linux-firmware-ralink linux-firmware-rtl8192cu \
	linux-firmware-rtl8192ce linux-firmware-rtl8192su linux-firmware-rtl8192cu \
	linux-firmware-ath9k \
	wl12xx-firmware wlconf \
	${BT_PACKAGES} \
" 

#ti-wifi-utils
#	wl12xx-firmware
