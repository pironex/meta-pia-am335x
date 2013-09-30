require u-boot-pia.inc

# No patches for other machines yet
COMPATIBLE_MACHINE = "pia-am335x"

DEFAULT_PREFERENCE = "100"
#DEFAULT_PREFERENCE_ti33x = "100"

PV = "2012.12+pia"
PR = "r11"

UBOOT_MACHINE ?= "am335x_pia_e2_config"
# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

SPL_BINARY = "MLO"

SRC_URI = "git://github.com/pironex/pia-uboot.git;protocol=git;branch=pia-am335x-mmi-dev \
          "
#	file://01_master.diff

SRCREV = "111dba415f7cf83daa64a3aaadcc7e6a31c7b049"
