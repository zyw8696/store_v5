package com.sean.store.web.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.store.domain.Product;
import com.sean.store.service.ProductService;
import com.sean.store.service.serviceImp.ProductServiceImp;
import com.sean.store.web.base.BaseServlet;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends BaseServlet {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//在页面加载的时候，先查询数据库中热门商品和最新商品信息，存放到request中后再跳转到真实的index.jsp首页中显示
		//分页信息由header.jsp中进行查询
		ProductService PS = new ProductServiceImp();
		List<Product> list01 = PS.getHots();
		List<Product> list02 = PS.getNews();

		request.setAttribute("hots",list01);
		request.setAttribute("news",list02);
		
		
		return "/jsp/index.jsp";
	}
}
