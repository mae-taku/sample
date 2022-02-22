package com.example.demo.hello.domain.user.service;

import com.example.demo.hello.domain.user.MUser;

public interface UserService {
	
//	ユーザー登録
	public void signup(MUser user);
	
//	ログインユーザー情報取得
	public MUser getLoginUser(String UserId);
}
