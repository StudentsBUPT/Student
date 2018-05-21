package cn.xing.dao;

import java.util.List;

import cn.xing.domain.Student;
import cn.xing.domain.Teacher;
import cn.xing.domain.Tstudent;
import cn.xing.domain.User;

public interface TeacherDao {
	
	//验证
	Teacher find(String teacherid,String password);

	List findbook(String teacherid);



	Student stulogin(String username, String password);

	

	List findClass(String studentid);
	

}
