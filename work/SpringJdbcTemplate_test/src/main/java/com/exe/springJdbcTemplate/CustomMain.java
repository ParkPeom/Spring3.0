package com.exe.springJdbcTemplate;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;


// ���� �޼ҵ�
public class CustomMain {

	public static void main(String[] args) {
		
		
		GenericXmlApplicationContext context
			= new GenericXmlApplicationContext("app-context.xml");
		
		
		CustomDAO dao = (CustomDAO)context.getBean("customDAO");
	
		CustomDTO dto;

		dto = new CustomDTO();
		
		dto.setId(111);
		dto.setName("���γ�");
		dto.setAge(40);
		
		dao.insertData(dto);
		
		System.out.println("insert �Ϸ�..");
		
		
	}
}
