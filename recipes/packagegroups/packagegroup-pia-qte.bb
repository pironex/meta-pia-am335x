DESCRIPTION = "QTembedded related packages for piA."
LICENSE = "MIT"
PR = "r003"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

QT_SGX_SUPPORT = "\
    qt4-embedded-plugin-gfxdriver-gfxpvregl \
    libqt-embeddedopengl4 \
    libqt-embeddedpvrqwswsegl4 \
"

#QTGFX_PACKAGES = "\
#	qt4-embedded \
#	qt4-embedded-fonts \
#	qt4-embedded-tools \
#	qt4-embedded-qmlviewer \
#	qt4-embedded-qml-plugins \
#	qt4-embedded-plugin-gfxdriver-gfxtransformed \
#	qt4-embedded-plugin-imageformat-gif \
#	qt4-embedded-plugin-imageformat-ico \
#	qt4-embedded-plugin-imageformat-jpeg \
#	qt4-embedded-plugin-imageformat-svg \
#	qt4-embedded-plugin-imageformat-tiff \
#	libqt-embeddedmultimedia4 \
#	libqt-embeddeddeclarative4 \
#	qwt-e \
#"

QTGFX_PACKAGES = "\
	packagegroup-core-qt4e \
	qt4-embedded-qmlviewer \
	qt4-embedded-plugin-gfxdriver-gfxtransformed \
	libqt-embeddeddeclarative4 \
	qwt-e \
"

QTBASE_PACKAGES = "\
	icu \
	libqt-embeddedcore4 \
	libqt-embeddedclucene4 \	
	libqt-embeddednetwork4 \
	libqt-embeddedxmlpatterns4 \
    qt4-embedded-plugin-script-dbus \
    qt4-embedded-plugin-bearer-connman \
    qt4-embedded-plugin-bearer-generic \
    qt4-embedded-plugin-sqldriver-sqlite \
"

RDEPENDS_${PN} = "\
	${QTBASE_PACKAGES} \
	${@base_contains('MACHINE_FEATURES', 'screen', '${QTGFX_PACKAGES}', '', d)} \
	${@base_contains('MACHINE_FEATURES', 'sgx', '${QT_SGX_SUPPORT}', '', d)} \
	${@base_contains('MACHINE_FEATURES', 'touchscreen', 'qt4-embedded-plugin-mousedriver-tslib', '', d)} \
"
#TODO
#	qt4-embedded-plugin-sqldriver-sqlmysql
#	qt4-embedded-plugin-sqldriver-sqlpsql
#	opencv-samples
# packages required for expansion boards, display
#RRECOMMENDS = ' \
#	qt4-embedded-demos qt4-embedded-examples \
#	matrix-gui-e am-benchmarks am-sysinfo \
#	qt-embedded-widgets-demo \
#	ti-xgxperf-qt-embedded \
#	qwt-e \	
#'
