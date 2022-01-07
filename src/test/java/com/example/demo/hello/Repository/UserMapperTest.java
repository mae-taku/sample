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

		//テストデータ作成
		HidukeForm newOne = new HidukeForm();
		
		newOne.setHidukeId("test");
		newOne.setHidukeName("test");
		newOne.setCountYear(10);
		newOne.setCountMonth(20);
		newOne.setCountDay(30);

		userMapper.insertHiduke(newOne);
	}
	@Test
	@DatabaseSetup(value = "/testData/init-data/")
	@ExpectedDatabase(value = "/testData/after-create2-data/", table = "hiduke", assertionMode = DatabaseAssertionMode.NON_STRICT)
	void id2番を削除後_新規登録したら_抜けた2番に新規が登録される(){
		
		//id2の登録を削除する
		userMapper.deleteHiduke(2);

		//テストデータ作成
		HidukeForm newOne = new HidukeForm();
		
		newOne.setHidukeId("newOne");
		newOne.setHidukeName("newOne");
		newOne.setCountYear(100);
		newOne.setCountMonth(100);
		newOne.setCountDay(100);

		userMapper.insertHiduke(newOne);

	}
	
	@Test
	@DatabaseSetup(value = "/testData/init-data/")
	@ExpectedDatabase(value = "/testData/after-delete-data/", table = "hiduke", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	void id2を削除した結果_想定DBとなることを() {

		//id2を消す
		userMapper.deleteHiduke(2);

	}
	
	@Test
	void 個別検索できるか_登録番号2を検索() {
		
		//ID=2を取得
		HidukeForm actual = userMapper.selectHiduke(2);
		
		assertEquals("sample02", actual.getHidukeName());
	}
	@Test
	@DatabaseSetup(value = "/testData/init-data/")
	@ExpectedDatabase(value = "/testData/after-change-data/", table = "hiduke", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
	void 変更_id1を変更する() {
		
		//テストデータ作成
		HidukeForm changeOne = new HidukeForm();
		
		changeOne.setId(1);
		changeOne.setHidukeId("change01");
		changeOne.setHidukeName("change01");
		changeOne.setCountYear(100);
		changeOne.setCountMonth(200);
		changeOne.setCountDay(300);
		
		userMapper.updateHiduke(changeOne);
		
	}
	
//	ログイン機能テスト
	@Test
	void ログインユーザー取得() {
		
		MUser actual = userMapper.findLoginUser("user");
		
		// Assert(検証する)
		assertEquals("user", actual.getUserId());
	}
}
