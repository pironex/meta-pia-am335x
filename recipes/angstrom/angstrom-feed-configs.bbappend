#PR_append = "+pia002"
PIRONEX_FEED_URI = "http://feeds.pironex.de/"

# override angstrom uri as MACHINE_ARCH doesn't exist for piA-am35x
do_compile_append() {
	sed -i -r "s/^src\/gz (.*) (.*machine.*)$/src\/gz \1 http:\/\/feeds.pironex.de\/machine\/\1\//g" ${S}/${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf 
	echo "src/gz updates ${PIRONEX_FEED_URI}/${FEED_ARCH}/updates" >> ${S}/${sysconfdir}/opkg/${MACHINE_ARCH}-feed.conf
}
