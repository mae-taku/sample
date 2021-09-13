package com.example.demo.hello;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.hello.domain.user.entity.IdSearch;
import com.example.demo.hello.domain.user.service.IdsearchRequest;

@Repository
public class HelloResponsitory {
	
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
	
	
	@Mapper
	public interface UserMapper{
		//@Select("SELECT * FROM empolyee WHERE id = #{id}")
		IdSearch search(IdsearchRequest id);
	}
	
}
