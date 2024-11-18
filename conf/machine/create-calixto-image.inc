create_rz_image () {

CALIXTO_IMAGE_PATH_SDCARD="${DEPLOY_DIR}/../../../calixto-images/${MACHINE}/sdcard"

mkdir -p ${CALIXTO_IMAGE_PATH_SDCARD}
rm -rf ${CALIXTO_IMAGE_PATH_SDCARD}/*

cp -v ${DEPLOY_DIR_IMAGE}/bl2_bp-${MACHINE}.srec ${CALIXTO_IMAGE_PATH_SDCARD}/bl2_bp-${MACHINE}.srec

cp -v ${DEPLOY_DIR_IMAGE}/fip-${MACHINE}.srec ${CALIXTO_IMAGE_PATH_SDCARD}/fip-${MACHINE}.srec


cp ${DEPLOY_DIR}/../../../meta-calixto-rz/recipes-bsp/rz-image-flasher/create-sdcard-boot.sh ${CALIXTO_IMAGE_PATH_SDCARD}

find ${DEPLOY_DIR_IMAGE}/ -name "*.mot" -exec cp {} ${CALIXTO_IMAGE_PATH_SDCARD}/ \;

find ${DEPLOY_DIR_IMAGE}/ -name "*.rootfs.tar" -exec cp {} ${CALIXTO_IMAGE_PATH_SDCARD}/rootfs.tar \;
}

 
