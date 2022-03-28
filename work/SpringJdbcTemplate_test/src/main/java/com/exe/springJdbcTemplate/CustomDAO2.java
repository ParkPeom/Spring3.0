package com.exe.springJdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


// Spring의 jdbc 제어의역전,의존성주입으로 가져옴
public class CustomDAO2 {
	
	private JdbcTemplate jdbcTemplate;
	

	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate  = jdbcTemplate;
	}
	
	Connection conn = null;
	
	
	public void insertData(CustomDTO dto) {
		
		/*
		 * StringBuilder sql = new StringBuilder();
		 * 
		 * sql.append("insert into custom (id,name,age) values(?,?,?)");
		 * 
		 * // Spring 의 jdbc
		 * jdbcTemplate.update(sql.toString(),dto.getId(),dto.getName(),dto.getAge());
		 */
		
		StringBuilder sql = new StringBuilder();
		
		// : 를 씀 
		sql.append("insert into custom(id,name,age) values(:id,:name,:age)");
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("id", dto.getId());
		params.addValue("name", dto.getName());
		params.addValue("age", dto.getName());
		
		namedJdbcTemplate.update(sql.toString(), params);
		
	}
	
	public void update(CustomDTO dto) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("update custom set name=?,age=? where id=?");
		
		jdbcTemplate.update(sql.toString(),dto.getName(),dto.getAge(),dto.getId());
	}
	
	public void deleteData(int id) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("delete custom where id=?");
		
		jdbcTemplate.update(sql.toString(),id);
		
	}
	
	public CustomDTO getReadData(int id) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("select id,name,age from custom where id=?");
		
		CustomDTO dtoOne =
				jdbcTemplate.queryForObject(sql.toString(), new RowMapper<CustomDTO>() {
						
					public CustomDTO mapRow(ResultSet rs , int rowNum) throws SQLException{
						
						CustomDTO dto = new CustomDTO();
						
						dto.setId(rs.getInt("id"));
						dto.setName(rs.getString("name"));
						dto.setAge(rs.getInt("age"));
						
						return dto;
					}
				},id);
		return dtoOne;
	}
	
	
	public List<CustomDTO> getLists() {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select id , name , age from custom");
		
		List<CustomDTO> lists =
				jdbcTemplate.query(sql.toString(), new RowMapper<CustomDTO>() {
					
					public CustomDTO mapRow(ResultSet rs , int rowNum) throws SQLException {
						
						CustomDTO dto = new CustomDTO();
						
						dto.setId(rs.getInt("id"));
						dto.setName(rs.getString("name"));
						dto.setAge(rs.getInt("age"));
						return dto;
					}
				},id);
			return dtoOne;
		}
	
}


