require u-boot-pia.inc

# No patches for other machines yet
#COMPATIBLE_MACHINE = "ti33x pia-am335x pia-am335x_e2 pia-am335x_mmi"
COMPATIBLE_MACHINE = "(pia-am335x|pia-am335x_e2|pia-am335x_mmi)"

DEFAULT_PREFERENCE_pia-am335x_e2 = "100"
DEFAULT_PREFERENCE_pia-am335x_mmi = "100"
DEFAULT_PREFERENCE_pia-am335x = "100"
DEFAULT_PREFERENCE_ti33x = "100"

PV = "2012.12-pia"
PR = "r12"

UBOOT_MACHINE ?= "am335x_pia_config"
# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

SPL_BINARY = "MLO"

#SRCREV = "111dba415f7cf83daa64a3aaadcc7e6a31c7b049"
SRCREV = "384e05e4a90e57791d49969f0f13756357b56b2e"

SRC_URI = "git://github.com/pironex/pia-uboot.git;protocol=git;branch=master \
          "
#	file://01_master.diff

