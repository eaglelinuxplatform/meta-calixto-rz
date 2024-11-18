LIC_FILES_CHKSUM = "file://docs/license.rst;md5=b2c740efedc159745b9b31f88ff03dde"

require fiptool-native.inc

URL = "git://github.com/eaglelinuxplatform/calixto-rz-atf.git"
BRANCH = "v2.7/rz"
SRCREV = "570290b2f622c0f6380ee59e44b2e14e9ba05759"

SRC_URI = "${URL};protocol=https;branch=${BRANCH}"

PV = "2.7+git${SRCPV}"
PR = "r1"



