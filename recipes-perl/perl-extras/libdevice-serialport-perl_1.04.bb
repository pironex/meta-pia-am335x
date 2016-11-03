SUMMARY = "Device::SerialPort - Linux/POSIX emulation of Win32::SerialPort functions."
AUTHOR = "Kees Cook <pause.cpan1@outflux.net>"
HOMEPAGE = "https://metacpan.org/release/Device-SerialPort"
SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-1.0+"
LIC_FILES_CHKSUM = "file://README;md5=34e53f81e654ff1fb3e5f6c5735bd1f9"

SRC_URI = "http://cpan.metacpan.org/authors/id/C/CO/COOK/Device-SerialPort-${PV}.tar.gz"
SRC_URI[md5sum] = "82c698151f934eb28c65d1838cee7d9e"
SRC_URI[sha256sum] = "d392567cb39b4ea606c0e0acafd8ed72320311b995336ece5fcefcf9b150e9d7"

S = "${WORKDIR}/Device-SerialPort-${PV}"

inherit cpan

do_configure_prepend () {
	mkdir -p m4
	autoreconf -Wcross --verbose --install --force || oefatal "autoreconf execution failed."
	sed -i 's:\./configure\(.[^-]\):./configure --build=${BUILD_SYS} --host=${HOST_SYS} --target=${TARGET_SYS} --prefix=${prefix} --exec_prefix=${exec_prefix} --bindir=${bindir} --sbindir=${sbindir} --libexecdir=${libexecdir} --datadir=${datadir} --sysconfdir=${sysconfdir} --sharedstatedir=${sharedstatedir} --localstatedir=${localstatedir} --libdir=${libdir} --includedir=${includedir} --oldincludedir=${oldincludedir} --infodir=${infodir} --mandir=${mandir}\1:' Makefile.PL
}

RPROVIDES_${PN} = "device-serialport-perl"
RREPLACES_${PN} = "device-serialport-perl"
RCONFLICTS_${PN} = "device-serialport-perl"

BBCLASSEXTEND="native"
