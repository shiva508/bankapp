package com.bank.controller;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bank.formmodel.Login;
import com.bank.model.Registration;

@Controller
public class LoginController {
	@Autowired
	private SessionFactory  sessionFactory;
	@GetMapping(value = "/")
	public String welcomePage(Model model) {
		Session session= sessionFactory.openSession();
		System.out.println("das"+session.isConnected());
		Registration registration = new Registration();
		model.addAttribute("registration", registration);
		return "welcome";
	}

	@PostMapping("/formregistration")
	public String registration(@Valid @ModelAttribute("registration") Registration registration, Model model,BindingResult result) {
		String view="";
		model.addAttribute("registration", registration);
		if(result.hasErrors()) {
			view= "welcome";
		}
		else {
			view= "registrationConform";
		}
		Session session= sessionFactory.getCurrentSession();
		System.out.println("das"+session.isConnected());
		return view; 
	}

	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}
	@PostMapping("login")
	public String userLogin(@ModelAttribute("login")Login login) {
		
		return "";
	}
}
