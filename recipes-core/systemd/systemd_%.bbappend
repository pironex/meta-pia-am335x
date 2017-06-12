# tweaks for systemd package

# add systemd features to use -networkd as network manager
# add Angstrom tweaks for pager and journald config
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "+pia0002"

SRC_URI += "file://journald.conf \
	file://11-eth.network \
"

# We use systemd-networkd as the system's network-manager
PACKAGECONFIG += " \
	networkd \
	resolved \
	iptc \
	libidn \
	lz4 \
"

do_install_append() {
	cp ${WORKDIR}/journald.conf ${D}${sysconfdir}/systemd
	install -d ${D}${sysconfdir}/systemd/network
	cp ${WORKDIR}/11-eth.network ${D}${sysconfdir}/systemd/network

	# remove the cleanup-rule for /var/tmp as systemd expects /var/tmp
	# not to be a symlink
	# this change was taken from meta-yogurt layer
	sed -i 's/^v \/var\/tmp.*$//g' \
		${D}${exec_prefix}/lib/tmpfiles.d/tmp.conf
}

# fix pager corruption with busybox less/more
RRECOMMENDS_${PN} += "less"
