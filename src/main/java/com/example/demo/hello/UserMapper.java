package com.example.demo.hello;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.hello.domain.user.entity.IdSearch;
import com.example.demo.hello.domain.user.service.IdsearchRequest;

@Mapper
public interface UserMapper{
	//@Select("SELECT * FROM empolyee WHERE id = #{id}")
	IdSearch search(IdsearchRequest id);
}
