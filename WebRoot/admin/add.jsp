
<%@page import="cn.xing.service.impl.BusinessServiceImpl"%>
<%@ page import="java.util.*"%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	    request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
	
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String work=request.getParameter("work");
		System.out.println(username+password+name+phone+email+work);
		BusinessServiceImpl server =new BusinessServiceImpl();
		boolean ac=server.Add(username,password,name,phone,email,work); 
%>

		
    	
    

