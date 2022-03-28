package com.exe.springJdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

// jdbc 단점 : 코딩 반복 
public class CustomDAO {
	
	private DataSource dataSource;
	
	// 의존성 주입
	public CustomDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
	}
	
	
	// DAO 컨넥션 필요
	Connection conn = null;
	
	
	// 전체 데이터 가져오기
	public List<CustomDTO> getLiests() {
		
		List<CustomDTO> lists = new ArrayList<CustomDTO>();
		CustomDTO dto = null; 
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			sql = "select id,name,age from custom";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				dto = new CustomDTO();
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
	
	// 하나의 데이터 가져오기
	public CustomDTO getReadData(int id) {
		
		// p s r 
		PreparedStatement pstmt = null;
		String sql;
		ResultSet rs = null;
		CustomDTO dto = null;

		try {
			conn = dataSource.getConnection();
			sql = "select id,name,age from custom where id = ? ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
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
	
	public int insertData(CustomDTO dto) {
		// psr
		
		PreparedStatement pstmt = null;
		String sql;
		int result = 0;
		
		try {
			
			conn = dataSource.getConnection();
			sql = "insert into custom (id,name,age) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());

			result = pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
	// 삭제
	
	public int delete(int id) {
		
		// psr 
		PreparedStatement pstmt = null;
		String sql;
		int result = 0;
		
		try {
			conn = dataSource.getConnection();
			sql = "delete from custom where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return id;
	}
	
	// 수정
	public int update(CustomDTO dto) {
		PreparedStatement pstmt = null;
		String sql;
		int result = 0;
		try {
			conn = dataSource.getConnection();

			sql = "update custom set age = ? ,name = ? where id = ?";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getAge());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}
	
}
