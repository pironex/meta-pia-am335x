# Image for assisting in hardware bringup

require pia335x-base-image.bb

BENCHMARK_PACKAGES = " \
	bonnie++ \
	iozone3 \
	iperf \
	lmbench \
"

HWTOOLS_PACKAGES = " \ 
	evtest \
	hdparm \
	memtester \
	powertop \
	rt-tests \
"

DEV_PACKAGES = " \
	bash \
    gdb \
    gdbserver \
    htop \
    iotop \
    latencytop \
"

SOUND_PACKAGES = " \
	alsa-utils-alsamixer \
"

EXTRA_MACHINE_IMAGE_INSTALL_pia-am335x += " \
	${DEV_PACKAGES} \
	${BENCHMARK_PACKAGES} \
	${HWTOOLS_PACKAGES} \
"

EXTRA_MACHINE_IMAGE_INSTALL_pia-am335x_mmi += " \
	${DEV_PACKAGES} \
	${BENCHMARK_PACKAGES} \
	${HWTOOLS_PACKAGES} \
" 

EXTRA_MACHINE_IMAGE_INSTALL_pia-am335x_e2 += " \
	${DEV_PACKAGES} \
	${BENCHMARK_PACKAGES} \
	${HWTOOLS_PACKAGES} \
"

EXTRA_MACHINE_IMAGE_INSTALL_pia-am35x += " \
	${DEV_PACKAGES} \
	${BENCHMARK_PACKAGES} \
	${HWTOOLS_PACKAGES} \
" 

IMAGE_INSTALL += " \
	${EXTRA_MACHINE_IMAGE_INSTALL} \
	${@base_contains("MACHINE_FEATURES", "alsa", "${SOUND_PACKAGES}", "",d)} \
	${@base_contains("MACHINE_FEATURES", "screen", "packagegroup-pia-gfx", "",d)} \
	mc \
"
#	libgles-omap3 \
#	libgles-omap3-blitwsegl \
#	libgles-omap3-flipwsegl \
#	libgles-omap3-frontwsegl \
#	libgles-omap3-linuxfbwsegl \
#	libgles-omap3-rawdemos \
#	omap3-sgx-modules


export IMAGE_BASENAME = "pia335x-full"

