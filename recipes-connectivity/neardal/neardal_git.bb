require neardal.inc

SRCREV = "6e566ffc8dff79e51213005d0691c016360b9cf5"
PV = "0.14+git${SRCPV}"

LIC_FILES_CHKSUM ??= "file://COPYING;md5=6a6e689d19255cf0557f3fe7d7068212"

SRC_URI += "git://github.com/AppNearMe/neardal.git \
    file://0001-fix-vfprintf-tracing-function-pointer-segfault.patch"

BBCLASSEXTEND += " native "

