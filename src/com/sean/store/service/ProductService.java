package com.sean.store.service;

import java.util.List;

import com.sean.store.domain.PageModel;
import com.sean.store.domain.Product;

public interface ProductService {

	List<Product> getHots() throws Exception;

	List<Product> getNews()throws Exception;

	Product findProductById(String pid)throws Exception;

	PageModel findProductsByidWithPage(String cid, int currNUM)throws Exception;

}
