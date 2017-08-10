SECTION = "kernel"
DESCRIPTION = "Linux kernel for pironex TI SoC based devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc
#require recipes-kernel/linux/cmem.inc

# Look in the generic major.minor directory for files
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.4:"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

# Add a run-time dependency for the PM firmware to be installed
# on the target file system.
RDEPENDS_kernel-base_append_ti33x = " amx3-cm3"

# Default is to package all dtb files for ti33x devices unless building
# for the specific beaglebone machine.
KERNEL_DEVICETREE_ti33x = "am335x-pia-base.dtb am335x-pia-dr.dtb am335x-pia-sf.dtb am335x-pia-sk.dtb am335x-pia-cantft.dtb"
KERNEL_DEVICETREE_ti33x += " am335x-evm.dtb am335x-evmsk.dtb am335x-bone.dtb am335x-boneblack.dtb"

# this is relevant for uImages
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT} V=1"

COMPATIBLE_MACHINE = "ti33x|pia-am335x|pia-am335x-dr"

S = "${WORKDIR}/git"

BRANCH = "${KERNEL_BRANCH}"

# 4.4.8 Release
#SRCREV = "23d362ec2b0fc00ede3bbd100556a50ab920a898"
#SRCREV = "d865ffe06e316b310ddee57a6910d14d6c961a5a"
# sham fix
#SRCREV = "6ba69c3a5385ead7afff49fa8738639184ab37d2"
# 4.4.22 ti-merge
SRCREV = "e5a441aa1a1e47347ad85bcb434c048eb29c6ad3"

PV = "4.4.22+git${SRCPV}"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

MULTI_CONFIG_BASE_SUFFIX = ""

KERNEL_GIT_URI = "git://github.com/pironex/pia-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI += "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig"
