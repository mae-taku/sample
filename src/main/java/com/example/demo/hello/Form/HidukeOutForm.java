package com.example.demo.hello.Form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class HidukeOutForm {
	private int id;
	private	String hidukeId;
	private String hidukeName;
	private String date;
	private LocalDate resultDate;
}
