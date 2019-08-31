<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:forward page="/IndexServlet"></jsp:forward>


<!-- 在跳转到真实首页前，需要先调用一次servlet查询分页信息等，在有servlet保存到request中转发到真实首页中 

IndexServlet默认执行的方法：execute

四个作用域
1.page指当前页面有效。在一个jsp页面里有效

2.request 指在一次请求的全过程中有效，即从http请求到服务器处理结束，返回响应的整个过程，存放在HttpServletRequest对象中。在这个过程中可以使用forward方式跳转多个jsp。在这些页面里你都可以使用这个变量。

3.Session是用户全局变量，在整个会话期间都有效。只要页面不关闭就一直有效（或者直到用户一直未活动导致会话过期，默认session过期时间为30分钟，或调用HttpSession的invalidate()方法）。存放在HttpSession对象中 

4.application是程序全局变量，对每个用户每个页面都有效。存放在ServletContext对象中。它的存活时间是最长的，如果不进行手工删除，它们就一直可以使用 

总结：当数据只需要在下一个forward有用时，用request就够了；
         若数据不只是在下一个forward有用时，就用session。
         上下文，环境信息之类的，用application。

具体使用方法：

page里的变量没法从index.jsp传递到test.jsp。只要页面跳转了，它们就不见了。  
request里的变量可以跨越forward前后的两页。但是只要刷新页面，它们就重新计算了。  
session的变量一直在累加，开始还看不出区别，只要关闭浏览器，再次重启浏览器访问这页，session里的变量就重新计算了。  
application里的变量一直在累加，除非你重启tomcat，否则它会一直变大。  
而作用域规定的是变量的有效期限。  
-->