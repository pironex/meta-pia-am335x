# main image for piA with QT5 support
require pia335x-base-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

inherit populate_sdk_qt5

IMAGE_INSTALL += " \
	packagegroup-qt5-apps \
	packagegroup-qt5 \
	packagegroup-pia-extra \
	qtimageformats \
	qtgraphicaleffects \
	qtserialport \
	packagegroup-qt5-qtcreator-debug \
	qtquickcontrols \
	${@base_contains('MACHINE_FEATURES','sgx','packagegroup-graphics','',d)} \
"

export IMAGE_BASENAME = "pia335x-qt5"
