package com.example.demo.hello;

<<<<<<< dev-test4
import org.apache.ibatis.annotations.Mapper;
=======
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
>>>>>>> bc9e68d MybatisによるSELECT文を追加。
import org.springframework.stereotype.Repository;

@Repository
public class HelloResponsitory {
<<<<<<< dev-test4
	@Mapper
	public interface UserMapper{
		IdSearch search(IdserachRequest id);
	}
=======
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object>findByld(String id){
		
		//SELECT文
		String query = "SELECT *"
			+ " FROM employee"
			+ " WHERE id=?";
		
		//検索実行
		Map<String, Object> employee = jdbcTemplate.queryForMap(query,id);
		
		return employee;
	}

>>>>>>> bc9e68d MybatisによるSELECT文を追加。
}
