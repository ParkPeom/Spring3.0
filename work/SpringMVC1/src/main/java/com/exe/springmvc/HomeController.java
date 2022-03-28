package com.exe.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @Controller : 객체생성해줌
@Controller
public class HomeController { 
	
	// /라는 주소가 들어오면 GET방식으로 home이라는 메소드가 무조건 실행 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		// 앞에 /WEB-INF/views/home.jsp 
		return "home";
	}
	
	// hello.action 주소가 오면 getHello() 메소드 실행

	
	@RequestMapping(value = "/hello.action")
	public String getHello() {
	
		// /WEB-INF/views/hello.jsp 로 이동 
		return "hello";
	}
	
	
}
