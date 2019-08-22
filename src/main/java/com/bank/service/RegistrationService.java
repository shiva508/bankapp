package com.bank.service;

import java.util.List;
import com.bank.formmodel.RegistrationForm;
import com.bank.model.Registration;

public interface RegistrationService {
	public Integer saveUser(RegistrationForm registrationForm);
	public List<RegistrationForm> usersList();
	public RegistrationForm updateUser(RegistrationForm registrationForm);
	public Integer deleteUser(Integer userid);
	public RegistrationForm getUserByEmailAndPassword(String username,String password);
	public RegistrationForm getUserByUserId(Integer userId);
}
