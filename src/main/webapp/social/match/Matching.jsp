<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Today's Matching List</title>
</head>
<body>
today;'request
${FUCK}
<table border="1">
<c:forEach var='m' items='${Matching}' >
	<tr>
		<td>${m.matchID}</td>
		<td>${m.memberID}</td>
	</tr>
</c:forEach>
</table>
MathingResult
<table border="1">
<c:forEach var='mL' items='${Matchlist}' >
	<tr>
		<td>${mL[0]}</td>
		<td>${mL[1]}</td>
		<td>${mL[2]}</td>
	</tr>
</c:forEach>
</table>
</html>