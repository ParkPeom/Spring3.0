package com.exe.aop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("app-context.xml");
		
		TargetA ta = (TargetA)context.getBean("targetA"); // @Componet 객체 읽어옴
		
		// 특정메소드가 실행되기전에 호출시키기 
		
		// beforeMethodCall 이 실행되고 나서 각각의 메소드가 실행됨
		ta.doSomething1();
		ta.doSomething2();
		ta.doAnother1();
		ta.doAnother2();
		
		// "execution(public void com..aop.*B.*(..))
		// targetA는 다 나오지만 TargetB는 메소드실행전..(BeforeAdvice)실행후 출력
		TargetB tb = (TargetB)context.getBean("targetB"); 
		
		/*
		tb.doSomething1("테스트");
		tb.doSomething2();
		tb.doAnother1();
		tb.doAnother2();
		*/
		
		// "execution(public void com..aop.*.*(..))	
		// execution(public void com..aop.*.*S*(..))"  대문자 S자가 들어간 메소드만 실행	
		// execution(public void com..aop.*.*2(..))"  메소드에 끝에 2가 들어가는 것만 실행 	
		// "execution(public void com..aop.*.*(String))"  String형태  매개변수에만 있는 메소드에 적용 		
		
	}
}
