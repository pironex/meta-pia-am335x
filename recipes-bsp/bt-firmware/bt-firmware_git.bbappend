PR = "r4+pia001+gitr${SRCPV}"

COMPATIBLE_MACHINE = "ti33x"

LIC_FILES_CHKSUM = "file://am335x/LICENCE;md5=1c9961176d6529283e0d0c983be41b45 \
"

SRCREV = "fbcab22449ce930a4192ffeb470c168f4e85e0c6"
SRC_URI = "git://git.ti.com/wilink8-bt/ti-bt-firmware.git;protocol=git \
           file://0001-Makefile-allow-building-within-the-OE.patch"
