package com.example.demo.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.hello.HelloService;
import com.example.demo.hello.domain.user.entity.IdSearch;

@Controller
public class OrderController {

	@Autowired
	private HelloService service;
	

	@GetMapping("/Order")
	public String getOrder() {
	 return "Order";
	}
	
	@PostMapping("/Order")
	public String Order(@ModelAttribute IdSearch NewId, Model model) {
	//1件検索
	 IdSearch OrderId = service.order(NewId);
	//検索結果をModelに登録
	model.addAttribute("searchOne", OrderId);
	//db.htmlに画面遷移
	return "hello";	
	}
}
