require u-boot-pia.inc

# u-boot needs devtree compiler to parse dts files
DEPENDS += "dtc-native"

DESCRIPTION = "u-boot bootloader for piA devices"

LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

PR = "r01"
PV_append = "+git${SRCPV}"

SRC_URI = "git://github.com/pironex/pia-uboot.git;protocol=git;branch=${UBOOT_BRANCH} \
	file://uEnv.txt \
"

SRCREV = "835a2ec1a49c25953b603c8d7b7d5b8f2b26773a"


UBOOT_CONFIG = "am335x_pia_defconfig"

#UBOOT_MACHINE ?= "am335x_pia_config"
UBOOT_BRANCH = "master"

SPL_BINARY = "MLO"


