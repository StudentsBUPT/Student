package cn.xing.dao.impl;

import java.sql.Connection;
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
					String  sql="select * from student_class";
					st= conn.createStatement();
					
					rs= st.executeQuery(sql);
					List list = new ArrayList();
					while(rs.next()){
                		Classbook user = new Classbook();
						user.setId(rs.getInt("id"));
						user.setClassid(rs.getString("classid"));
						
						user.setClassname(rs.getString("classname"));
						user.setClasss(rs.getString("classs"));
						user.setClassmust(rs.getString("classmust"));
						
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
