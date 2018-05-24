package cn.xing.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.xing.service.impl.BusinessServiceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jxl.Sheet;
import jxl.Workbook;


public class AddStudentAll extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public AddStudentAll() {
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
		String fileName = "";
		// 设置跨域访问
        //response.addHeader("Access-Control-Allow-Origin", "*");
        // 设置请求和返回编码为 UTF-8, 如非必要,不要设置,不然会影响文件扩展名的获取
        //response.setCharacterEncoding("UTF-8");
        //request.setCharacterEncoding("UTF-8");
        // 获取项目根目录绝对路径
        String path = getServletContext().getRealPath("");
        // 设置存放返回路径的变量
        System.out.println(path);
        StringBuilder returnPath = new StringBuilder(200);
        
        try {
            // 实例化本地磁盘工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 设置文件上传启用的缓存的值,每 2M 写入一次临时文件
            factory.setSizeThreshold(2 * 1024 * 1024);
            // 设置缓存文件的临时存放目录
            factory.setRepository(new File(path + "Upload"));
            // 实例化文件上传类
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置全部文件上传的最大值
            //upload.setSizeMax(Integer.valueOf(100) * 1024 * 1024);
            // 获取前端上传的文件列表
            List<FileItem> items = upload.parseRequest(request);
            // 循环所有上传的字段或文字
            for (FileItem item : items) {
            	System.out.println("item"+item);
                if (item.isFormField()) {
                    // 获取字段名
                    String name = item.getFieldName();
                    // 获取字段值 括号内的参数不可少否则乱码
                    String value = item.getString("UTF-8");
                    // 打印不是文件的字段
                    System.out.println(name + ".." + value);
                } else {
                    // 获取文件名
                    String name = item.getName();
                    
                    fileName = System.currentTimeMillis() + "." + name.split("\\.")[1];
                    // 确定文件存放的相对路径
                     String filePath = "Upload/" + fileName;
                    // 将文件写入指定的路径
                    //item.write(new File(path + filePath));
                     item.write(new File("D:/" + filePath));
                    // 删除缓存文件, 如果没有设置, 大部分时候临时文件也会被删除
                    System.out.println("path: "+path + filePath);
                    item.delete();
                    // 将相对路径赋值给返回值
                    returnPath.append(filePath);
                    // 路径之间用逗号隔开
                    returnPath.append(",");
                }
            }
            //response.getWriter().write(returnPath.substring(0, returnPath.length()- 1));
        } catch (Exception e) {
            //response.getWriter().write("上传失败");
        }
		
//		String studentid;
//		String password;
//		String studentname;
//		String dist;
//		String gender;
//		String year;
//		
//		BusinessServiceImpl server =new BusinessServiceImpl();
//		boolean ac=server.AddStudent(studentid,password,studentname,dist,gender,year);
//		String mes=null;
//		System.out.println(studentid+password+studentname+dist+gender+year);
//		if (ac) {
//			mes="成功";
//		} else {
//			mes="";
//		}
//		request.setAttribute("message", mes);
//		//request.getRequestDispatcher("/message.jsp").forward(request, response);
//		response.sendRedirect("/student/admin/student.jsp");
        
        
        //文件上传完毕，路径为D:/Upload/fileName
        //List<StuEntity> list=new ArrayList<StuEntity>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File("D:/Upload/"+fileName));
            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
            int clos=rs.getColumns();//得到所有的列
            int rows=rs.getRows();//得到所有的行
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 0; i < rows; i++) {
            	System.out.println(i);
                for (int j = 0; j < clos; j++) {
                    //第一个是列数，第二个是行数
                    String studentid=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
                    System.out.println("studentid"+studentid);
                    String studentsex=rs.getCell(j++, i).getContents();
                    String studentclass=rs.getCell(j++, i).getContents();
                    String studentyear=rs.getCell(j++, i).getContents();
                    String studentname=rs.getCell(j++, i).getContents();
                    String studentpassword=rs.getCell(j++, i).getContents();
                    System.out.println("id:"+studentid+" name:"+studentname+" sex:"+studentsex+" studentclass"+studentclass+" studentyear"+studentyear+" password:"+studentpassword);
                    
                    //插入数据库
            		BusinessServiceImpl server =new BusinessServiceImpl();
            		boolean ac=server.AddStudent(studentid,studentpassword,studentname,studentclass,studentsex,studentyear);
            		String mes=null;
            		if (ac) {
            			mes="成功";
            		} else {
            			mes="";
            		}
                }
            }
            //request.getRequestDispatcher("/message.jsp").forward(request, response);
            System.out.println("sendRedirect");
    		response.sendRedirect("/student/admin/student.jsp");
    		return;
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
		
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
