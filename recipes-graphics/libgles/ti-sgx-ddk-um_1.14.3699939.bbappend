FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit systemd

SRC_URI += "file://pvr.service"

# use k4.4 branch as the default one breaks wayland support (missing symbol wl_proxy_marshal_constructor_versioned)
# this should be changed back when wayland is upgraded
#BRANCH = "ti-img-sgx/${PV}_k4.4"
#SRCREV = "1145367010f416dbed87884bac329158eda26777"

PR_append = "+pia003"

do_install_append () {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/pvr.service ${D}${systemd_unitdir}/system
    install -d ${D}${sysconfdir}/modules-load.d
    echo "pvrsrvkm" > ${D}${sysconfdir}/modules-load.d/pvr.conf
}

SYSTEMD_SERVICE_${PN} = "pvr.service"
