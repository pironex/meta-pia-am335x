CONMANPKGS ?= "connman connman-plugin-loopback connman-plugin-ethernet connman-systemd connman-tests connman-client"

require ${COREBASE}/../meta-angstrom/recipes-images/angstrom/console-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
	bc \
	tcpdump \
	${@base_contains("MACHINE_FEATURES", "alsa", "alsa-state", "",d)} \
	${@base_contains("MACHINE_FEATURES", "can", "canutils", "", d)} \
	${@base_contains("MACHINE_FEATURES", "usbhost", "usbutils", "", d)} \
"

export IMAGE_BASENAME = "pia335x-base"
