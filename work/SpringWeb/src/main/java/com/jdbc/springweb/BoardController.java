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

import com.jdbc.dao.BoardDAO;
import com.jdbc.dto.BoardDTO;
import com.jdbc.util.MyUtil;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardDAO")
	BoardDAO dao; // ������ ����
	
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
		
		mav.addObject("lists",lists); // ������ �ѱ��
		mav.addObject("articleUrl",articleUrl); // ������ �ѱ��
		mav.addObject("pageIndexList",pageIndexList); // ������ �ѱ��
		mav.addObject("dataCount",dataCount); // ������ �ѱ��
		mav.setViewName("bbs/list"); // ����?

		return mav;
	}
}
