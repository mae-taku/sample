package com.example.demo.hello.Form;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InputDateForm implements Serializable{
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public LocalDate inputDate;

}