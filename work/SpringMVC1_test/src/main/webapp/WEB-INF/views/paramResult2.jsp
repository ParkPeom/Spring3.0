<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

이름 <%=name %>
이메일 <%=email %>
전화<%=phone %>
</body>
</html>