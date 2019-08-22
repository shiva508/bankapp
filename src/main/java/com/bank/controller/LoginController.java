package com.bank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.formmodel.Login;
import com.bank.formmodel.RegistrationForm;
import com.bank.model.Registration;
import com.bank.service.RegistrationService;

@Controller
public class LoginController {
	@Autowired
	private RegistrationService registrationService;

	@GetMapping(value = "/")
	public String welcomePage(Model model) {
		RegistrationForm registration = new RegistrationForm();
		model.addAttribute("registration", registration);
		return "HomePage";
	}

	@GetMapping("/users")
	public String usersList(Model model) {
		model.addAttribute("users",registrationService.usersList());
		return "usersList";
	}
	@GetMapping("/user/{userid}")
	public String getUser(@PathVariable("userid")Integer userid,Model model) {
		model.addAttribute("registration",registrationService.getUserByUserId(userid));
		return "updateuser";
	}
	@GetMapping("/deleteuser/{userid}")
	public String deleteUser(@PathVariable("userid")Integer userid,Model model) {
		registrationService.deleteUser(userid);
		return "redirect:/users";	
	}
	@GetMapping(path="/viewuser/{userid}",produces = { MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public RegistrationForm viewUser(@PathVariable("userid")Integer userid,Model model) {
		//model.addAttribute("user",registrationService.getUserByUserId(userid));
		return registrationService.getUserByUserId(userid);	
	}
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("registration") RegistrationForm registration, Model model ) {
		registrationService.updateUser(registration);
		return "redirect:/users";
	}
	@PostMapping("/formregistration")
	public String registration(@Valid @ModelAttribute("registration") RegistrationForm registration, Model model,
			BindingResult result) {
		String view = "";
		registrationService.saveUser(registration);
		model.addAttribute("registration", registration);
		if (result.hasErrors()) {
			view = "welcome";
		} else {
			view = "redirect:/users";
		}
		return view;
	}

	@GetMapping("/customlogin")
	public String loginpage() {
		return "login";
	}

	@GetMapping("/myform")
	public String myform() {
		return "MyForm";
	}

	@GetMapping("/fromexp")
	public String fromexp(HttpServletRequest request, Model model, @RequestParam("myname") String myName) {
		String name1 = request.getParameter("myname");
		model.addAttribute("name1", name1);
		model.addAttribute("myName", myName);
		return "ParamExe";
	}
}
