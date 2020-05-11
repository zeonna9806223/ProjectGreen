<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Tabs - Collapse content</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/fontAwesome.css">
<link rel="stylesheet" href="css/hero-slider.css">
<link rel="stylesheet" href="css/owl-carousel.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/templatemo-style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("#tabs").tabs({
			collapsible : true
		});
	});

	$(function() {
		$("#datepicker").datepicker({
			showButtonPanel : true
		});
	});
</script>
</head>
<style>
#tabs {
	width: 750px;
	height: 700px;
}

.form-control {
	width: 300px;
}
</style>

<body>
	<div class="wrap">
		<header id="header">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<button id="primary-nav-button" type="button">Menu</button>
						<a href="index.html">
							<div class="logo">
								<img src="img/logo.png" alt="Venue Logo">
							</div>
						</a>
						<nav id="primary-nav" class="dropdown cf">
							<ul class="dropdown menu">
								<li class='active'><a href="#">Popular</a></li>
								<li><a class="scrollTo" data-scrollTo="popular" href="#">找餐廳</a></li>
								<li><a class="scrollTo" data-scrollTo="blog" href="#">Blog
										Entries</a></li>
								<li><a class="scrollTo" data-scrollTo="services" href="#">Our
										Services</a></li>
								<li><a class="scrollTo" data-scrollTo="contact" href="#">Contact
										Us</a></li>
							</ul>
						</nav>
						<!-- / #primary-nav -->
					</div>
				</div>
			</div>
		</header>
	</div>

	<div class=container id="tabs">
		<ul>
			<li><a href="#tabs-1">訂位 GO</a></li>
			<li><a href="#tabs-3">看地圖</a></li>
		</ul>
		<form action="resBookingServlet.do" method="post">
		<div id="tabs-1">
			<p>
				<strong>餐廳名稱 : ${name}  </strong>
					
			</p>
			<p>
				<strong>餐廳類型 : ${type}</strong>
			</p>
			<p>
				<strong>餐廳區域 : ${zone}</strong>
			</p>
			<p>
				<strong>餐廳地址 : ${address}</strong>
			</p>
			<p>
				<strong>餐廳電話 : ${phone}</strong>
			</p>
			<p>
<!-- 				<strong>開放預定數 :</strong> -->
			</p>
			<p>
<!-- 				<strong>剩餘預定數 : </strong> -->
			</p>
			<p>
<!-- 				<label for="usr">訂位人 :</label><input type="text" -->
<!-- 					class="form-control" id="usr"> -->
			</p>
			<p>
<!-- 				<label for="usr">手機號碼 :</label><input type="text" -->
<!-- 					class="form-control" id="usr"> -->
			</p>
			<p>
				<label for="usr">選擇日期 : </label><input type="date" >
			</p>
			<p>
				<label for="usr">選擇時間 :</label><input type="time" class="form-control"
					id="usr">
			</p>
			<p>
				<label for="usr">訂位人數 :</label>
				<select class="form-control" id="sel1">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</p>
			<p>
				<label for="usr"><input type="submit" value="確定訂位"></label>
			</p>
		</div>
		</form>
		<div class=container id="tabs-3">
			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d14459.637546852602!2d121.53959607813277!3d25.037148993532153!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3442a9821392326d%3A0x93faef9e2359365c!2z6byO5rOw6LGQIOS_oee-qeW6lw!5e0!3m2!1szh-TW!2stw!4v1587392050363!5m2!1szh-TW!2stw"
				width="600" height="450" frameborder="0" style="border: 0;"
				allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>

		</div>
	</div>


</body>

</html>