package com.example.demo.hello.Controller;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.hello.DateCalcService;
import com.example.demo.hello.domain.user.entity.HidukeForm;
import com.example.demo.hello.domain.user.entity.HidukeOutForm;
import com.example.demo.hello.domain.user.service.InputDate;

@Controller
public class DateCalcController {

	@Autowired
	private DateCalcService service;
	
//	Top画面遷移
	@GetMapping("dateCalc/dateList")
	public String getTop() {
	 return "dateCalc/dateList";
	}
	
//	計算処理及び一覧表示
	@PostMapping("/dateCalc/dateList")	
	public String postdate(@ModelAttribute("inputDate") InputDate inputDate, Model m, Model s ) {

		//画面入力データを、一度InputDateに格納。そして、計算処理の為に、LocalDate型で取り出す。
		LocalDate date = inputDate.getInputDate();
		//serviceに画面データ（基準日）を渡す。
		ArrayList<HidukeOutForm>selectAll = service.selectAllDate(date);
		//System.out.println(date);
		m.addAttribute("selectAll", selectAll);//一覧データを渡す
		s.addAttribute("inputdate", inputDate);//基準日データを渡す
		return "dateCalc/dateList";
	}
//	CREAT
	@GetMapping("dateCalc/dateForm") //list -> 登録画面
	public String NewDateCalc(Model m, @ModelAttribute HidukeForm n) {
		//newボタンを押されるとここを通る
		return "dateCalc/dateForm";
	}
	@PostMapping("dateCalc/dateForm") //CREATE処理
	public String create(@ModelAttribute HidukeForm n) {
		service.insert(n);
		return "redirect:/dateCalc/dateList";
		}
	
//	UPDATE
	@GetMapping("/datechange/{id}/datechange") //list -> change画面
//	変更前の詳細画面
	public String change (@PathVariable int id, Model model) {
		HidukeForm selectOne = service.select(id);
		model.addAttribute("selectOne", selectOne);
		return "dateCalc/dateChange";		
	}
	
	@PutMapping("/dateCalc/dateChange/{id}") //UPDATE処理
	public String update (HidukeForm changeOne) {
		service.update(changeOne);
		return "redirect:/employee/employeeList";	
	}
	
//	DELEATE
	@DeleteMapping("/deleteCalc/{id}/deleteCalc")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/dateCalc/dateList";	
	}

}
