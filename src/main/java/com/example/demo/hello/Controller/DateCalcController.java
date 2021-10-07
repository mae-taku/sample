package com.example.demo.hello.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.hello.DateCalcService;
import com.example.demo.hello.domain.user.entity.HidukeOutForm;

@Controller
public class DateCalcController {
	
	
//	@GetMapping("dateCalc/dateList")
//	public String getTop() {
//	 return "dateCalc/dateList";
//	}
//	
	@Autowired
	private DateCalcService service;
	
	@GetMapping("dateCalc/dateList")
	public String top(Model m) {
		List<HidukeOutForm>selectAll = service.selectAllDate();
//		System.out.println(selectAll);
		m.addAttribute("selectAll", selectAll);
		return "dateCalc/dateList";
	}

}
