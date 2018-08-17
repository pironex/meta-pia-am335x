# additional tools for HW testing
require pia335x-qt5-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
    neard neardal neardal-bin \
"

export IMAGE_BASENAME = "pia335x-test"
