DEPENDS += " mysql5 "

QT_SQL_DRIVER_FLAGS = "-no-sql-ibase -plugin-sql-mysql -no-sql-psql -no-sql-odbc -plugin-sql-sqlite -system-sqlite"

QT_CONFIG_FLAGS += "-I${STAGING_INCDIR}/mysql"