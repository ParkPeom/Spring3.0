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

//Controller ��ü ���� ��  Controller �ڵ� ��� 
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
	BoardDAO2 dao; // ������ ����

	@Autowired
	MyUtil myUtil; // �����������ؼ� �ڵ����� ������
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home() {
		
		return "index";	
	}
	
	// get������� ������
	/*
	@RequestMapping(value="/created.action",
			method= {RequestMethod.GET,RequestMethod.POST})
	public String created(HttpServletRequest request,HttpServletResponse response) throws Exception {
		return "bbs/created";
	}
	*/
	
	// Spring ������ ModelAndView
	// method �Ⱦ��� �⺻�� get������� ����
	@RequestMapping(value="/created.action")
	public ModelAndView created() {		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("bbs/created");	
		return mav;
	}
	
	// created.jsp ���� �۾���ϷḦ ������ created_ok.action���� �̵�
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
	
	// ModelAndView�� 
	
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
		
		if(searchValue!=null&&!searchValue.equals("")) { //���� ã�Ƴ��� ���ϴ°�찡 �ֱ⶧���� ���ʿ� �������� ���ش�.
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
		
		// ModelAndView�� ������ �ѱ��
		ModelAndView mav = new ModelAndView();
		
		// ��ü�߰�
		mav.addObject("lists",lists); // ������ �ѱ��
		mav.addObject("articleUrl",articleUrl); // ������ �ѱ��
		mav.addObject("pageIndexList",pageIndexList); // ������ �ѱ��
		mav.addObject("dataCount",dataCount); // ������ �ѱ��
		
		// VIEW�̸����� 
		mav.setViewName("bbs/list"); // ����?	
		return mav;
	}
	
	@RequestMapping(value = "/article.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String article(BoardDTO dto,HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		String cp = request.getContextPath();
		
		String pageNum = request.getParameter("pageNum"); //  
		int num = Integer.parseInt(request.getParameter("num")); // �Խù���ȣ 
		String searchKey = request.getParameter("searchKey"); // �˻� Ű
		String searchValue = request.getParameter("searchValue"); // �˻� ��
		
		// ���� ������
		if(searchValue!=null) {
			searchValue = URLDecoder.decode(searchValue,"UTF-8");
		}
		
		//�Խù���ȣ(�����̸Ӹ�Ű) ��ȸ�� ����
		dao.updateHitCount(num);
		
		// �ϳ��� ������ �о�´�
		// setAttribute("dto",dto);
		dto = dao.getReadData(num);		
		
		if(dto==null) {
			// modeleAndView �϶��� "redirect:/list.action"; ����
			return "redirect:/list.action";
		}
		
		// ���μ� 
		// setAttribute("line",lineSu);
		int lineSu = dto.getContent().split("\n").length;
		
		dto.setContent(dto.getContent().replaceAll("\n", "<br/>"));
		
		// setAttribute("params",param);
		
		// �ؿ� ���° �Խù����� 
		String param = "pageNum="+pageNum;
		
		if(searchValue!=null&&!searchValue.equals("")) {
			//�˻��� �ߴٴ°�
			param += "&searchKey="+searchKey;
			// ���ڴ� ���Ѽ� ������
			param += "&searchValue="+URLEncoder.encode(searchValue,"UTF-8");
		}
		
		// �Խù� ������ �����Ͱ� �������� ���ؼ� �����͸� �ѱ�(setAttribute)
		request.setAttribute("dto", dto);
		
		// ����8��
		// ���� ������ �Ѿ�� ������ param�� ��������
		// param�� �̹� ���ο� ������ �����ִ�.
		request.setAttribute("params", param); // Ű�� ���� 
		request.setAttribute("lineSu", lineSu);
		request.setAttribute("pageNum", pageNum);
		
		return "bbs/article";
	}
	
	@RequestMapping(value = "/updated.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String updated(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String cp = request.getContextPath();
		
		// ������ư �������� �ּ�â���� �Ѿ�� ������ 
			int num = Integer.parseInt(request.getParameter("num"));
			String pageNum = request.getParameter("pageNum");
			String searchKey = request.getParameter("searchKey");
			String searchValue = request.getParameter("searchValue");
			
			if(searchValue!=null) {
				searchValue = URLDecoder.decode(searchValue,"UTF-8");		
			}
			// Ư�� ������ (�Ѱ��� ������) num���� Ŭ���ϰ� �����Ƿ� 
			
			// http://localhost:8080/study/sboard/updated.do?num=39&pageNum=1
			
			BoardDTO dto = dao.getReadData(num);

			if(dto==null) {
				return "redirect:/list.action";
			}
			
			// ������ �ѱ�� ���� param
			String param = "pageNum=" + pageNum;
			
			if(searchValue!=null&&!searchValue.equals("")) {
				param += "&searchKey=" + searchKey;
				param += "&searchValue=" + URLEncoder.encode(searchValue,"UTF-8");
			}
			
			// ���������� �������� ���� �����͵��� �ҷ��;ߵǹǷ� �ѱ� 
			
			// ����10�� ������ ���°� ������µ� 
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
	
		// getparameter ��û = �� �̰� �� ! 
					String pageNum = request.getParameter("pageNum");	
					String searchKey = request.getParameter("searchKey");
					String searchValue = request.getParameter("searchValue");
					
					// dto�� �Ű������� �Ѿ�´�.
					// �� ��������� ? created.jsp���� hidden���� �Ѱܿͼ� �ڵ����� dto�� ��
					dao.updateData(dto);
					
					String param = "pageNum="+pageNum;
					
					if(searchValue!=null&&!searchValue.equals("")) {
						param += "&searchKey=" + searchKey;
						param += "&searchValue=" + URLEncoder.encode(searchValue,"UTF-8");
						
					}
					// �����ּҷ� �̵���Ų��.
					// req.setAttribute("params", param);
					// ���� para��ü�� ���ѱ� �� ? �̹� ���̰��ִ� �����̴ϱ�
					
					// ���⼭ param�� �ȿ� ���ִ� ��ΰ� ���ִ�. �ᵵ�ȴ�.
					
					// ����12
					
					
					// �۾��� ������ list.do�� �̵� ( sendRedirect )
					
					// �Ѿ�� �����Ͱ������Ƿ� modelandview ���ʿ䰡 ����
					// modelandview�� �����Ϳ� ��θ� �Ѱ��ֱ⶧����
					// �����̷�Ʈ�� �Ѱ��ָ�� 
					return "redirect:/list.action?"+param;
		
	}
	
	@RequestMapping(value = "/deleted_ok.action",
			method = {RequestMethod.GET,RequestMethod.POST})
	public String deleted_ok(HttpServletRequest request, HttpServletResponse response) throws Exception{

		// pagenum , ��ġŰ , ��ġ ���� ������ 
					int num = Integer.parseInt(request.getParameter("num"));	
					String pageNum = request.getParameter("pageNum");
					String searchKey = request.getParameter("searchKey");
					String searchValue = request.getParameter("searchValue");
					
					dao.deleteData(num);
					
					// ���ư���
					String param = "pageNum="+pageNum;
					if(searchValue!=null&&!searchValue.equals("")) {
						param += "&searchKey=" + searchKey;
						param += "&searchValue=" + 
						URLEncoder.encode(searchValue,"UTF-8");
					}
					
					
			return "redirect:/list.action?" + param;
					
		}
	}
