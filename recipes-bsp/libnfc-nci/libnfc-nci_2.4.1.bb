SUMMARY = "Linux NFC stack for NCI based NXP NFC Controllers"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=86d3f3a95c324c9479bd8986968f4327"

SRCREV = "918075cc871fb28c344d09a2fae4ba0fac6ae7da"

SRC_URI = "git://github.com/NXPNFCLinux/linux_libnfc-nci"
SRC_URI[md5sum] = "69bfbdd9e0d7095c5d7423e71b2fb1a9"
SRC_URI[sha256sum] = "464fc1c8a58a502fe0c9e136cdf979ae9ed7d2a62bf255461b3c151ec69d9c1c"

inherit autotools pkgconfig

S = "${WORKDIR}/git"

#PR_append = ""

do_configure_prepend() {
    ( 
        cd ${S}
        sh bootstrap
    )
}

EXTRA_OECONF = " "

RRECOMMENDS_${PN} += "kernel-module-pn5xx-i2c"