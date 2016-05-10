#CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-systemd connman-tests connman-client"

#DISTRO_UPDATE_ALTERNATIVES += "update-alternatives-cworth"

#require ${COREBASE}/../meta-angstrom/recipes-images/angstrom/console-image.bb
require pia335x-extended-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
	packagegroup-qt5-apps \
	packagegroup-qt5 \
"


export IMAGE_BASENAME = "pia335x-qt5"
