package com.exe.springJdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


// jdbc�� ���� �Ȱ��� �ڵ��� ��� ��

public class CustomDAO {
	//dataSource���� ����ٰ� �־���� �ؼ� �ۼ�
	private DataSource dataSource;

	
	// ������ ���� 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	// DAO ���ؼ��ʿ�
	Connection conn = null;
	
	// �� ���� 
	public int insertData(CustomDTO dto) {
		
		// psr
		PreparedStatement pstmt = null;
		String sql;
		int result = 0;
		
		try {
			conn = dataSource.getConnection(); // db ����
			sql = "insert into custom (id,name,age) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
		
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	// ��ü �����͸� ������
	public List<CustomDTO> getLists() {
		
		List<CustomDTO> lists = new ArrayList<CustomDTO>();
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		
		
		try {
			conn = dataSource.getConnection();
			sql = "select id,name,age from custom";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); 
			
			while(rs.next()) {
				
				CustomDTO dto = new CustomDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				lists.add(dto);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}	
	
	// �ϳ��� �����͸� ������
	public CustomDTO getReadData(int id) {
		
		CustomDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql;
		
		try {
			conn = dataSource.getConnection();
			sql = "select id,name,age from custom where id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery(); 
			
			// �ϳ� �����ϱ� if�� 
			if(rs.next()) {
				dto = new CustomDTO();
				dto.setId(rs.getInt("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}	
		
	
	// update�� insert �� ����ϴ�
	
	public int updateData(CustomDTO dto) {
		
		// psr
		PreparedStatement pstmt = null;
		String sql;
		int result = 0;
		
		try {
			conn = dataSource.getConnection(); // db ����
			
			sql = "update custom set name=?,age=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getAge());
			pstmt.setInt(3, dto.getId());
		
			result =pstmt.executeUpdate();
			
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	
	// ���� 
	public int deleteData(int id) {
			
			// psr
			PreparedStatement pstmt = null;
			String sql;
			int result = 0;
			
			try {
				conn = dataSource.getConnection(); // db ����
				sql = "delete custom where id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
			
				result = pstmt.executeUpdate();
				
				pstmt.close();
			} catch (Exception e) {
				System.out.println(e.toString());
			}	
			return result;
		}
	}
