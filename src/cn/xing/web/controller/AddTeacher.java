package cn.xing.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.service.impl.BusinessServiceImpl;

public class AddTeacher extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AddTeacher() {
		super();
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String teacherid = request.getParameter("teacherid");
	
		String password=request.getParameter("password");
		String teachername = request.getParameter("teachername");
		String dist=request.getParameter("dist");
		String gender=request.getParameter("gender");
		String phone=request.getParameter("phone");
		
		BusinessServiceImpl server =new BusinessServiceImpl();
		boolean ac=server.AddTeacher(teacherid,password,teachername,dist,gender,phone);
		String mes=null;
		System.out.println(teacherid+password+teachername+dist+gender+phone);
		if (ac) {
			mes="³É¹¦";
		} else {
			mes="";
		}
		request.setAttribute("message", mes);
		//request.getRequestDispatcher("/message.jsp").forward(request, response);
		response.sendRedirect("/student/admin/teacher.jsp");
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
