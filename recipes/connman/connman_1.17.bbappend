FILESEXTRAPATHS_prepend := "${THISDIR}/connman:"

SRC_URI += "file://settings"

do_install_append() {
	install -d ${D}${localstatedir}/lib/connman/
	install -m 0644 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman/
}

PACKAGES =+ "${PN}-pironex-settings"

FILES_${PN}-pironex-settings = "${localstatedir}/lib/connman/settings"
RDEPENDS_${PN}-pironex-settings = "${PN}"
