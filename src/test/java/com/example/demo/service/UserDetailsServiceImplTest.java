package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.hello.domain.user.MUser;
import com.example.demo.hello.domain.user.service.UserService;
import com.example.demo.hello.domain.user.service.impl.UserDetailsServiceImpl;

//@TestPropertySource(locations = "classpath:test.properties ")
@SpringBootTest
@Transactional
class UserDetailsServiceImplTest {
//	
//	@Autowired
//	UserMapper mapper;
//	
//	@Autowired // テスト対象
//	UserDetailsServiceImpl servise;
//	
//	@Test
//	@DisplayName("ユーザー名が存在する時、ユーザー詳細を取得することを期待します")
//	void whenUsernameExists_expectToGetUserDetails() {
//		// Arrange(準備する)
//		MUser user = new MUser();
//		user.setUserId("Tester");
//		user.setPassword("password");
//		user.setRole("ROLE_USER");
//		mapper.insertUser(user);
//		
//		// Act(実行する)
//		UserDetails actual = servise.loadUserByUsername("Tester");
//		
//		// Assert(検証する)
//		assertEquals(user.getUserId(), actual.getUsername());
//	}
//
//	@Test
//	@DisplayName("ユーザー名が存在しない時、例外をスローします")
//	void whenUsernameDoesNotExist_throwException() {
//		// Act & Assert
//		assertThrows(UsernameNotFoundException.class,
//				() -> servise.loadUserByUsername("user01)"));
//	}
	
	/* Mockitoを使ってUserMapperをMock化することでUserDetailsServiceImplをテストする */
	
	// テスト対象のクラス内で呼び出すクラス（依存クラス）をモック化する
	@Mock
	UserService userService;
	
	// テスト対象のクラスにモックをインジェクションする
	@InjectMocks
	UserDetailsServiceImpl userDetailsServiceImpl;
	
	@BeforeEach
	void setup(){
		
		// 各テストの実行前にモックオブジェクトを初期化
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void ユーザーが存在するときにUserDetailsが返却されること(){
		// テスト内容
		
		// Arrange(準備する)
		MUser user = new MUser();
		user.setUserId("Tester");
		user.setPassword("password");
		user.setRole("ROLE_USER");
		when(userService.getLoginUser("Tester")).thenReturn(user);
		
		// Act(実行する)
		UserDetails actual = userDetailsServiceImpl.loadUserByUsername("Tester");
		
		// Assert(検証する)
		assertEquals(user.getUserId(), actual.getUsername());
	}
	/* Mockito
	 * 変数userにテストデータを格納
	 * ”Tester”とログインしようとすると、変数userが返ってくる */
	
	@Test
	void ユーザーが存在しないとき_例外にスローされる() throws Exception {
		Assertions.assertThrows(UsernameNotFoundException.class, ()-> {

			MUser user = new MUser();
			user.setUserId("Tester");
			user.setPassword("password");
			user.setRole("ROLE_USER");
			when(userService.getLoginUser("Tester")).thenReturn(user);
			
			//"Tester"と登録されているのに対し、"Toaseter"でログインしようとする
			userDetailsServiceImpl.loadUserByUsername("Toaster");
		});
		
	}
}
