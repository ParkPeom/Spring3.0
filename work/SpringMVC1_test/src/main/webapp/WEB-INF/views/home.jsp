<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h3>1.GET방식<a href="test/param.action?name=suzi&phone=010-123-1234&email=zkokopo@naver.com">클릭하세요</a></h3>

<h3>2.POST방식</h3>

<form action="test/param.action" method="POST">
	이름 : <input type="text" name="name"/><br/>
	전화 : <input type="tel" name="tel"/><br/>
	이메일 : <input type="text" name="email"/><br/>
	<input type="submit" value="전송"/><br/>
</form>
</body>
</html>
