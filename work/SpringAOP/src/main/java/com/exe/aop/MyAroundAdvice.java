package com.exe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAroundAdvice {
	
	
	// Object : �� �޼ҵ尡 ������� ��ȯ���� �𸣹Ƿ� Object�� ���� 
	// around : before -> �޼ҵ� -> after
	// �޼ҵ带 ��������ִ� �ڵ��� ProceedingJoinPoint
	
	@Around("execution(public void com..aop.*.*(..))")
	public Object aroundMethodCall(ProceedingJoinPoint jointPoint) {
		
		// ��ȯ��
		Object result = null;
		try {		
			System.out.println("�޼ҵ� ���� ��(AroundAdvice)..."); // Arround ���� ��
			
			result = jointPoint.proceed(); // Arround �޼ҵ� ���� ���� �ϴ� �޼ҵ� 
										   /*	ta.doSomething1();
												ta.doSomething2();
												ta.doAnother1();
												ta.doAnother2();*/
			System.out.println("�޼ҵ� ���� ��(AroundAdvice)..."); // �޼ҵ尡 ������ ����
		} catch (Throwable e) { // ȸ�峪�� ! ����Exception ���� ����  
			
		}
		return result;
	}
}
