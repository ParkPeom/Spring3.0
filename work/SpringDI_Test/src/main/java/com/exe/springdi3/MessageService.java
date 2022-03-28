package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageService {
	
	public void messageService() {
		
		GenericXmlApplicationContext context 
			= new GenericXmlApplicationContext("app-context.xml");
		
		MessageKr messagekr = (MessageKr)context.getBean("message");
		
		messagekr.sayHello("¹è¼öÁö");	
	}
}
