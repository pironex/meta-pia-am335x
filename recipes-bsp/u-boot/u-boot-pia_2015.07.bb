require u-boot-pia.inc

# u-boot needs devtree compiler to parse dts files
DEPENDS += "dtc-native"

DESCRIPTION = "u-boot bootloader for piA devices"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

PR = "r02"
PV_append = "+git${SRCPV}"

SRC_URI = "git://github.com/pironex/pia-uboot.git;protocol=git;branch=${UBOOT_BRANCH} \
	file://uEnv.txt \
"

SRCREV = "735da86a5377678a23539a752172dd498aca9406"

UBOOT_CONFIG = "am335x_pia_defconfig"

#UBOOT_MACHINE ?= "am335x_pia_config"
#UBOOT_BRANCH = "pia335x-2015.07"
UBOOT_BRANCH = "master"
UBOOT_BRANCH_pia-am335x = "pia335x-dev"

SPL_BINARY = "MLO"


