include qt-automotive-cluster-demo.inc

SRC_URI_append = " \
	file://mcc.conf \
	git://github.com/toradex/QtAutomotiveClusterDemo.git;branch=embedded-world-2015 \
"

SRCREV = "ed61ba9101302be288a013f221da7513e3ce84ab"

RDEPENDS_${PN}_append = " \
        libmcc \
        kernel-module-mcc \
        mqxboot \
"

# Add kernel include directory for vf610_sema4.h header file
CFLAGS += "-I${STAGING_KERNEL_DIR}/include"

do_install_append() {
	install -d ${D}${sysconfdir}/modules-load.d/
	install -m 0644 ${WORKDIR}/mcc.conf ${D}${sysconfdir}/modules-load.d/
}
