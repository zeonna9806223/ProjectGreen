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
<title>Show</title>
<!-- changed -->

<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">



<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">


<style>
.accommodation1 {
	padding-left: 30px;
	border: 3px solid #DDDDDD;
	border-radius: 25px;
	width: 600px;
}

.smimg {
	border: 3px solid #DDDDDD;
	border-radius: 10px;
}

.side {
	float: right;
	margin: auto:
}

.hide {
	display: none;
}

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

td {
	padding: 5px
}

.button :hover {
	background-color: rgba(0, 0, 0, 0.6);
	color: #4883FF;
}
</style>
</head>

<body>
<jsp:include page="/WEB-INF/top.jsp"/>

	<section class="featured-places" id="blog" style="margin-top: 0">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="accommodation1">
						<c:forEach var="i" items="${hInfo}">
							<table style="width: 500px">
								<tr>
									<td><h2 id="hname">${name}</h2></td>
									<td>
										<button type="button" id="booking" class="button hide"
											style="float: right" onclick="num();window.open('${i.web}');">訂房</button>
									</td>
								</tr>
							</table>
							<table>
								<iframe width="400" height="400" frameborder="0" scrolling="no"
									marginheight="0" marginwidth="0"
									src=https://maps.google.com.tw/maps?f=q&hl=zh-TW&geocode=&q=${i.addr}&z=16&output=embed&t=></iframe>
<!-- 								</tr> -->
								<tr>
									<td><b><p>地址:</p></b></td>
									<td><p>${i.addr}</p></td>
								</tr>
								<tr>
									<td><b><p>電話:</p></b></td>
									<td><p>${i.tel}</p></td>
								</tr>
								<c:if test="${i.email != ''}">
									<tr>
										<td><b><p>電郵:</p></b></td>
										<td><p>${i.email}</p></td>
									</tr>
								</c:if>
								<c:if test="${i.web != ''}">
									<script>
										$("#booking").removeClass("hide");
									</script>
									<tr>
										<td><b><p>官網:</p></b></td>
										<td><a onclick="window.open('${i.web}')">
												<p id="web">${i.web}</p>
										</a></td>
									</tr>
								</c:if>
								<tr>
									<td><b><p>最低價:</p></b></td>
									<td><p>${i.price}</p></td>
								</tr>
							</table>
						</c:forEach>
					</div>
				</div>

				<div class="col-md-4">
					<c:forEach var="i" items="${hInfo}">
						<table>
							<c:if test="${i.picture1 != '' and i.picture1!=null}">
								<div>
									<img style="width: 62px; height: 83px; display: block"
										class="smimg" src="${i.picture1}" onclick="showMaxImg(this)">
									<p>${i.pInfo1}</p>
							</div>
							</c:if>

							<c:if test="${i.picture2 != '' and i.picture2!=null}">
								<div>

									<img style="width: 62px; height: 83px; display: block"
										class="smimg" src="${i.picture2}" onclick="showMaxImg(this)">
									<p>${i.pInfo2}</p>
							</div>
							</c:if>

							<c:if test="${i.picture3 != '' and i.picture3!=null}">
								<div>

									<img style="width: 62px; height: 83px; display: block"
										class="smimg" src="${i.picture3}" onclick="showMaxImg(this)">
									<p>${i.pInfo3}</p>

								</div>
							</c:if>
						</table>

						<div class="modal fade bs-example-modal-lg text-center"
							id="imgModal" tabindex="-1" role="dialog" data-toggle="modal"
							aria-labelledby="myLargeModalLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg"
								style="display: inline-block; width: auto;">
								<div class="modal-content">
									<div id="imgshow"></div>
								</div>
							</div>
						</div>

						<script type="text/javascript">
							function showMaxImg(obj) {
								var src = $(obj).attr("src");
								$("#imgModal")
										.find("#imgshow")
										.html(
												"<img src='"+src+"' class='carousel-inner img-responsive img-rounded' data-dismiss='modal'>");
								$("#imgModal").modal('show');
							}
						</script>
					</c:forEach>

				</div>

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
		function num() {
			$.ajax({
				url : "${pageContext.request.contextPath}/bookUpdate",
				type : "POST",
				data : {
					booking : 1,
					hname : $("#hname").text(),
				}
			});
		}
	</script>

</body>

</html>