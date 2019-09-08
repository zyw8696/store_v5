package com.sean.store.service.serviceImp;

import java.util.List;

import com.sean.store.dao.ProductDao;
import com.sean.store.dao.daoImp.ProductDaoImp;
import com.sean.store.domain.PageModel;
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

	@Override
	public PageModel findProductsByidWithPage(String cid, int currNUM) throws Exception {
		//创建PageModl对象，规定分页参数（需要先查出该分类的商品总个数）每页显示的商品数目12（在PageModel中默认为5）
		//调用dao层查询该分类商品的总数
		//select * from product where cid = ?
		int totalRecords = PD.findCount(cid);
		PageModel pm = new PageModel(currNUM, totalRecords, 12);
		//查询分类商品信息 select * from product where cid=? limit ?,?; //返回一个product集合list 
		List list = PD.findProductsByIdWithPage(cid,pm.getStartIndex(),pm.getPageSize()); //cid  当前分页的起始查询值  分页大小
		//关联到PageModel的list中
		pm.setRecords(list);
		//关联
		pm.setUrl("ProdoctServlet?method=findProductsByidWithPage&cid="+cid);
		return pm;
	}

}
