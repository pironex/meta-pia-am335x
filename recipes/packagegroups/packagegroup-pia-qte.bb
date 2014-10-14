DESCRIPTION = "QTembedded related packages for piA."
LICENSE = "MIT"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

QT_SGX_SUPPORT = "\
    qt4-embedded-plugin-gfxdriver-gfxpvregl \
    libqt-embeddedopengl4 \
    libqt-embeddedpvrqwswsegl4 \
"

QTGFX_PACKAGES = "\
	qt4-embedded \
	libqt-embedded3support4 \
	libqt-embeddeddbus4 \
	libqt-embeddedgui4 \
	libqt-embeddedhelp4 \
	libqt-embeddedmultimedia4 \
	libqt-embeddedscript4 \
	libqt-embeddedscripttools4 \
	libqt-embeddedsql4 \
	libqt-embeddedsvg4 \
	libqt-embeddedtest4 \
	libqt-embeddedwebkit4 \
	libqt-embeddedxml4 \
	qt4-embedded-fonts-ttf-dejavu \
	qt4-embedded-fonts-ttf-vera \
	qt4-embedded-plugin-iconengine-svgicon \
	qt4-embedded-plugin-imageformat-gif \
	qt4-embedded-plugin-imageformat-ico \
	qt4-embedded-plugin-imageformat-jpeg \
	qt4-embedded-plugin-imageformat-mng \
	qt4-embedded-plugin-imageformat-svg \
	qt4-embedded-plugin-imageformat-tiff \
	qt4-embedded-plugin-mousedriver-tslib \
	qt4-embedded-plugin-phonon-backend-gstreamer \
	qt4-embedded-qmlviewer \
	qt4-embedded-plugin-gfxdriver-gfxtransformed \
	libqt-embeddeddeclarative4 \
"
#	packagegroup-core-qt4e 

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
	qt4-embedded-plugin-sqldriver-sqlmysql \
"

QTGFX_RECOMMENDS = " \
	qwt-e \
"

RDEPENDS_${PN} = "\
	${QTBASE_PACKAGES} \
	${@base_contains('MACHINE_FEATURES', 'screen', '${QTGFX_PACKAGES}', '', d)} \
	${@base_contains('MACHINE_FEATURES', 'sgx', '${QT_SGX_SUPPORT}', '', d)} \
	${@base_contains('MACHINE_FEATURES', 'touchscreen', 'qt4-embedded-plugin-mousedriver-tslib', '', d)} \
"

RRECOMMENDS_${PN} = "\
	${@base_contains('MACHINE_FEATURES', 'screen', '${QTGFX_RECOMMENDS}', '', d)} \
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
