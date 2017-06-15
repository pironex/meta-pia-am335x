DESCRIPTION = "Base console image with full featured Linux system functionality."

IMAGE_FEATURES += "splash ssh-server-openssh package-management"

EXTRA_MACHINE_IMAGE_INSTALL ?= ""

IMAGE_INSTALL += " \
	packagegroup-core-boot \
	packagegroup-core-full-cmdline \
	${CORE_IMAGE_EXTRA_INSTALL} \
	packagegroup-pia-tools \
	${@bb.utils.contains("MACHINE_FEATURES", "alsa", "packagegroup-pia-audio", "",d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "gsm", "packagegroup-pia-gsm", "", d)} \
	${@bb.utils.contains("MACHINE_FEATURES", "usbhost", "usbutils", "", d)} \
	cpufreq-tweaks \
	systemd-analyze \
"

export IMAGE_BASENAME = "pia335x-base"

inherit core-image
