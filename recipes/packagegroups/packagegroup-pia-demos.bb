DESCRIPTION = "Various demo applications."
LICENSE = "MIT"
PR = "r001"

inherit packagegroup


RDEPENDS_${PN} = " \
	matrix-gui \
	matrix-gui-browser \
	matrix-gui-qt4-demos \
	matrix-gui-armbenchmarks-demos \
	matrix-gui-ethernet-demos \
	matrix-gui-settings-demos \
	qt4-embedded-demos \
	qt-tstat \
"
#	bigbuckbunny-480p

RRECOMMENDS_${PN} = " \
	qt4-embedded-examples \
" 