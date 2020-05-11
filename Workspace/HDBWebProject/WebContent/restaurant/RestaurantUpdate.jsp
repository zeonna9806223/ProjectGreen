<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<!-- <link rel="stylesheet" href="css/fontAwesome.css"> -->
<link rel="stylesheet" href="css/hero-slider.css">
<link rel="stylesheet" href="css/owl-carousel.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/templatemo-style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>

<style>
div {
/* 	display: block; */
	margin: 10px;
	font-size:large;
}
</style>

<body>
<body>
	<div class="wrap">
		<header id="header">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<button id="primary-nav-button" type="button">Menu</button>
						<a href="index.html"><div class="logo">
								<img src="img/logo.png" alt="Venue Logo">
							</div></a>
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
	
	
	<H2>update update update update update</H2>
	<form action="UpdateResServlet.do" method="post">
		<Input type='hidden' name='resId' value='${rest.restaurantID}'> 
		<div class="container">
			<div >
				<label>餐廳ID</label>
				 <input type="text" placeholder="" id="name"
					name="id" value="${id}">
				<label>餐廳名稱</label>
				 <input type="text" placeholder="" id="name"
					name="name" value="${name}"> <small><Font
					color='red' size="-3">${MsgMap.name} </Font></small>
			</div>
			<div>
				<label>餐廳類型</label> <input type="text" placeholder="" id="type"
					name="type" value="${type}"> <small><Font
					color='red' size="-3">${MsgMap.type}</Font></small>
			</div>
			<div>
				<label>餐廳地區</label> <input type="text" placeholder="" id="zone"
					name="zone" value="${zone}"> <small><Font
					color='red' size="-3">${MsgMap.zone}</Font></small>
			</div>
			<div>
				<label>餐廳地址</label> <input type="text" placeholder="" id="address"
					name="address" value="${address}"> <small><Font
					color='red' size="-3">${MsgMap.address}</Font></small>
			</div>
			<div>
				<label>餐廳經度</label> <input type="text" placeholder="" id="px"
					name="px" value="${px}">
			</div>
			<div>
				<label>餐廳緯度</label> <input type="text" placeholder="" id="py"
					name="py" value="${py}">
			</div>
			<div>
				<label>餐廳電話</label> <input type="text" placeholder="" id="phone"
					name="phone" value="${phone}">
			</div>
			

			<button type="submit" class="btn btn-info">Submit</button>
		</div>
	</form>
</body>
</html>