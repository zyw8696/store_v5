package com.sean.store.service;

import java.sql.SQLException;

import com.sean.store.domain.User;

public interface UserService {

	void userRegist(User user) throws SQLException;

}
