<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd%22%3E
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/springweb/resources/css/style.css" type="text/css"/>
<link rel="stylesheet" href="/springweb/resources/css/article.css" type="text/css"/>
<title>Insert title here</title>
</head>
<body>

<div id="bbs">
	<div id="bbs_title">
	게시판(Spring3.0)
	</div>
	<div id="bbsArticle">
		<div id="bbsArticle_header">
			${dto.subject }
		</div>	
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>${dto.name }</dd>
				<dt>줄수</dt>
				<dd>${lineSu }</dd>
			</dl>
		</div>
	<div id="bbsArticle">
		<div id="bbsArticle_header">
			${dto.subject }
		</div>	
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>등록일</dt>
				<dd>${dto.created }</dd>
				<dt>조회수</dt>
				<dd>${dto.created }</dd>
			</dl>
		</div>	
	<div id="bbsArticle_content">
		<table width="600" border="0">
			<tr><td style="padding:20px 80px 20px 62px;" valign="top" height="200">
			${dto.content }
			</td></tr>
			</table>
		</div>	
	</div>
	<div class="bbsArticle_noLine" style="text-align: right;">
		From: ${dto.ipAddr }
	</div>
	<div id="bbsArticle_footer">
		<div id="leftFooter">
			<input type="button" value="수정" class="btn2"
			onclick="javascript:location.href='<%=cp %>/updated.action?num=${dto.num }&pageNum=${pageNum }'/">
				<input type="button" value="삭제" class="btn2"
			onclick="javascript:location.href='<%=cp %>/deleted.action?num=${dto.num }&pageNum=${pageNum }'/">
			</div>
			<div id="rightFooter">
				<input type="button" value="리스트" class="btn2"
			onclick="javascript:location.href='<%=cp %>/list.action?${params }'/">
			</div>
		</div>
	</div>
</div>
</body>
</html>