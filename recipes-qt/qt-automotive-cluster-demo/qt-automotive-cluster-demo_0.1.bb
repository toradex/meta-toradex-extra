DESCRIPTION = "The instrument cluster is used to display status of the vehicle systems, \
               information and drive conditions. This includes gauges for various parameters, \
               indicators and status lights but also displays and acoustical effects."

HOMEPAGE = "http://www.toradex.com"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README.md;md5=ef04578258c3a626c9ce8ac0141858e4 \
                   "

PR = "r4"

SRC_URI = "git://github.com/toradex/QtAutomotiveClusterDemo.git \
           "

SRCREV = "93ccd9d2aefa844035ca3976f5e8dceed007f80a"


SRC_URI[md5sum] = "142ef697332e0777c6d22c5bc96cc438"
SRC_URI[sha256sum] = "e4d0c005d2cb1d7c09438bfc3098eadebc08946e4fbc0655b7fc8b046de3810d"

#S = "${WORKDIR}/QtAutomotiveClusterDemo-${PV}"
S = "${WORKDIR}/git"

#inherit qt4x11
inherit qt4e

EXTRA_QMAKEVARS_PRE += "CONFIG+=no-webcam DEFINES+=RESOLUTION_1024x600"


TOUCH = ' ${@base_contains("MACHINE_FEATURES", "touchscreen", "tslib tslib-calibrate tslib-tests", "",d)}'

RDEPENDS_${PN} = " \
        libqt-embedded3support4 \
        libqt-embeddeddeclarative4 \
        libqt-embeddedcore4 \
        libqt-embeddedgui4 \
        libqt-embeddedhelp4 \
        libqt-embeddedsvg4 \
        libqt-embeddedxml4 \
        qt4-embedded-fonts-ttf-dejavu \
        qt4-embedded-fonts-ttf-vera \
        qt4-embedded-plugin-imageformat-svg \
        qt4-embedded-plugin-imageformat-jpeg \
        qt4-embedded-plugin-mousedriver-tslib \
        ${TOUCH} \
        qt4-embedded-assistant \
        libmcc \
        kernel-module-mcc \
        mqxboot \
"


do_install() {
	oe_runmake INSTALL_ROOT=${D} install
}

FILES_${PN}-dbg += "${bindir}/.debug"

#do_install() {
#        export INSTALL_ROOT=${D}
#        make install
#}



# Ensure we have some plugins for some useful image formats
RRECOMMENDS_${PN} += "qt4-plugin-imageformat-gif qt4-plugin-imageformat-jpeg qt4-plugin-imageformat-tiff"
