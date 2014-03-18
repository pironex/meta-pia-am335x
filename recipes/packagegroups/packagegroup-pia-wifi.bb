DESCRIPTION = "WIFI related packages for piA."
LICENSE = "MIT"
PR = "r001"

inherit packagegroup

BT_PACKAGES = " \
	bluez-tools \
	obexd obex-client \
	pulseaudio pulseaudio-server \
	pulseaudio-module-loopback pulseaudio-module-bluetooth-discover \
	pulseaudio-module-bluetooth-device \
	bt-enable \
	bluez4 bluez4-agent bluez-hcidump openobex openobex-apps obexftp ussp-push \
"

RDEPENDS_${PN} = " \
	iw wireless-tools \ 
	rfkill wpa-supplicant \
"
# TODO check bluetooth-gui wl1271-demo from arago

RRECOMMENDS_${PN} = " \
	kernel-module-rtlwifi kernel-module-rtl8192c-common kernel-module-rtl8192cu \
	kernel-module-rt2x00lib kernel-module-rt2x00usb \
	kernel-module-rfcomm kernel-module-rfkill \
	kernel-module-wl1251 kernel-module-wl1251-sdio \
	bt-firmware wl12xx-firmware \
" 

#ti-wifi-utils
#	wl12xx-firmware
