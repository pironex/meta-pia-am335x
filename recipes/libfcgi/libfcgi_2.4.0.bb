DESCRIPTION = "C CGI library"
HOMEPAGE = "http://fastcgi.com"
SUMMARY  = "FIXME"
LICENSE  = ""

LIC_FILES_CHKSUM = "file://LICENSE.TERMS;md5=e3aacac3a647af6e7e31f181cda0a06a"

SRC_URI  = "http://www.fastcgi.com/dist/fcgi-${PV}.tar.gz"



SRC_URI[md5sum] = "d15060a813b91383a9f3c66faf84867e"
SRC_URI[sha256sum] = "66fc45c6b36a21bf2fbbb68e90f780cc21a9da1fffbae75e76d2b4402d3f05b9"

inherit autotools

S = "${WORKDIR}/fcgi-${PV}"

# autoreconf couldn't find acinclude.m4 when stepping into subdirectory. Instead of
# duplicating acinclude.m4 in every subdirectory, use absolute include path to aclocal

#BBCLASSEXTEND = "native"

