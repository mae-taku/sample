package com.example.demo.hello.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.hello.HelloService;
import com.example.demo.hello.domain.Employee;

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
	 return "hello/hello";
	}
	
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1")String str, Model model) {
		model.addAttribute("sample", str);
		return "hello/response";
	}
	
	@PostMapping("/hello/db")
	public String postDbRequest(@RequestParam("text2")String id, Model model) {
		//1件検索
	Employee employee = service.getEmployee(id);
	
	//検索結果をModelに登録
	model.addAttribute("employee", employee);
	
	//db.htmlに画面遷移
	return "hello/db";
	}
	//Mapper検索
//	 @RequestMapping(value = "/hello/db2", method = RequestMethod.POST)
//	  public String search(@ModelAttribute IdsearchRequest idsearchRequest, Model model) {
//		 IdsearchRequest sampleId = new IdsearchRequest();
//		 sampleId.setId(1);
//	    IdSearch idSearch = service.search(idsearchRequest);
//	    System.out.println(idSearch);
//	    model.addAttribute("searchOne", idSearch);
//	    return "hello/db2";
//	}
}
