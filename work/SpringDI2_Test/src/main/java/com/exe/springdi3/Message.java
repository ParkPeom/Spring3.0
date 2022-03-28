package com.exe.springdi3;

// 인터페이스를 통한 의존성 주입
// 하나의 인터페이스를 구현한 2개의 클래스
// 하나는 영문 하나는 한글
public interface Message {
	
	public void sayHello(String name);
}
