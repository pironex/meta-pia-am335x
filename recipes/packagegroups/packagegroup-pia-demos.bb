DESCRIPTION = "Various demo applications."
LICENSE = "MIT"

inherit packagegroup


RDEPENDS_${PN} = " \
	matrix-gui \
	matrix-gui-browser \
	matrix-gui-qt4-demos \
	matrix-gui-armbenchmarks-demos \
	matrix-gui-ethernet-demos \
	matrix-gui-settings-demos \
	qt4-embedded-demos \
	qt4-embedded-examples \
	qt-tstat \
"
#	bigbuckbunny-480p

RRECOMMENDS_${PN} = " \
	qt4-embedded-examples \
" 