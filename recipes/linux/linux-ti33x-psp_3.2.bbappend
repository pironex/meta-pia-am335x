#PR_append = "+pia001"
#MACHINE_KERNEL_PR_append .= ".pia001"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-ti33x-psp_3.2:"
#PRINC = "1"

BRANCH = "master-pia335x-3.2"
#SRCREV = "b74d46884a9177b7ffdbd7bd7cf37716232891e6"
#SRCREV = "3ced54b3679495c674f385350c8ebc513d65e3c6"
SRCREV = "ffd3de57556bf05b775ae213d628e31889e5d546"

PV = "${@base_contains('DISTRO_FEATURES', 'tipspkernel', "3.2", "3.2.34", d)}"

MACHINE_KERNEL_PR_append = ".pia001"
#MACHINE_KERNEL_PR_append .= ".1"

#SRC_URI += "git://github.com/pironex/pia-linux-kernel.git;protocol=git;branch=${BRANCH}

SRC_URI = "git://192.168.1.90/kernel/linux-pia-bk.git;protocol=git;branch=${BRANCH} \
        file://am335x-pm-firmware.bin \
        file://defconfig \
        file://configs \
        file://logo_linux_clut224.ppm \
"
#	file://pia-am335x-patches.diff

PATCHES_OVER_PSP = ""