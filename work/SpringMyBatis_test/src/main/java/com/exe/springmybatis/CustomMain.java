package com.exe.springmybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {
		
// XML 있는 내용을 읽어온다.
	GenericXmlApplicationContext context
		= new GenericXmlApplicationContext("app-context.xml");
	CustomDAO dao = (CustomDAO)context.getBean("customDAO");
	CustomDTO dto;
	
	dto = new CustomDTO();
	
	dto.setId(111);
	dto.setName("유인나");
	dto.setAge(40);
	
	dao.insertData(dto);
	
	System.out.println("insert 완료 ... ");
		
	dto = dao.getReadData(111);
		if(dto!=null) {
			System.out.printf("%d %s %d\n", dto.getId(),dto.getName(),dto.getName());
		}
		System.out.println("One select 완료..");
	
	//update
		dto = new CustomDTO();
		dto.setId(111);
		dto.setName("배수지");
		dto.setAge(28);
		
		dao.updateData(dto);
		System.out.println("업데이트 완료");
		
		dao.deleteData(111);
		System.out.println("삭제완료");
	}
}
