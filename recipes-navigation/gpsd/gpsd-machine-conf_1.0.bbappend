FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_DEPS = ""

RDEPENDS_${PN} += "${EXTRA_DEPS}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI_pia-am335x = " \
    file://gpsd-machine \
"

inherit update-alternatives

ALTERNATIVE_${PN}_pia-am335x = "gspd-defaults"
ALTERNATIVE_LINK_NAME[gspd-defaults] = "${sysconfdir}/default/gpsd"
ALTERNATIVE_TARGET[gspd-defaults] = "${sysconfdir}/default/gpsd.machine"
ALTERNATIVE_PRIORITY[gspd-defaults] = "15"

# we're moving device-hook from gpsd bbappend (gpsd-conf package)
RREPLACES_${PN} += "gpsd-conf"

do_install() {
    if [ "${MACHINE}" = "pia-am335x" ]; then
        install -d ${D}/${sysconfdir}/default
        install -m 0644 ${WORKDIR}/gpsd-machine ${D}/${sysconfdir}/default/gpsd.machine
    fi
}
