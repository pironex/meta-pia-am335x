PR_append = "+pia002"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

#SRC_URI_append = " \
#    file://runWeston \
#"

# clear, we don't have opengl but egl
REQUIRED_DISTRO_FEATURES = ""

#RDEPENDS_${PN} += " bash"

#do_install_append() {
#    install -d ${D}${bindir}
#    install -m 755 ${WORKDIR}/runWeston ${D}${bindir}
#}
