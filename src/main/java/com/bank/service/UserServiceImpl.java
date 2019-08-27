package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dao.UserRepository;
import com.bank.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Transactional(readOnly = true)
	public User findUserByUserName(String email) {
		return userRepository.findUserByUserName(email);
	}

}
