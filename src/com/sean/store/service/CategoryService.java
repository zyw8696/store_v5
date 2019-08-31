package com.sean.store.service;

import java.sql.SQLException;
import java.util.List;

import com.sean.store.domain.Category;

public interface CategoryService {

	List<Category> getAllCategory() throws SQLException;

}
