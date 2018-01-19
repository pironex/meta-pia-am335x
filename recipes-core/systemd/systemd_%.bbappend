FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://journald.conf \
    file://system.conf \
"

do_install_append() {
	cp ${WORKDIR}/journald.conf ${D}${sysconfdir}/systemd
	cp ${WORKDIR}/system.conf ${D}${sysconfdir}/systemd
}
