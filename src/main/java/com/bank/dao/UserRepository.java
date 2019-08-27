package com.bank.dao;

import com.bank.model.User;

public interface UserRepository {
public User findUserByUserName(String email);
}
