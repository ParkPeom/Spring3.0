package com.exe.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterAdvice {
	
	// �ϰ���� �۾�	
	@After("execution(public void com..aop.*.*(..))")
	public void afterMethodCall() {
		System.out.println("�޼ҵ� ������(AfterAdvice)...");
	}
}
