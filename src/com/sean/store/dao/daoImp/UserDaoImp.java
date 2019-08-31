package com.sean.store.dao.daoImp;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

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

}
