package com.bank.dao;

import java.util.List;

import com.bank.model.Registration;

public interface RegistrationDao {
public Integer saveUser(Registration registration);
public List<Registration> usersList();
public void updateUser(Registration registration);
public Integer deleteUser(Integer userid);
public Registration getUserByEmailAndPassword(String username,String password);
}
