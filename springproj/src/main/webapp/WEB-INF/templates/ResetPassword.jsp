<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="resetpassword" modelAttribute="User">
		<center>
			<table border="1" width="30%" cellpadding="3">
				<tr>
					<td>Password</td>
					<td><input type="text" name="password" value="" /></td>
					<br>
					<td>ConfirmPassword</td>
					<td><input type="text" name="confirmpassword" value="" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
</body>
</html>