package cn.xing.dao;

import java.util.ArrayList;
import java.util.List;

import cn.xing.domain.User;

public interface UserDao {
	
	//验证֤
		User find(String username,String password);
	//查找
		List selectAll();
	//删除
		boolean del(String username,String name);
	//增加
		boolean add(String username,String password,String name, String phone, String email, String work);
	//添加课程
		boolean addclass(String classid, String classname, String classs, String classmust, String teacherid, String classhouse, String classtime);
		boolean addTeacher(String teacherid, String password, String teachername, String dist, String gender,
				String phone);
		boolean addStudent(String studentid, String password, String studentname, String dist, String gender,
				String year);
		boolean addGrade(String studentid, String classname, String grade);
	

}
