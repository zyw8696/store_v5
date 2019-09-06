package com.sean.store.web.servlet;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.store.domain.Category;
import com.sean.store.service.CategoryService;
import com.sean.store.service.serviceImp.CategoryServiceImp;
import com.sean.store.utils.JedisUtils;
import com.sean.store.web.base.BaseServlet;

import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet {

	
	public String findAllCats(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//在redis中获取全部分类信息（经过一次查询数据库后，将分类信息存放在内存中，此后每次查询可直接返回而不需要再次访问数据库硬盘）
		Jedis jedis = JedisUtils.getJedis();
		String array = jedis.get("allCats");//获取该键值对 （第一次allCats为空）
		if(null == array || "".equals(array))
		{
			//调用业务层 查询分页信息
			CategoryService CS = new CategoryServiceImp();
			List<Category> list = CS.getAllCategory();//查询返回Category集合
			
			//Servlet不能直接返回java对象，这里转换成json格式数据相应给游览器
			array = JSONArray.fromObject(list).toString();
			jedis.set("allCats", array);//
			System.out.println("redis缓存中没有数据");
			//需要告诉游览器返回的数据类型为json 而不是String
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().print(array);
		}
		else
		{
			System.out.println("redist有数据");
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().print(array);
		}
		
		
		return null;
	}

}
