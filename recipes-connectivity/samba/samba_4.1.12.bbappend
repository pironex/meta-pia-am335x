PR_append = "+pia001"

# /usr/lib/perl5 is a symlink to /usr/lib/perl, don't install into perl5
# as this would create perl5 directory not a symlink 
PERL_VERNDORLIB="${libdir}/perl/vendor_perl/${PERLVERSION}"
