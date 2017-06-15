# tweaks for systemd package

# add systemd features to use -networkd as network manager
# add Angstrom tweaks for pager and journald config
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR_append = "+pia0002"

SRC_URI += "file://journald.conf \
	file://11-eth.network \
"

# We use systemd-networkd as the system's network-manager
PACKAGECONFIG = "xz \
	ldconfig \
	${@bb.utils.contains('DISTRO_FEATURES', 'pam', 'pam', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xkbcommon', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'selinux', 'selinux', '', d)} \
	${@bb.utils.contains('DISTRO_FEATURES', 'wifi', 'rfkill', '', d)} \
	${@bb.utils.contains('MACHINE_FEATURES', 'efi', 'efi', '', d)} \
	binfmt \
	randomseed \
	machined \
	backlight \
	quotacheck \
	hostnamed \
	${@bb.utils.contains('TCLIBC', 'glibc', 'myhostname sysusers', '', d)} \
	hibernate \
	timedated \
	timesyncd \
	localed \
	kdbus \
	ima \
	smack \
	logind \
	firstboot \
	utmp \
	polkit \
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
