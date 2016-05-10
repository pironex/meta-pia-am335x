DESCRIPTION = "Extra utilities and tools for piA systems."
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
	bash \
	gdbserver \
	mc \
	nano \
	picocom \
"

RRECOMMENDS_${PN} = " \
"

