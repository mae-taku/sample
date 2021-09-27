package com.example.demo.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.hello.HelloService;
import com.example.demo.hello.domain.user.entity.EmployeeId;
import com.example.demo.hello.domain.user.service.IdsearchRequest;

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
	}
	
//	READ
	//Mapper検索
	@PostMapping("/hello/db2")
	public String postDbRequest1(@ModelAttribute IdsearchRequest idsearchRequest, Model model) {
		//1件検索
		EmployeeId idSearch = service.search(idsearchRequest);
		//検索結果をModelに登録
		model.addAttribute("searchOne", idSearch);
		//db.htmlに画面遷移
		return "hello/db2";
	}
	
//	CREAT
	@GetMapping("hello/employeeForm") //list -> newボタン
	public String NewEmployee(Model m, @ModelAttribute EmployeeId n) {
		//newボタンを押されるとここを通る
		return "hello/employeeForm";
	}
	@PostMapping("hello/employeeForm")
	public String create(@ModelAttribute EmployeeId n) {
		System.out.println(n);
		service.insert(n);
		return "redirect:/hello/employeeList";
		}
	
	//	UODATE
//	DEALETE
	
}
