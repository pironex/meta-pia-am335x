require u-boot.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot_2012.12-pia:"

# No patches for other machines yet
COMPATIBLE_MACHINE = "pia-am335x"

DEFAULT_PREFERENCE = "100"
#DEFAULT_PREFERENCE_ti33x = "100"

PV = "2012.12+pia"
PR = "r8"

UBOOT_MACHINE ?= "am335x_pia_mmi_config"
# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

SRC_URI = "git://github.com/pironex/pia-uboot.git;protocol=git;branch=pia-am335x-mmi-dev \
          "
#	file://01_master.diff

SRCREV = "e11b002f864d59f26cc156156ab0d2e64f7e5156"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

