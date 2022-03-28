package com.exe.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect  // <aop:aspect~</aop:aspect>������ ����
@Component  // ��ü ����
public class MyBeforeAdvice {
	
	@Before("execution(public void com..aop.*.*(..))")//���� ������ execution�� ����
	public void beforeMethodCall() {
		
		// �����̽� 
		// �޼ҵ尡 ����Ǳ��� ����� �ڵ� 
		System.out.println("�޼ҵ� ������(BeforeAdvice)");
	}
}
