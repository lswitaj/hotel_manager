package com.proz.hotel_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

	/* TODO separated greetings by roles */
	@RequestMapping
	public String welcome(Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("greeting", "Welcome to Elka Hotel!");
		model.addAttribute("tagline", "The place where your mind will change");

//		redirectAttributes.addFlashAttribute("greeting", "Welcome to Web Store!");
//		redirectAttributes.addFlashAttribute("tagline", "The one and only amazing web store");
//		    
		return "redirect:/welcome/greeting";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
	   return "welcome";
	}

}