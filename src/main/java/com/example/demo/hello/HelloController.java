package com.example.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author maetaku
 *
 */
@Controller
public class HelloController {

	@Autowired
	private HelloService service;
	
	@GetMapping("/hello")
	public String getHello() {
	 return "hello";
	}
	
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String str, Model model) {
		model.addAttribute("sample", str);
		return "hello/response";
	}
	
	//Mapper検索
	@PostMapping("/hello/db2")
	public String postDbRequest1(@RequestParam("text3")String id, Model model) {
		//1件検索
	Employee employee = service.getEmployee(id);
	
	//検索結果をModelに登録
	model.addAttribute("employee", employee);
	
	//db.htmlに画面遷移
	return "hello/db2";
	}
}
