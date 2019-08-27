package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bank.exception.UserExceprtion;
import com.bank.exception.UserResponse;
import com.bank.formmodel.RegistrationForm;
import com.bank.model.CachePerson;
import com.bank.model.RolesMaster;
import com.bank.service.RegistrationService;
import com.bank.service.RolesMasterService;

@Controller
public class WebServiceController {
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private RolesMasterService rolesMasterService;
	@GetMapping(path="/restusers",produces = {MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<Object> usersList(Model model) {
		return new ResponseEntity<Object>(registrationService.usersList(),HttpStatus.OK);
	}
	
	@GetMapping(path="/restdeleteuser/{userid}",produces = {MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public ResponseEntity<Object> deleteUser(@PathVariable("userid")Integer userid,Model model) {
		Integer deteteid=registrationService.deleteUser(userid);
		if(deteteid==0) {
			return new ResponseEntity<Object>(new UserResponse("User is Not Found with id:"+deteteid),HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Object>(new UserResponse("User is DEleted with id:"+deteteid),HttpStatus.OK);	
		}	
	}
	@GetMapping(path="/restviewuser/{userid}",produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public ResponseEntity<Object> viewUser(@PathVariable("userid")Integer userid,Model model) {
		RegistrationForm registrationForm=registrationService.getUserByUserId(userid);
		if(registrationForm !=null) {
			return new ResponseEntity<Object>(registrationService.getUserByUserId(userid), HttpStatus.OK);	
		}else {
		
			return new ResponseEntity<Object>(new UserExceprtion("No USER Found"), HttpStatus.BAD_GATEWAY);		
		}
			
	}
	@PostMapping("/restupdateUser")
	@ResponseBody
	public ResponseEntity<Object> updateUser(@ModelAttribute("registration") RegistrationForm registration, Model model ) {
		 RegistrationForm registrationupdated=registrationService.updateUser(registration);
		return new ResponseEntity<Object>(registrationupdated,HttpStatus.OK);
	}
	@PostMapping("/restformregistration")
	@ResponseBody
	public ResponseEntity<Object> registration(@RequestBody RegistrationForm registration, Model model,
			BindingResult result) {
		Integer userid=registrationService.saveUser(registration);
		return new ResponseEntity<Object>(new UserResponse("User is Not Found with id:"+userid), HttpStatus.OK);
	}
	
	@GetMapping(path="/restroles",produces = { MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public List<RolesMaster> getAllCachePersons(){
		return rolesMasterService.getAllRoles();
	}

}
