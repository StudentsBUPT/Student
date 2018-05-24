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
		// ���ÿ������
        //response.addHeader("Access-Control-Allow-Origin", "*");
        // ��������ͷ��ر���Ϊ UTF-8, ��Ǳ�Ҫ,��Ҫ����,��Ȼ��Ӱ���ļ���չ���Ļ�ȡ
        //response.setCharacterEncoding("UTF-8");
        //request.setCharacterEncoding("UTF-8");
        // ��ȡ��Ŀ��Ŀ¼����·��
        String path = getServletContext().getRealPath("");
        // ���ô�ŷ���·���ı���
        System.out.println(path);
        StringBuilder returnPath = new StringBuilder(200);
        
        try {
            // ʵ�������ش��̹���
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // �����ļ��ϴ����õĻ����ֵ,ÿ 2M д��һ����ʱ�ļ�
            factory.setSizeThreshold(2 * 1024 * 1024);
            // ���û����ļ�����ʱ���Ŀ¼
            factory.setRepository(new File(path + "Upload"));
            // ʵ�����ļ��ϴ���
            ServletFileUpload upload = new ServletFileUpload(factory);
            // ����ȫ���ļ��ϴ������ֵ
            //upload.setSizeMax(Integer.valueOf(100) * 1024 * 1024);
            // ��ȡǰ���ϴ����ļ��б�
            List<FileItem> items = upload.parseRequest(request);
            // ѭ�������ϴ����ֶλ�����
            for (FileItem item : items) {
            	System.out.println("item"+item);
                if (item.isFormField()) {
                    // ��ȡ�ֶ���
                    String name = item.getFieldName();
                    // ��ȡ�ֶ�ֵ �����ڵĲ��������ٷ�������
                    String value = item.getString("UTF-8");
                    // ��ӡ�����ļ����ֶ�
                    System.out.println(name + ".." + value);
                } else {
                    // ��ȡ�ļ���
                    String name = item.getName();
                    
                    fileName = System.currentTimeMillis() + "." + name.split("\\.")[1];
                    // ȷ���ļ���ŵ����·��
                     String filePath = "Upload/" + fileName;
                    // ���ļ�д��ָ����·��
                    //item.write(new File(path + filePath));
                     item.write(new File("D:/" + filePath));
                    // ɾ�������ļ�, ���û������, �󲿷�ʱ����ʱ�ļ�Ҳ�ᱻɾ��
                    System.out.println("path: "+path + filePath);
                    item.delete();
                    // �����·����ֵ������ֵ
                    returnPath.append(filePath);
                    // ·��֮���ö��Ÿ���
                    returnPath.append(",");
                }
            }
            //response.getWriter().write(returnPath.substring(0, returnPath.length()- 1));
        } catch (Exception e) {
            //response.getWriter().write("�ϴ�ʧ��");
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
//			mes="�ɹ�";
//		} else {
//			mes="";
//		}
//		request.setAttribute("message", mes);
//		//request.getRequestDispatcher("/message.jsp").forward(request, response);
//		response.sendRedirect("/student/admin/student.jsp");
        
        
        //�ļ��ϴ���ϣ�·��ΪD:/Upload/fileName
        //List<StuEntity> list=new ArrayList<StuEntity>();
        try {
            Workbook rwb=Workbook.getWorkbook(new File("D:/Upload/"+fileName));
            Sheet rs=rwb.getSheet(0);//����rwb.getSheet(0)
            int clos=rs.getColumns();//�õ����е���
            int rows=rs.getRows();//�õ����е���
            
            System.out.println(clos+" rows:"+rows);
            for (int i = 0; i < rows; i++) {
            	System.out.println(i);
                for (int j = 0; j < clos; j++) {
                    //��һ�����������ڶ���������
                    String studentid=rs.getCell(j++, i).getContents();//Ĭ������߱��Ҳ��һ�� ���������j++
                    System.out.println("studentid"+studentid);
                    String studentsex=rs.getCell(j++, i).getContents();
                    String studentclass=rs.getCell(j++, i).getContents();
                    String studentyear=rs.getCell(j++, i).getContents();
                    String studentname=rs.getCell(j++, i).getContents();
                    String studentpassword=rs.getCell(j++, i).getContents();
                    System.out.println("id:"+studentid+" name:"+studentname+" sex:"+studentsex+" studentclass"+studentclass+" studentyear"+studentyear+" password:"+studentpassword);
                    
                    //�������ݿ�
            		BusinessServiceImpl server =new BusinessServiceImpl();
            		boolean ac=server.AddStudent(studentid,studentpassword,studentname,studentclass,studentsex,studentyear);
            		String mes=null;
            		if (ac) {
            			mes="�ɹ�";
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
