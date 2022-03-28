package com.exe.springdi4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


// Scope : serviceConsumer���� @Qualifier�� �ڵ����� �о�´�.
// �ٸ������� messageService�� �ָ� ��ü �浹�� .com�� ���ش�. 
// ��Ȯ�� �о���� ������ service���� Qualifier(messageService)
@Component("messageService") 
@Scope(value="prototype")  // ��ü�� �ҷ��ö����� ����ü�� �����.
public class MyMessageService implements MessageService {

	public String getMessage() {
		return "�ȳ� �氡�氡!!!";
	}
	
	
}


//@Scope
//�ڵ����� ��ϵǴ� ���� ���� ����
//singleton, prototype, session ��
//
//
//@Qualifier
//@Autowired�� �Բ� ���Ǿ �ڵ� ������ ������ ����� ��� Bean�� ��ü������ ����
//���� Ÿ���� Bean�� �� �� �̻� ��ϵ� ��� @Autowired�� �߻��� �� �ִ� ��ȣ�� ����