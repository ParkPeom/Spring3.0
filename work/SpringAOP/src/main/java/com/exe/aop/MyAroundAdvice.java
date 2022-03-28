package com.exe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAroundAdvice {
	
	
	// Object : 그 메소드가 어느것을 반환할지 모르므로 Object로 받음 
	// around : before -> 메소드 -> after
	// 메소드를 실행시켜주는 코딩은 ProceedingJoinPoint
	
	@Around("execution(public void com..aop.*.*(..))")
	public Object aroundMethodCall(ProceedingJoinPoint jointPoint) {
		
		// 반환값
		Object result = null;
		try {		
			System.out.println("메소드 실행 전(AroundAdvice)..."); // Arround 실행 전
			
			result = jointPoint.proceed(); // Arround 메소드 실행 전에 하는 메소드 
										   /*	ta.doSomething1();
												ta.doSomething2();
												ta.doAnother1();
												ta.doAnother2();*/
			System.out.println("메소드 실행 후(AroundAdvice)..."); // 메소드가 끝나고 실행
		} catch (Throwable e) { // 회장나와 ! 사장Exception 보다 높음  
			
		}
		return result;
	}
}
