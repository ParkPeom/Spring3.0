package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;

import com.jdbc.dto.BoardDTO;

public class BoardDAO {
	
	private SqlSessionTemplate sessionTemplate;
	
	
	// 의존성 주입 
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) throws Exception {
		this.sessionTemplate = sessionTemplate;
	}
	
	public int getMaxNum() {
		
		int maxNum = 0;
		maxNum = sessionTemplate.selectOne("boardMapper.maxNum");
		
		return maxNum;
	}
	
	public void insertData(BoardDTO dto) {
		sessionTemplate.insert("boardMapper.insertData",dto);
	}
	
	public List<BoardDTO> getLists(int start,int end,String searchKey,String searchValue) {
		
		HashMap<String,Object> params = new HashMap<String, Object>();
		params.put("start", start);
		params.put("end", end);
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		List<BoardDTO> lists = sessionTemplate.selectList("boardMapper.getLists",params);
		
		return lists;
	}
	
	public int getDataCount(String searchKey,String searchValue) {
		
		HashMap<String, Object> params = new HashMap<String,Object>();
		
		params.put("seachKey", searchValue);
		params.put("searchValue", searchValue);		
		int result = sessionTemplate.selectOne("boardMapper.getDataCount",params);

		return result;
	}
	
	public void updateHitCount(int num) { 
		sessionTemplate.update("boardMapper.updateHitCount",num);
		
	}
	
	public BoardDTO getReadData(int num) {
		BoardDTO dto = sessionTemplate.selectOne("boardMapper.getReadData",num);
		return dto;
	}
	
	public void deleteData(int num) {
		sessionTemplate.delete("boardMapper.deleteData",num);
	}
	
	public void updateData(BoardDTO dto) {
		sessionTemplate.update("boardMapper.updateData",dto);
	}
}
