package com.exe.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAroundAdvice {
	
	// ���νõ���������Ʈ ( ���ϰ��� �־�� ����Ȱ� �˼������ϱ� )
	@Around("execution(public void com..aop.*.*(..))")
		public Object aroundMethodCall(ProceedingJoinPoint joinPoint) {
		
			Object result = null;

		try {
		
			System.out.println("�޼ҵ� ���� ��(AroundAdvice)...");
			result = joinPoint.proceed(); // TargetA.doSomething1
			
			System.out.println("�޼ҵ� ���� ��(AroundAdvice)...");
			
		} catch (Throwable e) {

		}	
		return result;
	}
}
