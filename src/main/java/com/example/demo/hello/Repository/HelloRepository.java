package com.example.demo.hello.Repository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {
	
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
	
	
	
}
