package com.proz.hotel_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	/* TODO separated greetings by roles */
	@RequestMapping("/welcome")
	public String welcome(Model model) {
		model.addAttribute("greeting", "Welcome to Elka Hotel!");
		model.addAttribute("tagline", "The only hotel where you can book the room for 7 semesters!");

		return "welcome";
	}
}