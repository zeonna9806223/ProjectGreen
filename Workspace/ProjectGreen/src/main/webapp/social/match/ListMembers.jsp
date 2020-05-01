<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<c:forEach var='mem' items='${memberList}' >
	<tr>
		<td>${mem.pk}</td>
		<td>${mem.account}</td>
		<td>${mem.password}</td>
		<td>${mem.username}</td>
		<td>${mem.gender}</td>
		<td>${mem.birthday}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>