FILESEXTRAPATHS := "${THISDIR}/${PN}:"

require qt4-embedded-pi.inc

SRC_URI_append_omap3 = " file://0001-Qt-4.x-v2-Changes-for-integrating-with-TI-graphics-S.patch"
