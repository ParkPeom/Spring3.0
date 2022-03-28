package com.exe.springdi4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DiMain {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		// ServiceConsumer 중간다리 
		ServiceConsumer sc = (ServiceConsumer)context.getBean("serviceConsumer"); // bean id , 객체명
		sc.consumerService();
		
	}
}
