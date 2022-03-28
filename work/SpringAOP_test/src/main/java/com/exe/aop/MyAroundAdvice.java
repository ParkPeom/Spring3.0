package com.exe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAroundAdvice {
	
	// 프로시딩조인포인트 ( 리턴값이 있어야 실행된걸 알수있으니까 )
	@Around("execution(public void com..aop.*.*(..))")
		public Object aroundMethodCall(ProceedingJoinPoint joinPoint) {
		
			Object result = null;

		try {
		
			System.out.println("메소드 실행 전(AroundAdvice)...");
			result = joinPoint.proceed(); // TargetA.doSomething1
			
			System.out.println("메소드 실행 후(AroundAdvice)...");
			
		} catch (Throwable e) {

		}	
		return result;
	}
}
