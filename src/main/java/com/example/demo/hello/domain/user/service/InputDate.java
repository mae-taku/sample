package com.example.demo.hello.domain.user.service;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InputDate implements Serializable{
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate inputDate;

	public LocalDate plusYears(LocalDate Y, long countYear) {
		LocalDate date = Y.plusYears(countYear);
		// TODO 自動生成されたメソッド・スタブ
		return date;
	}
	

}