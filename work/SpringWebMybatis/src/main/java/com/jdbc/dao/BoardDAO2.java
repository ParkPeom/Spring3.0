package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import org.mybatis.spring.SqlSessionTemplate;

import com.jdbc.dto.BoardDTO;


public class BoardDAO2 {

	private SqlSessionTemplate sessionTemplate;
	
	// 객체 생성 동시에 초기화 = 의존성 주입 
	// dataSource받아서 초기화
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) throws Exception {
		this.sessionTemplate = sessionTemplate; 
	}
	
	
	// num의 최대값
	public int getMaxNum() {
		
		int maxNum = 0;
		
		maxNum = sessionTemplate.selectOne("com.boardMapper.maxNum");
		
		return maxNum;
	}
	
	// 입력
	public void insertData(BoardDTO dto) {	
		
		sessionTemplate.insert("com.boardMapper.insertData",dto);
		
	}
	
	// 전체 데이터 갯수
	public int getDataCount(String searchKey,String searchValue) {
		
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		int totalCount = sessionTemplate.selectOne("com.boardMapper.getDataCount", params);	
	
		return totalCount;	
		
	}
	
	// 전체데이터 4개의 매개변수
	// Board dto 가 들어가있는 list
	public List<BoardDTO> getLists(int start,int end ,
			String searchKey,String searchValue) {
		
		
		HashMap<String, Object> params = new HashMap<String,Object>();
		
		//4개의 매개변수
		params.put("start", start);
		params.put("end", end);
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		List<BoardDTO> lists =
				sessionTemplate.selectList("com.boardMapper.getLists",params);
		
		return lists;
	}
	
	// num으로 조회한 한개의 데이터 ( article , update 할때 쓰일것임 ) 
		// Board dto 가 들어가있는 list
		
	public BoardDTO getReadData(int num) { 
			BoardDTO dto = 
					sessionTemplate.selectOne("com.boardMapper.getReadData",num);
			return dto;
		}
		
		// 조회수 증가(update 업데이트)
		// num이라는 값의 조회수를 증가시킬것이다.
		public void updateHitCount(int num) {
			
			sessionTemplate.update("com.boardMapper.updateHitCount",num);
		}
		
		//수정
		public void updateData(BoardDTO dto) {
			int result = 0;
			sessionTemplate.update("com.boardMapper.updateData",dto);
		}
		
		// 삭제
		public void deleteData(int num) {
			sessionTemplate.delete("com.boardMapper.deleteData",num);
			
		}
	}
