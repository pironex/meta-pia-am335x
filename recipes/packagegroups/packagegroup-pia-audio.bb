DESCRIPTION = "Audio related utilities and tools for piA systems."
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
	alsa-state \
	alsa-utils-alsamixer \
"

RRECOMMENDS_${PN} = " \
	pulseaudio-server \
"

