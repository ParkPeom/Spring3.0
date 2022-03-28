package com.exe.springdi2;

public class MessageMain {

	public static void main(String[] args) {
		
		System.out.println("1. 일반적인 객체 생성");
		
		// 한글
		MessageKr ob1 = new MessageKr();
		ob1.sayHello("유인나");
		
		
		// 영문
		MessageEn ob2 = new MessageEn();
		ob2.sayHello("suzi");
		
		System.out.println("2. 인터페이스 객체 생성");
		
		Message ms = null;
		
		ms = new MessageEn();
		ms.sayHello("insun");
		
		ms = new MessageKr();
		ms.sayHello("정인선");
	}
}	
