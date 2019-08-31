package com.sean.store.web.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.store.domain.Category;
import com.sean.store.service.CategoryService;
import com.sean.store.service.serviceImp.CategoryServiceImp;
import com.sean.store.web.base.BaseServlet;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends BaseServlet {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Servlet调用业务层Service查询分类信息
		
		CategoryService CS = new CategoryServiceImp();
		List<Category> list = CS.getAllCategory();//业务层中 调用查询方法getAll获取所有category类的分类信息并作为category类的集合返回，getAll方法的具体实现在Dao层
		//将查询到的信息存放到request中 给下一个forword调用
		
		request.setAttribute("AllCategory", list);
		
		return "/jsp/index.jsp";
	}
}
