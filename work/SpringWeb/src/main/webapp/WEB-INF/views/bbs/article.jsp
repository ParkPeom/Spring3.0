<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게 시 판</title>

<link rel="stylesheet" type="text/css" href="/springweb/resources/css/style.css"/>
<link rel="stylesheet" type="text/css" href="/springweb/resources/css/article.css"/>

</head>
<body>
<!-- 서블릿으로 넘어온건 다이렉트로 dto.변수명으로 받는다 -->
<div id="bbs">
	
	<div id="bbs_title">
		게 시 판 
	</div>
	<div id="bbsArticle">	
		<div id="bbsArticle_header">
			${dto.subject }
		</div>
		
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>작성자</dt>
				<dd>${dto.name }</dd>
				<dt>${lineSu }</dt>
				<dd>15</dd>
			</dl>		
		</div>
		
		<div class="bbsArticle_bottomLine">
			<dl>
				<dt>등록일</dt>
				<dd>${dto.created }</dd>
				<dt>조회수</dt>
				<dd>${dto.hitCount }</dd>
			</dl>		
		</div>
		
		<div id="bbsArticle_content">
			<table width="600" border="0">
			<tr>
				<td style="padding-left: 20px 80px 20px 62px;" 
				valign="top" height="200">
				${dto.content }
				</td>
			</tr>			
			</table>
		</div>
		
	</div>
	
	<div class="bbsArticle_noLine" style="text-align: right">
	From : ${dto.ipAddr }
	</div>
	
	<div id="bbsArticle_footer">
		<div id="leftFooter">
			<!-- 특정 num값을 가지고 들어가면서 설치키도,설치벨류 가지고 들어감  -->
			<input type="button" value=" 수정 " class="btn2" 
			onclick="javascript:location.href='<%=cp%>/updated.action?num=${dto.num }&${params }'"/>
			<input type="button" value=" 삭제 " class="btn2" 
			onclick="javascript:location.href='<%=cp%>/deleted_ok.action?num=${dto.num }&${params }'"/>
		</div>
		<div id="rightFooter">
			<input type="button" value=" 리스트 " class="btn2" 
			onclick="javascript:location.href='<%=cp%>/list.action?${params }';"/>
			<!-- 검색했다면 설치키,설치벨류도 가지고 나감 -->
			<!-- 설치키 설치벨류는 param 이 가지고 있다. -->
			<!-- 사진8번 setAttribute("params",param) param 변수를 그대로 써서 넘겨줄수없다 -->
		</div>	
	</div>
</div>
</body>
</html>






