#CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-systemd connman-tests connman-client"

#DISTRO_UPDATE_ALTERNATIVES += "update-alternatives-cworth"

#require ${COREBASE}/../meta-angstrom/recipes-images/angstrom/console-image.bb
require pia335x-base-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
	${@base_contains("MACHINE_FEATURES", "wifi", "packagegroup-pia-wifi", "", d)} \
"

#

export IMAGE_BASENAME = "pia335x-ext"
