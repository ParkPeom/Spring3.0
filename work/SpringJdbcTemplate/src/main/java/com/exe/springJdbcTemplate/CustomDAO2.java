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
	
	// JdbcTemplate 은 스프링의 jdbc 이다.
	
	private JdbcTemplate jdbcTemplate;

	// 의존성 주입 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	// 의존성 주입 // 또 다른 jdbc템플릿
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
	
	
	// DAO 컨넥션필요
	Connection conn = null;
	
	
	// NamedParameterJdbcTemplate INSERT 만 적용
	// Spring JDBC의 또 다른 템플릿
	
	public void insertData(CustomDTO dto) {
		
		// String으로 받기 
		StringBuilder sql = new StringBuilder();
		/*
		 *JdbcTemplate
		sql.append("insert into custom (id,name,age) values(?,?,?)");
		
		// Spring의 jdbc는 insert,updated,delete는 모두 update 메소드를 호출한다.
		jdbcTemplate.update(sql.toString(),dto.getId(),dto.getName(),dto.getAge());
		*/

		// insert만 NamedParameterJdbcTemplate 사용해보기
		// ? 대신 :컬럼명을 써버림
		sql.append("insert into custom(id,name,age) values (:id,:name,:age)");
		
		//PrepareStatement같은기능
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		//ModelAndView와 비슷
		params.addValue("id", dto.getId());
		params.addValue("name", dto.getName());
		params.addValue("age", dto.getAge());
		
		namedJdbcTemplate.update(sql.toString(),params); 
	}
	
	// 전체 데이터를 가져옴
	public List<CustomDTO> getLists() {
		// select 는 resultSet이 필요
		
		StringBuilder sql = new StringBuilder();	
		sql.append("select id,name,age from custom");
		
		// 전체 데이터를 가져올때는 query 
		List<CustomDTO> lists = 
				jdbcTemplate.query(sql.toString(),
					new RowMapper<CustomDTO>() { // rowMapper : 값이 있는동안 반복 while(rs.next)와 같음
						public CustomDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						
							// select 한 데이터가 rs에 들어감
							// 각각 받아오는 인덱스번호가 rowNum에 들어감

							CustomDTO dto = new CustomDTO();
							dto.setId(rs.getInt("id"));
							dto.setName(rs.getString("name"));
							dto.setAge(rs.getInt("age"));
							
							return dto; // dto가 반환이 되서 lists에 하나씩 들어감
						}
				}); 
			return lists;
		}	
	
	// 하나의 데이터를 가져옴 queryForObject 
	public CustomDTO getReadData(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id,name,age from custom where id=?");
		
		// id를 가져와서 넣고 sql.toString()으로 실행해서 실행한결과를 rs에 넣는다.
		CustomDTO dtoOne = 
				jdbcTemplate.queryForObject(sql.toString(),
						new RowMapper<CustomDTO>() {

							public CustomDTO mapRow(ResultSet rs, int rowNum) throws SQLException {

								CustomDTO dto = new CustomDTO();
								
								dto.setId(rs.getInt("id"));
								dto.setName(rs.getString("name"));
								dto.setAge(rs.getInt("age"));
								
								return dto;
							}
					
					},id); 
					// 매개변수가 3개 , RowMapper가 길뿐
				return dtoOne;	
			}	
	// update는 insert 와 비슷하다
	
	public void updateData(CustomDTO dto) {	
		// 버퍼보다는 빌더가 더 빠르다. 빌더를 더 많이씀
		StringBuffer sql = new StringBuffer();
		sql.append("update custom set name=?,age=? where id=?");
		jdbcTemplate.update(sql.toString(),dto.getName(),dto.getAge(),dto.getId());
	}
	
	
	// 삭제 
	public void deleteData(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete custom where id=?");
		jdbcTemplate.update(sql.toString(),id);
	}
}
