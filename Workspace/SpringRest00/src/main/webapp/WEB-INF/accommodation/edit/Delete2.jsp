<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible"
	content="width=device-width, initial-scale=1.0">
<!-- changed -->
<title>Delete</title>
<!-- changed -->

<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	

	<style type="text/css">
.button {
	background-color: #4883FF;
	border: none;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	transition-duration: 0.4s;
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/top.jsp"/>
	<!-- aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa -->
	<section class="featured-places" id="blog">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-heading">
						<span></span>
						<h2>旅宿資料刪除</h2>
					</div>
				</div>
			</div>

		<div style="width: 600px; margin: 0 auto; text-align: center">
					<form name="form1" action='<c:url value="/edit/edit.do"/>' method="post" >
		<fieldset>
		    <legend>申請人資料</legend>
<!-- 			    <label >姓名:<input type="text"  name="Uname" required  value="火星人"></label><br> -->
			    <label >姓名:<input type="text"  name="Uname" required disabled value="${sessionScope.LoginOK.memberName}"></label><br>
<%-- 			    <label >電話:<input type="text"  name="Utel" placeholder="請輸入電話" required value="${owner.utel}"></label><br> --%>
			    <label >電話:<input type="text"  name="Utel" disabled value="${sessionScope.LoginOK.memberCellPhone}"></label><br>
			    <label >電郵:<input type="email"  name="Uemail" disabled  value="${sessionScope.LoginOK.memberCellPhone}"></label><br>
<%-- 			    <label >電郵:<input type="email"  name="Uemail" placeholder="請輸入電郵" required value="${owner.uemail}"></label><br> --%>
			   
			   <input type="hidden" name="status2" value="delete">
<!-- 			    <input type="reset" class="button"> -->
			    <input type="submit" class="button" value="確認">
  		</fieldset>
  	</form>
  		<c:if test="${hotel.name != null}">
  		<form name="form2" action='<c:url value="/edit/edit.do"/>' method="post" >
  		<fieldset>
		    <legend>您的旅宿資料</legend>
			    <label >旅宿名稱: <input type="text"  name="name"  disabled value="${hotel.name}" style="background-color:snow" ></label><br>
				<label >旅宿地址: <input type="text"  name="addr"  disabled value="${hotel.addr}" style="background-color:snow"></label><br>
			    <label >旅宿電話: <input type="text"  name="tel"  disabled value="${hotel.tel}" style="background-color:snow"></label><br>
			    <label >旅宿電郵:<input type="email"  name="email"  disabled value="${hotel.email}" style="background-color:snow"></label><br>
			    <label >旅宿官網: <input type="text"  name="web"  disabled value="${hotel.web}" style="background-color:snow"></label><br>
			    <label >旅宿最低價:<input type="text"  name="price"  disabled value="${hotel.price}" style="background-color:snow"></label><br>
			  	
			  	<input  type="hidden"  name="Hname" placeholder="請輸入中文姓名"  value="${hotel.name}">
				<input type="hidden"  name="Haddr" placeholder="請輸入電話"  value="${hotel.addr}">
				<input type="hidden"  name="Hregion" placeholder="請輸入電話"  value="${hotel.regionId}">
				<input type="hidden"  name="Htown" placeholder="請輸入電話"  value="${hotel.townId}">
				<input type="hidden"  name="Htel" placeholder="請輸入電郵"  value="${hotel.tel}">
				<input type="hidden"  name="Hemail" placeholder="請輸入電郵"  value="${hotel.email}">
				<input type="hidden"  name="Hweb" placeholder="請輸入電郵"  value="${hotel.web}">
			    <input type="hidden"  name="Hprice" placeholder="請輸入電郵"  value="${hotel.price}">
			   
				<input type="hidden" name="status" value="delete">
			    <input type="submit" value="刪除" class="button">
		</fieldset>
		</form>
		</c:if>
	</div>
</div>
				
</section>


	

	<!-- aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa -->

	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<div class="about-veno">
						<div class="logo">
							<img
								src="${pageContext.request.contextPath}/social/img/footer_logo.png"
								alt="Venue Logo">
						</div>
						<p>Mauris sit amet quam congue, pulvinar urna et, congue diam.
							Suspendisse eu lorem massa. Integer sit amet posuere tellus, id
							efficitur leo. In hac habitasse platea dictumst.</p>
						<ul class="social-icons">
							<li><a href="#"><i class="fa fa-facebook"></i></a> <a
								href="#"><i class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-linkedin"></i></a> <a href="#"><i
									class="fa fa-rss"></i></a> <a href="#"><i
									class="fa fa-dribbble"></i></a>
						</ul>
					</div>
				</div>
				<div class="col-md-4">
					<div class="useful-links">
						<div class="footer-heading">
							<h4>Useful Links</h4>
						</div>
						<div class="row">
							<div class="col-md-6">
								<ul>
									<li><a href="#"><i class="fa fa-stop"></i>Help FAQs</a></li>
									<li><a href="#"><i class="fa fa-stop"></i>Register</a></li>
									<li><a href="#"><i class="fa fa-stop"></i>Login</a></li>
									<li><a href="#"><i class="fa fa-stop"></i>My Profile</a></li>
									<li><a href="#"><i class="fa fa-stop"></i>How It
											Works?</a></li>
									<li><a href="#"><i class="fa fa-stop"></i>More About
											Us</a></li>
								</ul>
							</div>
							<div class="col-md-6">
								<ul>
									<li><a href="#"><i class="fa fa-stop"></i>Our Clients</a></li>
									<li><a href="#"><i class="fa fa-stop"></i>Partnerships</a></li>
									<li><a href="#"><i class="fa fa-stop"></i>Blog Entries</a></li>
									<li><a href="#"><i class="fa fa-stop"></i>Contact Us</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="contact-info">
						<div class="footer-heading">
							<h4>Contact Information</h4>
						</div>
						<p>Praesent iaculis gravida elementum. Proin fermentum neque
							facilisis semper pharetra. Sed vestibulum vehicula tincidunt.</p>
						<ul>
							<li><span>Phone:</span><a href="#">010-050-0550</a></li>
							<li><span>Email:</span><a href="#">hi@company.co</a></li>
							<li><span>Address:</span><a href="#">company.co</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</footer>

	<div class="sub-footer">
		<p>
			Copyright &copy; 2018 Company Name - Design: <a rel="nofollow"
				href="http://www.templatemo.com">Template Mo</a>
		</p>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"
		type="text/javascript"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="${pageContext.request.contextPath}/social/js/vendor/jquery-1.11.2.min.js"><\/script>')
	</script>

	<script
		src="${pageContext.request.contextPath}/social/js/vendor/bootstrap.min.js"></script>

	<script
		src="${pageContext.request.contextPath}/social/js/datepicker.js"></script>
	<script src="${pageContext.request.contextPath}/social/js/plugins.js"></script>
	<script src="${pageContext.request.contextPath}/social/js/main.js"></script>
</body>

</html>