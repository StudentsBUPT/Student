package cn.xing.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.xing.dao.StudentDao;
import cn.xing.domain.Classbook;
import cn.xing.domain.User;
import cn.xing.domain.Student;
import cn.xing.exception.DaoException;
import cn.xing.utils.JdbcUtils;

public class StudentDaoJdbcImpl implements StudentDao {

	
	@Override
	public List selectAllstudent() {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		
		ResultSet rs=null;
		JdbcUtils jdbc =new JdbcUtils();
				try {
					conn = jdbc.getConection();
					String  sql="select * from student_stu";
					st= conn.createStatement();
					
					rs= st.executeQuery(sql);
					List list = new ArrayList();
					while(rs.next()){
                		Student user = new Student();
						user.setStudentid(rs.getString("studentid"));
						
						user.setStudentname(rs.getString("studentname"));
						user.setStudentyear(rs.getString("studentyear"));
						user.setStudentsex(rs.getString("studentsex"));
						user.setStudentclass(rs.getString("studentclass"));
						
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

	
	

}
