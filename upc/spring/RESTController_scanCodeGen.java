package com.dz_fs_dev.scanCode.upc.spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz_fs_dev.scanCode.upc.UPCGen;

import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;

/**
 * UPC REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@RestController
@RequestMapping("/scanCodeGen")
public class RESTController_scanCodeGen {
	@GetMapping(value = "/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] barbecueEAN13Barcode(@PathVariable("barcode") String barcode) throws Exception {
		ByteArrayOutputStream byteArrayStream = new ByteArrayOutputStream();
		ImageIO.write(UPCGen.generateEAN13BarcodeImage(barcode), "png", byteArrayStream);
		byte[] bytes = byteArrayStream.toByteArray();

		return bytes;
	}
}
