package com.bank.service;

import com.bank.model.User;

public interface UserService {
	public User findUserByUserName(String email);
}
