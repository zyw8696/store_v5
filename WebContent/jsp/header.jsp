<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<body>
		

			<!--
            	描述：菜单栏
            -->
			<div class="container-fluid">
				<div class="col-md-4">
					<img src="${pageContext.request.contextPath}/img/logo2.png" />
				</div>
				<div class="col-md-5">
					<img src="${pageContext.request.contextPath}/img/header.png" />
				</div>
				<div class="col-md-3" style="padding-top:20px">
					<ol class="list-inline">
					<!--  如果LoginUser为空 则表示游客模式，显示登录和注册，若LoginUser在后台被查到说明用户已经登录，显示购物车等等信息 -->
						<c:if test="${empty LoginUser }">
						<li><a href="${pageContext.request.contextPath}/UserServlet?method=loginUI">登录</a></li>
						<li><a href="${pageContext.request.contextPath}/UserServlet?method=registUI">注册</a></li>
						</c:if>
						
						<c:if test="${not empty LoginUser }">
						<li>欢迎${LoginUser.username}</li>
						<li><a href="${pageContext.request.contextPath}/UserServlet?method=quit">退出</a></li>
						<li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
						<li><a href="${pageContext.request.contextPath}/jsp/order_list.jsp">我的订单</a></li>
						</c:if>
					</ol>
				</div> 
			</div>
			<!--
            	描述：导航条
            -->
			<div class="container-fluid">
				<nav class="navbar navbar-inverse">
					<div class="container-fluid">
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="#">首页</a>
						</div>

						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav" id="myUL">
							<!-- 
							<c:forEach items="${AllCategory }" var="c">
								<li><a href="#">${c.cname}</a></li>
							</c:forEach> 
							-->
							
							</ul>
							<form class="navbar-form navbar-right" role="search">
								<div class="form-group">
									<input type="text" class="form-control" placeholder="Search">
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
							</form>

						</div>
						<!-- /.navbar-collapse -->
					</div>
					<!-- /.container-fluid -->
				</nav>
			</div>
			</body>
		<script>
		$(function(){//ajax方法
			//向服务器CategoryServlet->getAllCats发起ajax请求
			//将所有查询到的分类信息以JSON格式数据返回，并把分类信息数据绑定在页面的显示分类区域
			var url = "/store_v5_zywGH/CategoryServlet";//请求服务器地址 (Servlet)
			var obj = {"method":"findAllCats"}; //jsp中的对象由{}扩起 ，这里表示传入方法名
			//ajax请求
			$.post(url,obj,function(data){
				
				
				$.each(data,function(i,obj){
					var li="<li><a href='#'>"+obj.cname+"</a></li>";
					$("#myUL").append(li);
				})
			},"json");
		})
		</script>

</html>