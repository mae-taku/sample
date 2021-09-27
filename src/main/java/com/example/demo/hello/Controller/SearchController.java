package com.example.demo.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.hello.HelloService;
import com.example.demo.hello.domain.user.entity.EmployeeId;

@Controller
public class SearchController {
	
	@Autowired
	private HelloService service;
	
//	全件検索
	@GetMapping("hello/employeeList")
	public String top(Model m) {
		List<EmployeeId>selectAll = service.selectAll();
		m.addAttribute("selectAll", selectAll);
		return "hello/employeeList";

//	READ

//	CREAT
//	UODATE
//	DEALETE
	}
}
