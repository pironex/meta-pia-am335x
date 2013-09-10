toolchain_create_sdk_env_script_append() {
	#Adds qt.conf file that points qmake to properly locate Qt library and header files.
	#This enables Qt Creator to work properly
	#taken from meta-arago's meta-toolchain-arago-qte.bb

	qt_conf="${SDK_OUTPUT}/${SDKPATHNATIVE}${bindir_nativesdk}/qt.conf"
	touch $qt_conf
	echo '[Paths]' >> $qt_conf
	echo 'Prefix = $(SDK_PATH_TARGET)' >> $qt_conf
	echo 'Libraries = $(OE_QMAKE_LIBDIR_QT)' >> $qt_conf
	echo 'Headers = $(OE_QMAKE_INCDIR_QT)' >> $qt_conf
}
