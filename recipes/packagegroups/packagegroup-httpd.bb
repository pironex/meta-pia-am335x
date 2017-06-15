DESCRIPTION = "Local webserver and related tools."
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = " \
	lighttpd \
"

RRECOMMENDS_${PN} = " \
	lighttpd-module-auth \
	lighttpd-module-cgi \
	lighttpd-module-compress \
	lighttpd-module-fastcgi \
	lighttpd-module-magnet \
	lighttpd-module-redirect \
	lighttpd-module-rewrite \
	lighttpd-module-ssi \
"

# fast-cgi?

