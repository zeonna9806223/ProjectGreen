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
rrrss
<c:forEach var="b" items="${showMatch}">
${b.memberName}ㄎㄎ<br>
${b.gender}<br>
</c:forEach>

</body>
</html>