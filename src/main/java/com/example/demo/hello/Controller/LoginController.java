package com.example.demo.hello.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //ログイン画面用のコントローラー
public class LoginController {

//	ログイン画面を表示
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}
//	top画面にリダイレクト
	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/hello";
	}
}
