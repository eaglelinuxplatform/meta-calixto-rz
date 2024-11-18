require conf/machine/include/${SOC_FAMILY}.inc
require conf/machine/include/rzg2-common-calixto.inc
require include/ecc-control.inc

# Firmware-pack 
EXTRA_IMAGEDEPENDS += " firmware-pack-calixto-rz"

MACHINEOVERRIDES =. "rzg2l:"

MACHINE_FEATURES_append = " bayer2raw"
