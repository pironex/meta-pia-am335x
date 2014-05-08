# Image for special KM boards development

CONMANPKGS += " "

require pia335x-full-image.bb

IMAGE_INSTALL += " \
	dbus-glib \
	glib-2.0 \
"

export IMAGE_BASENAME = "km-dev"

