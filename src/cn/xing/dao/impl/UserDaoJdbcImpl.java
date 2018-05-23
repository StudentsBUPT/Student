package cn.xing.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import cn.xing.dao.UserDao;
import cn.xing.domain.User;
import cn.xing.exception.DaoException;
import cn.xing.utils.JdbcUtils;

public class UserDaoJdbcImpl implements UserDao {
	
	@Override
	public User find(String username, String password) {
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
			String  sql="select * from student_admin where username=? and password=?";
			st= conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			rs= st.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setWork(rs.getString("work"));
				user.setType(rs.getInt("type"));
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
	public List selectAll() {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
				try {
					conn = jdbc.getConection();
					String  sql="select * from student_admin";
					st= conn.createStatement();
					
					rs= st.executeQuery(sql);
					List list = new ArrayList();
					while(rs.next()){
                		User user=new User();
						user.setId(rs.getInt("id"));
						user.setUsername(rs.getString("username"));
						
						user.setPassword(rs.getString("password"));
						user.setName(rs.getString("name"));
						user.setPhone(rs.getString("phone"));
						user.setEmail(rs.getString("email"));
						user.setWork(rs.getString("work"));
						user.setType(rs.getInt("type"));
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
	public boolean del(String username,String name) {
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
			String  sql="delete from student_admin where username = ? and name=?";
			st= conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, name);
			
			int ac = st.executeUpdate();
			System.out.println(ac);
			System.out.println(sql+username+name);
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
	public boolean add(String username,String password,String name, String phone, String email, String work) {
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
			String  sql="insert student_admin(username,password,name,phone,email,work,type) values(?,?,?,?,?,?,1)";
			st= conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			st.setString(3, name);
			st.setString(4, phone);
			st.setString(5, email);
			st.setString(6, work);
			
			
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

	@Override
	public boolean addclass(String classid, String classname, String classs, String classmust,String teacherid, String classhouse, String classtime) {
		// TODO Auto-generated method stub
		Connection conn=null;
		
		PreparedStatement st=null;
		ResultSet rs=null;
		
		PreparedStatement st2=null;
		ResultSet rs2=null;
		JdbcUtils jdbc =new JdbcUtils();
		try {
			conn = jdbc.getConection();
			if(conn==null){
				System.out.println("meiyou");
			}
			String  sql="insert student_class (classid, classname, classs, classmust) values(?,?,?,?)";
			st= conn.prepareStatement(sql);
			st.setString(1, classid);
			st.setString(2, classname);
			st.setString(3, classs);
			st.setString(4, classmust);
			
			System.out.println(classid+classname+classs);
			
			String sql2 = "insert teacher_book (teacherid, bookname, bookhouse) values(?,?,?)";
			st2= conn.prepareStatement(sql2);
			st2.setString(1, teacherid);
			st2.setString(2, classname);
			st2.setString(3, classhouse);
			//st2.setString(4, classtime); //时间先不处理
			
			int ac = st.executeUpdate();
			
			int ac2 = st2.executeUpdate();
			System.out.println(ac);
			System.out.println(ac2);
			
			if (ac==1 && ac2 == 1) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new DaoException(e);
		}finally {
			jdbc.releace(conn, st, rs);
			jdbc.releace(conn, st2, rs2);
		}
		
	}

	@Override
	public boolean addTeacher(String teacherid, String password, String teachername, String dist, String gender,
			String phone) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		
		PreparedStatement st=null;
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
		try {
			conn = jdbc.getConection();
			if(conn==null){
				System.out.println("none");
			}
			String  sql="insert student_teacher (teacherid, teacherpassword, teachername, teacherfrom, teachersex, teacherphone) values(?,?,?,?,?,?)";
			st= conn.prepareStatement(sql);
			st.setString(1, teacherid);
			st.setString(2, password);
			st.setString(3, teachername);
			st.setString(4, dist);
			st.setString(5, gender);
			st.setString(6, phone);
			
			System.out.println(teacherid+password+teachername+dist+gender+phone);
			
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

	@Override
	public boolean addStudent(String studentid, String password, String studentname, String dist, String gender,
			String year) {
		// TODO Auto-generated method stub
        Connection conn=null;
		
		PreparedStatement st=null;
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
		try {
			conn = jdbc.getConection();
			if(conn==null){
				System.out.println("none");
			}
			String  sql="insert student_stu (studentid, studentsex, studentclass, studentyear, studentname, studentpassword) values(?,?,?,?,?,?)";
			st= conn.prepareStatement(sql);
			st.setString(1, studentid);
			st.setString(2, gender);
			st.setString(3, dist);
			st.setString(4, year);
			st.setString(5, studentname);
			st.setString(6, password);
			
			System.out.println(studentid+password+studentname+dist+gender+year);
			
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

	@Override
	public boolean addGrade(String studentid, String classname, String grade) {
		// TODO Auto-generated method stub
        Connection conn=null;
		
		PreparedStatement st=null;
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
		try {
			conn = jdbc.getConection();
			if(conn==null){
				System.out.println("none");
			}
			String  sql="update student_book set chengji = ? where studentid = ? and bookname = ?";
			st= conn.prepareStatement(sql);
			st.setString(1, grade);
			st.setString(2, studentid);
			st.setString(3, classname);
			
			
			int ac = st.executeUpdate();
			System.out.println(grade);
			
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

	@Override
	public boolean addStuClass(String classid, String classname, String studentid) {
        Connection conn=null;
		
		PreparedStatement st=null;
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
		try {
			conn = jdbc.getConection();
			if(conn==null){
				System.out.println("none");
			}
			String  sql="insert student_book (studentid, bookname, chengji) values(?,?,?)";
			st= conn.prepareStatement(sql);
			st.setString(1, studentid);
			st.setString(2, classname);
			st.setString(3, "");
			
			
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
