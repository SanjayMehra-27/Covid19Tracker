<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Redirect Page </title>
</head>
<body>



	<%
	// Redirects To Main URL eg : http://localhost:8085/NewsBlogsWeb/News
	
	response.sendRedirect(request.getContextPath()+"/Covid19");
	
	%>
</body>
</html>