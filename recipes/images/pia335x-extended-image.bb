# this image is not really used for now
require pia335x-base-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
	${@base_contains("MACHINE_FEATURES", "wifi", "packagegroup-pia-wifi", "", d)} \
"

export IMAGE_BASENAME = "pia335x-ext"
