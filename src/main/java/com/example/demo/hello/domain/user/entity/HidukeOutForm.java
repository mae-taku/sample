package com.example.demo.hello.domain.user.entity;

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
