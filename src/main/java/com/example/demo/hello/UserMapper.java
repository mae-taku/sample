package com.example.demo.hello;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.hello.domain.user.entity.EmployeeId;
import com.example.demo.hello.domain.user.service.IdsearchRequest;

@Mapper
public interface UserMapper{
	
//	全件取得
	List<EmployeeId> selectAll();
	
//	idが一致した1件取得
	//@Select("SELECT * FROM empolyee WHERE id = #{id}")
	EmployeeId search(IdsearchRequest id);
	
	EmployeeId select(int id);
	
//	登録
	void insert(EmployeeId newone);
	
//	更新
//	削除

}
