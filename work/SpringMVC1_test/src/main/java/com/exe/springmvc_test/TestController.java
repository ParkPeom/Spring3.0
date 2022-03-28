package com.exe.springmvc_test;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.el.fmt.RequestEncodingTag;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller("com.testcontroller")
public class TestController {
	
	@RequestMapping(value="/test/param.action",method=RequestMethod.GET)
	public String precessGetRequest() {
		
		return "paramResult";
	}
	
	// 추가한 DTO를 매개변수로 받는다. 
	@RequestMapping(value="/test/param.action",method=RequestMethod.POST)
	public String precessPostRequest(PersonDTO dto, String name,HttpServletRequest request) {
		
		System.out.println("GET/POST 방식 Request");
		System.out.println(name);
		System.out.println(request.getParameter("phone"));
		
		// 추가한 dto 출력
		System.out.println(dto);
		System.out.println("dto.getName():" + dto.getName());
		System.out.println("dto.getPhone():" + dto.getPhone());
		System.out.println("dto.getEmail():" + dto.getEmail());
		return "paramResult";
	}
	
	// ModelAndView를 사용하여 데이터 뿌리기
	// - Model 과 view를 동시에 
	@RequestMapping(value="/test/mav.action",method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView mavRequest(PersonDTO dto) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("dto",dto);
		mav.setViewName("paramResult");
		return mav;
	}
	
	// 리다이렉션으로 데이터 넘기기
	// 세션이 바뀌거나 insert , delete ,update
	
	@RequestMapping(value="/test/redirect.action",method= {RequestMethod.POST,RequestMethod.GET})
	public String mavRedirectRequest() {
		
		return "redirect:/hello.action";
	}
	
	@RequestMapping(value="/test/param.action",method= {RequestMethod.POST,RequestMethod.GET})
	public String precessGetPost() {
		System.out.println("GET 과 POST방식");
		
		return "paramResult";
	}
	
	@RequestMapping(value="/test/list.action" , method= {RequestMethod.GET,RequestMethod.POST})
	public String processGetPost2(HttpServletRequest request, String name) {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			return "list1";
		}
		return "paramResult";
	}	
	
	@RequestMapping(value="/love/test.action" , method=RequestMethod.POST)
		public String processPostGetequest(String name,HttpServletRequest request,HttpServletResponse response) {
		System.out.println("GET/POST 방식 Request");
		return "list";
	}
	
}

