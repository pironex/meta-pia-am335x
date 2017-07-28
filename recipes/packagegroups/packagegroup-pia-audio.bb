DESCRIPTION = "Audio related utilities and tools for piA systems."
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
	alsa-state \
	alsa-utils \
	alsa-utils-alsamixer \
	alsa-utils-amixer \
	alsa-utils-speakertest \
"

RRECOMMENDS_${PN} = " \
	pulseaudio-server \
	pulseaudio-misc \
"

