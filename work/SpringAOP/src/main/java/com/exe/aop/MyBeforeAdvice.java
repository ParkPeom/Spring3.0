package com.exe.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect  // <aop:aspect~</aop:aspect>구조로 만듬
@Component  // 객체 생성
public class MyBeforeAdvice {
	
	@Before("execution(public void com..aop.*.*(..))")//내가 정해준 execution에 적용
	public void beforeMethodCall() {
		
		// 어드바이스 
		// 메소드가 실행되기전 실행될 코드 
		System.out.println("메소드 실행전(BeforeAdvice)");
	}
}
