inherit uboot
require u-boot-pia.inc

# No patches for other machines yet
#COMPATIBLE_MACHINE = "ti33x pia-am335x pia-am335x_e2 pia-am335x_mmi"
COMPATIBLE_MACHINE = "(pia-am335x|pia-am335x-e2|pia-am335x-mmi)"

DEFAULT_PREFERENCE_pia-am335x-e2 = "100"
DEFAULT_PREFERENCE_pia-am335x-mmi = "100"
DEFAULT_PREFERENCE_pia-am335x = "100"
DEFAULT_PREFERENCE_ti33x = "100"

SRCREV = "${AUTOREV}"
PV = "2014.04-pia+git${SRCPV}"
PR = "r01"

UBOOT_MACHINE ?= "am335x_pia_config"
UBOOT_BRANCH ?= "pia-am335x-dev"

# SPL build
UBOOT_BINARY = "u-boot.img"
UBOOT_IMAGE = "u-boot-${MACHINE}-${PKGV}-${PKGR}.img"
UBOOT_SYMLINK = "u-boot-${MACHINE}.img"

SPL_BINARY = "MLO"

LIC_FILES_CHKSUM = "file://README;beginline=1;endline=6;md5=157ab8408beab40cd8ce1dc69f702a6c"

#SRCREV = "111dba415f7cf83daa64a3aaadcc7e6a31c7b049"
#SRCREV = "384e05e4a90e57791d49969f0f13756357b56b2e"
#SRCREV = "b694001f95f649318032b6ccc9d0f6648ba84378"
#SRCREV = "c96fcc725957ce9f7c34c116266dab525a55743d"
#SRCREV = "225e7b7c59bc8a20ea781916bfcb670a9bf65081"
#SRCREV = "98a6219d2fc9069082525c8d93a423378f25ecdf"

SRC_URI = "git://github.com/pironex/pia-uboot.git;protocol=git;branch=${UBOOT_BRANCH} \
	file://uEnv.txt \
"
#	file://01_master.diff

do_deploy[prefuncs] += "package_get_auto_pr"

do_deploy_append() {
    install ${WORKDIR}/uEnv.txt ${DEPLOYDIR}/uEnv.txt
}