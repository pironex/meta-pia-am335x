FILESEXTRAPATHS_prepend := "${THISDIR}/perl:"

SRC_URI += " file://perl-5.26.1-guard_old_libcrypt_fix.patch \
"
#PR_append = "+pia001"