FILESEXTRAPATHS_prepend := "${THISDIR}/linux-ti33x-psp_3.2:"

# update package version to kernel version matching the SRCREV
PV = "3.2.51+gitr${SRCPV}"

KERNEL_BRANCH ?= "pia335x-dev"
SRCREV = "${AUTOREV}"

#KERNEL_LOCALVERSION = "gitr${SRCPV}"
MACHINE_KERNEL_PR_append = "+pia007"
KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-${PKGE}-${PKGV}-${MACHINE}-${DATETIME}"
MODULE_IMAGE_BASE_NAME = "modules-${PKGE}-${PKGV}-${MACHINE}-${DATETIME}"

PR = "r30+pia008"

#SRC_URI = "git://192.168.1.90/kernel/linux-pia-bk.git;protocol=git;branch=${KERNEL_BRANCH}
SRC_URI = "git://github.com/pironex/pia-linux-kernel.git;protocol=https;branch=${KERNEL_BRANCH} \
        file://defconfig \
        file://configs \
        file://logo_linux_clut224.ppm \
"
