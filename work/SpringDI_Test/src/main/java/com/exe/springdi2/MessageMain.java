package com.exe.springdi2;

public class MessageMain {

	public static void main(String[] args) {
		
		System.out.println("1. �Ϲ����� ��ü ����");
		
		// �ѱ�
		MessageKr ob1 = new MessageKr();
		ob1.sayHello("���γ�");
		
		
		// ����
		MessageEn ob2 = new MessageEn();
		ob2.sayHello("suzi");
		
		System.out.println("2. �������̽� ��ü ����");
		
		Message ms = null;
		
		ms = new MessageEn();
		ms.sayHello("insun");
		
		ms = new MessageKr();
		ms.sayHello("���μ�");
	}
}	
