require u-boot.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot_2012.12-pia:"

# No patches for other machines yet
COMPATIBLE_MACHINE = "pia-am335x"

DEFAULT_PREFERENCE = "100"
#DEFAULT_PREFERENCE_ti33x = "100"

PV = "2012.12+pia"
PR = "r4"

# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PV}-${PR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

SRC_URI = "git://github.com/pironex/pia-uboot.git;protocol=git;branch=pia-am335x-dev \
	file://pia-am335x-patches.diff \
          "

SRCREV = "84f178821e22b242368c94dc6fd5cd565ac62056"

LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

S = "${WORKDIR}/git"

