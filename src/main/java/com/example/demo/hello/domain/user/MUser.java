package com.example.demo.hello.domain.user;

import lombok.Data;

@Data
public class MUser {
	
	private int Id;

	private String userId;
	
	private String password;
	
	private String role; 
}
