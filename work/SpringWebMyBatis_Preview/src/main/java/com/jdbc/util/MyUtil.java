package com.jdbc.util;

public class MyUtil {
	
	// ��ü�������� ���ϱ�
	//numPerPage : ��ȭ�鿡 ǥ���� ������ ����
	//dataCount : ��ü �������� ����
	public int getPageCount(int numPerPage,int dataCount) {
		
		int pageCount = 0;
		pageCount = dataCount / numPerPage;
		
		if(dataCount % numPerPage != 0)
			pageCount++;
		return pageCount;
	}
	
	// ����¡ ó�� �޼ҵ�
	//currentPage : ���� ǥ���� ������
	//totalPage : ��ü ��������
	// listUrl : ��ũ�� ������ Url
	
	public String pageIndexList(int currentPage,int totalPage,String listUrl) {
		
		int numPerBlock = 5;
		int currentPageSetup;
		int page;
		
		StringBuffer sb = new StringBuffer();
		
		if(currentPage==0 || totalPage==0) 
			return "";
		else 
			listUrl = listUrl + "?";
		
		// ǥ���� ù ������ -1 ���ذ�
		currentPageSetup = (currentPage/numPerBlock) * numPerBlock;
		
		if(currentPageSetup % numPerBlock == 0)
			currentPageSetup = currentPageSetup - numPerBlock;
		
		// ������
		if(totalPage > numPerBlock && currentPageSetup > 0) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + currentPageSetup +"\">������</a>&nbsp;");
		}
		
		// �ٷΰ��� ������
		page = currentPageSetup + 1;
		
		while(page <= totalPage && page <= (currentPageSetup + numPerBlock)) {
			
			if(page == currentPage) {
				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
				
			} else {
				
				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">" + page + "</a>&nbsp;");
				
			}
			page++;
		}
		if(totalPage - currentPageSetup > numPerBlock) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">������</a>&nbsp;");
		}
		return sb.toString();
	}
}
