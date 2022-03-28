package com.exe.springmybatis;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomMain {

	public static void main(String[] args) {
		
		// app-context.xml 를 읽어와서 객체 생성해서  의존성을 넣으면 됨
		GenericXmlApplicationContext context 
		 		= new GenericXmlApplicationContext("app-context.xml");
		// customDAO 객체 필요 
		//CustomDAO dao = (CustomDAO)context.getBean("customDAO");
		
		// spring jdbc dao
		CustomDAO dao = (CustomDAO)context.getBean("customDAO");
		// CustomDAO02 dao = (CustomDAO)context.getBean("customDAO02");
			
		CustomDTO dto;
		
		// db엑세스
		dto = new CustomDTO();
		
		dto.setId(111);
		dto.setName("유인나");
		dto.setAge(40);
		
		dao.insertData(dto);
		
		System.out.println("insert완료..");
		// select
		
		// lombok.jar 로 get 메소드 호출가능
		List<CustomDTO> lists = dao.getLists();
		
		for(CustomDTO dto1 : lists) {
			System.out.printf("%d %s %d\n",
					dto1.getId(),dto1.getName(),dto1.getAge());
		}	
		System.out.println("select 완료.."); 
		
		//OneSelect
		/*
		dto = dao.getReadData(111);
		if(dto!=null) {
			System.out.printf("%d %s %d\n",
					dto.getId(),dto.getName(),dto.getAge());
		}
		System.out.println("One select 완료.."); 
		//update
		*/
		/*
		dto = new CustomDTO();
		dto.setId(111);
		dto.setName("배수지");
		dto.setAge(28);
		
		dao.updateData(dto);
		System.out.println("업데이트 완료"); 
		*/
		// delete
		
		/*
		dao.deleteData(111);
		System.out.println("삭제 완료");
		*/
	}
}
