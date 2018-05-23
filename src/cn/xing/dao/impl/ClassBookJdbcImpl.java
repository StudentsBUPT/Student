package cn.xing.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.xing.dao.ClassBook;
import cn.xing.domain.Classbook;
import cn.xing.domain.User;
import cn.xing.exception.DaoException;
import cn.xing.utils.JdbcUtils;

public class ClassBookJdbcImpl implements ClassBook {

	
	@Override
	public List selectAllclass() {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
				try {
					conn = jdbc.getConection();
					String sql = "select a.teachername, b.id, b.classid, b.classname, b.classmust,b.classs, c.bookhouse from student_teacher as a,student_class as b, teacher_book as c where a.teacherid=c.teacherid and b.classname=c.bookname";
					String  sql2="select * from student_class";
					st= conn.createStatement();
					
					rs= st.executeQuery(sql);
					List list = new ArrayList();
					while(rs.next()){
                		Classbook user = new Classbook();
						user.setId(rs.getInt("id"));
						user.setClassid(rs.getString("classid"));
						System.out.println(rs.getString("classid"));
						user.setClassname(rs.getString("classname"));
						user.setClasss(rs.getString("classs"));
						user.setClassmust(rs.getString("classmust"));
						user.setClasshouse(rs.getString("bookhouse"));
						System.out.println(rs.getString("bookhouse"));
						user.setTeachername(rs.getString("teachername"));
						System.out.println(rs.getString("teachername"));
						
						list.add(user);
                	}
					return list;
					
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					throw new DaoException(e);
				}finally {
					jdbc.releace(conn, st, rs);
				}
		
	}
	
	
	@Override
	public List selectAllclassStu(String studentid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
				try {
					conn = jdbc.getConection();
					String sql = "select a.teachername, b.id, b.classid, b.classname, b.classmust,b.classs, c.bookhouse from student_teacher as a,student_class as b, teacher_book as c, student_book as e where a.teacherid=c.teacherid and b.classname=c.bookname and e.studentid!=?";
					String  sql2="select * from student_class";
					st= conn.prepareStatement(sql);
					st.setString(1, studentid);
					rs= st.executeQuery();
					List list = new ArrayList();
					while(rs.next()){
                		Classbook user = new Classbook();
						user.setId(rs.getInt("id"));
						user.setClassid(rs.getString("classid"));
						System.out.println(rs.getString("classid"));
						user.setClassname(rs.getString("classname"));
						user.setClasss(rs.getString("classs"));
						user.setClassmust(rs.getString("classmust"));
						user.setClasshouse(rs.getString("bookhouse"));
						System.out.println(rs.getString("bookhouse"));
						user.setTeachername(rs.getString("teachername"));
						System.out.println(rs.getString("teachername"));
						
						list.add(user);
                	}
					return list;
					
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e);
					throw new DaoException(e);
				}finally {
					jdbc.releace(conn, st, rs);
				}
	}

	
	

}
