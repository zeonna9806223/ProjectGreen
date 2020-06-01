<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>

<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<!-- Title -->
<title>Roberto - Hotel &amp; Resort HTML Template</title>

<!-- Favicon -->
<link rel="icon" href="../roberto/img/core-img/favicon.png">

<!-- Stylesheet -->
<link rel="stylesheet" href="../roberto/style.css">
<script
	src='${pageContext.request.contextPath}/restaurant/fontawesome/js/all.js'></script>
<link rel="stylesheet"
	href='${pageContext.request.contextPath}/restaurant/fontawesome/css/all.css'>
<link rel="stylesheet"
	href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
	integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
	crossorigin="" />
</head>
<style>
#mapid {
	width: 600px;
	height: 400px;
	margin-left: 20px;
	padding: 0;
}
</style>

<body>
	<header class="header-area">
		<!-- 	Search Form -->
		<div class="search-form d-flex align-items-center">
			<div class="container">
				<form action="index.html" method="get">
					<input type="search" name="search-form-input" id="searchFormInput"
						placeholder="Type your keyword ...">
					<button type="submit">
						<i class="icon_search"></i>
					</button>
				</form>
			</div>
		</div>

		<!-- 	Top Header Area Start -->
		<div class="top-header-area">
			<div class="container">
				<div class="row">

					<div class="col-6">
						<div class="top-header-content">
							<a href="#"><i class="icon_phone"></i> <span>(123)
									456-789-1230</span></a> <a href="#"><i class="icon_mail"></i> <span>info.colorlib@gmail.com</span></a>
						</div>
					</div>

					<div class="col-6">
						<div class="top-header-content">
							<!-- 								Top Social Area -->
							<div class="top-social-area ml-auto">
								<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-tripadvisor" aria-hidden="true"></i></a>
								<a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<!-- 	Top Header Area End -->

		<!-- 	Main Header Start -->
		<div class="main-header-area">
			<div class="classy-nav-container breakpoint-off">
				<div class="container">
					<!-- 						Classy Menu -->
					<nav class="classy-navbar justify-content-between" id="robertoNav">

						<!-- 							Logo -->
						<a class="nav-brand" href="index.html"><img
							src="../roberto/img/core-img/logo.png" alt=""></a>

						<!-- 							Navbar Toggler -->
						<div class="classy-navbar-toggler">
							<span class="navbarToggler"><span></span><span></span><span></span></span>
						</div>

						<!-- 							Menu -->
						<div class="classy-menu">
							<!-- 								Menu Close Button -->
							<div class="classycloseIcon">
								<div class="cross-wrap">
									<span class="top"></span><span class="bottom"></span>
								</div>
							</div>
							<!-- 								Nav Start -->
							<div class="classynav">
								<ul id="nav">
									<li class="active"><a href="./index.html">Home</a></li>
									<li><a href="./room.html">Rooms</a></li>
									<li><a href="./about.html">About Us</a></li>
									<li><a href="#">Pages</a>
										<ul class="dropdown">
											<li><a href="./index.html">- Home</a></li>
											<li><a href="./room.html">- Rooms</a></li>
											<li><a href="./single-room.html">- Single Rooms</a></li>
											<li><a href="./about.html">- About Us</a></li>
											<li><a href="./blog.html">- Blog</a></li>
											<li><a href="./single-blog.html">- Single Blog</a></li>
											<li><a href="./contact.html">- Contact</a></li>
											<li><a href="#">- Dropdown</a>
												<ul class="dropdown">
													<li><a href="#">- Dropdown Item</a></li>
													<li><a href="#">- Dropdown Item</a></li>
													<li><a href="#">- Dropdown Item</a></li>
													<li><a href="#">- Dropdown Item</a></li>
												</ul></li>
										</ul></li>
									<li><a href="./blog.html">News</a></li>
									<li><a href="./contact.html">Contact</a></li>
								</ul>

								<!-- 									Search -->
								<div class="search-btn ml-4">
									<i class="fa fa-search" aria-hidden="true"></i>
								</div>

								<!-- 									Book Now -->
								<div class="book-now-btn ml-3 ml-lg-5">
									<a href="#">Book Now <i class="fa fa-long-arrow-right"
										aria-hidden="true"></i></a>
								</div>
							</div>
							<!-- 								Nav End -->
						</div>
					</nav>
				</div>
			</div>
		</div>
	</header>
	<!-- 	Header Area End -->

	<!-- 	Breadcrumb Area Start -->
	<div class="breadcrumb-area bg-img bg-overlay jarallax"
		style="background-image: url(../roberto/img/bg-img/56.jpg);">
		<div class="container h-100">
			<div class="row h-100 align-items-center">
				<div class="col-12">
					<div class="breadcrumb-content text-center">
						<h2 class="page-title">找餐廳</h2>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb justify-content-center">
								<li class="breadcrumb-item"><a href="index.html">首頁</a></li>
								<li class="breadcrumb-item active" aria-current="page">餐廳</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb Area End -->

	<!-- 	表單區塊開始 -->
	<div class="container" id="block" >
		<div class="jumbotron" 
			style="width: 600px; display: inline-block; margin: 60px">
			<h4 class="display-4">新增餐廳</h4>
			<div id="tabs-1">

				<form:form Method="POST" modelAttribute="RestaurantBean"
					enctype="application/x-www-form-urlencoded">

					<div class="form-group">
						<fieldset>
							<form:label path="" class="control-label">餐聽名稱</form:label>
							<form:input path="restaurantName" class="form-control" />
							<form:errors path="restaurantName" style="color:red" />


						</fieldset>
					</div>

					<div class="form-group">
						<fieldset>
							<form:label path="" class="control-label">餐聽類型</form:label>
							<form:input path="restaurantType" class="form-control" />
							<form:errors path="restaurantType" style="color:red" />
						</fieldset>
					</div>
