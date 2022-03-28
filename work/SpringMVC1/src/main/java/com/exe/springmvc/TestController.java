package com.exe.springmvc;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// @Controller : TestController 객체생성
@Controller("test.controller")
public class TestController {
	
	
	/*
	// test/patam.action 가상주소가 GET방식으로 오면 processGetRequest()메소드 실행
	@RequestMapping(value="/test/param.action",method = RequestMethod.GET)
	public String processGetRequest() {
	
		// 작업
		System.out.println("GET 방식 Request");

		//돌아감
		// /paramResult.jsp
		return "paramResult";
	}
	
	
	// test/patam.action 가상주소가 POST방식으로 오면 processPostRequest()메소드 실행
	@RequestMapping(value = "/test/param.action",method = RequestMethod.POST)
	public String processPostRequest() {
		
		System.out.println("POST 방식 Request");
		return "paramResult";
	}*/
	
	// test/patam.action 가상주소가 GET 또는 POST 방식으로 오면 processGetPostRequest() 메소드 실행 
	
	/*
	@RequestMapping(value="/test/param.action",method = {RequestMethod.GET,RequestMethod.POST})
	public String processGetPostRequest(HttpServletRequest request) {
		
		if(request.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("GET방식 Request");
			 return "paramResult";
		} else {
			 System.out.println("POST 방식 Request");
			 return "paramResult1";
		}
		 return "paramResult";
	
	}*/
	
	
	// 추가한 DTO를 매개변수로 받는다. 
		 @RequestMapping(value = "/test/param.action",
					method = {RequestMethod.GET,RequestMethod.POST})
		
		 public String processPostRequest(PersonDTO dto , String name , HttpServletRequest request) {

			System.out.println("GET/POST 방식 Request");
			System.out.println(name);
			
			// request로 넘어오는 데이터 받아서 출력
			System.out.println(request.getParameter("phone"));
			
			// 추가한 DTO의 값 콘솔에 출력
			System.out.println(dto);
			System.out.println("dto.getName(): " +  dto.getName());
			System.out.println("dto.getPhone(): " +  dto.getPhone());
			System.out.println("dto.getEmail(): " +  dto.getEmail());
			
			return"paramResult";
	}
	

	// ModelAndView 를 사용하여 데이터 뿌리기
	// ModelAndView : ModelAndView : 데이터(Model)과 jsp파일(View)를 한 세트로 반환값을 돌려줄 때 사용 
	// 스프링에만 있는 변수형
	// jsp위에 dto를 얹어서 한번에 넘겨준다
	
	@RequestMapping(value="/test/mav.action",method= {RequestMethod.POST,RequestMethod.GET})
	public ModelAndView mavRequest(PersonDTO dto) {
		// 스프링은 DTO에 가서 자동으로 들어가서 DTO내용을 가져다줌
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("dto",dto); // 데이터를 넘긴다 (model)
		mav.setViewName("paramResult");// 누구한테 뿌릴거냐 (view)
		return mav;
	}
	
	// 리다이렉션으로 데이터 넘기기 
	// return redirect:/ 는 원래 페이지로 돌아가는 return 값 
	// :/ 뒤에는 리다이렉트하고 싶은 페이지를 적어준다
	// 뒤에 아무것도 적지 않으면 원래페이지 리다렉트
	@RequestMapping(value = "/test/redirect.action",method= {RequestMethod.GET,RequestMethod.POST})
	public String mavRedirectRequest() {
		return "redirect:/hello.action";
	}
}
