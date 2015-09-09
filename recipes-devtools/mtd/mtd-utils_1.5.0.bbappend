FILESEXTRAPATHS := "${THISDIR}/files"

SRC_URI_append_class-native = " file://0005-mkfs.ubifs-Fix-build-with-gcc-5.1.patch"

CFLAGS += "-fgnu89-inline"
