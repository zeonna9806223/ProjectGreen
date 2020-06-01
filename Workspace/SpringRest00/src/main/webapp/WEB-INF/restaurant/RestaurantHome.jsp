<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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

</head>

<body>
<!-- 	Preloader -->
<!-- 	    <div id="preloader"> -->
<!-- 	        <div class="loader"></div> -->
<!-- 	    </div> -->
<!-- 	/Preloader -->

<!-- 	Header Area Start -->
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
	<!-- 下拉式選單開始 -->
	<div class="hotel-reservation--area mb-40" style="margin-top: 20px">
		<!-- Hotel Reservation Area -->
		<div class="hotel-reservation--area mb-40">
			<form action='selectRestaurant' method='Get'>
				<div class="container">
					<div class="row">
						<div class="col">
							<span style="text-family: Microsoft JhengHei">城市</span> <select
								id="city" name="city" onchange="zonelist()" class="form-control">
								<option value="0">請選擇</option>
								<option value="台北市">台北市</option>
								<option value="新北市">新北市</option>
							</select>
						</div>
						<div class="col">
							<span>區域</span> <select id="zone" name="zone"
								onchange="typelist()" class="form-control">
								<option value="0" disabled="disabled">請選擇</option>
							</select>
						</div>
						<div class="col">
							<span>餐廳類型</span> <select id="type" name="type"
								class="form-control">
								<option value="0" disabled="disabled">請選擇</option>
							</select>
						</div>
						<div style="margin: 10px;">
							<button type="submit" class="btn roberto-btn w-100">搜尋</button>
						</div>
						<div style="margin: 10px;">
							<button type="button" class="btn roberto-btn w-100"
								onclick="location.href='queryallRestaurant'">查所有餐廳</button>
						</div>
						<div style="margin: 10px">
							<button type="button" class="btn roberto-btn w-100"
								style="background-color: lightpink; color: black"
								onclick="location.href='insertintoRestaurant'">新增餐廳</button>
						</div>
					</div>


				</div>
			</form>
		</div>
	</div>
	<!-- 下拉式選單結束 -->
	<div class="roberto-rooms-area section-padding-100-0">
		<div class="container">
			<div class="row">
				<div class="col-12 col-lg-8">
					<!-- 						Single Room Area -->
					<c:forEach varStatus='vs' var='rest' items='${queryresult}'>
						<div
							class="single-room-area d-flex align-items-center mb-50 wow fadeInUp"
							data-wow-delay="100ms">
							<!-- 							Room Thumbnail -->
							<div class="room-thumbnail">
								<img src="../roberto/img/bg-img/44.jpg" alt="">
							</div>
							<!-- 							Room Content -->
							<div class="room-content">
								<h2>${rest.restaurantName}</h2>
								<h4>
									${rest.restaurantType} <span>${rest.restaurantZone}</span>
								</h4>
								<div style="width:100px">
								<FORM action='moreInfo' method="Get">
									<Input type='hidden' name='id' value='${rest.restaurantID}'>
										<input
										class="btn roberto-btn w-100" type="submit"
										style="width:30px;margin: 10px 10px 10px 0px; border-radius: 15px"
										value="更多資訊">
								</FORM>
								<FORM action='deleteRes' method="Get" name="delete">
									<Input type='hidden' name='id' value='${rest.restaurantID}'>
										<input
										class="btn roberto-btn w-100" type="submit"
										style="margin: 10px 10px 10px 0px; border-radius: 15px;style;background-color: lightpink; color: black"
										value="刪除" name="delete" onclick="window.alert('確定刪除?');">
								</FORM>
							</div>

							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		// 各別查詢雙北有YouBike的區域
		function zonelist() {
			$.ajax({
				url : "${pageContext.request.contextPath}/restaurant/zonelist",
				// 			梅姬原本的URL
				// 			url:"${pageContext.request.contextPath}/restaurant/resController/zonelist",
				type : "GET",
				data : {
					// 往controller傳的參數命名為cityChoosen
					cityChoosen : $("#city").val(),
				// 			梅姬原本要往後傳的參數命名為ybCityChoosen
				// 				ybCityChoosen:$("#city").val(),
				},
				dataType : "json",
				success : function(data) {
					$("#zone option").remove();
					for (i = 0; i < data.length; i++) {
						// 					console.log(data[i]);

						$("#zone").append(
								$("<option></option>").attr("value", data[i])
										.text(data[i]));
					}
				},
				error : function() {
					console.log("回到ajax，data==null");
					$("#zone option").remove();
					$("#zone").append(
							$("<option></option>").attr("value", "0").text(
									"請選擇"));
				}
			})
		}

		function typelist() {
			$.ajax({
				url : "${pageContext.request.contextPath}/restaurant/typelist",
				// 			梅姬原本的URL
				// 			url:"${pageContext.request.contextPath}/restaurant/resController/zonelist",
				type : "GET",
				data : {
					// 往controller傳的參數命名為cityChoosen
					zoneChoosen : $("#zone").val(),
				// 			梅姬原本要往後傳的參數命名為ybCityChoosen
				// 				ybCityChoosen:$("#city").val(),
				},
				dataType : "json",
				success : function(data) {
					$("#type option").remove();
					for (i = 0; i < data.length; i++) {
						// 					console.log(data[i]);
						$("#type").append(
								$("<option></option>").attr("value", data[i])
										.text(data[i]));
					}
				},
				error : function() {
					console.log("回到ajax，data==null");
					$("#type option").remove();
					$("#type").append(
							$("<option></option>").attr("value", "0").text(
									"請選擇"));
				}
			})
		}

		// 姿君留言：function test()是我用來檢查前端往後端送的資料狀況，看你有沒有需要留著這支
		function test() {
			var city = $("city").val();
			var district = $("#zone").val();
			console.log("city：" + city + "／zone：" + district);
		}
	</script>
</body>

</html>