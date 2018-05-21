package cn.xing.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.xing.dao.ClassBook;
import cn.xing.dao.StudentDao;
import cn.xing.dao.TeacherDao;
import cn.xing.dao.UserDao;
import cn.xing.dao.impl.ClassBookJdbcImpl;
import cn.xing.dao.impl.StudentDaoJdbcImpl;
import cn.xing.dao.impl.TeacherDaoJdbcImpl;
import cn.xing.dao.impl.UserDaoJdbcImpl;
import cn.xing.domain.Student;
import cn.xing.domain.Teacher;
import cn.xing.domain.Tstudent;
import cn.xing.domain.User;

public class BusinessServiceImpl {
	
	public UserDao dao = new UserDaoJdbcImpl();
	public ClassBook classbook = new ClassBookJdbcImpl();
	public StudentDao student = new StudentDaoJdbcImpl();
	public TeacherDao teacher = new TeacherDaoJdbcImpl();
	
	
	public User login(String username,String password){
		//password = ServiceUtils.md5(password);
		
		return dao.find(username , password);
		
	} 
	public List finAll(){
		//password = ServiceUtils.md5(password);
		
		return dao.selectAll();
		
	} 
	
	public boolean Del(String username,String name){
		//password = ServiceUtils.md5(password);
		
		return dao.del(username,name);
		
	} 

	public boolean Add(String username,String password,String name, String phone, String email, String work){
		//password = ServiceUtils.md5(password);
		
		return dao.add(username, password,name, phone, email, work);
		
	}
	public boolean Addclass(String classid, String classname, String classs, String classmust) {
		// TODO Auto-generated method stub
		System.out.println(classid+classname+classs+classmust+"busi");
		return dao.addclass(classid, classname, classs, classmust);
	} 

	public List finAllclass(){
		//password = ServiceUtils.md5(password);
		
		return classbook.selectAllclass();
		
	} 
	public List finAllstudent(){
		//password = ServiceUtils.md5(password);
		
		return student.selectAllstudent();
		
	} 
	//Teacher
	public Teacher teacherlogin(String username,String password){
		//password = ServiceUtils.md5(password);
		
		return teacher.find(username , password);
		
	} 
	public List findBook(String teacherid){
		//password = ServiceUtils.md5(password);
		
		return teacher.findbook(teacherid);
		
	} 
	//查询学生
	public List findstudent(String teacherid){
		//password = ServiceUtils.md5(password);
		
		return teacher.findbook(teacherid);
		
	}
	public Student stulogin(String username,String password){
		//password = ServiceUtils.md5(password);
		
		return teacher.stulogin(username , password);
		
	} 
	public List findclass(String studentid){
		//password = ServiceUtils.md5(password);
		
		return teacher.findClass(studentid);
		
	}
	public boolean AddTeacher(String teacherid, String password, String teachername, String dist, String gender, String phone) {
		// TODO Auto-generated method stub
		System.out.println(teacherid+password+teachername+dist+gender+phone);
		return dao.addTeacher(teacherid,password,teachername,dist,gender,phone);
	}
	public boolean AddStudent(String studentid, String password, String studentname, String dist, String gender,
			String year) {
		// TODO Auto-generated method stub
		System.out.println(studentid+password+studentname+dist+gender+year);
		return dao.addStudent(studentid,password,studentname,dist,gender,year);
	}

}
