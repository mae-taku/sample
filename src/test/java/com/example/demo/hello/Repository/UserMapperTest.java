package com.example.demo.hello.Repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.example.demo.hello.Form.HidukeForm;
import com.example.demo.hello.domain.user.MUser;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
class UserMapperTest {
	
	@Autowired
	UserMapper userMapper;

	//	日付計算アプリテスト
	
	@Test
	void 全件出力できるか_2件登録あることを確認() {
		
		List<HidukeForm> actual = userMapper.selectAllDate();
		
		//全件＝2であることを確認
		assertThat(actual.size()). isEqualTo(2);
	}
	
	@Test
	void 個別検索できるか_登録番号2を検索() {
		
		//ID=2を取得
		HidukeForm actual = userMapper.selectHiduke(2);
		
		assertEquals("sample02", actual.getHidukeName());
	}
	
	@Test
	void ログインユーザー取得() {
		
		MUser actual = userMapper.findLoginUser("user");
		
		// Assert(検証する)
		assertEquals("user", actual.getUserId());
	}
}
