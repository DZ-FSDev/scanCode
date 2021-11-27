package com.dz_fs_dev.scanCode.upc;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import java.awt.Font;
import java.awt.image.BufferedImage;

/**
 * Contains various methods for processing UPCs.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public final class UPCGen {
	private UPCGen() {}
	
	public static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws BarcodeException, OutputException{
	    return generateEAN13BarcodeImage(barcodeText, new Font("Arial", 0, 16));
	}
	
	public static BufferedImage generateEAN13BarcodeImage(String barcodeText, Font font) throws BarcodeException, OutputException{
	    Barcode barcode = BarcodeFactory.createEAN13(barcodeText);
	    barcode.setFont(font);

	    return BarcodeImageHandler.getImage(barcode);
	}
}
