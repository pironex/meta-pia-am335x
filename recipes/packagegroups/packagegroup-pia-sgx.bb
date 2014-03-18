DESCRIPTION = "Support for 3D-Graphics on piAx"
LICENSE = "MIT"
PR = "r001"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

SGX_PACKAGES = "\
    libgles-omap3 \
    libgles-omap3-blitwsegl \
    libgles-omap3-flipwsegl \
    libgles-omap3-frontwsegl \
    libgles-omap3-linuxfbwsegl \
    libgles-omap3-rawdemos \
    omap3-sgx-modules \
"

# allow only supported archs, the actual selection must be done in the depending bb 
SGX_RDEPENDS = ""
SGX_RDEPENDS_ti33x = " ${SGX_PACKAGES} "
SGX_RDEPENDS_omap3 = " ${SGX_PACKAGES} "

RDEPENDS_${PN} = "\
	${SGX_RDEPENDS} \
"
