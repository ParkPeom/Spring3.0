package com.exe.springdi4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DiMain {

	// main에서 xml를 읽음
	public static void main(String[] args) {
	
		// 객체 생성해서 메세지 호출
		//  ServiceConsumer sc = new ServiceConsumer();
		//	sc.consumerService();
		
		// XML파일 읽어와서 실행 
		GenericXmlApplicationContext context =
			new GenericXmlApplicationContext("app-context.xml");
		
		// ServiceConsumer은 중간다리역할
		ServiceConsumer sc = (ServiceConsumer)context.getBean("serviceConsumer");
		sc.consumerService();
	}
}
