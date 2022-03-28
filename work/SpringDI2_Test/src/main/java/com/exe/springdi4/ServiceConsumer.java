package com.exe.springdi4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// ������̼�
// @Component : ��ü���� <bean id="serviceConsumer" class="com.exe.springdi4.ServiceConsumer"/>
// �浹���������Ƿ� �̸���
@Component("serviceConsumer") 
public class ServiceConsumer {
	
	// �������̽�
	// @Autowired : �ϰ� �˾Ƽ� ms �ʱ�ȭ �ض� (�������̽��� ��ӹ��� Ŭ������ ã�ƿ�)
	// @Resource = @Autowired + @Qualifier
	@Autowired
	@Qualifier("messageService") // Qualifier : �̸��� ������༭  MyMessageService ã�ƿ�
	MessageService ms; 
	
	// �ؿ� Qualifier�Ƚᵵ ã�ƿ´�.
	@Autowired
	TimeService ts; 
	
	@Autowired // Ŭ���� MyJobService�� ã�ƿ´�. this.js = JobService�� ������ ��ü
	JobService js; 
	
	public void consumerService() {
	
		String message = ms.getMessage();
		System.out.println(message);
		
		String time = ts.getTimeString();
		System.out.println(time);
		
		js.getJob();
	
	}
}
