# License: MIT
#
# Filename: pia-gprshelper.bb

DESCRIPTION = "GPRS systemd scripts and device handling for piA-AM335x boards"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PV = "1.2"
PR = "0"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "pia-am335x"

SRC_URI = "\
  file://gprs \
  file://default/gprs \
  \
  file://peers/* \
  file://chats/* \
  file://ppp.service \
  file://ppp_connection_check.sh \
  file://pppmonitor.service \
  file://pppmonitor.timer \
"

S = "${WORKDIR}"

# install service into /etc not /usr/lib/systemd
do_install() {
	install -d ${D}${sbindir}
	install -m 0755 ${WORKDIR}/gprs ${D}${sbindir}/gprs
	install -m 0755 ${WORKDIR}/setgprsapn ${D}${sbindir}/setgprsapn
	install -m 0755 ${WORKDIR}/ppp_connection_check.sh ${D}${sbindir}/ppp_connection_check.sh
	install -d ${D}${sysconfdir}/systemd/system
	install -m 0644 ${WORKDIR}/ppp.service ${D}${sysconfdir}/systemd/system/
	install -m 0644 ${WORKDIR}/pppmonitor.* ${D}${sysconfdir}/systemd/system/
	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/default/gprs ${D}${sysconfdir}/default/gprs.defaults
	# from ppp-gprs
	install -d ${D}${sysconfdir}/ppp/peers/
	install -d ${D}${sysconfdir}/ppp/chats/
	install -m 0644 ${WORKDIR}/peers/* ${D}${sysconfdir}/ppp/peers/
	install -m 0644 ${WORKDIR}/chats/* ${D}${sysconfdir}/ppp/chats/
	ln -s -T pin.none ${D}${sysconfdir}/ppp/chats/pin
	ln -s -T apn.aspider ${D}${sysconfdir}/ppp/chats/apn
	ln -s -T gprs.default ${D}${sysconfdir}/ppp/peers/gprs
}

inherit systemd
SYSTEMD_SERVICE_${PN} = "ppp.service pppmonitor.timer pppmonitor.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

FILES_${PN} = "${sysconfdir}/ppp \
    ${sbindir}/gprs \
    ${sbindir}/setgprsapn \
    ${sbindir}/ppp_connection_check.sh \
    ${sysconfdir}/default/gprs.defaults \
"

CONFFILES_${PN} = " ${D}${sysconfdir}/default/gprs.defaults  \
    ${D}${sysconfdir}/ppp/chats/pin \
    ${D}${sysconfdir}/ppp/chats/pin.code \
    ${D}${sysconfdir}/ppp/chats/gprs \
    ${D}${sysconfdir}/ppp/chats/apn \
    ${D}${sysconfdir}/ppp/peers/gprs \
"
