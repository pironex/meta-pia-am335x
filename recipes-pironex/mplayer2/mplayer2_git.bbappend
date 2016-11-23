FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS = "libvpx libdvdread libtheora virtual/libsdl ffmpeg zlib \
           libpng jpeg liba52 freetype fontconfig alsa-lib lzo ncurses \
           libass speex faad2 \
           directfb directfb-examples tslib pointercal"

# Depends on xsp, libxv, virtual/libx11, libxscrnsaver
REQUIRED_DISTRO_FEATURES = ""

#SRCREV = "95e81df132e3dbc555974d125e56ae701a0f6968"

PR_append = "p01"

PACKAGECONFIG = "vorbis postproc directfb "
PACKAGECONFIG[portaudio] = ""

EXTRA_OECONF = " \
    --prefix=/usr \
    --mandir=${mandir} \
    --target=${SIMPLE_TARGET_SYS} \
    \
    --disable-lirc \
    --disable-lircc \
    --disable-joystick \
    --disable-vm \
    --disable-xf86keysym \
    --enable-tv \
    --enable-tv-v4l2 \
    --disable-tv-bsdbt848 \
    --enable-rtc \
    --enable-networking \
    --disable-smb \
    --disable-dvdnav \
    --enable-dvdread \
    --disable-dvdread-internal \
    --disable-libdvdcss-internal \
    --disable-enca \
    --disable-ftp \
    --disable-vstream \
    \
    --disable-gif \
    --enable-png \
    --enable-jpeg \
    --disable-libcdio \
    --disable-qtx \
    --disable-xanim \
    --disable-real \
    --disable-xvid \
    \
    --enable-speex \
    --enable-theora \
    --disable-ladspa \
    --disable-libdv \
    --enable-mad \
    --disable-xmms \
    --disable-musepack \
    \
    --disable-gl \
    --enable-sdl \
    --disable-caca \
    --disable-directx \
    --disable-dvb \
    --disable-xv \
    --disable-vm \
    --disable-xinerama \
    --disable-x11 \
    --enable-directfb \
    --disable-tga \
    --disable-pnm \
    --disable-md5sum \
    \
    --enable-alsa \
    --enable-ossaudio \
    --disable-pulse \
    --disable-jack \
    --disable-openal \
    --enable-select \
    \
    --extra-libs=' -lvorbis -ltheoradec -lasound ' \
"
#    --enable-libass
