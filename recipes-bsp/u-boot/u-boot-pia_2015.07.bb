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

SRCREV = "17e0e810080bce3110c771e64c98b0a6f56b002b"

UBOOT_CONFIG = "am335x_pia_defconfig"

#UBOOT_MACHINE ?= "am335x_pia_config"
#UBOOT_BRANCH = "pia335x-2015.07"
UBOOT_BRANCH = "master"

SPL_BINARY = "MLO"