<!-- 					<div class="form-group"> -->
<!-- 						<fieldset> -->
<%-- 							<form:label path="" class="control-label">城市</form:label> --%>
<%-- 							<form:input path="city" class="form-control" /> --%>
<%-- 							<form:errors path="city" style="color:red" /> --%>
<!-- 						</fieldset> -->
<!-- 					</div> -->

					<div class="form-group">
						<fieldset>
							<form:label path="" class="control-label">餐聽區域</form:label>
							<form:input path="restaurantZone" class="form-control" />
							<form:errors path="restaurantZone" style="color:red" />
						</fieldset>
					</div>

					<div class="form-group">
						<fieldset>
							<form:label path="" class="control-label">餐廳地址</form:label>
							<form:input path="restaurantAddress" class="form-control" />
							<form:errors path="restaurantAddress" style="color:red" />
						</fieldset>
					</div>
					<div class="form-group">
						<fieldset>

							<form:label path="" class="control-label">餐廳經度</form:label>
							<form:input path="restaurantPx" class="form-control" />
							<form:errors path="restaurantPx" style="color:red" />
						</fieldset>
					</div>
					<div class="form-group">
						<fieldset>
							<form:label path="" class="control-label">餐廳緯度</form:label>
							<form:input path="restaurantPy" class="form-control" />
							<form:errors path="restaurantPy" style="color:red" />
						</fieldset>
					</div>

					<div class="form-group">
						<fieldset>
							<form:label path="" class="control-label">餐廳電話</form:label>
							<form:input path="restaurantPhone" class="form-control" />
							<form:errors path="restaurantPhone" style="color:red" />
						</fieldset>
					</div>
					<div style="margin: 10px">
						<button type="submit" class="btn roberto-btn w-100;"
							style="border-radius: 15px"
							onclick="location.href='insertintoRestaurant'">確定送出</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>


	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

</body>

</html>