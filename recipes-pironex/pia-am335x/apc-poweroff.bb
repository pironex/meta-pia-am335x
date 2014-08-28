DESCRIPTION = "Systemd script to poweroff system on shutdown"

PR = "r1"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

COMPATIBLE_MACHINE = "pia-am335x-apc"
PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "file://apcpoweroff.service \
          "

inherit systemd
SYSTEMD_SERVICE_${PN} = "apcpoweroff.service"

do_install_append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 0644 ${WORKDIR}/apcpoweroff.service ${D}${systemd_unitdir}/system
#	ln -sf ../apcpoweroff.service ${D}${base_libdir}/systemd/system/final.target.wants/
}

#PACKAGES =+ "${PN}-storage ${PN}-network ${PN}-udhcpd"

ALLOW_EMPTY_${PN} = "1"

FILES_${PN} = "${systemd_unitdir}/system/apcpoweroff.service \
"
#FILES_${PN} = "${base_libdir}/systemd/system/apcpoweroff.service \
#               ${base_libdir}/systemd/system/basic.target.wants/storage-gadget-init.service \
#"

systemd_postinst() {
OPTS=""

if [ -n "$D" ]; then
    OPTS="--root=$D"
fi

if type systemctl >/dev/null 2>/dev/null; then
        systemctl $OPTS ${SYSTEMD_AUTO_ENABLE} ${SYSTEMD_SERVICE}

#        if [ -z "$D" -a "${SYSTEMD_AUTO_ENABLE}" = "enable" ]; then
#                systemctl restart ${SYSTEMD_SERVICE}
#        fi
fi
}