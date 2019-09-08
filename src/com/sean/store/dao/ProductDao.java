package com.sean.store.dao;

import java.util.List;

import com.sean.store.domain.Product;

public interface ProductDao {

	List<Product> getHots()throws Exception;

	List<Product> getNews() throws Exception;

	Product findProductById(String pid)throws Exception;

	int findCount(String cid)throws Exception;

	List findProductsByIdWithPage(String cid, int i, int j)throws Exception;

}
