FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
PRINC := "${@int(PRINC) + 1}"

# we provide a machine dependent asound.state
PACKAGE_ARCH = "${MACHINE_ARCH}"
