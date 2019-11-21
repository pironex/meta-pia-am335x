#!/bin/sh

### QT Environment Variables ###
export QT_QPA_GENERIC_PLUGINS=Auto
# QT default font search path is /usr/lib/fonts
#export QT_QPA_FONTDIR=/usr/share/fonts/ttf
export QT_QPA_FONTDIR=/usr/lib/fonts
# set default platform plugin to eglfs (use -platform command line argument to use a different one)
export QT_QPA_PLATFORM=eglfs

