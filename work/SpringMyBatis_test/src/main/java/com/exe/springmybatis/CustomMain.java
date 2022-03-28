package com.exe.springmybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {
		
// XML �ִ� ������ �о�´�.
	GenericXmlApplicationContext context
		= new GenericXmlApplicationContext("app-context.xml");
	CustomDAO dao = (CustomDAO)context.getBean("customDAO");
	CustomDTO dto;
	
	dto = new CustomDTO();
	
	dto.setId(111);
	dto.setName("���γ�");
	dto.setAge(40);
	
	dao.insertData(dto);
	
	System.out.println("insert �Ϸ� ... ");
		
	dto = dao.getReadData(111);
		if(dto!=null) {
			System.out.printf("%d %s %d\n", dto.getId(),dto.getName(),dto.getName());
		}
		System.out.println("One select �Ϸ�..");
	
	//update
		dto = new CustomDTO();
		dto.setId(111);
		dto.setName("�����");
		dto.setAge(28);
		
		dao.updateData(dto);
		System.out.println("������Ʈ �Ϸ�");
		
		dao.deleteData(111);
		System.out.println("�����Ϸ�");
	}
}
