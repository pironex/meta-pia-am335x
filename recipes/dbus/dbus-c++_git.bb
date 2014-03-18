DESCRIPTION = "C++ bindings for dbus"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"
SECTION = "libs"
DEPENDS = "dbus expat"
SRCREV = "1f6f3e6e966e0b453edc4a82338dc27966c37505"

PE = "1"
PV = "0.9.0+gitr${SRCREV}"

SRC_URI = "git://gitorious.org/dbus-cplusplus/mainline.git;protocol=git \
	file://add_unistd_header.patch \
	file://fix_tools_crosscompile.patch \
"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = " \
  --disable-ecore \
  --disable-examples \
  --disable-tests "
 
FILES_${PN}-dbg += "${bindir}/dbusxx-xml2cpp ${bindir}/dbusxx-introspect"
FILES_${PN}-dev += "${bindir}/.dev"
FILES_${PN} = "${libdir}/*.so.*"

EXTRA_OECONF_virtclass-sdk = " \
  --disable-ecore \
  --disable-examples \
  --disable-tests \
  'glib_CFLAGS=-I${STAGING_DIR}/${HOST_SYS}${target_includedir} -I${STAGING_DIR}/${HOST_SYS}${target_includedir}/glib-2.0 -I${STAGING_DIR}/${HOST_SYS}${target_libdir}/glib-2.0/include'\
  'dbus_CFLAGS=-I${STAGING_DIR}/${HOST_SYS}${target_includedir} -I${STAGING_DIR}/${HOST_SYS}${target_includedir}/dbus-1.0 -I${STAGING_DIR}/${HOST_SYS}${target_libdir}/dbus-1.0/include'\
  "

BBCLASSEXTEND = "native nativesdk"