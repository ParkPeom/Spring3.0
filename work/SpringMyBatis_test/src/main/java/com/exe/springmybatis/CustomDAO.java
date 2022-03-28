package com.exe.springmybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.support.xml.SqlXmlObjectMappingHandler;


public class CustomDAO {
	
	private SqlSessionTemplate sessionTemplate;
	
	// app-context 에서 의존성개입으로 들어옴 
	// class="org.mybatis.spring.SqlSessionTemplate"
	// ref="sessionTemplate"
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		
		this.sessionTemplate = sessionTemplate;
	}
	
	Connection conn = null;
	
	public void insertData(CustomDTO dto) {
		sessionTemplate.insert("com.exe.custom.insert",dto);
	}
	
	public List<CustomDTO> getLists(){
		List<CustomDTO> lists = sessionTemplate.selectList("com.exe.custom.list");
		return lists;
	}

	public CustomDTO getReadData(int id) {
		CustomDTO dto = sessionTemplate.selectOne("com.exe.custon.listsOne",id);
		return dto;
	}
	
	public void updateData(CustomDTO dto) {
		sessionTemplate.update("com.exe.custom.update",dto);
		
	}
	
	public void deleteData(int id) {
		sessionTemplate.delete("com.exe.custom.delete",id);
	}
}