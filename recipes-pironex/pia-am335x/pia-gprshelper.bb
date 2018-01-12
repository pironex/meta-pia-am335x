# License: MIT
#
# Filename: pia-gprshelper.bb

DESCRIPTION = "GPRS systemd scripts and device handling for piA-AM335x boards"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PV = "1.0"
PR = "2"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "pia-am335x"

SRC_URI = "\
  file://gprs \
  file://default/gprs \
  \
  file://peers/* \
  file://chats/* \
  file://ppp.service \
"

S = "${WORKDIR}"

# install service into /etc not /usr/lib/systemd
do_install() {
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/gprs ${D}${sbindir}/gprs
	install -d ${D}${sysconfdir}/systemd/system
	install -m 0644 ${WORKDIR}/ppp.service ${D}${sysconfdir}/systemd/system/
	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/default/gprs ${D}${sysconfdir}/default/
	# from ppp-gprs
	install -d ${D}${sysconfdir}/ppp/peers/
	install -d ${D}${sysconfdir}/ppp/chats/
	install -m 0644 ${WORKDIR}/peers/* ${D}${sysconfdir}/ppp/peers/
	install -m 0644 ${WORKDIR}/chats/* ${D}${sysconfdir}/ppp/chats/
	ln -s -T pin.none ${D}${sysconfdir}/ppp/chats/pin
	ln -s -T gprs.o2 ${D}${sysconfdir}/ppp/chats/gprs
	ln -s -T gprs.default ${D}${sysconfdir}/ppp/peers/gprs
}

inherit systemd
SYSTEMD_SERVICE_${PN} = "ppp.service"
SYSTEMD_AUTO_ENABLE_${PN} = "disable"

FILES_${PN} = "${sysconfdir}/ppp \
    ${sbindir}/gprs \
    ${sysconfdir}/default/gprs \
"

CONFFILES_${PN} = " ${sysconfdir}/default/gprs  \
    ${D}${sysconfdir}/ppp/chats/pin \
    ${D}${sysconfdir}/ppp/chats/pin.code \
    ${D}${sysconfdir}/ppp/chats/gprs \
    ${D}${sysconfdir}/ppp/peers/gprs \
"

#	${sysconfdir}/ppp/peers/gprs \
#	${sysconfdir}/ppp/peers/gprs.default \
#	${sysconfdir}/ppp/chats/gprs.o2 \
#	${sysconfdir}/ppp/chats/gprs.tmob \
#	${sysconfdir}/ppp/chats/gprs.aspider \
#	${sysconfdir}/ppp/chats/pin \
#	${sysconfdir}/ppp/chats/pin.code \
#	${sysconfdir}/ppp/chats/pin.none \
#