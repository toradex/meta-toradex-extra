SUMMARY = "Demo application drawing rectangles on screen using fbdev"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=69acbe326b9e7b4c7e760520f4a25598"

SRC_URI = "git://github.com/toradex/cairo-fb-examples;branch=master"
SRCREV = "1abe16dc00900c4797e5e24abaa9de81866f8fc3"

S = "${WORKDIR}/git/rectangles/"

do_install() {
    install -d ${D}${bindir}
    install rectangles ${D}${bindir}
}

DEPENDS = "cairo tslib"
RDEPENDS_${PN} = "zlib"
RRECOMMENDS_${PN} = "tslib-calibrate"
