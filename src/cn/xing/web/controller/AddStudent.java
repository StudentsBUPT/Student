package cn.xing.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.service.impl.BusinessServiceImpl;

public class AddStudent extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AddStudent() {
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
		String studentid = request.getParameter("studentid");
	
		String password=request.getParameter("studentpassword");
		String studentname = request.getParameter("studentname");
		String dist=request.getParameter("dist");
		String gender=request.getParameter("gender");
		String year=request.getParameter("year");
		
		BusinessServiceImpl server =new BusinessServiceImpl();
		boolean ac=server.AddStudent(studentid,password,studentname,dist,gender,year);
		String mes=null;
		System.out.println(studentid+password+studentname+dist+gender+year);
		if (ac) {
			mes="�ɹ�";
		} else {
			mes="";
		}
		request.setAttribute("message", mes);
		//request.getRequestDispatcher("/message.jsp").forward(request, response);
		response.sendRedirect("/student/admin/student.jsp");
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
