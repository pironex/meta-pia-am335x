FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

PR_append = "+pia002"

# when using PAM PasswordAuthentication has to be set to no to allow empty root
# password logins, without PAM the settings work as expected.
#
# The default Poky images don't use PAM when not in LSB mode.
# The ssh empty password permissions itself are set depending on the 
# IMAGE_FEATURES 'allow-empty-password' setting during rootfs generation
# (see PermitRootLogin and PermitEmptyPasswords in sshd_config)
do_install_append() {
	if ${@bb.utils.contains('DISTRO_FEATURES','pam','true','false',d)}; then
		sed -i -e 's:^.?PasswordAuthentication.*$:PasswordAuthentication no:g' ${D}${sysconfdir}/ssh/sshd_config
		sed -i -e 's:^.?UsePam.*$:UsePam yes:g' ${D}${sysconfdir}/ssh/sshd_config
	else
		sed -i -e 's:^.?PasswordAuthentication.*$:PasswordAuthentication yes:g' ${D}${sysconfdir}/ssh/sshd_config
		sed -i -e 's:^.?UsePam.*$:UsePam no:g' ${D}${sysconfdir}/ssh/sshd_config
	fi
}
