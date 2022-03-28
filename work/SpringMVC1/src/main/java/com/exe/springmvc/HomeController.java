package com.exe.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// @Controller : ��ü��������
@Controller
public class HomeController { 
	
	// /��� �ּҰ� ������ GET������� home�̶�� �޼ҵ尡 ������ ���� 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		// �տ� /WEB-INF/views/home.jsp 
		return "home";
	}
	
	// hello.action �ּҰ� ���� getHello() �޼ҵ� ����

	
	@RequestMapping(value = "/hello.action")
	public String getHello() {
	
		// /WEB-INF/views/hello.jsp �� �̵� 
		return "hello";
	}
	
	
}
