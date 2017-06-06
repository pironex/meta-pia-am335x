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

EXTRA_IMAGEDEPENDS += "u-boot"

PREFERRED_PROVIDER_virtual/kernel = "linux-ti-staging"
PREFERRED_PROVIDER_virtual/bootloader = "u-boot-pia"
PREFERRED_PROVIDER_u-boot = "u-boot-pia"

KERNEL_IMAGETYPE = "zImage"

UBOOT_ARCH = "arm"
UBOOT_MACHINE = "am335x_pia_defconfig"

IMAGE_FSTYPES += "tar.xz"

# Guesswork
SERIAL_CONSOLE = "115200 ttyO0"
