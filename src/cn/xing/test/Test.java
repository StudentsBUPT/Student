package cn.xing.test;

import cn.xing.dao.UserDao;
import cn.xing.dao.impl.UserDaoJdbcImpl;
import cn.xing.domain.User;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User users=new User();
		UserDao dao = new UserDaoJdbcImpl();
		users = dao.find("admin" , "admin");
		if (users==null) {
			System.out.println("û��ci�û�");
		}
		else
		System.out.println(users.getUsername()+users.getPassword());

	}

}
