CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-systemd connman-tests connman-client"

DISTRO_UPDATE_ALTERNATIVES += "update-alternatives-cworth"

# console-image seems outdated and missing some important stuff like root configuration, systemd-networkd configuration etc.
#require ${COREBASE}/../meta-angstrom/recipes-images/angstrom/console-image.bb
require ${COREBASE}/../meta-angstrom/recipes-images/angstrom/angstrom-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
	packagegroup-pia-tools \
	${@base_contains("MACHINE_FEATURES", "alsa", "packagegroup-pia-audio", "",d)} \
	${@base_contains("MACHINE_FEATURES", "gsm", "packagegroup-pia-gsm", "", d)} \
	${@base_contains("MACHINE_FEATURES", "usbhost", "usbutils", "", d)} \
"

# TODO add base config packages to config 
#	${@base_contains("MACHINE_FEATURES", "wifi", "packagegroup-pia-wifi", "", d)} \
#	${@base_contains("MACHINE_FEATURES", "can", "canutils", "", d)} \
#	packagegroup-pia

export IMAGE_BASENAME = "pia335x-base"
