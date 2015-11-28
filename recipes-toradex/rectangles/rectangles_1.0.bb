SUMMARY = "Demo application drawing rectangles on screen using fbdev"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=69acbe326b9e7b4c7e760520f4a25598"

SRC_URI = "git://github.com/toradex/cairo-fb-examples;branch=master"
SRCREV = "ad6bbf734a445947e6bb309520381c39931a6ff6"

S = "${WORKDIR}/git/rectangles/"

do_install() {
    install -d ${D}${bindir}
    install rectangles ${D}${bindir}
}

RDEPENDS_${PN} = "cairo tslib zlib"
RRECOMMENDS_${PN} = "tslib-calibrate"
