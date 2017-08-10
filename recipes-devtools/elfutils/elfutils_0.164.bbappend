# HACK: force gcc-6 when gcc-7 is installed on the build host
# there are some issues building elfutils with gcc-7 which are fixed in
# later versions
BUILD_CC_class-native="gcc-6"
BUILD_CCLD_class-native="gcc-6"
BUILD_CXX_class-native="g++-6"