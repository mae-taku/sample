package com.example.demo.hello.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

	@GetMapping("hello/employeeList")
	public String getemployeeList() {
	 return "hello/employeeList";

//	READ
	
//	CREAT
//	UODATE
//	DEALETE
	}
}
