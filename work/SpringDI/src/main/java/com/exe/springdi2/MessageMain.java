package com.exe.springdi2;

public class MessageMain {

	public static void main(String[] args) {
		
		// �������� ���� 
		System.out.println("1. �Ϲ����� ��ü ����");
		
		//�ѱ�
		MessageKr ob1 = new MessageKr();
		ob1.sayHello("���γ�");
		
		//����
		MessageEn ob2 = new MessageEn();
		ob2.sayHello("suzi");
		

		// �������̽� ����: ������ �������� ������
		System.out.println("2. �������̽� ��ü ����");
	
		// stack ms 
		Message ms = null;
		
		// ���� 
		// stack ms -> heap 10���� Ms en() ���� 
		ms = new MessageEn();
		ms.sayHello("insun");
		
		
		// �ѱ�
		// ���� ���� ���� 
		// stack ms  -> heap 20���� Ms kr() ����
		ms = new MessageKr();
		ms.sayHello("���μ�");
			
	}
}