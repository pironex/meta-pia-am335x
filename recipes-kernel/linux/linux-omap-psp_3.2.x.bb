require recipes-kernel/linux/linux.inc

DESCRIPTION = "Linux kernel for piA-AM35x boards"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE = "(omap3)"

PV = "3.2.54+gitr${SRCPV}"

# pia35x_release_3.2_201310
#SRCREV = "135789084f0bf303771170a8728d1b946ee8a92d"
SRCREV = "${AUTOREV}"
MACHINE_KERNEL_PR_append = "r011+gitr${SRCREV}"

KERNEL_BRANCH = "pia35x-3.2-dev"

KERNEL_IMAGE_BASE_NAME = "${KERNEL_IMAGETYPE}-${PKGE}-${PKGV}-${MACHINE}-${DATETIME}"
MODULE_IMAGE_BASE_NAME = "modules-${PKGE}-${PKGV}-${MACHINE}-${DATETIME}"

#local git:
#SRC_URI = "git://192.168.1.90/kernel/linux-pia-bk.git;branch=${KERNEL_BRANCH};protocol=git"
SRC_URI = "git://github.com/pironex/pia-linux-kernel.git;protocol=https;branch=${KERNEL_BRANCH} \
           file://defconfig \
"

SRC_URI_append_pia-am35x = " file://logo_linux_clut224.ppm \
"

# module_autoload_g_serial = "g_serial"

#SRC_URI_append_pia-am35x = "\
#    file://patches/0001-master_to_pia_testing_ems.patch "

S = "${WORKDIR}/git"

#do_configure_prepend() {
#	cp ${WORKDIR}/files/logo_linux_clut224.ppm ${WORKDIR}/git/drivers/video/logo/ 
#}