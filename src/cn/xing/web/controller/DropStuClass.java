package cn.xing.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.service.impl.BusinessServiceImpl;

public class DropStuClass extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public DropStuClass() {
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

		System.out.println("DropStuClass");
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String classid = request.getParameter("classid");
	
		String classname=request.getParameter("classname");
		String studentid=request.getParameter("studentid");
		BusinessServiceImpl server =new BusinessServiceImpl();
		boolean ac=server.DropStuClass(classid,classname,studentid);
		String mes=null;
		System.out.println(classid+classname+studentid);
		if (ac) {
			mes="success";
		} else {
			mes="";
		}
		request.setAttribute("message", mes);
		//request.getRequestDispatcher("/admin/addmanage.jsp").forward(request, response);
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
