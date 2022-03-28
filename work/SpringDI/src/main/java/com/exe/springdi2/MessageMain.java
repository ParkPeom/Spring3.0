package com.exe.springdi2;

public class MessageMain {

	public static void main(String[] args) {
		
		// 의존성이 강함 
		System.out.println("1. 일반적인 객체 생성");
		
		//한글
		MessageKr ob1 = new MessageKr();
		ob1.sayHello("유인나");
		
		//영문
		MessageEn ob2 = new MessageEn();
		ob2.sayHello("suzi");
		

		// 인터페이스 장점: 다형성 의존성이 약해짐
		System.out.println("2. 인터페이스 객체 생성");
	
		// stack ms 
		Message ms = null;
		
		// 영문 
		// stack ms -> heap 10번지 Ms en() 실행 
		ms = new MessageEn();
		ms.sayHello("insun");
		
		
		// 한글
		// 기존 연결 끊음 
		// stack ms  -> heap 20번지 Ms kr() 실행
		ms = new MessageKr();
		ms.sayHello("정인선");
			
	}
}
