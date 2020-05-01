<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="css/bootstrap-theme.min.css"> -->
<link rel="stylesheet" href="css/fontAwesome.css">
<link rel="stylesheet" href="css/hero-slider.css">
<link rel="stylesheet" href="css/owl-carousel.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/templatemo-style.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">

</head>
<script>
	$(function() {
		$("#speed").selectmenu();

		$("#files").selectmenu();

		$("#number").selectmenu().selectmenu("menuWidget").addClass("overflow");

		$("#salutation").selectmenu();
	});
</script>
<style>
fieldset {
	border: 0;
}

label {
	display: inline-block;
	margin: 30px 0 0 0;
}

.overflow {
	height: 200px;
}
</style>

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

	<div class="container">
		<h1>找餐廳</h1>
		<form action='res_templatemo/Lab/QueryType.do' method='POST'>
			<fieldset style="font-size: Large">
				<label for="speed">餐廳類型</label> <select name="type" id="type" >
					<option selected="selected">請選擇</option>
					<option>南洋</option>
					<option>飲品</option>
					<option>麵包、點心</option>
					<option>中式合菜</option>
					<option>日韓</option>
					<option>複合式餐飲</option>
					<option>速食漢堡</option>
					<option>素食</option>
					<option>早餐店</option>
					<option>日、西式料理(含速食)</option>
					<option>地方小吃</option>
					<option>歐</option>
					<option>美墨</option>
				</select> <label for="files">區域</label> <select name="zone" id="zone" >
					<option selected="selected">請選擇</option>
					<optgroup label="台北市">
						<option value="大安區">大安區</option>
			        	<option value="中山區">中山區</option>
			        	<option value="內湖區">內湖區</option>
			        	<option value="信義區">信義區</option>
			        	<option value="士林區">士林區</option>
			        	<option value="中正區">中正區</option>
			        	<option value="松山區">松山區</option>
			        	<option value="北投區">北投區</option>
			        	<option value="文山區">文山區</option>
			        	<option value="大同區">大同區</option>
			        	<option value="南港區">南港區</option>
			        	<option value="萬華區">萬華區</option>
					</optgroup>
					<optgroup label="新北市">
						<option value="板橋區">板橋區</option>
			        	<option value="三重區">三重區</option>
			        	<option value="新莊區">新莊區</option>
			        	<option value="中和區">中和區</option>
			        	<option value="新店區">新店區</option>
			        	<option value="汐止區">汐止區</option>
			        	<option value="樹林區">樹林區</option>
			        	<option value="土城區">土城區</option>
			        	<option value="林口區">林口區</option>
			        	<option value="淡水區">淡水區</option>
			        	<option value="永和區">永和區</option>
			        	<option value="蘆洲區">蘆洲區</option>
			        	<option value="鶯歌區">鶯歌區</option>
			        	<option value="五股區">五股區</option>
			        	<option value="三峽區">三峽區</option>
			        	<option value="泰山區">泰山區</option>
			        	<option value="八里區">八里區</option>
			        	<option value="金山區">金山區</option>
			        	<option value="深坑區">深坑區</option>
			        	<option value="瑞芳區">瑞芳區</option>
					</optgroup>

				</select> <input type="submit" value="搜尋"> 
				<input type="button"
					value="查所有餐廳" onclick="location.href='queryall.do'">
					<input type="button"
					value="新增餐廳" onclick="location.href='insertInto.jsp'">
			</fieldset>

		</form>
	</div>

	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>餐廳名字</th>
					<th>餐廳類型</th>
					<th>餐廳區域</th>
					<th>餐廳地址</th>
					<!-- 					<th>Px</th> -->
					<!-- 					<th>Py</th> -->
					<th>電話</th>
					<th>訂位</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty queryresult}">
						<tr height='36'>
							<td colspan='7' align='center'><font color='red'>歡迎查餐廳</font></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach  varStatus='vs' var='rest' items='${queryresult}'>
							<tr>
								<td align='left'>${rest.restaurantName}&nbsp;</td>
								<td align='left'>&nbsp;${rest.restaurantType}</td>
								<td align='left'>${rest.restaurantZone}</td>
								<td align='left'>&nbsp;${rest.restaurantAddress}</td>
								<%-- 								<td align='center'>${rest.restaurantPx}</td> --%>
								<%-- 								<td align='right'>${rest.restaurantPy}&nbsp;</td> --%>
								<td align='center'>${rest.restaurantPhone}</td>
								<td><c:if test="${ not empty rest.restaurantPhone}">
										<FORM action='resBookingServlet.do' method="Get">
											<Input type='hidden' name='resName' value='${rest.restaurantName}'> 
											<Input type='hidden' name='resZone' value='${rest.restaurantZone}'> 
											<Input type='hidden' name='resAddress' value='${rest.restaurantAddress}'>
											<Input type='hidden' name='resType' value='${rest.restaurantType}'>
											<Input type='hidden' name='resPhone' value='${rest.restaurantPhone}'>
										<input type="submit" value="訂位">
<!-- 											onclick="location.href='bookingRes.jsp'"> -->
										</FORM>
									</c:if></td>
							</tr>
							<!-- 							資料傳給下一個JSP -->

						</c:forEach>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
	</div>

</body>

</html>