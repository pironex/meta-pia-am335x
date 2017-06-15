#!/bin/bash

POKY_DIR="poky"
POKY_BRANCH="poky-morty"
BSP_LAYER_REPO_URI="git://github.com/pironex/meta-pia-am335x.git"

error_exit() {
    echo "ERROR occured! Aborting. Cleanup created files and try again"
    exit 1
}

normal_exit() {
    echo "DONE."
    exit 0
}

trap 'error_exit' ERR
trap 'normal_exit' EXIT

if [ -x ${POKY_DIR} ] ; then
    echo "ERROR: directory ${POKY_DIR} already exists"
    exit 1
fi



# poky.git
# contains oe-core, meta-poky, meta-yocto-bsp, bitbake and tools"
echo "Checkout poky.git..."
git clone git://git.yoctoproject.org/poky.git ${POKY_DIR}
cd ${POKY_DIR}
git checkout ${POKY_BRANCH}

# meta-pia-am335x.git
# BSP and image layer for pironex boards
echo "Checkout meta-pia-am335x..."
git clone ${BSP_LAYER_REPO_URI}
cd meta-pia-am335x
git checkout ${POKY_BRANCH}
cd ..

# meta-ti
# BSP layer for TI CPUs
echo "Checkout meta-ti..."
git clone git://git.yoctoproject.org/meta-ti
cd meta-ti
git checkout ${POKY_BRANCH}
cd ..

# meta-qt5
# QT5 packages
echo "Checkout meta-qt5..."
git clone git://github.com/meta-qt5/meta-qt5.git
cd meta-qt5
git checkout ${POKY_BRANCH}
cd ..

# meta-openembedded
# extra openenembedded packages not in core
echo "Checkout meta-openembedded, containint meta-oe, meta-networking, meta-systemd, meta-webserver..."
git clone git://git.openembedded.org/meta-openembedded
cd meta-openembedded
git checkout ${POKY_BRANCH}
cd ..

# meta-qt4
# QT4 (just for reference, some unused packages in meta-pia-am335x depend on it)
echo "Checkout meta-qt4..."
git clone git://git.yoctoproject.org/meta-qt4
cd meta-qt4
git checkout ${POKY_BRANCH}
cd ..



# init build config
echo "Configuring build system..."
mkdir build
cd build
mkdir conf
# use example configuration from meta-pia-am335x
ln -s ../../meta-pia-am335x/conf/local.conf local.conf
ln -s ../../meta-pia-am335x/conf/bblayers.conf bblayers.conf
cd ..
cd ..

echo "Success."
exit 0


# Verwendung

# Kurzanleitung unter https://www.yoctoproject.org/docs/current/yocto-project-qs/yocto-project-qs.html
# Abhängigkeiten:
# Git 1.8.3.1 or greater
# tar 1.24 or greater
# Python 3.4.0 or greater.
# Außerdem:
# sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
#     build-essential chrpath socat libsdl1.2-dev xterm

