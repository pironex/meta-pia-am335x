FILESEXTRAPATHS_prepend := "${THISDIR}/linux-ti33x-psp_3.2:"

# update package version to kernel version matching the SRCREV
PV = "3.2.51+gitr${SRCPV}"

KERNEL_BRANCH ?= "pia335x-dev"
#SRCREV = "2f636aa3aad808df1f5feb2fccdb05315ceb5e9f"
#prev
#SRCREV = "00a8e793e4dfe0b01cad599f4fd39e0d9ebd63d8"
#SRCREV = "96ccc27c1bc2b5aaab5c9e2578ed5bce7e38d853"
SRCREV = "${AUTOREV}"

#KERNEL_LOCALVERSION = "gitr${SRCPV}"
MACHINE_KERNEL_PR_append = ".pia007"

SRC_URI = "git://192.168.1.90/kernel/linux-pia-bk.git;protocol=git;branch=${KERNEL_BRANCH} \
        file://defconfig \
        file://configs \
        file://logo_linux_clut224.ppm \
"
