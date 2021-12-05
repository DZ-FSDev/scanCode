package com.dz_fs_dev.scanCode.upc.spring;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz_fs_dev.common.Graphics2DTools;
import com.dz_fs_dev.scanCode.upc.UPCGen;
import com.google.zxing.WriterException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * UPC REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
@RestController
@RequestMapping("/scanCodeGen")
public class RESTController_scanCodeGen {
	/**
	 * Returns a generated PNG byte array representation of the requested EAN13 barcode.
	 * 
	 * @param barcode
	 * @throws IOException
	 * @throws WriterException
	 * @since 0.0.2
	 * @return The generated PNG byte array representation of the requested EAN13 barcode.
	 */
	@GetMapping(value = "/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getEAN13Barcode(@PathVariable("barcode") String barcode) throws IOException, WriterException {
		return Graphics2DTools.toPNGbytes(UPCGen.generateEAN13BarcodeImage(barcode));
	}
	
	/**
	 * Returns a generated PNG byte array representation of the requested EAN8 barcode.
	 * 
	 * @param barcode
	 * @throws WriterException 
	 * @throws IOException 
	 * @throws Exception
	 * @since 0.0.2
	 * @return The generated PNG byte array representation of the requested EAN8 barcode.
	 */
	@GetMapping(value = "/ean8/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getEAN8Barcode(@PathVariable("barcode") String barcode) throws IOException, WriterException {
		return Graphics2DTools.toPNGbytes(UPCGen.generateEAN8BarcodeImage(barcode));
	}
}
