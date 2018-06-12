package com.proz.hotel_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proz.hotel_manager.domain.Other;

@Controller
public class WelcomeController {

	Other other = new Other();
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		if(other.getRoleOfUser().equals("client"))
			return "redirect:/client/myReservations/";
		else if(other.getRoleOfUser().equals("employee"))
			return "redirect:/employee/chooseClient/";
		else if(other.getRoleOfUser().equals("manager"))
			return "redirect:/boss/menu/";
		else
			return "redirect:/login";
	}
}