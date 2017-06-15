# do not try to load nfsd kernel module by default
# we normally don't enable it in default kernels for piA boards
do_install_append () {
	if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
	    echo "#nfsd" > ${D}${sysconfdir}/modules-load.d/nfsd.conf
	fi
}
