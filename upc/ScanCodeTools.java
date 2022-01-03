/*  Original Licensing Copyright
 * 
 *  Various methods for processing UPCs.
 *  Copyright (C) 2022  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.dz_fs_dev.scanCode.upc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;
import com.google.zxing.oned.EAN13Writer;
import com.google.zxing.oned.EAN8Writer;
import com.google.zxing.oned.UPCAWriter;
import com.google.zxing.oned.UPCEWriter;
import com.google.zxing.qrcode.QRCodeWriter;

import com.dz_fs_dev.common.Graphics2DTools;

/**
 * Contains various methods for processing UPCs.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.10
 */
public final class ScanCodeTools {
	private static int WIDTH_1D = 300;
	private static int HEIGHT_1D = 150;

	private ScanCodeTools() {}

	/**
	 * Generates an EAN8 Barcode for a specified text to encode.
	 * 
	 * @param barcodeText The text to encode.
	 * @return The EAN8 Barcode.
	 * @throws WriterException
	 * @since 0.0.5
	 */
	public static BufferedImage generateEAN8BarcodeImage(String barcodeText) throws WriterException {
		EAN8Writer ean8BarcodeWriter = new EAN8Writer();
	    BitMatrix bitMatrix = ean8BarcodeWriter.encode(barcodeText, BarcodeFormat.EAN_8, WIDTH_1D, HEIGHT_1D);

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
	 * Generates an EAN13 Barcode for a specified text to encode.
	 * 
	 * @param barcodeText The text to encode.
	 * @return The EAN13 Barcode.
	 * @throws WriterException
	 * @since 0.0.5
	 */
	public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws WriterException {
		EAN13Writer ean13BarcodeWriter = new EAN13Writer();
		BitMatrix bitMatrix = ean13BarcodeWriter.encode(barcodeText, BarcodeFormat.EAN_13, WIDTH_1D, HEIGHT_1D);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	/**
	 * Generates an UPC-A Barcode for a specified text to encode.
	 * 
	 * @param barcodeText The text to encode.
	 * @return The UPC-A Barcode.
	 * @throws WriterException
	 * @since 0.0.5
	 */
	public static BufferedImage generateUPCABarcodeImage(String barcodeText) throws WriterException {
		UPCAWriter upcABarcodeWriter = new UPCAWriter();
	    BitMatrix bitMatrix = upcABarcodeWriter.encode(barcodeText, BarcodeFormat.UPC_A, WIDTH_1D, HEIGHT_1D);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	/**
	 * Generates an UPC-E Barcode for a specified text to encode.
	 * 
	 * @param barcodeText The text to encode.
	 * @return The UPC-E Barcode.
	 * @throws WriterException
	 * @since 0.0.7
	 */
	public static BufferedImage generateUPCEBarcodeImage(String barcodeText) throws WriterException {
		UPCEWriter upcEBarcodeWriter = new UPCEWriter();
	    BitMatrix bitMatrix = upcEBarcodeWriter.encode(barcodeText, BarcodeFormat.UPC_E, WIDTH_1D, HEIGHT_1D);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	/**
	 * Generates an Code39 Barcode for a specified text to encode.
	 * 
	 * @param barcodeText The text to encode.
	 * @return The Code39 Barcode.
	 * @throws WriterException
	 * @since 0.0.7
	 */
	public static BufferedImage generateCode39BarcodeImage(String barcodeText) throws WriterException{
		Code39Writer code39BarcodeWriter = new Code39Writer();
	    BitMatrix bitMatrix = code39BarcodeWriter.encode(barcodeText, BarcodeFormat.CODE_39, WIDTH_1D, HEIGHT_1D);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	/**
	 * Generates an Code93 Barcode for a specified text to encode.
	 * 
	 * @param barcodeText The text to encode.
	 * @return The Code93 Barcode.
	 * @throws WriterException
	 * @since 0.0.9
	 */
	public static BufferedImage generateCode93BarcodeImage(String barcodeText) throws WriterException{
		Code93Writer code93BarcodeWriter = new Code93Writer();
	    BitMatrix bitMatrix = code93BarcodeWriter.encode(barcodeText, BarcodeFormat.CODE_93, WIDTH_1D, HEIGHT_1D);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	/**
	 * Generates an Code128 Barcode for a specified text to encode.
	 * 
	 * @param barcodeText The text to encode.
	 * @return The Code128 Barcode.
	 * @throws WriterException
	 * @since 0.0.10
	 */
	public static BufferedImage generateCode128BarcodeImage(String barcodeText) throws WriterException{
		Code128Writer code128BarcodeWriter = new Code128Writer();
	    BitMatrix bitMatrix = code128BarcodeWriter.encode(barcodeText, BarcodeFormat.CODE_128, WIDTH_1D, HEIGHT_1D);

	    return MatrixToImageWriter.toBufferedImage(bitMatrix);
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
	
	/**
	 * @return the wIDTH_1D
	 */
	public static int getWIDTH_1D() {
		return ScanCodeTools.WIDTH_1D;
	}

	/**
	 * @param wIDTH_1D the wIDTH_1D to set
	 */
	public static void setWIDTH_1D(int wIDTH_1D) {
		ScanCodeTools.WIDTH_1D = wIDTH_1D;
	}

	/**
	 * @return the hEIGHT_1D
	 */
	public static int getHEIGHT_1D() {
		return ScanCodeTools.HEIGHT_1D;
	}

	/**
	 * @param hEIGHT_1D the hEIGHT_1D to set
	 */
	public static void setHEIGHT_1D(int hEIGHT_1D) {
		ScanCodeTools.HEIGHT_1D = hEIGHT_1D;
	}
}
