package com.sean.store.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sean.store.domain.User;
import com.sean.store.service.UserService;
import com.sean.store.service.serviceImp.UserServiceImp;
import com.sean.store.utils.MailUtils;
import com.sean.store.utils.MyBeanUtils;
import com.sean.store.utils.UUIDUtils;
import com.sean.store.web.base.BaseServlet;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
  
    public String registUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/jsp/register.jsp";
	}
    //userRegist
    public String userRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收表达参数 (使用map接收表单中的键值对：username XXX， password xxx)
    	
    	Map<String, String[]> map = request.getParameterMap();
    	
    	User user = new User();
    	//myBeanUtils将map中的数据通过反射机制，填充到一个user对象中，同时解决String类型和Date类型的转化
    	MyBeanUtils.populate(user, map);
    	user.setUid(UUIDUtils.getId());//UUIDUtils用于获取一个32位的随机数作为id
    	user.setState(0);
    	user.setCode(UUIDUtils.getCode());
    	System.out.println(user);

    	//调用业务层注册功能
    	UserService UserService = new UserServiceImp();
    	try {
    		UserService.userRegist(user);//把数据封装进一个user对象后，作为参数传入给UserService的注册方法中实现注册功能
    		request.setAttribute("msg", "用户注册成功，请激活");
    		MailUtils.sendMail(user.getEmail(), user.getCode());
    	} catch (Exception e) {
			// TODO: handle exception
    		
    		
    		request.setAttribute("msg", "用户注失败");
        	
		}
    	
    	//注册成功，向用户邮箱发送信息，跳转到提示页面
    	//失败，跳转到提示页面
    	return "/jsp/info.jsp";	
	}
    
    
    //用户激活(收到邮件后，通过点击邮件的链接地址，跳转到UserServlet的active方法[])
    public String active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String code = request.getParameter("code");
		//通过code从数据库中查找用户是否存在,返回的是一个User对象,调用业务层执行代码 select * from User where code = ？
		UserService userService = new UserServiceImp();//创建服务层对象
		boolean flag = userService.userActive(code);//调用激活方法
		
		if(flag==true)
		{	
			request.setAttribute("msg", "注册成功");
			return "/jsp/login.jsp";
			
		}
		else
		{
			request.setAttribute("msg", "注册失败");
			return "/jsp/info.jsp";	
		}
		
    	
		
	}
    
    
    
    
    
    

}







