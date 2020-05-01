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


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/social/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/social/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/social/css/fontAwesome.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/social/css/hero-slider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/social/css/owl-carousel.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/social/css/datepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/social/css/templatemo-style.css">

<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<body>
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
<body>

	<div class="wrap">
		<header id="header">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<button id="primary-nav-button" type="button">Menu</button>
						<a href="${pageContext.request.contextPath}/social/index.html">
							<div class="logo">
								<img
									src="${pageContext.request.contextPath}/social/img/logo.png"
									alt="Venue Logo">
							</div>
						</a>
						<nav id="primary-nav" class="dropdown cf">
							<ul class="dropdown menu">
								<!-- changed -->
								<li><a>呼朋引伴</a>
									<ul class="sub-menu">
										<li><a class="scrollTo" data-scrollTo="subtitle" href="#">伴遊配對~</a></li>
										<li><a class="scrollTo" data-scrollTo="subtitle" href="#">我要揪團！</a></li>
									</ul></li>
								<!-- changed -->

								<!--                                 <li><a class="scrollTo" data-scrollTo="services" href="#">Our Services</a></li> -->
								<li><a class="scrollTo" data-scrollTo="transportation"
									href="#">交通方式</a></li>
								<li><a class="scrollTo" data-scrollTo="Attractions"
									href="#">景點選擇</a></li>
								<li><a href="#">住宿選擇</a>
									<ul class="sub-menu">
											<li><a
											href="${pageContext.request.contextPath}/social/index.jsp#accommodation">住宿查詢</a>
										<li><a href="#">住宿資料編輯</a>
											<ul class="sub-menu">
												<li><a
													href="${pageContext.request.contextPath}/accommodation/edit/Insert2.jsp">新增</a></li>
												<li><a
													href="${pageContext.request.contextPath}/accommodation/edit/Update2.jsp">修改</a></li>
												<li><a
													href="${pageContext.request.contextPath}/accommodation/edit/Delete2.jsp">刪除</a></li>
											</ul></li>
									</ul></li>
								<li><a class="scrollTo" data-scrollTo="comment" href="#">留言及評論</a></li>
							</ul>
						</nav>
						<!-- / #primary-nav -->
					</div>
				</div>
			</div>
		</header>
	</div>
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
					<form name="form1" action="${pageContext.request.contextPath}/accommodation/edit/controller/EditServlet" method="post" >
		<fieldset>
		    <legend>申請人資料</legend>
			    <label >姓名:<input type="text"  name="Uname" placeholder="請輸入中文姓名" required value="${owner.uname}"></label><br>
<%-- 			    <label >電話:<input type="text"  name="Utel" placeholder="請輸入電話" required value="${owner.utel}"></label><br> --%>
			    <label >電話:<input type="text"  name="Utel" placeholder="請輸入電話"  value="${owner.utel}"></label><br>
			    <label >電郵:<input type="email"  name="Uemail" placeholder="請輸入電郵"  value="${owner.uemail}"></label><br>
<%-- 			    <label >電郵:<input type="email"  name="Uemail" placeholder="請輸入電郵" required value="${owner.uemail}"></label><br> --%>
			   
			   <input type="hidden" name="delete" value="a">
			    <input type="reset" class="button">
			    <input type="submit" class="button">
  		</fieldset>
  	</form>
  		<c:if test="${eb.hname != null}">
  		<form name="form2" action="${pageContext.request.contextPath}/accommodation/edit/controller/EditServlet" method="post" >
  		<fieldset>
		    <legend>您的旅宿資料</legend>
			    <label >旅宿名稱: <input type="text"  name="name" placeholder="請輸入中文姓名" disabled value="${eb.hname}" style="background-color:snow" ></label><br>
				<label >旅宿地址: <input type="text"  name="addr" placeholder="請輸入電話" disabled value="${eb.haddr}" style="background-color:snow"></label><br>
			    <label >旅宿電話: <input type="text"  name="tel" placeholder="請輸入電郵" disabled value="${eb.htel}" style="background-color:snow"></label><br>
			    <label >旅宿電郵:<input type="email"  name="email" placeholder="請輸入電郵" disabled value="${eb.hemail}" style="background-color:snow"></label><br>
			    <label >旅宿官網: <input type="text"  name="web" placeholder="請輸入電郵" disabled value="${eb.hweb}" style="background-color:snow"></label><br>
			    <label >旅宿最低價:<input type="text"  name="price" placeholder="請輸入電郵" disabled value="${eb.price}" style="background-color:snow"></label><br>
			  <input  type="hidden"  name="Hname" placeholder="請輸入中文姓名"  value="${eb.hname}">
			<input type="hidden"  name="Haddr" placeholder="請輸入電話"  value="${eb.haddr}">
			<input type="hidden"  name="Hregion" placeholder="請輸入電話"  value="${eb.hregionId}">
			<input type="hidden"  name="Htown" placeholder="請輸入電話"  value="${eb.htownId}">
			<input type="hidden"  name="Htel" placeholder="請輸入電郵"  value="${eb.htel}">
			 <input type="hidden"  name="Hemail" placeholder="請輸入電郵"  value="${eb.hemail}">
			    <input type="hidden"  name="Hweb" placeholder="請輸入電郵"  value="${eb.hweb}">
			    <input type="hidden"  name="Hprice" placeholder="請輸入電郵"  value="${eb.price}">
			    <input type="hidden" name="hidname" value="${owner.uname}">
			   <input type="hidden" name="delete2" value="b">
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