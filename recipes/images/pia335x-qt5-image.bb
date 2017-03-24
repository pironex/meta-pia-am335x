# main image for piA with QT5 support
require pia335x-base-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
	packagegroup-qt5-apps \
	packagegroup-qt5 \
	qtimageformats \
	qtgraphicaleffects \
	qtserialport \
	packagegroup-qt5-qtcreator-debug \
"

export IMAGE_BASENAME = "pia335x-qt5"
