FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

GLES_EXTRA_DEPS = ""
GLES_EXTRA_DEPS_ti33x = "libdrm"

#removed for testing without OpenGL
PACKAGECONFIG_GL = "gles2"
PACKAGECONFIG_FB = "linuxfb"

PACKAGECONFIG_DISTRO = "icu examples sql-sqlite tslib"
PACKAGECONFIG_DISTRO += "fontconfig"
PACKAGECONFIG_DISTRO += "libinput"

PACKAGECONFIG[gles2] = "-opengl es2 -eglfs,,virtual/libgles2 virtual/egl ${GLES_EXTRA_DEPS}"

QT_CONFIG_FLAGS += "-qpa ${@base_contains('DISTRO_FEATURES', 'wayland', 'wayland', 'eglfs', d)}"

PR_append = "-pia002"

# qt_env.sh handling
QT_ENV = "qt_env.sh"
QT_ENV_ti33x = "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qt_env.sh', 'qt_env_ti33x.sh', d)}"

SRC_URI += "\
    file://${QT_ENV} \
"

do_install_append () {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0644 ${WORKDIR}/${QT_ENV} ${D}${sysconfdir}/profile.d/qt_env.sh

    cp -a ${B}/lib/libqt* ${D}${libdir}
}

PACKAGES =+ "${PN}-conf"

FILES_${PN}-conf = "${sysconfdir}/profile.d/qt_env.sh"

RDEPENDS_${PN} += "${PN}-conf"
