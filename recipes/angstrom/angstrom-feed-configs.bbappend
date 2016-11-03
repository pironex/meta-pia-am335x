#PR_append = "+pia002"
PIRONEX_FEED_URI = "http://feeds.pironex.de"

ANGSTROM_URI = "${PIRONEX_FEED_URI}"
FEED_BASEPATH = "oe1512/"

# override angstrom uri as MACHINE_ARCH doesn't exist for piA-am35x
do_compile_append() {
#	sed -i -r "s/^src\/gz (.*) (.*machine.*)$/src\/gz \1 http:\/\/feeds.pironex.de\/machine\/\1\//g" ${S}/${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf 
#	echo "src/gz updates ${PIRONEX_FEED_URI}/${FEED_ARCH}/updates" >> ${S}/${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf
	
}


FILES_${PN} = "${sysconfdir}/opkg/base-feed.conf \
               ${sysconfdir}/opkg/debug-feed.conf \
               ${sysconfdir}/opkg/perl-feed.conf \
               ${sysconfdir}/opkg/python-feed.conf \
               ${sysconfdir}/opkg/gstreamer-feed.conf \
               ${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf \
               ${sysconfdir}/opkg/noarch-feed.conf \
               ${sysconfdir}/opkg/sdk-feed.conf \
               "

CONFFILES_${PN} += "${sysconfdir}/opkg/base-feed.conf \
               ${sysconfdir}/opkg/debug-feed.conf \
               ${sysconfdir}/opkg/perl-feed.conf \
               ${sysconfdir}/opkg/python-feed.conf \
               ${sysconfdir}/opkg/gstreamer-feed.conf \
               ${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf \
               ${sysconfdir}/opkg/noarch-feed.conf \
               ${sysconfdir}/opkg/sdk-feed.conf \
               "