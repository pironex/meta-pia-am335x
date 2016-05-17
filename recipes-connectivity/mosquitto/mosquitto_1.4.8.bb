# taken from meta-intel-iot-middleware
SUMMARY = "Open source MQTT v3.1 implemention"
DESCRIPTION = "Mosquitto is an open source (BSD licensed) message broker that implements the MQ Telemetry Transport protocol version 3.1. MQTT provides a lightweight method of carrying out messaging using a publish/subscribe model. "
HOMEPAGE = "http://mosquitto.org/"
SECTION = "console/network"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=62ddc846179e908dc0c8efec4a42ef20"

DEPENDS = "c-ares openssl util-linux python"

PR = "r2"

inherit cmake

SRC_URI = "http://mosquitto.org/files/source/mosquitto-${PV}.tar.gz \
           file://mosquitto.service \
"
#           file://build.patch

export LIB_SUFFIX="${@d.getVar('baselib', True).replace('lib', '')}"

SRC_URI[md5sum] = "d859cd474ffa61a6197bdabe007b9027"
SRC_URI[sha256sum] = "d96eb5610e57cc3e273f4527d3f54358ab7711459941a9e64bc4d0a85c2acfda"

#do_compile() {
#    oe_runmake PREFIX=/usr
#}

#do_install() {
#    oe_runmake install DESTDIR=${D}
#    install -d ${D}${libdir}
#    install -m 0644 lib/libmosquitto.a ${D}${libdir}/
#
do_install_append() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/mosquitto.service ${D}${systemd_unitdir}/system/
}

PACKAGES += "libmosquitto1 libmosquittopp1 ${PN}-clients ${PN}-python"

FILES_${PN} = "${sbindir}/mosquitto \
               ${bindir}/mosquitto_passwd \
               ${sysconfdir}/mosquitto \
               ${systemd_unitdir}/system/mosquitto.service \
"

FILES_libmosquitto1 = "${libdir}/libmosquitto${SOLIBS}"

FILES_libmosquittopp1 = "${libdir}/libmosquittopp${SOLIBS}"

FILES_${PN}-clients = "${bindir}/mosquitto_pub \
                       ${bindir}/mosquitto_sub \
"

FILES_${PN}-staticdev += "${libdir}/libmosquitto.a"

FILES_${PN}-python = "/usr/lib/python2.7/site-packages"

inherit systemd

SYSTEMD_SERVICE_${PN} = "mosquitto.service"
