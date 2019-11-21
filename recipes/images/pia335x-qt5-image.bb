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

do_systemd_network_append () {
    install -d ${IMAGE_ROOTFS}${sysconfdir}/systemd/network
    cat << EOF > ${IMAGE_ROOTFS}${sysconfdir}/systemd/network/15-ppp.network
[Match]
Name=ppp*

EOF
}