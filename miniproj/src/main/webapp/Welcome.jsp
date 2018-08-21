<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@page import="com.jda.model.UserModel" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<%
       UserModel user = null;
		response.setHeader("Cache-control"," no-cache, no-store, must-revalidate");
		if(request.getSession().getAttribute("user") == null){
			response.sendRedirect("index.jsp");
		}else{
			user = (UserModel)request.getSession().getAttribute("user");
		}

%>
Hello <%=user.getName() %>,  please logout so than I can check if my code for the logout controller is properly working. 
<form method = "POST" action = "logout">
<center>
<input type="submit" value = "logout">
</center>
</form>

</body>
</html>