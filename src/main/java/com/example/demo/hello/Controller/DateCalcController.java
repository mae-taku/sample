package com.example.demo.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.hello.DateCalcService;
import com.example.demo.hello.domain.user.entity.HidukeOutForm;
import com.example.demo.hello.domain.user.service.InputDate;

@Controller
public class DateCalcController {
	
	
//	@GetMapping("dateCalc/dateList")
//	public String getTop() {
//	 return "dateCalc/dateList";
//	}
//	
	@Autowired
	private DateCalcService service;

	@PostMapping("/dateCalc/dateList")	
	public String postdate(@ModelAttribute("inputDate") InputDate inputDate, Model m) {
		System.out.println(inputDate);
		m.addAttribute("inputdate", inputDate);
		return "dateCalc/dateList";
	}
	@GetMapping("/dateCalc/dateList")
	public String top(Model m) {
		List<HidukeOutForm>selectAll = service.selectAllDate();
//		System.out.println(selectAll);
		m.addAttribute("selectAll", selectAll);
		return "dateCalc/dateList";
	}

}
