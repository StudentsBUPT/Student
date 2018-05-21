package cn.xing.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.service.impl.BusinessServiceImpl;

public class AddGrade extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AddGrade() {
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

		System.out.println("ere");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String studentid = request.getParameter("studentid");
		System.out.println(studentid);
	
		String classname=request.getParameter("classname");
		System.out.println(classname);
		String grade=request.getParameter("grade");
		System.out.println(grade);
		
		BusinessServiceImpl server =new BusinessServiceImpl();
		boolean ac=server.AddGrade(studentid,classname,grade);
		String mes=null;
		System.out.println(studentid+classname+grade);
		if (ac) {
			mes="³É¹¦";
		} else {
			mes="";
		}
		request.setAttribute("message", mes);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
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
		System.out.println("jjjjere");
		doGet(request, response);
	}

}
