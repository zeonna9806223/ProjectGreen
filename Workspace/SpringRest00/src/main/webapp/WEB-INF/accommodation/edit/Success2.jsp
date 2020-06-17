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
<title>Success</title>
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
						<h2>旅宿資料編輯結果</h2>
					</div>
				</div>
			</div>

			<div style="width: 600px; margin: 0 auto; text-align: center ; ">
					<img src="https://img.icons8.com/carbon-copy/100/000000/ok.png"/>
					<h3>====成功====</h3>

					<c:if test="${insert != null}">
<%-- 					${sessionScope.LoginOK.memberName} --%>
						<p> <b>${sessionScope.LoginOK.memberName} </b>,您的旅宿資料 <b>${hotel.name}</b>已新增</p>
					</c:if>

					<c:if test="${update != null}">
						<p> <b>${sessionScope.LoginOK.memberName} </b>,您的旅宿資料 <b>${hotel.name}</b>已更新</p>
					</c:if>
					
					<c:if test="${delete != null}">
						<p><b>${sessionScope.LoginOK.memberName} </b>,您的旅宿資料<b>${hotel.name}</b>已刪除</p>
					</c:if>
					
						<table style= "margin: 0 auto; ">
							<tr>
								<td>旅宿名稱:${hotel.name}</td>
							</tr>
							<tr>
								<td>旅宿電話:${hotel.tel}</td>
							</tr>
							<tr>
								<td>旅宿電郵:${hotel.email}</td>
							</tr>
							<tr>
								<td>旅宿官網:${hotel.website}</td>
							</tr>
							<tr>
								<td>旅宿地址:${hotel.address}</td>
							</tr>
							<tr>
								<td>旅宿最低價:${hotel.lowestPrice}</td>
							</tr>
						</table>
					

<!-- 					<p> -->
<!-- 						<a href="EditPage.jsp">回更改頁面</a> -->
<!-- 					</p> -->
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


</body>

</html>