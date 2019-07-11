package com.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	@GetMapping(value = "/")
	public String welcomePage(Model model) {
		model.addAttribute("HI", "whts appp");
		return "welcome";
	}
}
