package com.exe.springdi4;

import org.springframework.context.support.GenericXmlApplicationContext;

//중간단계역할
public class ServiceConsumer {
	
	// 인터페이스
	MessageService ms; // MessageService ms = (MessageService)context.getBean("messageService"); 와 같다 
	TimeService ts; 
	JobService js;
	
	// 생성자를 통한 의존성 주입
	// 받아내는건 인터페이스 들어오는건 클래스 
	// 바깥에서 ms를 받으므로 급하게 context를 만들필요가없어서 밑에 주석처리 
	public ServiceConsumer(MessageService ms) {
		this.ms = ms;
	}
	
	// 메소드를 통한 의존성 주입
	// 받아내는건 인터페이스 들어오는건 인터페이스
	public void setTimeService(TimeService ts) {
		this.ts = ts;
	}
	
	// 메소드를 통한 의존성 주입 
	public void setJobService(JobService js) {
		this.js = js;
	}
	
	
	
	public void consumerService() {
	
		// XML파일을 읽어와서 객체 생성	
		// "app-context.xml" 읽어와야 Bean객체 생성해서 가져옴
		//	GenericXmlApplicationContext context =
		//		new GenericXmlApplicationContext("app-context.xml");// 안써도됨 생성자 의존성주입을 통해서 객체생성 
	
		// 빈객체 불러옴(의존성주입)
		// 클래스객체를 인터페이스에 넣는다
		// MessageService ms = (MessageService)context.getBean("messageService"); // 위와 같음  
		
		String message = ms.getMessage();
		System.out.println(message);
		
		String time = ts.getTimeString();
		System.out.println(time);
		
		js.getJob();
	
	}
}
