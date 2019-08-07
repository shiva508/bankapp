package com.bank.service;

import java.util.List;

import com.bank.formmodel.RegistrationForm;
import com.bank.model.Registration;

public interface RegistrationService {
	public Integer saveUser(RegistrationForm registrationForm);
	public List<Registration> usersList();
	public void updateUser(RegistrationForm registrationForm);
	public Integer deleteUser(Integer userid);
	public RegistrationForm getUserByEmailAndPassword(String username,String password);
}
