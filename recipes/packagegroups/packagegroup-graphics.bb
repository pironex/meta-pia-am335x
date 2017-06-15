DESCRIPTION = "Task to install additional graphics and 3D support"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

GRAPHICS_RDEPENDS = ""

GRAPHICS_RDEPENDS_ti33x = "\
    libgbm \
    omap5-sgx-ddk-um-linux \
    omapdrm-pvr \
"

RDEPENDS_${PN} = "\
    ${GRAPHICS_RDEPENDS} \
"
