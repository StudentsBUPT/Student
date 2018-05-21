package cn.xing.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			st=conn.createStatement();
			rs=st.executeQuery("select * from student_admin");
			while (rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("username"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
