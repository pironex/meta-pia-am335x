# Bjoern Krombholz <b.krombholz@pironex.de> (c) 2012 pironex GmbH
# License: MIT
#
# Filename: pia-display-tools.bb

DESCRIPTION = "Allow runtime switching of LCD/DVI output for piAx-AM3517"
LICENSE = "MIT"
PV = "0.1.0"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "pia-am35x"

SRC_URI = "\
  file://pia-dispswitch \
"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${WORKDIR}/pia-dispswitch ${D}/usr/bin
}

FILES_${PN} = "/usr/bin/pia-dispswitch "

