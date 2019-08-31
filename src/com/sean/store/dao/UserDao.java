package com.sean.store.dao;

import java.sql.SQLException;

import com.sean.store.domain.User;

public interface UserDao {

	void userRegist(User user) throws SQLException;

	User userActive(String code) throws SQLException;

	void userUpdata(User user) throws SQLException;

	User userLogin(User user) throws SQLException;

}
