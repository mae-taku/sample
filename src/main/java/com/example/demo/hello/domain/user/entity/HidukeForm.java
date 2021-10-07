package com.example.demo.hello.domain.user.entity;

import lombok.Data;

@Data
public class HidukeForm {
	private int id;
	private	String hidukeId;
	private String hidukeName;
	private long countYear;
	private long countMonth;
	private long countDay;

	//データ加工
//    public LocalDate getLocalDate(){   	
//    return LocalDate.of(countYear, countMonth, countDay);
//    }
	public String calcDate() {
		return String.valueOf(countYear) + "/" + String.valueOf(countMonth) + "/" + String.valueOf(countDay);
	}
    
}
