PACKAGECONFIG = "egl kms launch libinput systemd"
#PACKAGECONFIG += " fbdev"

# When configured for fbdev compositor, make it the default
PACKAGECONFIG[fbdev] = "--enable-fbdev-compositor WESTON_NATIVE_BACKEND="fbdev-backend.so",--disable-fbdev-compositor,udev mtdev"
# KMS configuration from arago-dist
# weston only requires libgbm, which will be taken from TI's libgbm instead of mesa, which fails to compile
# as libgbm is provided by mesa and libgbm
PACKAGECONFIG[kms] = "--enable-drm-compositor,--disable-drm-compositor,drm udev libgbm mtdev"

PR_append = "-pia003"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

RDEPENDS_${PN} += "weston-conf"

SRC_URI += " \
	file://0001-weston1.9.0-Enabling-DRM-backend-with-multiple-displ.patch \
	file://0002-Weston1.9.0-Allow-visual_id-to-be-0.patch \
	file://0003-Weston1.9.0-Fix-virtual-keyboard-display-issue-for-Q.patch \
	file://0004-Weston1.9.0-Fix-touch-screen-crash-issue.patch \
"

# this patch added by TI breaks the device detection somehow
# on piA we see LCDC on /dev/dri/card1 and SGX on /dev/dri/card0
# => we need card1 not the 3D device
#	file://0001-udev-seat-restrict-udev-enumeration-to-card0.patch \
#
