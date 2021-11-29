package com.dz_fs_dev.scanCode.upc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.QRCodeWriter;

import com.dz_fs_dev.common.Graphics2DTools;

/**
 * Contains various methods for processing UPCs.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.3
 */
public final class UPCGen {
	private UPCGen() {}
	
	/**
	 * Generates an EAN13 Barcode for a specified text to encode.
	 * 
	 * @param barcodeText The text to encode.
	 * @return The EAN13 Barcode.
	 * @throws WriterException
	 * @since 0.0.2
	 */
	public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws WriterException {
		EAN13Writer ean13BarcodeWriter = new EAN13Writer();
	    BitMatrix bitMatrix = ean13BarcodeWriter.encode(barcodeText, BarcodeFormat.EAN_13, 300, 150);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	/**
	 * Generates an EAN13 Barcode for a specified text to encode and saves it to a file.
	 * 
	 * @param barcodeText The text to encode.
	 * @param file The file to save the EAN13 barcode to as a PNG.
	 * @throws WriterException
	 * @throws IOException
	 * @since 0.0.3
	 */
	public static void generateEAN13BarcodeImage(String barcodeText, File file) throws WriterException, IOException {
		Graphics2DTools.saveAsPNG(generateEAN13BarcodeImage(barcodeText), file);
	}
	
	/**
	 * Generates a QR Code for a specified text to encode.
	 * 
	 * @param barcodeText The text to encode.
	 * @return The QR Code.
	 * @throws WriterException 
	 * @since 0.0.2
	 */
	public static BufferedImage generateQRCodeImage(String barcodeText) throws WriterException  {
	    QRCodeWriter qrBarcodeWriter = new QRCodeWriter();
	    BitMatrix bitMatrix = 
	    		qrBarcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
}
