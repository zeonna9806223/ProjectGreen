<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊會員</title>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>">
<style>
.errMsg {
	color: red;
}
</style>
</head>
<body>
	<%-- 	<jsp:include page="/WEB-INF/template/top.jsp" /> --%>
	<div class="container">
		<h1>註冊會員</h1>
		<form action="SignUpCheck" method="POST">

			<div class="form-group">
				<label for="memberAccount">帳號</label> <input type="text"
					class="form-control" id="memberAccount" name="memberAccount"
					value="${memberAccount}"> <label class="errMsg">${errMsg.errmemberAccount}</label>
			</div>

			<div class="form-group">
				<label for="memberEmail">電子信箱</label> <input type="email"
					class="form-control" id="memberEmail" name="memberEmail" value="${memberEmail}">
				<label class="errMsg">${errMsg.errEmail}</label>
			</div>
			<div class="form-group">
				<label for="memberPWD">密碼</label> <input type="password"
					class="form-control" id="memberPWD" name="memberPWD"> <label
					class="errMsg">${errMsg.errPassword}</label>
			</div>
			<div class="form-group">
				<label for="repassword">確認密碼</label> <input type="password"
					class="form-control" id="repassword" name="repassword">
			</div>
			<div class="form-group">
				<label for="name">gender</label> <input type="text" class="form-control"
					id="gender" name="gender" value="${gender}"> 
<!-- 					<label -->
<%-- 					class="errMsg">${errMsg.errgender}</label> --%>
			</div>

			<div class="form-group">
				<label for="name">memberAddress</label> <input type="text" class="form-control"
					id="memberAddress" name="memberAddress" value="${memberAddress}"> <label
					class="errMsg">${errMsg.errAddr}</label>
			</div>
			<div class="form-group">
				<label for="name">memberCellPhone</label> <input type="text" class="form-control"
					id="memberCellPhone" name="memberCellPhone" value="${memberCellPhone}"> <label
					class="errMsg">${errMsg.errName}</label>
			</div>
			<div class="form-group">
				<label for="memberName">姓名</label> <input type="text" class="form-control"
					id="memberName" name="memberName" value="${memberName}"> <label
					class="errMsg">${errMsg.errName}</label>
			</div>

			<button type="submit" class="btn btn-primary">送出</button>
			<button type="reset" class="btn btn-primary">清除</button>
		</form>
	</div>
	<script src="<c:url value="/js/jquery.slim.min.js"/>"></script>
	<script src="<c:url value="/js/popper.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>