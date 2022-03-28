package com.exe.springJdbcTemplate;

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
		// xml에서 빈팩토리를 만들면 오브젝트로 가져오게됨 
		CustomDAO2 dao = (CustomDAO2)context.getBean("customDAO2");
			
		
		// 점심시간 후 dao작업을 할것임 
		CustomDTO dto;
		
		// db엑세스
		
		dto = new CustomDTO();
		
		dto.setId(111);
		dto.setName("유인나");
		dto.setAge(40);
		
		dao.insertData(dto);
		
		System.out.println("insert완료..");
		
		
		// select
		/*
		List<CustomDTO> lists = dao.getLists();
		
		for(CustomDTO dto1 : lists) {
			System.out.printf("%d %s %d\n",
					dto1.getId(),dto1.getName(),dto1.getAge());
		}
		System.out.println("select 완료.."); */
		
		//OneSelect
		/*
		dto = dao.getReadData(111);
		if(dto!=null) {
			System.out.printf("%d %s %d\n",
					dto.getId(),dto.getName(),dto.getAge());
		}
		System.out.println("One select 완료.."); */
		
		//update
		/*
		dto = new CustomDTO();
		dto.setId(111);
		dto.setName("배수지");
		dto.setAge(28);
		
		dao.updateData(dto);
		System.out.println("업데이트 완료"); */
		
		// delete
		/*
		dao.deleteData(111);
		System.out.println("삭제 완료");*/
	}
}
