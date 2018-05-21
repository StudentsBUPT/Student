package cn.xing.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.xing.dao.TeacherDao;
import cn.xing.domain.Student;
import cn.xing.domain.Teacher;
import cn.xing.domain.Tstudent;
import cn.xing.domain.User;
import cn.xing.domain.teacherbook;
import cn.xing.exception.DaoException;
import cn.xing.utils.JdbcUtils;

public class TeacherDaoJdbcImpl implements TeacherDao {

	@Override
	public Teacher find(String teacherid, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
		try {
			conn = jdbc.getConection();
			if(conn==null){
				System.out.println("meiyou");
			}
			String  sql="select * from student_teacher where teacherid=? and teacherpassword=?";
			st= conn.prepareStatement(sql);
			st.setString(1, teacherid);
			st.setString(2, password);
			rs= st.executeQuery();
			if (rs.next()) {
				Teacher user = new Teacher();
				user.setId(rs.getInt("id"));
				user.setTeacherid(rs.getString("teacherid"));
				
				user.setTeacherpassword(rs.getString("teacherpassword"));
				user.setTeachername(rs.getString("teachername"));
				user.setTeacherfrom(rs.getString("teacherfrom"));
				
				user.setTeacherphone(rs.getString("teacherphone"));
				user.setTeachersex(rs.getString("teachersex"));
				
				return user;
			}
			return null;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}finally {
			jdbc.releace(conn, st, rs);
		}
	}

	@Override
	public List findbook(String teacherid) {
		// TODO Auto-generated method stub
				Connection conn=null;
				PreparedStatement st=null;
				ResultSet rs=null;
				JdbcUtils jdbc =new JdbcUtils();
				try {
					conn = jdbc.getConection();
					if(conn==null){
						System.out.println("meiyou");
					}
					String  sql="select a.teacherid,a.bookname,a.bookhouse,b.classmust,b.classs from teacher_book as a,student_class as b where a.teacherid=? and a.bookname=b.classname";
					st= conn.prepareStatement(sql);
					st.setString(1, teacherid);
					rs= st.executeQuery();
					List list = new ArrayList();
					while(rs.next()) {
						teacherbook user = new teacherbook();
						
						user.setTeacherid(rs.getString("teacherid"));
						
						user.setBookname(rs.getString("bookname"));
						user.setBookhouse(rs.getString("bookhouse"));
						user.setBooktype(rs.getString("classmust"));
						user.setClasss(rs.getString("classs"));
						System.out.println(user.getBookname()+user.getBooktype());
						list.add(user);
						
						
						
					}
					
					return list;
					
					
				} catch (Exception e) {
					// TODO: handle exception
					throw new DaoException(e);
				}finally {
					jdbc.releace(conn, st, rs);
				}
	}
	
	@Override
	public Student stulogin(String studentid, String password) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
		try {
			conn = jdbc.getConection();
			if(conn==null){
				System.out.println("meiyou");
			}
			String  sql="select * from student_stu where studentid=? and studentpassword=?";
			st= conn.prepareStatement(sql);
			st.setString(1, studentid);
			st.setString(2, password);
			rs= st.executeQuery();
			System.out.println(studentid+password);
			
			if (rs.next()) {

				Student user = new Student();
				user.setStudentname(rs.getString("studentid"));
				user.setStudentpassword(rs.getString("studentpassword"));
				user.setStudentid(rs.getString("studentid"));
				user.setStudentsex(rs.getString("studentsex"));
//				
//				
				user.setStudentclass(rs.getString("studentclass"));
				user.setStudentyear(rs.getString("studentyear"));
				user.setStudentname(rs.getString("studentname"));
//				//student_teacher
//				user.setBookname(rs.getString("bookname"));
//				
//				user.setChengji(rs.getString("chengji"));
//				//student_book
//				user.setTeacherid(rs.getString("teachername"));
				System.out.println(user.getStudentname());
				return user;
			}
			return null;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}finally {
			jdbc.releace(conn, st, rs);
		}
	}

	@Override
	public List findClass(String studentid) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
		try {
			conn = jdbc.getConection();
			if(conn==null){
				System.out.println("meiyou");
			}
			String  sql="select a.bookname,a.chengji,b.studentclass,b.studentname,c.teachername from  student_book as a,student_stu as b,student_teacher as c,teacher_book as d where a.studentid=? and a.bookname=d.bookname and a.studentid=b.studentid and d.teacherid=c.teacherid";
			st= conn.prepareStatement(sql);
			st.setString(1, studentid);
			rs= st.executeQuery();
			List list = new ArrayList();
			while(rs.next()) {
				Tstudent user = new Tstudent();
				
				
				
				user.setBookname(rs.getString("bookname"));
				user.setStudentname(rs.getString("studentname"));
				user.setStudentclass(rs.getString("studentclass"));
				
				//student_teacher
				
				
				user.setChengji(rs.getString("chengji"));
				//student_book
				user.setTeacherid(rs.getString("teachername"));
				list.add(user);
				
				
				
			}
			
			return list;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}finally {
			jdbc.releace(conn, st, rs);
		}
	}
	public boolean updat(String studentid,String kecheng,String chengji) {
		// TODO Auto-generated method stub
		Connection conn=null;
		
		PreparedStatement st=null;
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
		try {
			conn = jdbc.getConection();
			if(conn==null){
				System.out.println("meiyou");
			}
			String  sql="update student_admin set chengji=? where studentid=? and classname=?";
			st= conn.prepareStatement(sql);
			st.setString(1, chengji);
			st.setString(2, studentid);
			st.setString(3, chengji);
			int ac = st.executeUpdate();
			System.out.println(ac);
			if (ac==1) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}finally {
			jdbc.releace(conn, st, rs);
		}
		
	
	}

}
