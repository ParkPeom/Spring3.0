package com.jdbc.springweb;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jdbc.dao.BoardDAO2;
import com.jdbc.dto.BoardDTO;
import com.jdbc.util.MyUtil;

//Controller 객체 생성 및  Controller 자동 상속 
@Controller
public class BoardController {
	
	/* servlet jdbc 
	@Autowired
	@Qualifier("boardDAO")
	BoardDAO dao; 
	*/
	
	// spring jdbc 
	@Autowired
	@Qualifier("boardDAO2")
	BoardDAO2 dao; // 의존성 주입

	@Autowired
	MyUtil myUtil; // 의존성주입해서 자동으로 가져옴
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		
		return "index";	
	}
	
	// get방식으로 왔을때
	/*
	@RequestMapping(value="/created.action",
			method= {RequestMethod.GET,RequestMethod.POST})
	public String created(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "bbs/created";
	}
	*/
	
	// Spring 고유의 ModelAndView
	// method 안쓰면 기본이 get방식으로 간다
	@RequestMapping(value="/created.action")
	public ModelAndView created() {		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs/created");	
		return mav;
	}
	
	// created.jsp 에서 글쓰기완료를 누르면 created_ok.action으로 이동
	@RequestMapping(value="/created_ok.action",
			method= {RequestMethod.GET,RequestMethod.POST})
	public String created_ok(BoardDTO dto , HttpServletRequest request,HttpServletResponse response) throws Exception {

		int maxNum = dao.getMaxNum();
		
		dto.setNum(maxNum + 1);
		dto.setIpAddr(request.getRemoteAddr());
		dao.insertData(dto);
		
		return "redirect:/list.action";
	}
	/*
	@RequestMapping(value = "/list.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String list(BoardDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception{
	*/
	
	// ModelAndView로 
	
	@RequestMapping(value = "/list.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView list(BoardDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		String cp = request.getContextPath();
		
		String pageNum = request.getParameter("pageNum");
		
		int currentPage = 1;
		
		if(pageNum!=null)
			currentPage = Integer.parseInt(pageNum);
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		if(searchValue==null) {
			searchKey = "subject";
			searchValue = "";
		
		}else {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				searchValue = URLDecoder.decode(searchValue, "UTF-8");
			}
		}
		
		int dataCount = dao.getDataCount(searchKey, searchValue);
		
		int numPerPage = 5;
		int totalPage = myUtil.getPageCount(numPerPage, dataCount);
		
		if(currentPage>totalPage)
			currentPage = totalPage;
		
		int start = (currentPage-1)*numPerPage+1; // 1 6 11 16
		int end = currentPage*numPerPage;
		
		List<BoardDTO> lists = dao.getLists(start, end, searchKey, searchValue);
		
		String param = "";
		
		if(searchValue!=null&&!searchValue.equals("")) { //널을 찾아내지 못하는경우가 있기때문에 양쪽에 부정문을 써준다.
			param = "searchKey=" + searchKey;
			param+= "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
		}
		
		String listUrl = cp + "/list.action";
		
		if(!param.equals("")) {
			listUrl += "?" + param;
		}

		String pageIndexList = myUtil.pageIndexList(currentPage, totalPage, listUrl);
		
		String articleUrl = cp + "/article.action?pageNum=" + currentPage;
		
		if(!param.equals("")) {
			articleUrl += "&" + param;
		}
		
		/*
		request.setAttribute("lists", lists);
		request.setAttribute("articleUrl", articleUrl);
		request.setAttribute("pageIndexList", pageIndexList);
		request.setAttribute("dataCount", dataCount);
		return "bbs/list";
		*/
		
		// ModelAndView로 데이터 넘기기
		ModelAndView mav = new ModelAndView();
		
		// 객체추가
		mav.addObject("lists",lists); // 데이터 넘기기
		mav.addObject("articleUrl",articleUrl); // 데이터 넘기기
		mav.addObject("pageIndexList",pageIndexList); // 데이터 넘기기
		mav.addObject("dataCount",dataCount); // 데이터 넘기기
		
		// VIEW이름설정 
		mav.setViewName("bbs/list"); // 어디로?	
		return mav;
	}
	
	@RequestMapping(value = "/article.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String article(BoardDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		String cp = request.getContextPath();
		
		String pageNum = request.getParameter("pageNum"); //  
		int num = Integer.parseInt(request.getParameter("num")); // 게시물번호 
		String searchKey = request.getParameter("searchKey"); // 검색 키
		String searchValue = request.getParameter("searchValue"); // 검색 값
		
		// 값이 있으면
		if(searchValue!=null) {
			searchValue = URLDecoder.decode(searchValue,"UTF-8");
		}
		
		//게시물번호(프라이머리키) 조회수 증가
		dao.updateHitCount(num);
		
		// 하나의 데이터 읽어온다
		// setAttribute("dto",dto);
		dto = dao.getReadData(num);		
		
		if(dto==null) {
			// modeleAndView 일때는 "redirect:/list.action"; 못씀
			return "redirect:/list.action";
		}
		
		// 라인수 
		// setAttribute("line",lineSu);
		int lineSu = dto.getContent().split("\n").length;
		
		dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));
		
		// setAttribute("params",param);
		
		// 밑에 몇번째 게시물인지 
		String param = "pageNum="+pageNum;
		
		if(searchValue!=null&&!searchValue.equals("")) {
			//검색을 했다는거
			param += "&searchKey="+searchKey;
			// 인코더 시켜서 보낸다
			param += "&searchValue="+URLEncoder.encode(searchValue,"UTF-8");
		}
		
		// 게시물 누르면 데이터가 보여지게 위해서 데이터를 넘김(setAttribute)
		request.setAttribute("dto", dto);
		
		// 사진8번
		// 값을 가지고 넘어가는 변수는 param을 쓸수없다
		// param은 이미 내부에 변수를 쓰고있다.
		request.setAttribute("params", param); // 키와 벨류 
		request.setAttribute("lineSu", lineSu);
		request.setAttribute("pageNum", pageNum);
		
		return "bbs/article";
	}
	
	@RequestMapping(value = "/updated.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String updated(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String cp = request.getContextPath();
		
		// 수정버튼 눌렀을때 주소창으로 넘어가는 데이터 
			int num = Integer.parseInt(request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");
			
			if(searchValue!=null) {
				searchValue = URLDecoder.decode(searchValue,"UTF-8");		
			}
			// 특정 데이터 (한개의 데이터) num으로 클릭하고 들어갔으므로 
			
			// http://localhost:8080/study/sboard/updated.do?num=39&pageNum=1
			
			BoardDTO dto = dao.getReadData(num);

			if(dto==null) {
				return "redirect:/list.action";
			}
			
			// 데이터 넘기기 위한 param
			String param = "pageNum=" + pageNum;
			
			if(searchValue!=null&&!searchValue.equals("")) {
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue,"UTF-8");
			}
			
			// 수정했을때 페이지에 기존 데이터들을 불러와야되므로 넘김 
			
			// 사진10번 변수를 쓰는건 상관없는데 
			request.setAttribute("dto", dto);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("params", param);
			request.setAttribute("searchKey", searchKey);
			request.setAttribute("searchValue", searchValue);
			return "bbs/updated";
	}
	@RequestMapping(value = "/updated_ok.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String updated_ok(BoardDTO dto, HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		// getparameter 요청 = 나 이거 줘 ! 
					String pageNum = request.getParameter("pageNum");	
					String searchKey = request.getParameter("searchKey");
					String searchValue = request.getParameter("searchValue");
					
					// dto가 매개변수로 넘어온다.
					// 왜 폼양식으로 ? created.jsp에서 hidden으로 넘겨와서 자동으로 dto에 들어감
					dao.updateData(dto);
					
					String param = "pageNum="+pageNum;
					
					if(searchValue!=null&&!searchValue.equals("")) {
						param += "&searchKey=" + searchKey;
						param += "&searchValue=" + URLEncoder.encode(searchValue,"UTF-8");
						
					}
					// 가상주소로 이동시킨다.
					// req.setAttribute("params", param);
					// 위에 para자체는 못넘김 왜 ? 이미 쓰이고있는 변수이니까
					
					// 여기서 param는 안에 들어가있는 경로가 들어가있다. 써도된다.
					
					// 사진12
					
					
					// 작업을 끝내서 list.do로 이동 ( sendRedirect )
					
					// 넘어가는 데이터가없으므로 modelandview 쓸필요가 없다
					// modelandview는 데이터와 경로를 넘겨주기때문에
					// 리다이렉트로 넘겨주면됨 
					return "redirect:/list.action?"+param;
		
	}
	
	@RequestMapping(value = "/deleted_ok.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String deleted_ok(HttpServletRequest request, HttpServletResponse response) throws Exception{

		// pagenum , 설치키 , 설치 벨류 가져와 
					int num = Integer.parseInt(request.getParameter("num"));	
					String pageNum = request.getParameter("pageNum");
					String searchKey = request.getParameter("searchKey");
					String searchValue = request.getParameter("searchValue");
					
					dao.deleteData(num);
					
					// 돌아갈곳
					String param = "pageNum="+pageNum;
					if(searchValue!=null&&!searchValue.equals("")) {
						param += "&searchKey=" + searchKey;
						param += "&searchValue=" + 
						URLEncoder.encode(searchValue,"UTF-8");
					}
					
					
			return "redirect:/list.action?" + param;
					
		}
	}
