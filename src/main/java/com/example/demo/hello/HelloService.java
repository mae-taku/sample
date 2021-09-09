package com.example.demo.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hello.HelloResponsitory.UserMapper;
import com.example.demo.hello.domain.user.entity.IdSearch;
import com.example.demo.hello.domain.user.service.IdserachRequest;

@Service
public class HelloService {
	
	@Autowired
	private HelloResponsitory repository;
	/**従業員を1人取得する*/
	public Employee getEmployee(String id) {
		//検索
		Map<String, Object>map = repository.findByld(id);
	
		//Mapから値を取得
		String employeeId = (String)map.get("id");
		String name = (String)map.get("name");
		int age = (Integer)map.get("age");
	
		//Employeeクラスに値をセット
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(name);
		employee.setEmployeeAge(age);
	
		return employee;	
	}
	@Autowired
	private UserMapper UserMapper;
	
	public IdSearch search(IdserachRequest idserachRequest){
		return UserMapper.search(idserachRequest);
	}
}
