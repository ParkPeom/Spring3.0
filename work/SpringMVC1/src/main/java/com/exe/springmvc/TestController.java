package com.exe.springmvc;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// @Controller : TestController ��ü����
@Controller("test.controller")
public class TestController {
	
	
	/*
	// test/patam.action �����ּҰ� GET������� ���� processGetRequest()�޼ҵ� ����
	@RequestMapping(value="/test/param.action",method = RequestMethod.GET)
	public String processGetRequest() {
	
		// �۾�
		System.out.println("GET ��� Request");

		//���ư�
		// /paramResult.jsp
		return "paramResult";
	}
	
	
	// test/patam.action �����ּҰ� POST������� ���� processPostRequest()�޼ҵ� ����
	@RequestMapping(value = "/test/param.action",method = RequestMethod.POST)
	public String processPostRequest() {
		
		System.out.println("POST ��� Request");
		return "paramResult";
	}*/
	
	// test/patam.action �����ּҰ� GET �Ǵ� POST ������� ���� processGetPostRequest() �޼ҵ� ���� 
	
	/*
	@RequestMapping(value="/test/param.action",method = {RequestMethod.GET,RequestMethod.POST})
	public String processGetPostRequest(HttpServletRequest request) {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET��� Request");
			 return "paramResult";
		} else {
			 System.out.println("POST ��� Request");
			 return "paramResult1";
		}
		 return "paramResult";
	
	}*/
	
	
	// �߰��� DTO�� �Ű������� �޴´�. 
		 @RequestMapping(value = "/test/param.action",
					method = {RequestMethod.GET,RequestMethod.POST})
		
		 public String processPostRequest(PersonDTO dto , String name , HttpServletRequest request) {

			System.out.println("GET/POST ��� Request");
			System.out.println(name);
			
			// request�� �Ѿ���� ������ �޾Ƽ� ���
			System.out.println(request.getParameter("phone"));
			
			// �߰��� DTO�� �� �ֿܼ� ���
			System.out.println(dto);
			System.out.println("dto.getName(): " +  dto.getName());
			System.out.println("dto.getPhone(): " +  dto.getPhone());
			System.out.println("dto.getEmail(): " +  dto.getEmail());
			
			return"paramResult";
	}
	

	// ModelAndView �� ����Ͽ� ������ �Ѹ���
	// ModelAndView : ModelAndView : ������(Model)�� jsp����(View)�� �� ��Ʈ�� ��ȯ���� ������ �� ��� 
	// ���������� �ִ� ������
	// jsp���� dto�� �� �ѹ��� �Ѱ��ش�
	
	@RequestMapping(value="/test/mav.action",method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView mavRequest(PersonDTO dto) {
		// �������� DTO�� ���� �ڵ����� ���� DTO������ ��������
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("dto",dto); // �����͸� �ѱ�� (model)
		mav.setViewName("paramResult");// �������� �Ѹ��ų� (view)
		return mav;
	}
	
	// �����̷������� ������ �ѱ�� 
	// return redirect:/ �� ���� �������� ���ư��� return �� 
	// :/ �ڿ��� �����̷�Ʈ�ϰ� ���� �������� �����ش�
	// �ڿ� �ƹ��͵� ���� ������ ���������� ���ٷ�Ʈ
	@RequestMapping(value = "/test/redirect.action",method= {RequestMethod.GET,RequestMethod.POST})
	public String mavRedirectRequest() {
		return "redirect:/hello.action";
	}
}
