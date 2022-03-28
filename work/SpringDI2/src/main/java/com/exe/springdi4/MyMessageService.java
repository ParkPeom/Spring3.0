package com.exe.springdi4;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


// Scope : serviceConsumer에서 @Qualifier을 자동으로 읽어온다.
// 다른곳에서 messageService을 주면 객체 충돌남 .com를 써준다. 
// 명확히 읽어오고 싶으면 service에서 Qualifier(messageService)
@Component("messageService") 
@Scope(value="prototype")  // 객체를 불러올때마다 새객체를 만든다.
public class MyMessageService implements MessageService {

	public String getMessage() {
		return "안녕 방가방가!!!";
	}
	
	
}


//@Scope
//자동으로 등록되는 빈의 범위 지정
//singleton, prototype, session …
//
//
//@Qualifier
//@Autowired와 함께 사용되어서 자동 의존성 주입이 수행될 대상 Bean을 구체적으로 설정
//같은 타입의 Bean이 두 개 이상 등록된 경우 @Autowired에 발생할 수 있는 모호성 제거