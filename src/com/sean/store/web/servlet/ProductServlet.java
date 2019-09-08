package com.sean.store.web.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.store.domain.PageModel;
import com.sean.store.domain.Product;
import com.sean.store.service.ProductService;
import com.sean.store.service.serviceImp.ProductServiceImp;
import com.sean.store.web.base.BaseServlet;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends BaseServlet {

	public String findProductById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//游览器发起查看商品详情的请求，request携带方法名和cid
		//通过cid查询该商品的全部信息，存入request作用域，在转发到商品详情页面
		String pid = request.getParameter("pid");
		ProductService PS = new ProductServiceImp();
		Product product = PS.findProductById(pid);
		request.setAttribute("product", product);
		
		return "/jsp/product_info.jsp";
	}
	
	public String findProductsByidWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//查询分页下的商品，带分页
		//获取参数
		String cid = request.getParameter("cid");
		int currNUM = Integer.parseInt(request.getParameter("num"));
		//调用业务层查询商品信息
		
		ProductService PS = new ProductServiceImp();
		PageModel pm  = PS.findProductsByidWithPage(cid,currNUM);//查询返回一个PageModel对象，其中包含3种信息：商品集合、分页信息、url信息
//		List list = pm.getRecords();
	//	for (Object object : list) {
	//		System.out.println(object.toString());
	//	}
	//	
		request.setAttribute("page", pm);
		return "/jsp/product_list.jsp";
	}

}
