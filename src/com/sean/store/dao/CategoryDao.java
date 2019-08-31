package com.sean.store.dao;

import java.sql.SQLException;
import java.util.List;

import com.sean.store.domain.Category;

public interface CategoryDao {

	List<Category> getAllCategory() throws SQLException;

}
