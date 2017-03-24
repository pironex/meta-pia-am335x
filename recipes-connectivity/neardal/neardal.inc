DESCRIPTION = "Neard Abstraction Library (for Neard v0.7)"
HOMEPAGE = "https://github.com/connectivity/neardal"
SECTION = "Network & Connectivity/NFC"
LICENSE = "LGPL-2.0"

SRC_URI = ""

S = "${WORKDIR}/git"

inherit autotools
inherit gettext
inherit pythonnative
inherit pkgconfig

BBCLASSEXTEND = ""

PROVIDES = ""

PROVIDES += "neardal-dev"

RDEPENDS = ""

RDEPENDS_${PN}-dev += "neardal"
RDEPENDS_${PN} += "glibc"
RDEPENDS_${PN}-bin += "neardal"

DEPENDS = ""
DEPENDS_append_class-native = " intltool-native"
DEPENDS_append_class-target = " intltool-native"
#DEPENDS_append_class-native = " automake-native"
#DEPENDS_append_class-target = " automake-native"
DEPENDS += "glib-2.0"
#DEPENDS_append_class-native = " libtool"
#DEPENDS_append_class-target = " libtool-cross"
DEPENDS += "python-xml"
DEPENDS_append_class-native = " readline-native"
DEPENDS_append_class-target = " readline-native"
#DEPENDS_append_class-native = " autoconf-native"
#DEPENDS_append_class-target = " autoconf-native"
DEPENDS += "dbus-glib"

do_configure_prepend() {
    touch ${S}/ChangeLog
}
EXTRA_OECONF = "--enable-debug --enable-trace"

do_install_append() {
    install -d ${D}${bindir}
    install -m 0755 demo/.libs/demo ${D}${bindir}/neardal-demo
    install -m 0755 ncl/.libs/ncl ${D}${bindir}/ncl
#    find ${D} -regex ".*\.la$" | xargs rm -f -- 
#    find ${D} -regex ".*\.a$" | xargs rm -f --
}

pkg_postinst_${PN}() {
    #!/bin/sh -e

    [ "x$D" == "x" ] && ldconfig
}

pkg_postrm_${PN}() {
    #!/bin/sh -e

    [ "x$D" == "x" ] && ldconfig
}

PACKAGES = "${PN}-dbg ${PN}-doc ${PN}-locale"
PACKAGES += " ${PN}-dev ${PN}-staticdev "
PACKAGES += " ${PN} ${PN}-bin "

neardal-dev_files = ""
neardal-dev_files += "${prefix}/include/neardal/*.h"
neardal-dev_files += "${prefix}/lib/pkgconfig/neardal.pc"
neardal-dev_files += "${prefix}/lib/libneardal.so"

neardal_files = "README AUTHORS"
neardal_files += "${prefix}/lib/libneardal.so.0"
neardal_files += "${prefix}/lib/libneardal.so.0.0.*"
neardal_files += "${sysconfdir}/dbus-1/system.d/org.neardal.conf"

FILES_${PN}-dev = "${neardal-dev_files}"
FILES_${PN}-staticdev = "${libdir}/*.a ${libdir}/*.la"
FILES_${PN}-bin = "${bindir}/neardal-demo ${bindir}/ncl"
FILES_${PN} = "${neardal_files}"
