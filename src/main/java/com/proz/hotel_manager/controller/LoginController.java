package com.proz.hotel_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proz.hotel_manager.domain.Other;

@Controller
public class LoginController {

	Other other = new Other();
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		if(!other.getRoleOfUser().equals("anonymous"))
			return "redirect:/welcome";
		else
			return "login";
	}
}