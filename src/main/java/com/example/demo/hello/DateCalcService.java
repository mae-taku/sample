package com.example.demo.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.hello.domain.user.entity.HidukeForm;

@Service
public class DateCalcService {

	@Autowired
	private UserMapper userMapper;


//	READ
	public List<HidukeForm> selectAllDate(){
//		System.out.println(selectAllDate());
		return userMapper.selectAllDate();
	}
	
//	CREATE
//	UPDATE
//	DELETE
}
