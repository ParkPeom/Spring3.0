<%@ page contentType="text/html; charset=UTF-8"%>

<%
	String cp = request.getContextPath();
	
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd%22%3E
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="bbs">
	<div id="bbs_title">
	게 시 판(Spring3.0)
	</div>
	
	<form action="" name="myForm" method="post">
	<div id="bbsCreated">
		<div class="bbsCreated_bottomLine">
			<dl>
				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>
				</dd>
					<input type="text" name="subject" value="${dto.subject }" size="74" maxlength="100" class="boxTF"/>
				</dd>
			</dl>
		</div>
	<div class="bbsCreated_bottomLine">
		<dl>
			<dt>작성자</dt>
			<dd>
			<input type="text" name="name" value="${dto.name }" size="35" maxlength="20" class="boxTF"/>
			</dd>
		</dl>
	</div>
	
	<div class="bbsCreated_bottomLine">
		<dl>
			<dt>E-Mail</dt>
			<dd>
				<input type="text" name="email" value="${dto.email }" size="35" maxlength="50" class="boxTF"/>
			</dd>
		</dl>
		
	<div class="bbsCreated_content">
		<dl>
			<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>
			<dd>
				<textarea rows="12" cols="63" name="content" class="boxTF">${dto.content }</textarea>
			</dd>
		</dl>	
	</div>	
	
	
	<div class="bbsCreated_noLine">
		<dl>
			<dt>패스워드</dt>
			<dd>
				<input type="password" name="pwd" value="${dto.pwd }" size="35" maxlength="7" class="boxTF"/>
			</dd>
		</dl>	
	</div>	
	</div>	
	
	<div id="bbsCreated_footer">
		<input type="hidden" name="num" value="${dto.num }"/>
		<input type="hidden" name="pageNum" value="${dto.num }"/>
		<input type="button" value="수정하기" class="btn2" onclick="sendIt();"/>
		<input type="button" value="수정취소" class="btn2" onclick="javascript:location.href='<%=cp%>/list.action';"/>
	</div>
	</form>
</div>







</body>
</html>