DESCRIPTION = "Additional packages for KACO EMS images"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = ' \
	psplash-kaco \
'
#		udev-extra-rules 

# packages required for expansion boards, display
RRECOMMENDS_${PN} = ' \
    bash \
    sqlite3 \
    usbutils \
'
