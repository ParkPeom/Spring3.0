package com.exe.springJdbcTemplate;

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
		// xml���� �����丮�� ����� ������Ʈ�� �������Ե� 
		CustomDAO2 dao = (CustomDAO2)context.getBean("customDAO2");
			
		
		// ���ɽð� �� dao�۾��� �Ұ��� 
		CustomDTO dto;
		
		// db������
		
		dto = new CustomDTO();
		
		dto.setId(111);
		dto.setName("���γ�");
		dto.setAge(40);
		
		dao.insertData(dto);
		
		System.out.println("insert�Ϸ�..");
		
		
		// select
		/*
		List<CustomDTO> lists = dao.getLists();
		
		for(CustomDTO dto1 : lists) {
			System.out.printf("%d %s %d\n",
					dto1.getId(),dto1.getName(),dto1.getAge());
		}
		System.out.println("select �Ϸ�.."); */
		
		//OneSelect
		/*
		dto = dao.getReadData(111);
		if(dto!=null) {
			System.out.printf("%d %s %d\n",
					dto.getId(),dto.getName(),dto.getAge());
		}
		System.out.println("One select �Ϸ�.."); */
		
		//update
		/*
		dto = new CustomDTO();
		dto.setId(111);
		dto.setName("�����");
		dto.setAge(28);
		
		dao.updateData(dto);
		System.out.println("������Ʈ �Ϸ�"); */
		
		// delete
		/*
		dao.deleteData(111);
		System.out.println("���� �Ϸ�");*/
	}
}
