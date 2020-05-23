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
<title>Search</title>
<!-- changed -->

<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">



</head>

<body>
<jsp:include page="/WEB-INF/top.jsp"/>
	

	 <section class="pricing-tables">
		<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="section-heading">
							<span></span>
							<h2>${show}</h2>
						</div>
					</div>
				</div>
				
			<div class="row" >
					<c:forEach var="i" varStatus="vs" items="${hmap}">
						<div class="col-md-4" style="padding:10px 6px; height: 450px;" >
							<div class="table-item">
								<div class="top-content">
									<h4  id="name${vs.index}" >${i.name}</h4>
									<h1>$${i.price}</h1>
									<span>最低價</span>
								</div>
								<ul>
									<li><b>地址:</b>&nbsp;${i.addr}</li>
									<li><b>電話:</b>&nbsp;${i.tel}</li>
								
								</ul>
								<div class="blue-button " >
									<a onclick="pp();" id="${vs.index}">Go</a>
								</div>
							</div>
						</div>
					</c:forEach>
			</div>
		</div>
	</section>

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
									class="fa fa-dribbble"></i></a></li>
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
	<script>

		function pp() {
			var a ="#name"+event.srcElement.id;
			window.location.href = "${pageContext.request.contextPath}/show?hotel="+$(a).text();
		}
		

	</script>

</body>

</html>