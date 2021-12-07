package com.example.demo.hello.domain.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.hello.domain.user.MUser;
import com.example.demo.hello.domain.user.service.UserService;

@Service
//ユーザー認証サービスの為の、spring securityのデフォルトのUserDetailsServiceを実装したクラス
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired 
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
//		ユーザー情報取得
		MUser loginUser = service.getLoginUser(username);
		
//		ユーザーが存在しない場合
		if(loginUser == null) {
			throw new UsernameNotFoundException("user not found");
		}
//		権限listの作成
		GrantedAuthority authority = new SimpleGrantedAuthority(loginUser.getRole());
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);
		
//		UserDetails生成 
		UserDetails userDetails = (UserDetails) new User(loginUser.getUserId(), loginUser.getPassword(), authorities);

		return userDetails;//userDetails = ユーザー。必須設定：「ユーザーID」「パスワード」「権限リスト」。
		
	}
}
