# modify default memory configuration
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " file://98-memory.conf "

PR_append = "+pia001"

do_install_append () {
        install -m 0644 ${WORKDIR}/98-memory.conf ${D}${sysconfdir}/sysctl.d
}

CONFFILES_${PN} += "${sysconfdir}/sysctl.d/98-memory.conf"
