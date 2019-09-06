package com.sean.store.service.serviceImp;

import java.util.List;

import com.sean.store.dao.ProductDao;
import com.sean.store.dao.daoImp.ProductDaoImp;
import com.sean.store.domain.Product;
import com.sean.store.service.ProductService;

public class ProductServiceImp implements ProductService {

	ProductDao PD = new ProductDaoImp();
	
	@Override
	public List<Product> getHots() throws Exception {
		return PD.getHots();
	}

	@Override
	public List<Product> getNews() throws Exception {
		return PD.getNews();
	}

	@Override
	public Product findProductById(String pid) throws Exception {
		return PD.findProductById(pid);
	}

}
