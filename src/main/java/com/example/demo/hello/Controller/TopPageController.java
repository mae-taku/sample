package com.example.demo.hello.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopPageController {
	
	@GetMapping("/top")
	public String getTop() {
		return "top";
	}

}
