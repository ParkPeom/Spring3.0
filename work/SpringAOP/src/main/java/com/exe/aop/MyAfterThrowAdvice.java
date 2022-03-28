package com.exe.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAfterThrowAdvice {
	
	// 에러가 났을때 실행
	@AfterThrowing("execution(public void com..aop.*.*(..))")
	public void afterThrowMethodCall() {
		System.out.println("메소드 에러발생후 실행(afterThrow...");
	}
}
