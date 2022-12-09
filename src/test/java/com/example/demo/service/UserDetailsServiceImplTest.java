package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.hello.Repository.UserMapper;
import com.example.demo.hello.domain.user.MUser;
import com.example.demo.hello.domain.user.service.impl.UserDetailsServiceImpl;

@SpringBootTest
@Transactional
class UserDetailsServiceImplTest {
	
	@Autowired
	UserMapper mapper;
	
	@Autowired // テスト対象
	UserDetailsServiceImpl servise;
	
	@Test
	@DisplayName("ユーザー名が存在する時、ユーザー詳細を取得することを期待します")
	void whenUsernameExists_expectToGetUserDetails() {
		// Arrange(準備する)
		MUser user = new MUser();
		user.setUserId("Tester");
		user.setPassword("password");
		user.setRole("ROLE_USER");
		mapper.insertUser(user);
		
		// Act(実行する)
		UserDetails actual = servise.loadUserByUsername("Tester");
		
		// Assert(検証する)
		assertEquals(user.getUserId(), actual.getUsername());
	}

	@Test
	@DisplayName("ユーザー名が存在しない時、例外をスローします")
	void whenUsernameDoesNotExist_throwException() {
		// Act & Assert
		assertThrows(UsernameNotFoundException.class,
				() -> servise.loadUserByUsername("user01)"));
	}
}
