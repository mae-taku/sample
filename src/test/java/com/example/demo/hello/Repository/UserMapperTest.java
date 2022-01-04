package com.example.demo.hello.Repository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.hello.Form.HidukeForm;
import com.example.demo.hello.domain.user.MUser;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@Transactional
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class) //CsvDataSetLoderを利用する
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	TransactionDbUnitTestExecutionListener.class
	})
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
	@DatabaseSetup(value = "/testData/init-data/")
	@ExpectedDatabase(value = "/testData/after-create-data/", table = "hiduke", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	void 登録_id4で追加する() {
		
		HidukeForm newOne = HidukeForm.builder()
				.hidukeId("test")
				.hidukeName("test")
				.countYear(10)
				.countMonth(20)
				.countDay(30)
				.build();
		
		userMapper.insertHiduke(newOne);
	}
	
	@Test
	@DatabaseSetup(value = "/testData/init-data/")
	@ExpectedDatabase(value = "/testData/after-delete-data/", table = "hiduke", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	void 削除_id2を削除する() {
		
		userMapper.deleteHiduke(2);
		
		List<HidukeForm> actual = userMapper.selectAllDate();
		System.out.println(actual);
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
