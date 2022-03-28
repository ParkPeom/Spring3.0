package com.exe.springdi4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DiMain {

	
	public static void main(String[] args) {
		
		
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml");
		
		
		ServiceConsumer consumer = (ServiceConsumer)context.getBean("serviceConsumer");
		
		consumer.consumerService();
		
		
	}
}
