<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
			if (request.getAttribute("login") != null
					&& request.getAttribute("login").equals("true")) {
		%>
		<h2>登陆成功</h2>
		<%
			} else {
		%>
		<jsp:forward page="login.jsp"></jsp:forward>
		<%
			}
		%>
	</center>
</body>
</html>