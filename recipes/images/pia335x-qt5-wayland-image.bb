# QT5 image with Wayland/Weston
require pia335x-qt5-image.bb

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

REQUIRED_DISTRO_FEATURES = "wayland"

IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'qtwayland-plugins', '', d)} \
    weston \
    weston-init \
"

export IMAGE_BASENAME = "pia335x-wayland"
