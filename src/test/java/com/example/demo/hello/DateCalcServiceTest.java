package com.example.demo.hello;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.hello.Form.HidukeForm;
import com.example.demo.hello.Form.HidukeOutForm;
import com.example.demo.hello.Repository.UserMapper;

@SpringBootTest
@Transactional
class DateCalcServiceTest {
	
	@Mock
	UserMapper userMapper;
	
	@InjectMocks
	DateCalcService dateCalcService;
	
	@BeforeEach
	void setup() {
		
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void 基準日2022年1月1日の年月日にそれぞれ1を足す() {
		
		//Arrange
		//コントローラーから受け取る基準日
		LocalDate date = LocalDate.of(2022, 1, 1);
		
		//基準日の各年月日を＋1した結果（期待値）
		LocalDate expectedDate = LocalDate.of(2023, 2, 2);
		
		//計算式のインスタンスを格納するリスト
		List<HidukeForm> list = new ArrayList<HidukeForm>();
		
		//計算式のテストデータのインスタンス
		HidukeForm hiduke = new HidukeForm();
		hiduke.setId(1);
		hiduke.setHidukeId("Test");
		hiduke.setHidukeName("Test");
		hiduke.setCountYear(1);
		hiduke.setCountMonth(1);
		hiduke.setCountDay(1);
		
		list.add(hiduke);
		
		//計算式が呼ばれると、上記のテストデータをMock化して返す。
		when(userMapper.selectAllDate()).thenReturn(list);
		
		//Act
		List<HidukeOutForm>actual = dateCalcService.selectAllDate(date); 
		
		//Assert
		assertThat(actual.get(0).getResultDate(), is(equalTo(expectedDate)));
		
	}
	@Test
	void 基準日2022年1月1日に12ヶ月足す_桁上がりして1年加算となる() {
		
		//Arrange
		//コントローラーから受け取る基準日
		LocalDate date = LocalDate.of(2022, 1, 1);
		
		//基準日に12ヶ月（＝1年）足した結果（期待値）
		LocalDate expectedDate = LocalDate.of(2023, 1, 1);
		
		//計算式のインスタンスを格納するリスト
		List<HidukeForm> list = new ArrayList<HidukeForm>();
		
		//計算式のテストデータのインスタンス
		HidukeForm hiduke = new HidukeForm();
		hiduke.setId(1);
		hiduke.setHidukeId("Test");
		hiduke.setHidukeName("Test");
		hiduke.setCountYear(0);
		hiduke.setCountMonth(12);
		hiduke.setCountDay(0);
		
		list.add(hiduke);
		
		//計算式が呼ばれると、上記のテストデータをMock化して返す。
		when(userMapper.selectAllDate()).thenReturn(list);
		
		//Act
		List<HidukeOutForm>actual = dateCalcService.selectAllDate(date); 
		
		//Assert
		assertThat(actual.get(0).getResultDate(), is(equalTo(expectedDate)));
		
	}

}
