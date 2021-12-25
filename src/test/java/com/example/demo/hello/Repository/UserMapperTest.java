package com.example.demo.hello.Repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.demo.hello.domain.user.MUser;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class UserMapperTest {
	
	@Autowired
	UserMapper userMapper;
	
	@Test
	void ログインユーザー取得() {
		
		MUser actual = userMapper.findLoginUser("user");
		
		// Assert(検証する)
		assertEquals("user", actual.getUserId());
	}

}
