# Image for assisting in hardware bringup

require pia335x-base-image.bb

BENCHMARK_PACKAGES = " \
	bonnie++ \
	iozone3 \
	iperf \
	lmbench \
"

HWTEST_PACKAGES = " \
	i2c-tools \
	devmem2 \
	hdparm \
	rt-tests \
	evtest \
	memtester \
	fb-test \
	ethtool \
	fixmac \
	iw \
"

DEV_PACKAGES = " \
	bash \
    gdb \
    gdbserver \
    htop \
    iotop \
"

GFX_PACKAGES = " \
	matrix-gui \
	matrix-gui-browser \
	matrix-gui-qt4-demos \
	matrix-gui-armbenchmarks-demos \
	matrix-gui-ethernet-demos \
	matrix-gui-settings-demos \
	qt4-embedded-demos \
	omapfbplay \
	qt-tstat \
	icu \
"

SOUND_PACKAGES = " \
	alsa-utils-alsamixer \
"

TOUCH_PACKAGES = " \
	tslib \
	tslib-tests \
	tslib-calibrate \
	qt4-embedded-plugin-mousedriver-tslib \
"

EXTRA_MACHINE_IMAGE_INSTALL_pia-am335x += " \
	${DEV_PACKAGES} \
	${BENCHMARK_PACKAGES} \
	${HWTEST_PACKAGES} \
"

EXTRA_MACHINE_IMAGE_INSTALL_pia-am335x_mmi += " \
	${DEV_PACKAGES} \
	${BENCHMARK_PACKAGES} \
	${HWTEST_PACKAGES} \
" 

EXTRA_MACHINE_IMAGE_INSTALL_pia-am335x_e2 += " \
	${DEV_PACKAGES} \
	${BENCHMARK_PACKAGES} \
	${HWTEST_PACKAGES} \
" 

IMAGE_INSTALL += " \
	${EXTRA_MACHINE_IMAGE_INSTALL} \
	${@base_contains("MACHINE_FEATURES", "alsa", "${SOUND_PACKAGES}", "",d)} \
	${@base_contains("MACHINE_FEATURES", "screen", "${GFX_PACKAGES}", "",d)} \
	${@base_contains("MACHINE_FEATURES", "touchscreen", "${TOUCH_PACKAGES}", "",d)} \
	mc \
"
#	libgles-omap3 \
#	libgles-omap3-blitwsegl \
#	libgles-omap3-flipwsegl \
#	libgles-omap3-frontwsegl \
#	libgles-omap3-linuxfbwsegl \
#	libgles-omap3-rawdemos \
#	omap3-sgx-modules


IMAGE_FEATURES += " ssh-server-openssh eclipse-debug tools-debug "
export IMAGE_BASENAME = "pia335x-full"

