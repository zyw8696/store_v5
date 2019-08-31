package com.sean.store.service.serviceImp;

import java.sql.SQLException;

import com.sean.store.dao.UserDao;
import com.sean.store.dao.daoImp.UserDaoImp;
import com.sean.store.domain.User;
import com.sean.store.service.UserService;

public class UserServiceImp implements UserService{

	public void userRegist(User user) throws SQLException {
		//实现注册功能	业务层实现类中是通过调用dao层实现类来完成业务操作需求的，而实现类中用接口来声明
		UserDao UserDao = new UserDaoImp();
		UserDao.userRegist(user);
	}


}
