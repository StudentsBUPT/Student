package cn.xing.dao;

import java.util.List;

public interface ClassBook {
	
			List selectAllclass();

			List selectAllclassStu(String studentid);

			List selectAllclassStuDrop(String studentid);
	
}
