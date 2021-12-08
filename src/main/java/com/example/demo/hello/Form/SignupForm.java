package com.example.demo.hello.Form;

import lombok.Data;

@Data
public class SignupForm {
	//modelmapperによるマッピングの際、MUserクラスに合わせて、Idの項目追加。ただし、画面入力時は用いないため、Form上は常に「0」。
	private  int Id;
	
	private String userId;
	
	private String password;
}
