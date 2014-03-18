# Image for piAx-AM3517 with QTembedded and support for 3D

CONMANPKGS = "connman connman-angstrom-settings connman-plugin-loopback connman-plugin-ethernet connman-plugin-wifi connman-tests connman-client connman-tools"

require pia335x-full-image.bb

IMAGE_LINGUAS = "de-de en-us"

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard \
"

ANGSTROM_EXTRA_INSTALL ?= ""
#SPLASH = "exquisite exquisite-themes exquisite-theme-angstrom"

IMAGE_INSTALL += "\
	${@base_contains('MACHINE_FEATURES','screen','packagegroup-pia-gfx','',d)} \
	packagegroup-pia-extended \
	packagegroup-pia-demos \
"

#	packagegroup-pia-extended
#    ${XSERVER}
#    ${SPLASH} 

IMAGE_FEATURES += " ssh-server-openssh eclipse-debug tools-debug "

export IMAGE_BASENAME = "piax-image"
