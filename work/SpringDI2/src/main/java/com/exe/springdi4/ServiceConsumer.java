package com.exe.springdi4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 어노테이션
// @Component : 객체생성 <bean id="serviceConsumer" class="com.exe.springdi4.ServiceConsumer"/>
// 충돌날수있으므로 이름줌
@Component("serviceConsumer") 
public class ServiceConsumer {
	
	// 인터페이스
	// @Autowired : 니가 알아서 ms 초기화 해라 (인터페이스를 상속받은 클래스를 찾아옴)
	// @Resource = @Autowired + @Qualifier
	@Autowired
	@Qualifier("messageService") // Qualifier : 이름을 명시해줘서  MyMessageService 찾아옴
	MessageService ms; 
	
	// 밑에 Qualifier안써도 찾아온다.
	@Autowired
	TimeService ts; 
	
	@Autowired // 클래스 MyJobService를 찾아온다. this.js = JobService로 가져온 객체
	JobService js; 
	
	public void consumerService() {
	
		String message = ms.getMessage();
		System.out.println(message);
		
		String time = ts.getTimeString();
		System.out.println(time);
		
		js.getJob();
	
	}
}
