package com.example.demo.hello.domain.user;

import lombok.Data;

@Data
public class MUser {
	private int id;
	private String userId;
	private String password;
	public String role; 
}
