# HACK: force gcc-5 when gcc-6+ is installed on the build host
# there are some issues building elfutils with gcc-7 which are fixed in
# later versions
BUILD_CC_class-native="gcc-5"
BUILD_CCLD_class-native="gcc-5"
BUILD_CXX_class-native="g++-5"
