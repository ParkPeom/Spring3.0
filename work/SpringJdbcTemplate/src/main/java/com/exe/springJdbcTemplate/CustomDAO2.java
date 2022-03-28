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


// Spring�� jdbc �����ǿ���,�������������� ������
public class CustomDAO2 {
	
	// JdbcTemplate �� �������� jdbc �̴�.
	
	private JdbcTemplate jdbcTemplate;

	// ������ ���� 
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	// ������ ���� // �� �ٸ� jdbc���ø�
	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}
	
	
	
	// DAO ���ؼ��ʿ�
	Connection conn = null;
	
	
	// NamedParameterJdbcTemplate INSERT �� ����
	// Spring JDBC�� �� �ٸ� ���ø�
	
	public void insertData(CustomDTO dto) {
		
		// String���� �ޱ� 
		StringBuilder sql = new StringBuilder();
		/*
		 *JdbcTemplate
		sql.append("insert into custom (id,name,age) values(?,?,?)");
		
		// Spring�� jdbc�� insert,updated,delete�� ��� update �޼ҵ带 ȣ���Ѵ�.
		jdbcTemplate.update(sql.toString(),dto.getId(),dto.getName(),dto.getAge());
		*/

		// insert�� NamedParameterJdbcTemplate ����غ���
		// ? ��� :�÷����� �����
		sql.append("insert into custom(id,name,age) values (:id,:name,:age)");
		
		//PrepareStatement�������
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		//ModelAndView�� ���
		params.addValue("id", dto.getId());
		params.addValue("name", dto.getName());
		params.addValue("age", dto.getAge());
		
		namedJdbcTemplate.update(sql.toString(),params); 
	}
	
	// ��ü �����͸� ������
	public List<CustomDTO> getLists() {
		// select �� resultSet�� �ʿ�
		
		StringBuilder sql = new StringBuilder();	
		sql.append("select id,name,age from custom");
		
		// ��ü �����͸� �����ö��� query 
		List<CustomDTO> lists = 
				jdbcTemplate.query(sql.toString(),
					new RowMapper<CustomDTO>() { // rowMapper : ���� �ִµ��� �ݺ� while(rs.next)�� ����
						public CustomDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						
							// select �� �����Ͱ� rs�� ��
							// ���� �޾ƿ��� �ε�����ȣ�� rowNum�� ��

							CustomDTO dto = new CustomDTO();
							dto.setId(rs.getInt("id"));
							dto.setName(rs.getString("name"));
							dto.setAge(rs.getInt("age"));
							
							return dto; // dto�� ��ȯ�� �Ǽ� lists�� �ϳ��� ��
						}
				}); 
			return lists;
		}	
	
	// �ϳ��� �����͸� ������ queryForObject 
	public CustomDTO getReadData(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id,name,age from custom where id=?");
		
		// id�� �����ͼ� �ְ� sql.toString()���� �����ؼ� �����Ѱ���� rs�� �ִ´�.
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
					// �Ű������� 3�� , RowMapper�� ���
				return dtoOne;	
			}	
	// update�� insert �� ����ϴ�
	
	public void updateData(CustomDTO dto) {	
		// ���ۺ��ٴ� ������ �� ������. ������ �� ���̾�
		StringBuffer sql = new StringBuffer();
		sql.append("update custom set name=?,age=? where id=?");
		jdbcTemplate.update(sql.toString(),dto.getName(),dto.getAge(),dto.getId());
	}
	
	
	// ���� 
	public void deleteData(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete custom where id=?");
		jdbcTemplate.update(sql.toString(),id);
	}
}
