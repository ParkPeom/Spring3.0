package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

// app-context -> service(완충지대) -> en,kr
// 콘솔 자바는 xml를 읽어내야만 bean 객체가 생성
// 웹은 리스너를 통해 xml를 자동으로 읽어냄
public class MessageService {
	
	public void messageService() {
		
		//BeanFactory 생성
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml"); // XML화일 읽어서 객체 생성 

		// 이제 Bean객체 사용 가능
		Message ms = (Message)context.getBean("message"); // 객체가지고옴 object로 생성되므로 다운캐스팅
	
		ms.sayHello("배수지"); // app-context 에서 class를 바꾸면 클래스마다 메소드 호출
	}
}
