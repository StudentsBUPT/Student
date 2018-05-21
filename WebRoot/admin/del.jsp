<%@page import="cn.xing.service.impl.BusinessServiceImpl"%>
<%@ page import="java.util.*"%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String name = request.getParameter("name");
	System.out.println(username+"//"+name);
    BusinessServiceImpl del = new BusinessServiceImpl();
    boolean ac=del.Del(username, name);
    if(ac)
    	System.out.println("删除成功！");
    else
    System.out.println("删除失败！");
    	
    
%>
