DESCRIPTION = "Additional demos and utility packages for piA AM35x that require more space. Can be uninstalled."
LICENSE = "MIT"

inherit packagegroup

# we don't depend on task-base-extended, as we don't want bluetooth or wifi by default
# TODO create special task for them and an image if necessary
RDEPENDS_${PN} = ' \
	packagegroup-pia \
	dbus dbus-systemd dbus-c++ \
	packagegroup-pia-qte \
'

# packages required for expansion boards, display
RRECOMMENDS_${PN} = ' \
	man man-doc \
	canutils-doc \
	gdb-doc \
	i2c-tools-doc \
	iproute2-doc \
	iw-doc \
	lighttpd-doc \
	links-doc \
	mc-doc \
	memtester-doc \
	minicom \
	mtd-utils-doc \
	openvpn-doc \
	picocom-doc \
	powertop-doc \
	ppp-doc \
	tar-doc \
	vim-doc \
	wpa-supplicant-doc \
	\
	perl perl-module-posix perl-module-exporter-heavy perl-module-fcntl \
	openvpn \
	vim \
'
#bigbuckbunny-480p \
# 	kernel-modules