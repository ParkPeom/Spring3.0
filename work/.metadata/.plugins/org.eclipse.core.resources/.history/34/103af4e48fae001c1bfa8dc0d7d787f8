package com.exe.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterReturnAdvice {

	@AfterReturning("execution(public void com..aop.*.*(..))")
	public void afterReturnMethodCall() {
		System.out.println("메소드 실행후(After return)..");
	}
}
