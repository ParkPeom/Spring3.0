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
	
	// ��ü ���� ���ÿ� �ʱ�ȭ = ������ ���� 
	// dataSource�޾Ƽ� �ʱ�ȭ
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) throws Exception {
		this.sessionTemplate = sessionTemplate; 
	}
	
	
	// num�� �ִ밪
	public int getMaxNum() {
		
		int maxNum = 0;
		
		maxNum = sessionTemplate.selectOne("com.boardMapper.maxNum");
		
		return maxNum;
	}
	
	// �Է�
	public void insertData(BoardDTO dto) {	
		
		sessionTemplate.insert("com.boardMapper.insertData",dto);
		
	}
	
	// ��ü ������ ����
	public int getDataCount(String searchKey,String searchValue) {
		
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		int totalCount = sessionTemplate.selectOne("com.boardMapper.getDataCount", params);	
	
		return totalCount;	
		
	}
	
	// ��ü������ 4���� �Ű�����
	// Board dto �� ���ִ� list
	public List<BoardDTO> getLists(int start,int end ,
			String searchKey,String searchValue) {
		
		
		HashMap<String, Object> params = new HashMap<String,Object>();
		
		//4���� �Ű�����
		params.put("start", start);
		params.put("end", end);
		params.put("searchKey", searchKey);
		params.put("searchValue", searchValue);
		
		List<BoardDTO> lists =
				sessionTemplate.selectList("com.boardMapper.getLists",params);
		
		return lists;
	}
	
	// num���� ��ȸ�� �Ѱ��� ������ ( article , update �Ҷ� ���ϰ��� ) 
		// Board dto �� ���ִ� list
		
	public BoardDTO getReadData(int num) { 
			BoardDTO dto = 
					sessionTemplate.selectOne("com.boardMapper.getReadData",num);
			return dto;
		}
		
		// ��ȸ�� ����(update ������Ʈ)
		// num�̶�� ���� ��ȸ���� ������ų���̴�.
		public void updateHitCount(int num) {
			
			sessionTemplate.update("com.boardMapper.updateHitCount",num);
		}
		
		//����
		public void updateData(BoardDTO dto) {
			int result = 0;
			sessionTemplate.update("com.boardMapper.updateData",dto);
		}
		
		// ����
		public void deleteData(int num) {
			sessionTemplate.delete("com.boardMapper.deleteData",num);
			
		}
	}
