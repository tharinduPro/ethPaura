package org.rusl.ethpaura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	// Return logging page
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String tt(ModelMap map) {

		return "admin";

	}

	

}
