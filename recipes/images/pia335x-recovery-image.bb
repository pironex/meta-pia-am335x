# main image for piA with QT5 support
require pia335x-base-image.bb

IMAGE_FEATURES += "splash"

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
"

export IMAGE_BASENAME = "pia335x-recovery"
