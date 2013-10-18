# common machine settings for AM335x based boards
SOC_FAMILY = "ti33x"

require conf/machine/include/ti33x.inc

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-video-fbdev \
           xf86-input-tslib "

MACHINE_FEATURES = "kernel26 apm vfat "

EXTRA_IMAGEDEPENDS = "u-boot"

PREFERRED_VERSION_bluez4 = "4.101"
PREFERRED_VERSION_wpa-supplicant = "2.0"
PREFERRED_PROVIDER_u-boot = "u-boot"
PREFERRED_PROVIDER_gcc-cross-canadian-arm = "gcc-cross-canadian-arm"
PREFERRED_PROVIDER_binutils-cross-canadian-arm = "binutils-cross-canadian-arm"

# Use v4.09.00.01 of the Graphics SDK
PREFERRED_VERSION_omap3-sgx-modules = "4.09.00.01"
PREFERRED_VERSION_libgles-omap3 = "4.09.00.01"
PREFERRED_PROVIDER_omap3-sgx-modules = "omap3-sgx-modules"
PREFERRED_PROVIDER_libgles-omap3 = "libgles-omap3"
PREFERRED_PROVIDER_virtual/egl = "libgles-omap3"

PREFERRED_PROVIDER_mysql5 = "mariadb"
PREFERRED_PROVIDER_mysql5-native = "mariadb-native"
PREFERRED_PROVIDER_mysql5-client = "mariadb"
PREFERRED_PROVIDER_mysql5-server = "mariadb"

IMAGE_FSTYPES += " tar.bz2 "

# Guesswork
SERIAL_CONSOLE = "115200 ttyO0"

# use real openssh daemon to allow building an SDK as this isn't possible at the moment
# this is set in angstrom conf now
#TASK_BASIC_SSHDAEMON = "openssh-sshd openssh-sftp openssh-sftp-server"