CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-systemd connman-tests connman-client"

DISTRO_UPDATE_ALTERNATIVES += "update-alternatives-cworth"

require ${COREBASE}/../meta-angstrom/recipes-images/angstrom/console-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
	packagegroup-pia \
	${@base_contains("MACHINE_FEATURES", "alsa", "alsa-state", "",d)} \
	${@base_contains("MACHINE_FEATURES", "can", "canutils", "", d)} \
	${@base_contains("MACHINE_FEATURES", "gsm", "packagegroup-pia-gsm", "", d)} \
	${@base_contains("MACHINE_FEATURES", "usbhost", "usbutils", "", d)} \
	${@base_contains("MACHINE_FEATURES", "wifi", "packagegroup-pia-wifi", "", d)} \
"

export IMAGE_BASENAME = "pia335x-base"
