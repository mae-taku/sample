package com.example.demo.hello.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.hello.domain.user.model.MUser;

@Mapper
public interface UserMapper {
	
	/**ユーザー登録*/
	public int insertOne(MUser user);
}
