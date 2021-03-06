package com.example.demo.hello;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hello.Repository.HelloRepository;
import com.example.demo.hello.Repository.UserMapper;
import com.example.demo.hello.domain.Employee;
import com.example.demo.hello.domain.user.entity.EmployeeId;
import com.example.demo.hello.domain.user.service.IdsearchRequest;



@Service
public class HelloService {
	
	@Autowired
	private HelloRepository repository;
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
	private UserMapper userMapper;
	
//	全件取得
	public List<EmployeeId> selectAll(){
		return userMapper.selectAll();
	}
	
//	1件検索
	public EmployeeId search(IdsearchRequest idsearchRequest){
		return userMapper.search(idsearchRequest);
	}

	public EmployeeId select(int id) {
		return userMapper.select(id);
	}
//　登録
	public void insert(EmployeeId newOne) {
		userMapper.insert(newOne);
		}
//	更新
	public int update(EmployeeId changeOne) {
		return userMapper.update(changeOne);
		}
//	削除
	public void delete(int id) {
		userMapper.delete(id);
	}
}
