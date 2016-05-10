SECTION = "kernel"
DESCRIPTION = "Linux kernel for pironex TI SoC based devices"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc
require recipes-kernel/linux/multi-kernel.inc
#require recipes-kernel/linux/cmem.inc

# Look in the generic major.minor directory for files
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-4.4:"

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

# Add a run-time dependency for the PM firmware to be installed
# on the target file system.
RDEPENDS_kernel-base_append_ti33x = " amx3-cm3"
RDEPENDS_kernel-base_append_ti43x = " amx3-cm3"

# Add a run-time dependency for the VPE VPDMA firmware to be installed
# on the target file system.
#RDEPENDS_kernel-base_append_dra7xx = " vpdma-fw"

# Install boot-monitor skern file into /boot dir of rootfs
#RDEPENDS_kernel-base_append_keystone = " boot-monitor"

# Default is to package all dtb files for ti33x devices unless building
# for the specific beaglebone machine.
KERNEL_DEVICETREE_ti33x = "am335x-evm.dtb am335x-evmsk.dtb am335x-bone.dtb am335x-boneblack.dtb am335x-pia-base.dtb am335x-pia-dr.dtb am335x-pia-sk.dtb am335x-pia-cantft.dtb"
#KERNEL_DEVICETREE_ti43x = "am43x-epos-evm.dtb am43x-epos-evm-hdmi.dtb am437x-gp-evm.dtb am437x-gp-evm-hdmi.dtb am437x-sk-evm.dtb"
#KERNEL_DEVICETREE_beaglebone = "am335x-bone.dtb am335x-boneblack.dtb"
#KERNEL_DEVICETREE_omap5-evm = "omap5-uevm.dtb"
#KERNEL_DEVICETREE_dra7xx-evm = "dra7-evm.dtb dra7-evm-lcd-lg.dtb dra7-evm-lcd-osd.dtb dra72-evm.dtb dra72-evm-lcd-lg.dtb dra72-evm-lcd-osd.dtb"
#KERNEL_DEVICETREE_am57xx-evm = "am57xx-beagle-x15.dtb am57xx-evm.dtb"
#KERNEL_DEVICETREE_omap3 = "omap3-beagle.dtb omap3-beagle-xm.dtb omap3-evm.dtb omap3-evm-37xx.dtb am3517-evm.dtb"
#KERNEL_DEVICETREE_am3517-evm = "am3517-evm.dtb"
#KERNEL_DEVICETREE_am37x-evm = "omap3-evm-37xx.dtb"
#KERNEL_DEVICETREE_beagleboard = "omap3-beagle.dtb omap3-beagle-xm.dtb"
#KERNEL_DEVICETREE_pandaboard = "omap4-panda.dtb omap4-panda-es.dtb"
#KERNEL_DEVICETREE_k2hk-evm = "k2hk-evm.dtb"
#KERNEL_DEVICETREE_k2e-evm = "k2e-evm.dtb"
#KERNEL_DEVICETREE_k2l-evm = "k2l-evm.dtb"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

COMPATIBLE_MACHINE = "ti33x|pia-am335x|pia-am335x-dr"

S = "${WORKDIR}/git"

BRANCH = "${KERNEL_BRANCH}"

#SRCREV = "9abbabaf42f4231cec3fd43ccf660af14b3e4b0f"
SRCREV = "ac992cceccf8d742b76bd64f1487d6dd63a0f06b"
PV = "4.4.8+git${SRCPV}"

# Append to the MACHINE_KERNEL_PR so that a new SRCREV will cause a rebuild
MACHINE_KERNEL_PR_append = "a"
PR = "${MACHINE_KERNEL_PR}"

#KERNEL_CONFIG_DIR = "${S}/ti_config_fragments"

# SoC specific config fragments are not enabled yet
#KERNEL_CONFIG_FRAGMENTS_append_ti33x = " ${KERNEL_CONFIG_DIR}/am33xx_only.cfg"
#KERNEL_CONFIG_FRAGMENTS_append_ti43x = " ${KERNEL_CONFIG_DIR}/am43xx_only.cfg"
#KERNEL_CONFIG_FRAGMENTS_append_dra7xx = " ${KERNEL_CONFIG_DIR}/dra7_only.cfg"

MULTI_CONFIG_BASE_SUFFIX = ""

KERNEL_GIT_URI = "git://github.com/pironex/pia-linux-kernel.git"
KERNEL_GIT_PROTOCOL = "git"
SRC_URI += "${KERNEL_GIT_URI};protocol=${KERNEL_GIT_PROTOCOL};branch=${BRANCH} \
            file://defconfig"
