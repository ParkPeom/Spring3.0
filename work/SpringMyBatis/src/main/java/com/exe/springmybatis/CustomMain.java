package com.exe.springmybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {
		
		// app-context.xml �� �о�ͼ� ��ü �����ؼ�  �������� ������ ��
		GenericXmlApplicationContext context 
		 		= new GenericXmlApplicationContext("app-context.xml");
		// customDAO ��ü �ʿ� 
		//CustomDAO dao = (CustomDAO)context.getBean("customDAO");
		
		// spring jdbc dao
		CustomDAO dao = (CustomDAO)context.getBean("customDAO");
		// CustomDAO02 dao = (CustomDAO)context.getBean("customDAO02");
			
		CustomDTO dto;
		
		// db������
		dto = new CustomDTO();
		
		dto.setId(111);
		dto.setName("���γ�");
		dto.setAge(40);
		
		dao.insertData(dto);
		
		System.out.println("insert�Ϸ�..");
		// select
		
		// lombok.jar �� get �޼ҵ� ȣ�Ⱑ��
		List<CustomDTO> lists = dao.getLists();
		
		for(CustomDTO dto1 : lists) {
			System.out.printf("%d %s %d\n",
					dto1.getId(),dto1.getName(),dto1.getAge());
		}	
		System.out.println("select �Ϸ�.."); 
		
		//OneSelect
		/*
		dto = dao.getReadData(111);
		if(dto!=null) {
			System.out.printf("%d %s %d\n",
					dto.getId(),dto.getName(),dto.getAge());
		}
		System.out.println("One select �Ϸ�.."); 
		//update
		*/
		/*
		dto = new CustomDTO();
		dto.setId(111);
		dto.setName("�����");
		dto.setAge(28);
		
		dao.updateData(dto);
		System.out.println("������Ʈ �Ϸ�"); 
		*/
		// delete
		
		/*
		dao.deleteData(111);
		System.out.println("���� �Ϸ�");
		*/
	}
}
