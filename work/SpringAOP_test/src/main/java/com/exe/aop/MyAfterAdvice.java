package com.exe.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

public class MyAfterAdvice {
	
	// �ϰ���� �۾� 
	public void afterMethodCall() {
		System.out.println("�޼ҵ� ������(AfterAdvice)...");
	}
}
