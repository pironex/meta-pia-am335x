# Bjoern Krombholz <b.krombholz@pironex.de> (c) 2012 pironex GmbH
# License: MIT
#
# Filename: pia-gprs.bb

DESCRIPTION = "GPRS init scripts and device handling for piA-AM35x boards"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
PV = "0.1.0"
PR = "r011"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "pia-am35x"

SRC_URI = "\
  file://init.d/gprs \
  file://init.d/mkcmuxdev.sh \
  file://default/gprs \
  file://src \
  file://src/linux \
  \
  file://peers/* \
  file://chats/* \
  file://pin.code \
"

inherit update-rc.d

INITSCRIPT_NAME = "gprs"
# don't start automatically, run from network scripts
# INITSCRIPT_PARAMS = "start 99 2 3 4 5 . stop 99 0 6 ."

S = "${WORKDIR}/src"

do_compile() {
        cd ${S}
        ${CC} -o cmux -I./ main.c ${LDFLAGS}
}


do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init.d/gprs ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/init.d/mkcmuxdev.sh ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/default
	install -m 0755 ${WORKDIR}/default/gprs ${D}${sysconfdir}/default/
	install -d ${D}/usr/sbin
	install -m 0755 ${S}/cmux ${D}/usr/sbin
	# from ppp-gprs
	install -d ${D}${sysconfdir}/ppp/peers/
    install -d ${D}${sysconfdir}/ppp/chats/
    install -m 0644 ${WORKDIR}/peers/* ${D}${sysconfdir}/ppp/peers/
    install -m 0644 ${WORKDIR}/chats/* ${D}${sysconfdir}/ppp/chats/
	ln -s -T  pin.code ${D}/etc/ppp/chats/pin

    # Add links for providers sharing same well-known config
    ln -sf _gprs-ap-internet ${D}${sysconfdir}/ppp/peers/ua-life
}

FILES_${PN} = " ${sysconfdir}/init.d \
        ${sysconfdir}/init.d/gprs \
        ${sysconfdir}/init.d/mkcmuxdev.sh \
        ${sysconfdir}/default/gprs \
        /usr/sbin/cmux \
        ${sysconfdir}/ppp"

CONFFILES_${PN} = " ${sysconfdir}/init.d/gprs ${sysconfdir}/default/gprs  \
	${sysconfdir}/init.d/mkcmuxdev.sh \
	${sysconfdir}/ppp/peers/gprs \
	${sysconfdir}/ppp/chats/gprs \
	${sysconfdir}/ppp/chats/umts \
	${sysconfdir}/ppp/peers/gprs_cmux \
	${sysconfdir}/ppp/peers/gprs_cmux_3.2 \
	${sysconfdir}/ppp/chats/pin.code \
	${sysconfdir}/ppp/chats/pin.none \
	${sysconfdir}/ppp/peers/_gprs \
	${sysconfdir}/ppp/chats/chat-gprs \
"