<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<!-- pageEncoding="UTF-8" : 한글 표시 -->
request.setCharacterEncoding("UTF-8");

<html>
<head>
	<title>Home</title>
</head>
<body>

<h2>Spring MVC Controller Test</h2>


<!-- Get방식으로 링크 -->
<!-- ★링크를 보낼때 맨앞에/쓰면 안된다. -->
<!-- GET방식테스트 누르면 GET방식으로 이름 전화번호가 TestController로 가서 주소를 찾음 -->
<h3>1.<a href="test/param.action?name=suzi&phone=010-123-1234&email=suzi@naver.com">GET 방식 테스트</a></h3>



<!-- POST방식으로 데이터 넘기기-->
<h3>2.Post방식 </h3>
<form action="test/param.action" method="POST">
이름 : <input type="text" name="name"/><br/>
전화 : <input type="text" name="phone"/><br/>
이메일 : <input type="text" name="email"/><br/>
<input type="submit" value="전송"/><br/>
</form>
<br/>


<h3>3.ModelAndView 방식  <a href="test/mav.action?name=inna&phone=010-222-3333&email=inna@naver.com">ModelAndView Get 테스트</a></h3>

<!-- request.setAttribute();
return new ModelAndView() -->
<h3>2. ModelAndView Post 테스트 </h3>
<form action="test/mav.action" method="POST">
이름 : <input type="text" name="name"/><br/>
전화 : <input type="text" name="phone"/><br/>
이메일 : <input type="text" name="email"/><br/>
<input type="submit" value="전송"/><br/>
</form>

<br/>

<!-- 세션이 바뀌었을때 실행하는 명령어 -->
<h3>5. <a href="test/redirect.action">리다이렉트 테스트</a></h3>


</body>
</html>
