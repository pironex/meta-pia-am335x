FILESEXTRAPATHS_prepend := "${THISDIR}/linux-ti33x-psp_3.2:"

# update package version to kernel version matching the SRCREV
PV = "${@base_contains('DISTRO_FEATURES', 'tipspkernel', "3.2", "3.2.51", d)}"

BRANCH = "pia335x-mmi-dev"
SRCREV = "2f636aa3aad808df1f5feb2fccdb05315ceb5e9f"

KERNEL_LOCALVERSION = "g${SRCREV}"
MACHINE_KERNEL_PR_append = ".pia001"

SRC_URI = "git://192.168.1.90/kernel/linux-pia-bk.git;protocol=git;branch=${BRANCH} \
        file://defconfig \
        file://configs \
        file://logo_linux_clut224.ppm \
"
