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

	@Override
	public boolean userActive(String code) throws SQLException {
		UserDao UserDao = new UserDaoImp();
		
		//查找
		User user = UserDao.userActive(code);//数据库查找该用户是否存在 select * from User where code = ? 返回的是一个user对象
		
		if(null!=user)
		{//查找到 更改user的状态并置空code 
			user.setCode(null);
			user.setState(1);
			UserDao.userUpdata(user);
			return true;
		}else
		{
			return false;
		}
		
	}

	@Override
	public User userLogin(User user) throws SQLException {
		UserDao UD = new UserDaoImp();
		User user02 = UD.userLogin(user);
		return user02;
	}

}
