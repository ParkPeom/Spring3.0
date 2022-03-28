package com.exe.springdi3;

import org.springframework.context.support.GenericXmlApplicationContext;

// app-context -> service(��������) -> en,kr
// �ܼ� �ڹٴ� xml�� �о�߸� bean ��ü�� ����
// ���� �����ʸ� ���� xml�� �ڵ����� �о
public class MessageService {
	
	public void messageService() {
		
		//BeanFactory ����
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("app-context.xml"); // XMLȭ�� �о ��ü ���� 

		// ���� Bean��ü ��� ����
		Message ms = (Message)context.getBean("message"); // ��ü������� object�� �����ǹǷ� �ٿ�ĳ����
	
		ms.sayHello("�����"); // app-context ���� class�� �ٲٸ� Ŭ�������� �޼ҵ� ȣ��
	}
}
