FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG_append = "linuxfb"

GLES_EXTRA_DEPS = ""
GLES_EXTRA_DEPS_ti33x = "libdrm"

#removed for testing without OpenGL
#PACKAGECONFIG_GL = "gles2"
#PACKAGECONFIG_GL = ""
PACKAGECONFIG_FB = "linuxfb"

PACKAGECONFIG[gles2] = "-opengl es2 -eglfs,,virtual/libgles2 virtual/egl ${GLES_EXTRA_DEPS}"
PACKAGECONFIG[gl] = "-opengl desktop -no-eglfs,-no-opengl,virtual/libgl"
PACKAGECONFIG += "sql-sqlite \
    tslib \
"



#PR_append = "-pia001"

#QT_ENV = "qt_env.sh"
#QT_ENV_ti33x = "${@base_contains('DISTRO_FEATURES', 'wayland', 'qt_env.sh', 'qt_env_ti33x.sh', d)}"

do_install_append () {
#    install -d ${D}${sysconfdir}/profile.d
#    install -m 0644 ${WORKDIR}/${QT_ENV} ${D}${sysconfdir}/profile.d/qt_env.sh

    cp -a ${B}/lib/libqt* ${D}${libdir}
}
