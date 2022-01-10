package com.example.demo.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.hello.HelloService;
import com.example.demo.hello.domain.user.entity.EmployeeId;
import com.example.demo.hello.domain.user.service.IdsearchRequest;

@Controller
public class EmployeeController {
	
	@Autowired
	private HelloService service;
	
//	全件検索
	@GetMapping("employee/employeeList")
	public String top(Model m) {
		List<EmployeeId>selectAll = service.selectAll();
		m.addAttribute("selectAll", selectAll);
		return "employee/employeeList";
	}
	
//	READ
	//Mapper検索
	@PostMapping("/employee/db2")
	public String postDbRequest1(@ModelAttribute IdsearchRequest idsearchRequest, Model model) {
		//1件検索
		EmployeeId idSearch = service.search(idsearchRequest);
		//検索結果をModelに登録
		model.addAttribute("searchOne", idSearch);
		//db.htmlに画面遷移
		return "employee/db2";
	}
	//詳細画面遷移
	@GetMapping("/show/{id}")
	public String show(@PathVariable int id, Model model) {
		EmployeeId selectOne = service.select(id);
		model.addAttribute("selectOne", selectOne);
		return "employee/employeeShow";
		}

//	CREAT
	@GetMapping("employee/employeeForm") //list -> 登録画面
	public String NewEmployee(Model m, @ModelAttribute EmployeeId n) {
		//newボタンを押されるとここを通る
		return "employee/employeeForm";
	}
	@PostMapping("employee/employeeForm") //CREATE処理
	public String create(@ModelAttribute EmployeeId n) {
		service.insert(n);
		return "redirect:/employee/employeeList";
		}
	
//	UODATE
	@GetMapping("/change/{id}/change") //list -> change画面
	public String change (@PathVariable int id, Model model) {
		EmployeeId selectOne = service.select(id);
		model.addAttribute("selectOne", selectOne);
		return "employee/employeeChange";		
	}
	
	@PutMapping("/employee/employeeChange/{id}") //UPDATE処理
	public String update (EmployeeId changeOne) {
		service.update(changeOne);
		return "redirect:/employee/employeeList";	
	}
	
//	DEALETE
	@DeleteMapping("/delete/{id}/delete")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/employee/employeeList";	
	}
	
}


