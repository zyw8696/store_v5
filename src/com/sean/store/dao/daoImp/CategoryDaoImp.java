package com.sean.store.dao.daoImp;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sean.store.dao.CategoryDao;
import com.sean.store.domain.Category;
import com.sean.store.utils.JDBCUtils;

public class CategoryDaoImp implements CategoryDao {

	@Override
	public List<Category> getAllCategory() throws SQLException {
		//dao层实现查询分页信息：select * from category
		String sql = "select * from category";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		//查询操作会返回对象或对象列表,此处返回category类的集合，因此反射使用的是BeanListHandler
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
		
	}

}
