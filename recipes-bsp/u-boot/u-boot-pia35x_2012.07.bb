require u-boot-pia.inc

COMPATIBLE_MACHINE = "omap3"

DEFAULT_PREFERENCE_pia-am35x = "100"

PV = "2012.12-pia"
PR = "r14"

# should be set in MACHINE conf
UBOOT_MACHINE ?= "am35x_pia_config"

# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

SPL_BINARY = "MLO"

#SRCREV = "65893fb023fa48347a890c4e565fc4bc1cce453b"
SRCREV = "5a94d90e5f9241874e1acaadda2d195a88b887ac"

SRC_URI = " git://github.com/pironex/pia-uboot.git;protocol=git;branch=pia-master \
          "

