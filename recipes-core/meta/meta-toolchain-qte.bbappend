toolchain_create_sdk_env_script_append() {
	echo 'export OE_QMAKE_HOST_BINDIR_QT=${QT_TOOLS_PREFIX}' >> $script
	#echo 'export OE_QMAKE_STRIP="echo"' >> $script

	echo 'export QMAKE_DEFAULT_LIBDIRS=${QT_QMAKE_LIBDIR_QT}' >> $script
	echo 'export QMAKE_DEFAULT_INCDIRS=${QT_QMAKE_INCDIR_QT}' >> $script

	#Adds qt.conf file that points qmake to properly locate Qt library and header files.
	#This enables Qt Creator to work properly
	#taken from meta-arago's meta-toolchain-arago-qte.bb

	qt_conf="${SDK_OUTPUT}/${SDKPATHNATIVE}${bindir_nativesdk}/qt.conf"
	touch $qt_conf
	echo '[Paths]' >> $qt_conf
	echo 'Prefix = ${SDKTARGETSYSROOT}/${prefix_nativesdk}' >> $qt_conf
	echo 'Libraries = ${SDKTARGETSYSROOT}/${libdir}' >> $qt_conf
	echo 'Headers = ${SDKTARGETSYSROOT}/${includedir}/${QT_DIR_NAME}' >> $qt_conf
	echo 'HostPrefix = ${SDKPATHNATIVE}/usr' >> $qt_conf
	echo 'HostBinaries = ${SDKPATHNATIVE}/usr/bin' >> $qt_conf
}
