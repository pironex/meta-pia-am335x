# this recipe is taken from Angstrom as it's quire useful to conserve power on embedded systems
DESCRIPTION = "CPU-freq tweaks for angstrom"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit allarch systemd

#PV = "${DISTRO_VERSION}"

SRC_URI = "file://cpu-ondemand.timer \
           file://cpu-ondemand.service \
          "	

do_compile() {
	:
}


do_install () {

	install -d ${D}/${base_libdir}/systemd/system
	install -m 0644 ${WORKDIR}/cpu-ondemand.* ${D}/${base_libdir}/systemd/system/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "cpu-ondemand.timer"

FILES_${PN} += "${base_libdir}/systemd"
RDEPENDS_${PN} = "cpufrequtils"

