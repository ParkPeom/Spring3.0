<%@page import="com.exe.springmvc.PersonDTO"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8"); // post방식에서 한글안깨짐
		
	/* GET방식으로  넘어오는 데이터를 받는다 */
	String cp = request.getContextPath();
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	
	
	// ModelAndView 방식으로 넘어오는 DTO받기
	PersonDTO dto = (PersonDTO)request.getAttribute("dto"); 
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>Param Result</h2>
이름:<%=name %><br/>
전화:<%=phone %><br/>
이메일<%=email %><br/>
<br/><br/>


<h2>ModelAndView로 넘어온 데이터</h2>
<%if(dto!=null) {%>
	이름 : <%=dto.getName() %><br/>
	전화: <%=dto.getPhone() %><br/>
	이메일: <%=dto.getEmail() %><br/>
<%} else { %>
	데이터없음 <br/>
<%} %>

</body>
</html>