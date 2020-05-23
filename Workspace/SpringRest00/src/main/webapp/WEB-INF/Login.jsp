<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->


<!-- Loding font -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:300,700" rel="stylesheet">



<style>
body {
	font-family: 'Montserrat', sans-serif;
	text-rendering : optimizeLegibility;
	-webkit-font-smoothing : antialiased;
}


#login-bg.container-fluid {
	padding: 0;
	height: 100%;
	position: absolute;
}

/* Background image an color divs*/

.bg-img , .bg-color {
	min-width: 50%;
	vertical-align: top;
	padding: 0;
	margin-left: 0;
	height: 100%;
	background-color: #CAF0D3;
	display: inline-block;
	overflow: hidden;
}

.bg-color {
	margin-left: -5px;
}

.bg-img {
	background-image: url(./bg-image.jpeg);
	background-size: cover;
}

#login{
	padding-top: 10%;
	text-align: center;
	text-transform: uppercase;
}


.login {
	width: 100%;
	height: 500px;
	background-color: #fff;
	padding: 15px;
	padding-top: 30px;
}

.login h1 {
	margin-top: 30px;
	font-weight: bold;
	font-size: 60px;
	letter-spacing: 3px;
}

.login form {
	max-width: 420px;
	margin: 30px auto;
}

.login .btn {
	border-radius: 50px;
	text-transform: uppercase;
	font-weight: bold;
	letter-spacing: 2px;
	font-size: 20px;
	padding: 14px;
	background-color: #00B72E;
}

.form-group input {
	height:5px;
	font-size: 20px;
	font-weight: lighter;
	border: none;
	background-color: #F0F0F0;
	color: #465347!important;
	padding: 10px;
	border-radius: 50px;
	transition : 0.2s;
}




/* Form check styles*/

.form-check {
	padding: 0;
	text-align: left;
}

.form-check label {
	vertical-align: top;
	padding-top: 5px;
	padding-left: 5px;
	font-size: 15px;
	color: #606060;
	font-size: 14px;
}

.forgot-password {
	text-align: right;
	float: right;
	font-weight: bold;
}

.forgot-password a {
	color: #00B72E;
	opacity: 0.6;
}

.forgot-password a:hover {
	opacity: 1;
}


/* Switch styles */

.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 30px;
}

/* Hide default HTML checkbox */
.switch input {display:none;}

/* The slider */
.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #F0F0F0;
  -webkit-transition: .4s;
  transition: .4s;
  border-radius: 30px;
}

.slider:before {
  position: absolute;
  content: "";
  height: 22px;
  width: 22px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
  border-radius: 50%;
}

input:checked + .slider {
  background-color: #00B72E;
}

input:focus + .slider {
  box-shadow: 0 0 1px ##00B72E;
}

input:checked + .slider:before {
  -webkit-transform: translateX(30px);
  -ms-transform: translateX(30px);
  transform: translateX(30px);
}



/* Media queries */

@media(max-width: 500px) {
	.bg-img , .bg-color {
	min-width: 100%;
	height: 50%;
	margin: 0;
	}

	.forgot-password {
	text-align: right;
	float: left;
	padding: 20px 0;
	}


	#login {
		padding-top: 50px;
	}

}

</style>

<title>Login</title>

<script type="text/javascript">

function setFocusToUserId(){   
	 document.forms[0].userId.focus();
}
</script>
</head>
<body onLoad="setFocusToUserId()">
<c:set var="funcName" value="LOG" scope="session"/>
<c:set var="msg" value="登入" />

<c:if test="${ ! empty sessionScope.timeOut }" >
<c:set var="msg" value="<font color='red'>${sessionScope.timeOut}</font>" />
</c:if>

<div class="container" id="login">
	<div class="row justify-content-center">
	<div class="col-lg-8">
	  <div class="login">

		<h1>Login</h1>
		<form action="LoginCheck" method="POST">
			<div class="form-group">
				<label for="memberAccount">帳號</label>
				<input type="text" class="form-control" id="memberAccount" name="memberAccount" value="${memberAccount}" />
				<label class="errMsg">${errMsg.eptAcc}</label>
			</div>
			
			<br>
			<div class="form-group">
				<label for="password">密碼</label>
				<input type="password" class="form-control" id="password" name="password">
				<label class="errMsg">${errMsg.eptPwd}</label>
			</div>			
			<a href="<c:url value="/Manage"/>">ma</a>
			<button type="submit" class="btn btn-primary">登入</button>
			<button type="reset" class="btn btn-primary">清除</button>
		</form>
		
	
	</div>
	</div>
	</div>
	</div>
	<script src="<c:url value="/js/jquery.slim.min.js"/>"></script>
	<script src="<c:url value="/js/popper.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
</body>
</html>