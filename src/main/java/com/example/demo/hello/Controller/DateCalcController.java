package com.example.demo.hello.Controller;

import java.time.LocalDate;
import java.util.ArrayList;

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
	
	
	@GetMapping("dateCalc/dateList")
	public String getTop() {
	 return "dateCalc/dateList";
	}
	
	@Autowired
	private DateCalcService service;

	@PostMapping("/dateCalc/dateList")	
	public String postdate(@ModelAttribute("inputDate") InputDate inputDate, Model m, Model s ) {

		//画面入力データを、一度InputDateに格納。そして、計算処理の為に、LocalDate型で取り出す。
		LocalDate date = inputDate.getInputDate();
		//serviceに画面データ（基準日）を渡す。
		ArrayList<HidukeOutForm>selectAll = service.selectAllDate(date);
		//System.out.println(date);
		m.addAttribute("selectAll", selectAll);
		s.addAttribute("inputdate", inputDate);
		return "dateCalc/dateList";
	}
//	@GetMapping("/dateCalc/dateList")
//	public String top(Model m) {
//		List<HidukeOutForm>selectAll = service.selectAllDate();
////		System.out.println(selectAll);
//		m.addAttribute("selectAll", selectAll);
//		return "dateCalc/dateList";
//	}

}
