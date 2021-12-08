package com.example.demo.hello.domain.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.hello.Repository.UserMapper;
import com.example.demo.hello.domain.user.MUser;
import com.example.demo.hello.domain.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
//	ユーザー登録
	@Override
	public void signup(MUser user) {
		
		// ログイン機能用の権限を自動登録
		user.setRole("ROLE_GENERAL"); //接頭語[ROLE_]必須。GENERAL他、ADMINとかある。
		
		// パスワード暗号化
		String rawpassword = user.getPassword();
		user.setPassword(encoder.encode(rawpassword));
		
		mapper.insertUser(user);
	}
	
//	ログインユーザー情報取得
	@Override
	public MUser getLoginUser(String userId) {
		return mapper.findLoginUser(userId);
	}
}
