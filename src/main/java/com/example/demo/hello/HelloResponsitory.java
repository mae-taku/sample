package com.example.demo.hello;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.hello.domain.user.entity.IdSearch;
import com.example.demo.hello.domain.user.service.IdserachRequest;

@Repository
public class HelloResponsitory {
	@Mapper
	public interface UserMapper{
		IdSearch search(IdserachRequest id);
	}
}
