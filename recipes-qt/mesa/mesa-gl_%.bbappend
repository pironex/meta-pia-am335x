FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "+pia001"

PACKAGECONFIG ??= "dri \
	${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)}\
	${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'wayland', '', d)}\
"