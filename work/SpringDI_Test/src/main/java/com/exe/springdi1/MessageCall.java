package com.exe.springdi1;

public class MessageCall {
	
	public static void main(String[] args) {
		
		// 의존성 : 결과를 만들기 위해 Message에 의존 
		// 의존성 문제 : Message 내용이 바뀌면 모든곳에 에러
		// 의존성이 강하다
		Message ob = new Message();
		ob.sayHello("배수지");
		
	}
}
