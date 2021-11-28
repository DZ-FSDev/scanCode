package com.dz_fs_dev.scanCode.upc;

import java.awt.image.BufferedImage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Contains various methods for processing UPCs.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
public final class UPCGen {
	private UPCGen() {}
	
	public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws WriterException {
		EAN13Writer ean13BarcodeWriter = new EAN13Writer();
	    BitMatrix bitMatrix = ean13BarcodeWriter.encode(barcodeText, BarcodeFormat.EAN_13, 300, 150);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	public static BufferedImage generateQRCodeImage(String barcodeText) throws Exception {
	    QRCodeWriter qrBarcodeWriter = new QRCodeWriter();
	    BitMatrix bitMatrix = 
	    		qrBarcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 200, 200);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
}
