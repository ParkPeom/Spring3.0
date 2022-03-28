package com.exe.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterReturnAdvice {

	// 메소드가 정상적으로 실행이 됬을때
	@AfterReturning("execution(public void com..aop.*.*(..))")
	public void afterReturnMethodCall() {
		System.out.println("메서드 실행후(After return)..");
		// TargetA.doSomething2  정상적으로 실행이 됬을때
		// 메서드 실행후(After return)..	
	}
}
