package com.sean.store.dao.daoImp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.sean.store.dao.UserDao;
import com.sean.store.domain.User;
import com.sean.store.utils.JDBCUtils;

public class UserDaoImp implements UserDao{

	@Override
	public void userRegist(User user) throws SQLException {
		//dao的实现类中，获取了user对象，向数据库中添加user对象的信息=注册
		String sql = "INSERT INTO USER VALUES(?,?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());//获取数据库资源
		Object[] params = {user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()};
		qr.update(sql, params);
	}

	public User userActive(String code) throws SQLException {
		String sql = "select * from user where code=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		User user = qr.query(sql,new BeanHandler<User>(User.class),code);//通过反射创建一个对象
		
		
		return user;
	}

	@Override
	public void userUpdata(User user) throws SQLException {
		//从Service层获取了一个更新后的对象user，执行更新语句 操作DB
		String sql = "update user set username=?,password=?,name=?,email=?,telephone=?,birthday=?,sex=?,state=?,code=? where uid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		Object[] params = {user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode(),user.getUid()};
		qr.update(sql, params);
		
	}

}
