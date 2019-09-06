package com.sean.store.service.serviceImp;

import java.sql.SQLException;
import java.util.List;

import com.sean.store.dao.CategoryDao;
import com.sean.store.dao.daoImp.CategoryDaoImp;
import com.sean.store.domain.Category;
import com.sean.store.service.CategoryService;

public class CategoryServiceImp implements CategoryService {

	@Override
	public List<Category> getAllCategory() throws SQLException {
		//业务层调用Dao层的方法具体实现 获取所有分类信息
		CategoryDao CD = new CategoryDaoImp();
		List<Category> list = CD.getAllCategory();
		
		return list;
	}

}
