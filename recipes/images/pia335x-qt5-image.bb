# main image for piA with QT5 support
require pia335x-base-image.bb

inherit distro_features_check

inherit populate_sdk_qt5

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
	packagegroup-qt5-apps \
	packagegroup-qt5 \
	qtimageformats \
	qtgraphicaleffects \
	qtserialport \
	packagegroup-qt5-qtcreator-debug \
	packagegroup-httpd \
	packagegroup-graphics \
"

export IMAGE_BASENAME = "pia335x-qt5"
