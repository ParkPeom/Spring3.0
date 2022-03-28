package com.exe.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterThrowAdvice {
	
	// ������ ������ ����
	@AfterThrowing("execution(public void com..aop.*.*(..))")
	public void afterThrowMethodCall() {
		System.out.println("�޼ҵ� �����߻��� ����(afterThrow...");
	}
}
