DESCRIPTION = "WIFI related packages for piA."
LICENSE = "MIT"

inherit packagegroup

BT_PACKAGES = " \
	obexd obex-client \
	pulseaudio pulseaudio-server \
	pulseaudio-module-loopback pulseaudio-module-bluetooth-discover \
	pulseaudio-module-bluetooth-device \
	bluez4 bluez4-agent bluez-hcidump openobex openobex-apps obexftp ussp-push \
"
#	bluez-tools bt-enable \
#

RDEPENDS_${PN} = " \
	iw wireless-tools \ 
	rfkill wpa-supplicant \
	linux-firmware \
"
#	linux-firmware-wl12xx bt-firmware \
#

# TODO check bluetooth-gui wl1271-demo from arago

RRECOMMENDS_${PN} = " \
	kernel-module-rtlwifi kernel-module-rtl8192c-common kernel-module-rtl8192cu \
	kernel-module-rt2x00lib kernel-module-rt2x00usb \
	kernel-module-rfcomm kernel-module-rfkill \
" 

#ti-wifi-utils
#	wl12xx-firmware
