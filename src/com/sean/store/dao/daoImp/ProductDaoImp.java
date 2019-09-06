package com.sean.store.dao.daoImp;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.sean.store.dao.ProductDao;
import com.sean.store.domain.Product;
import com.sean.store.utils.JDBCUtils;

public class ProductDaoImp implements ProductDao {

	@Override
	public List<Product> getHots() throws Exception {
		//查询最热商品
		String sql = "select * from product where pflag=0 and is_hot=0 order by pdate desc limit 0,9";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		return qr.query(sql, new BeanListHandler<Product>(Product.class));
	}

	@Override
	public List<Product> getNews() throws Exception {
		String sql = "SELECT * FROM product WHERE pflag=0 ORDER BY pdate DESC LIMIT 0,9";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		
		return qr.query(sql, new BeanListHandler<Product>(Product.class));
	}

	@Override
	public Product findProductById(String pid) throws Exception {
		//根据商品id查询该商品并返回商品对象
		String sql = "select * from product where pid=?";
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		return qr.query(sql, new BeanHandler<Product>(Product.class),pid);//查询得到商品的全部信息，通过反射创建一个对象返回
		
	}

}
 