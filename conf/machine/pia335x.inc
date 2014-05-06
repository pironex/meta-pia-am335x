# common machine settings for AM335x based boards
require conf/machine/include/ti33x.inc

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-video-fbdev \
           xf86-input-tslib "

MACHINE_FEATURES = "kernel26 apm vfat ext2 ethernet "

EXTRA_IMAGEDEPENDS = "u-boot"

PREFERRED_VERSION_bluez4 = "4.101"
PREFERRED_VERSION_wpa-supplicant = "2.0"
PREFERRED_PROVIDER_u-boot = "u-boot"
##PREFERRED_PROVIDER_gcc-cross-canadian-arm = "gcc-cross-canadian-arm"
##PREFERRED_PROVIDER_binutils-cross-canadian-arm = "binutils-cross-canadian-arm"

PIA_QT_PROVIDER = "${@base_contains('MACHINE_FEATURES','sgx','qt4-embedded-gles','qt4-embedded',d)}"
PREFERRED_PROVIDER_qt4-embedded = "${PIA_QT_PROVIDER}"
#PREFERRED_PROVIDER_qt4-embedded = "qt4-embedded-gles"

PREFERRED_VERSION_qt4-embedded = "4.8.4"
PREFERRED_VERSION_qt4-native = "4.8.4"
PREFERRED_VERSION_nativesdk-qt4-tools = "4.8.4"

PREFERRED_PROVIDER_virtual/kernel = "linux-am335x-psp"

# Use v4.09.00.01 of the Graphics SDK
PREFERRED_PROVIDER_virtual/libgl = "mesa-gl"
PREFERRED_PROVIDER_virtual/egl = "libgles-omap3"
PREFERRED_PROVIDER_virtual/libgles1 = "libgles-omap3"
PREFERRED_PROVIDER_virtual/libgles2 = "libgles-omap3"
PREFERRED_PROVIDER_virtual/mesa = "mesa-gl"
PREFERRED_PROVIDER_omap3-sgx-modules = "omap3-sgx-modules"
PREFERRED_PROVIDER_libgles-omap3 = "libgles-omap3"
PREFERRED_VERSION_omap3-sgx-modules = "5.00.00.01"
PREFERRED_VERSION_libgles-omap3 = "5.00.00.01"

PREFERRED_PROVIDER_mysql5 = "mariadb"
PREFERRED_PROVIDER_mysql5-native = "mariadb-native"
PREFERRED_PROVIDER_mysql5-client = "mariadb"
PREFERRED_PROVIDER_mysql5-server = "mariadb"

PREFERRED_PROVIDER_wl12xx-firmware = "wl12xx-firmware"

IMAGE_FSTYPES += " tar.bz2 "

# Guesswork
SERIAL_CONSOLE = "115200 ttyO0"
