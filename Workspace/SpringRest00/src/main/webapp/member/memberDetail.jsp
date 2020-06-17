<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>會員資料</title>
	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<table class="table">
	<caption>
		<img style="padding-left:10px;" src='${pageContext.request.contextPath}/social/getImage?id=${LoginOK.memberAccount}&type=MEMBER' alt="" width="50px" height="50px" > 
		${LoginOK.memberName} 的會員資料
	</caption>

	<tbody>
		<tr class="active">
			<td>姓名</td>
			<td>${LoginOK.memberName}</td>
		</tr>
		<tr class="success">
			<td>帳號</td>
			<td>${LoginOK.memberAccount}</td>

		</tr>
		<tr  class="warning">
			<td>地址</td>
			<td>${LoginOK.memberAddress}</td>
		</tr>
		
		<tr  class="warning">
			<td>電子郵件</td>
			<td>${LoginOK.memberEmail}</td>
		</tr>
		<tr  class="warning">
			<td>電話</td>
			<td>${LoginOK.memberCellPhone}</td>
		</tr>

		<tr  class="warning">
			<td>註冊時間</td>
			<td>${LoginOK.memberJoinDate}</td>
		</tr>
		
		<tr  class="warning">
			<td>性別</td>
			<td>${LoginOK.gender}</td>
		</tr>
	</tbody>
</table>

</body>
</html>