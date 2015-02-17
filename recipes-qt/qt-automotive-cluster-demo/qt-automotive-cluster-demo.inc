DESCRIPTION = "The instrument cluster is used to display status of the vehicle systems, \
               information and drive conditions. This includes gauges for various parameters, \
               indicators and status lights but also displays and acoustical effects."

HOMEPAGE = "http://www.toradex.com"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://README.md;md5=ef04578258c3a626c9ce8ac0141858e4 \
                   "

PR = "r1"

SRC_URI = " \
	file://qt-automotive-cluster-demo.service \
	file://mouse.rules \
	file://keyboard.rules \
"

SRC_URI[md5sum] = "142ef697332e0777c6d22c5bc96cc438"
SRC_URI[sha256sum] = "e4d0c005d2cb1d7c09438bfc3098eadebc08946e4fbc0655b7fc8b046de3810d"

#S = "${WORKDIR}/QtAutomotiveClusterDemo-${PV}"
S = "${WORKDIR}/git"

inherit qt4e systemd

EXTRA_QMAKEVARS_PRE += "CONFIG+=no-webcam DEFINES+=RESOLUTION_800x480"


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
"


do_install() {
	oe_runmake INSTALL_ROOT=${D} install

	install -d ${D}${sysconfdir}/udev/rules.d/
	install -m 0644 ${WORKDIR}/mouse.rules ${D}${sysconfdir}/udev/rules.d/
	install -m 0644 ${WORKDIR}/keyboard.rules ${D}${sysconfdir}/udev/rules.d/

	install -d ${D}${systemd_unitdir}/system/
	install -m 0644 ${WORKDIR}/qt-automotive-cluster-demo.service ${D}${systemd_unitdir}/system
}

FILES_${PN}-dbg += "${bindir}/.debug"

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "qt-automotive-cluster-demo.service"
