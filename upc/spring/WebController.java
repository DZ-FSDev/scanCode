package com.dz_fs_dev.scanCode.upc.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * UPC Web Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
@Controller
public class WebController {
	/**
	 * Renders the Welcome page view.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/welcome")
	public String getWelcome(Model model)  {
		model.addAttribute("welcomeMessage", "Welcomes!");
		model.addAttribute("upc", "9199151591916");
		model.addAttribute("upcsrc", "/scanCodeGen/ean13/9199151591916");
		return "welcome.html";
	}
}
