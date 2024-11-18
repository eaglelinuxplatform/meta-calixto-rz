LIC_FILES_CHKSUM = "file://LICENSE.md;md5=1fb5dca04b27614d6d04abca6f103d8d"
LICENSE="BSD-3-Clause"
PV = "1.06+git${SRCPV}"

PACKAGE_ARCH = "${MACHINE_ARCH}"

FLASH_WRITER_URL = "git://github.com/eaglelinuxplatform/calixto-rz-flashwriter"
BRANCH = "rz_g2l"

SRC_URI = "${FLASH_WRITER_URL};branch=${BRANCH}"
SRCREV = "690f2d1b4fa48fc1ba822a69e46f124064a78774"

inherit deploy
#require include/provisioning.inc

S = "${WORKDIR}/git"
PMIC_BUILD_DIR = "${S}/build_pmic"

do_compile() {
        if [ "${MACHINE}" = "rzg2l-optima-1gb" ]; then
                BOARD="RZG2L_OPTIMA_SOM_1GB";
	elif [ "${MACHINE}" = "rzg2l-optima-2gb" ]; then
		BOARD="RZG2L_OPTIMA_SOM_2GB";
        elif [ "${MACHINE}" = "rzg2l-versa-1gb" ]; then
                BOARD="RZG2L_VERSA_SOM_1GB";
	elif [ "${MACHINE}" = "rzg2l-versa-2gb" ]; then
		BOARD="RZG2L_VERSA_SOM_2GB";
	elif [ "${MACHINE}" = "rzv2l-optima-1gb" ]; then
		BOARD="RZV2L_OPTIMA_SOM_1GB";
	elif [ "${MACHINE}" = "rzv2l-optima-2gb" ]; then
		BOARD="RZV2L_OPTIMA_SOM_2GB";
	elif [ "${MACHINE}" = "rzv2l-versa-1gb" ]; then
		BOARD="RZV2L_VERSA_SOM_1GB";
	elif [ "${MACHINE}" = "rzv2l-versa-2gb" ]; then
		BOARD="RZV2L_VERSA_SOM_2GB";
        fi
        cd ${S}

	oe_runmake BOARD=${BOARD}

        if [ "${PMIC_SUPPORT}" = "1" ]; then
		oe_runmake OUTPUT_DIR=${PMIC_BUILD_DIR} clean;
		oe_runmake BOARD=${PMIC_BOARD} OUTPUT_DIR=${PMIC_BUILD_DIR};
	fi
}

do_install[noexec] = "1"

do_deploy() {
        install -d ${DEPLOYDIR}
        install -m 644 ${S}/AArch64_output/*.mot ${DEPLOYDIR}
        if [ "${PMIC_SUPPORT}" = "1" ]; then
        	install -m 644 ${PMIC_BUILD_DIR}/*.mot ${DEPLOYDIR}
	fi
}
PARALLEL_MAKE = "-j 1"
addtask deploy after do_compile
