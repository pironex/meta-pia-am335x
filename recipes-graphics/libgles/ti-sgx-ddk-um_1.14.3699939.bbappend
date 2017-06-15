FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit systemd

SRC_URI += "file://pvr.service"

PR_append = "+pia001"

do_install_append () {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/pvr.service ${D}${systemd_unitdir}/system
    install -d ${D}${sysconfdir}/modules-load.d
    echo "pvrsrvkm" > ${D}${sysconfdir}/modules-load.d/pvr.conf
}

SYSTEMD_SERVICE_${PN} = "pvr.service"
