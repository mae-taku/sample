package com.example.demo.hello.domain.user.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class HidukeForm {
	private int id;
	
	@NotBlank //スペース含めて、空白×
	private	String hidukeId;
	@NotEmpty //スペースは許容
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
