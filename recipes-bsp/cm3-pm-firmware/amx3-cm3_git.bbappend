PR_append = "+pia001"

# force usage of the BFD linker instead of the default gold which creates a broken binary
# for the CM3 controller
TOOLCHAIN_OPTIONS += "${@bb.utils.contains('DISTRO_FEATURES', 'ld-is-gold', '-fuse-ld=bfd', '', d)}"
