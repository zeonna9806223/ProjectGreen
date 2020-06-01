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
	width: 400px;
	height: 400px;
	margin-top: 0px;
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
								<li class="breadcrumb-item"><a href="index.html">Home</a></li>
								<li class="breadcrumb-item active" aria-current="page">Room</li>
							</ol>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb Area End -->


	<!-- 	表單區塊開始 -->
	<div class="container" style="margin-top: 20px">
		<div class="jumbotron">
			<h4 class="display-4">${resBeselect.restaurantName}</h4>
			<p class="lead">This is a simple hero unit, a simple
				jumbotron-style component for calling extra attention to featured
				content or information.</p>
			<hr class="my-4">
			<p>It uses utility classes for typography and spacing to space
				content out within the larger container.</p>

			<form:form action="resBookingServlet.do" method="post">
				<div id="tabs-1">
					<div class=container>
						<i class="fas fa-eye" id="views"></i>${CountBean.viewCount} <i
							class="fas fa-thumbs-up" id="like" onclick="like (this.id)"></i>${CountBean.likeCount}
						<i class="far fa-thumbs-up" id="dialike"
							onclick="dislike (this.id)"></i>${CountBean.dislikeCount}
					</div>
					<p>
						<strong>餐廳類型 : ${resBeselect.restaurantType}</strong>
					</p>
					<p>
						<strong>餐廳區域 : ${resBeselect.restaurantZone}</strong>
					</p>
					<p>
						<strong>餐廳地址 : ${resBeselect.restaurantAddress}</strong>
					</p>
					<p>
						<strong>餐廳電話 : ${resBeselect.restaurantPhone}</strong>
					</p>

					<p class="lead">
						<a class="btn btn-primary btn-lg" href="#" role="button">看地圖</a>
					</p>



				</div>
			</form:form>
		</div>
	</div>
	<!-- 		<div class="container" style="width: 600px"> -->
	<!-- 			<div class="container" style="width: 600px" id="mapid"></div> -->
	<!-- 		</div> -->
	<!-- 	<div style="width: 600px"> -->
	<!-- 		<table class="table table-striped" id="table"> -->
	<!-- 			<thead> -->
	<!-- 				<tr> -->
	<!-- 					<th>餐廳ID</th> -->
	<!-- 					<th>餐廳名字</th> -->
	<!-- 					<th>餐廳區域</th> -->
	<!-- 					<th>餐廳選擇</th> -->
	<!-- 				</tr> -->
	<!-- 			</thead> -->
	<%-- 			<c:forEach varStatus='vs' var='rest' items='${queryresult}'> --%>
	<!-- 				<tr> -->
	<%-- 					<td align='left'>${rest.restaurantID}</td> --%>
	<%-- 					<td align='left'>${rest.restaurantName}</td> --%>
	<%-- 					<td align='left'>${rest.restaurantZone}</td> --%>
	<!-- 					<td> -->
	<%-- 						<button onclick="add(${rest.restaurantPx},${rest.restaurantPy})">加入地圖</button> --%>
	<%-- 						<button onclick="remove(${rest.restaurantPx},${rest.restaurantPy})">移除地圖</button> --%>
	<!-- <!-- 						<button id="marker" -->
	-->
	<%-- <%-- 							onclick="remove(${rest.restaurantPx},${rest.restaurantPy},'${rest.restaurantName}')">移除地圖</button> --%>
	--%>
	<!-- 					</td> -->
	<!-- 				</tr> -->
	<%-- 			</c:forEach> --%>
	<!-- 		</table> -->
	<!-- 	</div> -->
	<div class="card border-light mb-3" style="width: 50rem;">
		<div class="card-header">Header</div>
		<div class="card-body">
			<h4 class="card-title">Light card title</h4>
			<p class="card-text">Some quick example text to build on the card
				title and make up the bulk of the card's content.</p>
			<div style="display: inline-block" id="mapid"></div>
			<div style="display: inline-block">
				<button type="button" class="btn btn-primary" id="youbike"
					onclick="tpYoubike()">Youbike</button>
				<button type="button" class="btn btn-primary" id="mrt"
					onclick="mrt()">捷運站</button>
			</div>
		</div>
	</div>


	<script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js"
		integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA=="
		crossorigin=""></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script>
		//行程的點  一進來這個頁面就要先LOAD好的

		// 步驟 1-1 : 建立 Leaflet 地圖,設定經緯度座標 

		var myMap = L.map('mapid', {
			center : [ 25.031036, 121.550066 ],
			zoom : 15
		});
		// 步驟 1-2 :設定圖資來源
		L.tileLayer('https://{s}.tile.opentopomap.org/{z}/{x}/{y}.png', {
			maxZoom : 17,
		//    attribution: 'Map data: © <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>, <a href="http://viewfinderpanoramas.org">SRTM</a> | Map style: © <a href="https://opentopomap.org">OpenTopoMap</a> (<a href="https://creativecommons.org/licenses/by-sa/3.0/">CC-BY-SA</a>)'
		}).addTo(myMap);

		function add(px, py, name) {
			// 步驟 3 : 座標設上Mark  (把在網頁上選取某的地點,回送座標給API,地圖會顯示MARKER.bindPopup 秀地標說明)
			myMap.panTo([ py, px ]); //一加入地圖就會以這個座標當中心顯示
			L.marker([ py, px ]).addTo(myMap).bindPopup(
					"<strong>" + name + "</strong>").on('mouseover',
					function(over) {
						this.openPopup();
					}).on('mouseout', function() {
				this.closePopup().addControl;
			})
		}
		function remove(px, py, name) {
			L.marker([ py, px ]).removeControl;
		}

		// MRT被點選時	
		// 步驟 4 : 準備不同icon等等要用
		const mrtIcon = new L.Icon(
				{
					iconUrl : "https://cdn.rawgit.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-orange.png",
					//					shadowUrl : "https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png",
					iconSize : [ 15, 24 ],
					iconAnchor : [ 12, 41 ],
					popupAnchor : [ 1, -34 ],
					shadowSize : [ 41, 41 ]
				});
		var mrtlayer = new L.layerGroup();
		var mrtcont = 1;

		// youbike Icon設定
		const youbikeIcon = new L.Icon(
				{
					iconUrl : "https://cdn.rawgit.com/pointhi/leaflet-color-markers/master/img/marker-icon-2x-green.png",
					//				shadowUrl : "https://cdnjs.cloudflare.com/ajax/libs/leaflet/0.7.7/images/marker-shadow.png",
					iconSize : [ 15, 24 ],
					iconAnchor : [ 12, 41 ],
					popupAnchor : [ 1, -34 ],
					shadowSize : [ 41, 41 ]
				});
		//把所有youbike當作一個圖層(之後就可以一起加入一起移除)
		var youbikelayer = new L.layerGroup();
		//放一個計數器 我用來偵測USER押了幾次ICON,壓一下顯示YOUBIKE,再壓一下就消失
		var youbikecont = 1;
		function tpYoubike() {
			if (youbikecont % 2 != 0) {
				$
						.ajax({
							url : "${pageContext.request.contextPath}/restaurant/tpYoubike",
							type : "GET",
							data : {},
							dataType : "json",
							success : function(data) {
								for (i = 0; i < data.length; i++) {
									L.marker(
											[ data[i].latitude,
													data[i].longitude ], {
												icon : youbikeIcon
											}).addTo(youbikelayer) //把它加入youbikelayer圖層
									.bindPopup(
											"<strong>" + data[i].stationName
													+ "<br> 可借 :"
													+ data[i].available
													+ "<br> 可還 :"
													+ data[i].vacancy
													+ "</strong>").on(
											'mouseover', function(over) {
												this.openPopup();
											}).on('mouseout', function() {
										this.closePopup();
									})
								}
							},
							error : function() {
								console.log("回到ajax，data==null");
								$("#zone option").remove();
								$("#zone").append(
										$("<option></option>").attr("value",
												"0").text("請選擇"));
							}
						})
				NTPyoubike();
				//把youbikelayer圖層加入地圖
				youbikelayer.addTo(myMap);
			} else {
				myMap.removeLayer(youbikelayer); //當計數器偵測到偶數就做youbikelayer圖層移除
			}
			youbikecont++; //計數器記得加一
		}

		function NTPyoubike() {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/restaurant/ntpYoubike",
						type : "GET",
						data : {
						//				px:px,
						//				py:py
						},
						dataType : "json",
						success : function(datantp) {
							console.log(datantp)

							for (i = 0; i < datantp.length; i++) {
								L.marker(
										[ datantp[i].latitude,
												datantp[i].longitude ], {
											icon : youbikeIcon
										}).addTo(youbikelayer).bindPopup(
										"<strong>" + datantp[i].stationName
												+ "<br> 可借 :"
												+ datantp[i].available
												+ "<br> 可還 :"
												+ datantp[i].vacancy
												+ "</strong>").on('mouseover',
										function(over) {
											this.openPopup();
										}).on('mouseout', function() {
									this.closePopup();
								})
							}
						},
						error : function() {
							console.log("回到ajax，data==null");
							$("#zone option").remove();
							$("#zone").append(
									$("<option></option>").attr("value", "0")
											.text("請選擇"));
						}
					})
		}

		function mrt() {
			if (mrtcont % 2 != 0) {
				$
						.ajax({
							url : "${pageContext.request.contextPath}/restaurant/tpmrt",
							type : "GET",
							data : {
							//					px:px,
							//					py:py
							},
							dataType : "json",
							success : function(data) {
								console.log(data)
								for (i = 0; i < data.length; i++) {
									L.marker(
											[ data[i].latitude,
													data[i].longitude ], {
												icon : mrtIcon
											}).addTo(mrtlayer).bindPopup(
											"<strong>" + data[i].exitName
													+ "</strong>").on(
											'mouseover', function(over) {
												this.openPopup();
											}).on('mouseout', function() {
										this.closePopup();
									})
								}
							},
							error : function() {
								console.log("回到ajax，data==null");
								$("#zone option").remove();
								$("#zone").append(
										$("<option></option>").attr("value",
												"0").text("請選擇"));
							}
						})
				mrtlayer.addTo(myMap);
			} else {
				myMap.removeLayer(mrtlayer);
			}
			mrtcont++;
			console.log(mrtcont);
		}

		// 			L.marker([ 25.030861, 121.553995 ], {
		// 				icon : youbikeIcon
		// 			}).addTo(myMap).bindPopup(
		// 					"<strong>顯示地標(.openOn(myMap)每次LOAD進來都打開)</strong>").on(
		// 					'mouseover', function(over) {
		// 						this.openPopup();
		// 					}).on('mouseout', function() {
		// 				this.closePopup();
		// 			})

		// 以 L.circle 加入圓圈：
		// 		var circle = L.circle([ 25.031036, 121.550066 ], // 圓心座標
		// 		1000, // 半徑（公尺）
		// 		{
		// 			color : 'red', // 線條顏色
		// 			fillColor : 'lightblue', // 填充顏色
		// 			fillOpacity : 0.5
		// 		// 透明度
		// 		}).addTo(myMap).bindPopup("這是圓圈。");
	</script>

</body>

</html>