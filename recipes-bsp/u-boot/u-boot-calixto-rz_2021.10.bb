require u-boot-common_${PV}.inc
require u-boot.inc

DEPENDS += "bc-native dtc-native"

UBOOT_URL = "git://github.com/eaglelinuxplatform/calixto-rz-uboot.git"

BRANCH = "v2021.10"

SRC_URI = "${UBOOT_URL};branch=${BRANCH}"
SRCREV = "d5597e4477058537e8b06d62d9aff184b13e7049"
PV = "v2021.10+git${SRCPV}"
