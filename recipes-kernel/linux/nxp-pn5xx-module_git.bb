SUMMARY = "NXP PN7150/20 kernel mode i2c driver"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c1c00f9d3ed9e24fa69b932b7e7aff2"

inherit module

MACHINE_KERNEL_PR_append = "b"
PR = "${MACHINE_KERNEL_PR}"

# Header file provided by a separate package
#DEPENDS += "cryptodev-linux"
SRCREV = "5cabbc58ff17f6023b4d0d217cdfb31b63f737c4"

SRC_URI += " git://github.com/NXPNFCLinux/nxp-pn5xx \
"

S = "${WORKDIR}/git"

DEPENDS += "virtual/kernel"

EXTRA_OEMAKE = 'BUILD_KERNEL_PATH="${STAGING_KERNEL_DIR}"'

do_install() {
    # Install kernel module
    oe_runmake INSTALL_PATH="${D}" KERNELRELEASE="${KERNEL_VERSION}" install
}
