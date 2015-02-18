QTNAME = "qte"
QT_DIR_NAME = "qtopia"

RDEPENDS_${PN} += " \
	libmcc \
"
require recipes-qt/meta/meta-toolchain-qt.inc
