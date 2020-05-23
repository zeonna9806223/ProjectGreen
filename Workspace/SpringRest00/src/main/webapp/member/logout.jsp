<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登出</title>
</head>
<body>

<c:set var="memberName" value="${ LoginOK.memberName }" />
<c:remove var="LoginOK" scope="session" />
<c:remove var="ShoppingCart" scope="session" />
<c:set var="funcName" value="OUT" scope="session"/>
<c:set var="logoutMessage" scope="request"/>

<jsp:useBean id='logoutBean' class='member.model.LogoutBean' scope='page' />
    
<c:set target='${logoutBean}' 
   property='session'    value='${pageContext.session}'/>
   
${ logoutBean.logout }

<c:redirect url="/social/Index.jsp"/>
</body> 
</html>