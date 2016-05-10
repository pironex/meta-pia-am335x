# common machine settings for AM335x based boards
require conf/machine/include/ti33x.inc

PREFERRED_PROVIDER_virtual/xserver = "xserver-xorg"
XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-video-fbdev \
           xf86-input-tslib "

#MACHINE_FEATURES = "kernel26 apm usbgadget usbhost vfat ext2 screen alsa ethernet sgx"
# override ti33x features as we don't support SGX, ALSA, USB, Screen on every board
MACHINE_FEATURES = "kernel26 apm vfat ext2 ethernet "

KERNEL_IMAGETYPE = "zImage"
EXTRA_IMAGEDEPENDS = "u-boot"

PREFERRED_PROVIDER_virtual/kernel = "linux-ti-staging"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-pia"
PREFERRED_PROVIDER_u-boot = "u-boot-pia"

#UBOOT_CONFIG = "am335x_pia_defconfig"
UBOOT_MACHINE = "am335x_pia_defconfig"
UBOOT_ARCH = "arm"

# Use v4.09.00.01 of the Graphics SDK
#PREFERRED_PROVIDER_virtual/libgl = "mesa-gl"
#PREFERRED_PROVIDER_virtual/egl = "libgles-omap3"
#PREFERRED_PROVIDER_virtual/libgles1 = "libgles-omap3"
#PREFERRED_PROVIDER_virtual/libgles2 = "libgles-omap3"
#PREFERRED_PROVIDER_virtual/mesa = "mesa-gl"

IMAGE_FSTYPES += " tar.bz2 "

# Guesswork
SERIAL_CONSOLE = "115200 ttyO0"
