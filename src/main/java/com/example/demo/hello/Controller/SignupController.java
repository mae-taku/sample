package com.example.demo.hello.Controller;

import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.hello.Form.SignupForm;
import com.example.demo.hello.domain.user.MUser;
import com.example.demo.hello.domain.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
//	ユーザー登録画面を表示
	@GetMapping("/signup")
	public String getSignup(Model m, Locale locale, @ModelAttribute SignupForm form) {
//		ユーザー登録画面に遷移
		return "user/signup";
	}
//	ユーザー登録処理
	@PostMapping("/signup")
	public String postSignup(Model m, Locale locale,@ModelAttribute SignupForm form, 
			BindingResult bindingResult) {
		
		// 入力チェック結果
		if (bindingResult.hasErrors()) {
			// NG:ユーザー登録画面に戻る
			return getSignup(m, locale, form);
		}
		
		log.info(form.toString());
		
		// form->MUserクラスに変換（ModelMapperのmapメソッド、フィールドの内容を簡単にコピー。
		// フィールドをコピーするためには、コピー元とコピー先のフィールド名が一致している必要あり。
		MUser user = modelMapper.map(form, MUser.class);
		
		// ユーザー登録		
		userService.signup(user);
		
		// ログイン画面にリダイレクト
		return "redirect:/login";
	}

}
