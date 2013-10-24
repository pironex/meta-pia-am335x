require linux-pia335x_3.2.x.inc

SRC_URI_append = " ${PATCHES} "

#PATCHES = " file://0001-am33x-Add-memory-addresses-for-crypto-modules.patch \
#                file://0002-am33x-Add-crypto-device-and-resource-structures.patch \
#                file://0003-am33x-Add-crypto-device-and-resource-structure-for-T.patch \
#                file://0004-am33x-Add-crypto-drivers-to-Kconfig-and-Makefiles.patch \
#                file://0005-am33x-Create-header-file-for-OMAP4-crypto-modules.patch \
#                file://0006-am33x-Create-driver-for-TRNG-crypto-module.patch \
#                file://0007-am33x-Create-driver-for-AES-crypto-module.patch \
#                file://0008-am33x-Create-driver-for-SHA-MD5-crypto-module.patch \
#                file://0002-AM335x-OCF-Driver-for-Linux-3.patch \
#                file://0001-am335x-Add-crypto-driver-settings-to-defconfig.patch \
#                file://0001-am335x-Add-pm_runtime-API-to-crypto-driver.patch \
#                file://0002-am335x-Add-suspend-resume-routines-to-crypto-driver.patch \
#                file://0001-ARM-AM33xx-hwmod-Convert-SHA0-crypto-device-data-to-.patch \
#                file://0002-crypto-omap4-sham-Use-finer-grained-PM-management.patch \
#                file://0003-crypto-omap4-sham-Add-suspend-resume-PM-support.patch \
#                file://0004-crypto-omap4-sham-Don-t-use-hardcoded-base-address.patch \
#                file://0005-ARM-AM33xx-hwmod-Convert-AES0-crypto-device-data-to-.patch \
#                file://0006-crypto-omap4-aes-User-finer-grained-PM-management.patch \
#                file://0007-crypto-omap4-aes-Add-suspend-resume-PM-support.patch \
#                file://0008-crypto-omap4-aes-Don-t-use-hardcoded-base-address.patch \
#                file://0009-ARM-AM33xx-hwmod-Convert-RNG-device-data-to-hwmod.patch \
#                file://0010-hwrng-omap4-rng-Convert-to-use-pm_runtime-API.patch \
#                file://0001-omap4-rng-Remove-check-for-GP-only-device-type-in-RN.patch \
#"
PATCHES = " file://0001-am33x-Add-memory-addresses-for-crypto-modules.patch \
	file://0002-am33x-Add-crypto-device-and-resource-structures.patch \
	file://0003-am33x-Add-crypto-device-and-resource-structure-for-T.patch \
	file://0004-am33x-Add-crypto-drivers-to-Kconfig-and-Makefiles.patch \
	file://0005-am33x-Create-header-file-for-OMAP4-crypto-modules.patch \
	file://0006-am33x-Create-driver-for-TRNG-crypto-module.patch \
	file://0007-am33x-Create-driver-for-AES-crypto-module.patch \
	file://0008-am33x-Create-driver-for-SHA-MD5-crypto-module.patch \
	file://0009-Add-crypto-driver-settings-to-defconfig.patch \
	file://0010-AM335x-OCF-Driver-for-Linux-3.patch \
	file://0011-Add-pm_runtime-API-to-crypto-driver.patch \
	file://0012-Add-suspend-resume-routines-to-crypto-driver.patch \
	file://0013-ARM-AM33xx-hwmod-Convert-SHA0-crypto-device-data-to-.patch \
	file://0014-crypto-omap4-sham-Use-finer-grained-PM-management.patch \
	file://0015-crypto-omap4-sham-Add-suspend-resume-PM-support.patch \
	file://0016-crypto-omap4-sham-Don-t-use-hardcoded-base-address.patch \
	file://0017-ARM-AM33xx-hwmod-Convert-AES0-crypto-device-data-to-.patch \
	file://0018-crypto-omap4-aes-User-finer-grained-PM-management.patch \
	file://0019-crypto-omap4-aes-Add-suspend-resume-PM-support.patch \
	file://0020-crypto-omap4-aes-Don-t-use-hardcoded-base-address.patch \
	file://0021-ARM-AM33xx-hwmod-Convert-RNG-device-data-to-hwmod.patch \
	file://0022-hwrng-omap4-rng-Convert-to-use-pm_runtime-API.patch \
	file://0023-omap4-rng-Remove-check-for-GP-only-device-type-in-RN.patch \
	file://0024-fix-permissions-that-got-changed-by-crypto-patches.patch \
	file://0025-pia335x-fix-compilation-error-caused-by-am33xx_cpuid.patch \
	file://0026-random-ocf-fix-internal-api-usage-for-mix_pool_bytes.patch \
	file://0027-am33xx-force-sleep33xx.S-to-arm-mode-if-thumb-is-ena.patch \
"
