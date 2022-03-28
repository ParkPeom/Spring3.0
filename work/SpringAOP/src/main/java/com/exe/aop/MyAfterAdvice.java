package com.exe.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterAdvice {
	
	// 하고싶은 작업	
	@After("execution(public void com..aop.*.*(..))")
	public void afterMethodCall() {
		System.out.println("메소드 실행후(AfterAdvice)...");
	}
}
