FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://journald.conf \
    file://system.conf \
    file://logind.conf \
"

do_install_append() {
	cp ${WORKDIR}/journald.conf ${D}${sysconfdir}/systemd
	cp ${WORKDIR}/system.conf ${D}${sysconfdir}/systemd
	# use our logind.conf to disable getty spawing
	install -m 0644 ${WORKDIR}/logind.conf ${D}${sysconfdir}/systemd/
}

pkg_postinst_${PN}() {
if [ x"$D" = "x" ]; then
    systemctl disable getty@tty1.service
else
    systemctl --root=$D disable getty@tty1.service
fi
}
