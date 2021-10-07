package com.example.demo.hello.domain.user.service;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InputDate {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate inputDate;
	
	
	
}