package com.example.demo.hello;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.hello.domain.user.entity.EmployeeId;
import com.example.demo.hello.domain.user.entity.HidukeForm;
import com.example.demo.hello.domain.user.service.IdsearchRequest;

@Mapper
public interface UserMapper{
	
//	全件取得
	List<EmployeeId> selectAll();
	
//	idが一致した1件取得
	//@Select("SELECT * FROM empolyee WHERE id = #{id}")
	EmployeeId search(IdsearchRequest id);
	
//	詳細画面出力用
	EmployeeId select(int id);	

//	登録
	void insert(EmployeeId newone);
	
//	更新
	int update(EmployeeId changeOne);
	
//	削除
	void delete(int id);
//	全件取得
	List<HidukeForm> selectAllDate();
}
