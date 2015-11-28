FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot-toradex:"

SRC_URI += "file://boot-fast-config.patch \
	    file://boot-config.patch"
