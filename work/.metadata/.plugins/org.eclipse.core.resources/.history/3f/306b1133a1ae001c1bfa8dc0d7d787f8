package com.exe.springmybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;


public class CustomDAO {
	private SqlSessionTemplate sessionTemplate;

	// SqlSessionTemplate 의 insert,delete 등 impl 구현된것
	
	// 의존성 주입 
	public void setsessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}
		
	// DAO 컨넥션필요
	Connection conn = null;

	// insert 반환 voide
	// 쿼리를 라이브러리에 내장시킴 
	public void insertData(CustomDTO dto) {
		sessionTemplate.insert("com.exe.custom.insert",dto);
	}
	
	// 전체 데이터를 가져옴
	public List<CustomDTO> getLists() {
		List<CustomDTO> lists = sessionTemplate.selectList("com.exe.custom.list");	
		return lists;
	}	
	
	// 하나의 데이터를 가져옴
	public CustomDTO getReadData(int id) {		
		CustomDTO dto = sessionTemplate.selectOne("com.exe.custom.listOne",id);
		return dto;
	}	
		
	// update는 insert 와 비슷하다
	public void updateData(CustomDTO dto) {
		sessionTemplate.update("com.exe.custom.update",dto);
	}
	
	// 삭제 
	public void deleteData(int id) {	
		sessionTemplate.delete("com.exe.custom.delete",id);	
	}
}