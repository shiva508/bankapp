package com.bank.controller;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.formmodel.Login;
import com.bank.model.Registration;

@Controller
public class LoginController {
	
	@GetMapping(value = "/")
	public String welcomePage(Model model) {
		Registration registration = new Registration();
		model.addAttribute("registration", registration);
		return "welcome";
	}

	@PostMapping("/formregistration")
	public String registration(@Valid @ModelAttribute("registration") Registration registration, Model model,BindingResult result) {
		String view="";
		System.out.println(registration);
		registration.getFirstName().trim();
		model.addAttribute("registration", registration);
		if(result.hasErrors()) {
			view= "welcome";
		}
		else {
			view= "registrationConform";
		}
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
	@GetMapping("/myform")
	public String myform() {
		return "MyForm";
	}
	@GetMapping("/fromexp")
	public String fromexp(HttpServletRequest request,Model model,@RequestParam("myname")String myName) {
		String name1=request.getParameter("myname");
		model.addAttribute("name1", name1);
		model.addAttribute("myName", myName);
		return "ParamExe";
	}
}
