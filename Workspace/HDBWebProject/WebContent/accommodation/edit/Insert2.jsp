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
<title>Insert</title>
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

	<style>
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

.imgSize {
	width: 20px;
	height: 20px;
	vertical-align: middle;
}
</style>
</head>
<body>

<div class="wrap">
        <header id="header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <button id="primary-nav-button" type="button">Menu</button>
                        <a href="${pageContext.request.contextPath}/social/Index.jsp">
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/social/img/logo.png" alt="Venue Logo">
                            </div>
                        </a>
                        <nav id="primary-nav" class="dropdown cf">
                            <ul class="dropdown menu">
                                <!-- changed -->
                                <li><a>呼朋引伴</a>
                                    <ul class="sub-menu">
                                        <li><a class="scrollTo" data-scrollTo="subtitle" href="${pageContext.request.contextPath}/social/Match.jsp">旅伴配對~</a></li>
                                        <li><a class="scrollTo" data-scrollTo="subtitle" href="${pageContext.request.contextPath}/social/Event.html">我要揪團！</a></li>
                                    </ul>
                                </li>
                                <!-- changed -->
                              
<!--                                 <li><a class="scrollTo" data-scrollTo="services" href="#">Our Services</a></li> -->
<!--                                 <li><a class="scrollTo" data-scrollTo="transportation" href="#">交通方式</a></li> -->
                                <li><a class="scrollTo" data-scrollTo="popular" href="${pageContext.request.contextPath}/restaurant/rSearchResult.jsp">找餐廳</a></li>
<!--                                 <li><a class="scrollTo" data-scrollTo="Attractions" href="#">景點選擇</a></li> -->
<!--                                 <li><a class="scrollTo" data-scrollTo="popular" href="#">找餐廳</a></li> -->
                                  <li><a href="#">住宿選擇</a>
									<ul class="sub-menu">
										<li><a
											href="${pageContext.request.contextPath}/social/Index.jsp#accommodation">住宿查詢</a>
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
                                <li><a class="scrollTo" data-scrollTo="transportation" href="#">交通方式</a></li>
                                <li><a class="scrollTo" data-scrollTo="Attractions" href="#">景點選擇</a></li>
									
<!--                                 <li><a class="scrollTo" data-scrollTo="comment" href="#">留言及評論</a></li> -->
                                <li>
                            		<c:if test="${empty LoginOK}">
										<a href="<c:url value='/member/login.jsp' />">
				     						登入 
										</a>
              						</c:if>
                            	</li>
                            	
                            	<li>
                            		<!-- 註冊 -->
                            		<c:if test="${empty LoginOK}">
			   							<a href="<c:url value='/member/register.jsp' />"> 註冊 </a>
									</c:if> 
									
									<!-- 登入後 顯示基本資料 -->
									<c:if test="${ ! empty LoginOK }">
										<span id="account"></span>
										<img style="padding-left:10px;" src='${pageContext.request.contextPath}/social/getImage?id=${LoginOK.memberAccount}&type=MEMBER' alt="" width="50px" height="50px" >
									</c:if> 
									
            					</li>
            					
            					<li>
            						<!-- 登入後  顯示登出 -->
            						
            						
									<c:if test="${ ! empty LoginOK }">
			  						<a href="<c:url value='/member/logout.jsp' />">登出 </a>
									</c:if>
            						
            						
            					</li>
                            </ul>
                        </nav><!-- / #primary-nav -->
                    </div>
                </div>
            </div>
        </header>
    </div>

	<script>
		function test() {
			$.ajax({
				url : "${pageContext.request.contextPath}/accommodation/edit/controller/EditServlet",
				type : "GET",
				data : {
					Hregion : $("#rs").val(),
				},
				dataType : "json",
				success : function(data) {
					$("#ts option").remove();
					for (i = 0; i < data.length; i++) {
						$('#ts').append(
								$("<option></option>").attr("value",
										data[i].value).text(data[i].text));
					}
				}
			});
		}
	</script>

	<script>
		function putAddr(x) {
			var selectAddr = document.getElementById(x);
			var index = selectAddr.selectedIndex;
			var c = selectAddr.options[index].text;
			var addrInput = document.getElementById('Haddr').value;
			if (c == '臺北市' | c == '新北市') {
				$("#Haddr").val(c);
			} else {
				if ($("#Haddr").val().charAt(4) != '') {
					var old = $("#Haddr").val().substring(3, 6);
					document.getElementById('Haddr').value = addrInput.replace(
							old, c);
				} else {
					$("#Haddr").val(function() {
						return this.value + c;
					});
				}
			}
		}

		

		function keyDown(x) {
			var et = document.getElementById(x);
			et.innerHTML = '';
		}

		function checkHname(x, y, z) {
			var n = document.getElementById(x).value;
			var c1 = document.getElementById(y);
			if (n == "") {
				c1.innerHTML = '<img class="imgSize"  src="${pageContext.request.contextPath}/social/img/accommodation/X.png">'
						+ z + '不可為空白';
			} else if (n.length < 2) {
				c1.innerHTML = '<img class="imgSize"  src="${pageContext.request.contextPath}/social/img/accommodation/X.png">'
						+ z + '至少兩個字以上';
			} else if (n.length >= 2) {
				for (let i = 0; i < n.length; i++) {
					if (n.charCodeAt(i) < 0x4E00 || n.charCodeAt(i) > 0x9FA5) {
						c1.innerHTML = '<img class="imgSize"  src="${pageContext.request.contextPath}/social/img/accommodation/X.png">'
								+ z + '必須全部為中文字';
					} else {
						c1.innerHTML = '<img class="imgSize"  src="${pageContext.request.contextPath}/social/img/accommodation/V.png">';
					}
				}
			}
		}

		function checkAddr(x, y, z) {
			let unn = [ "!", "@", "#", "$", "%", "^", "&", "*" ];
			var p = document.getElementById(x).value;
			var c2 = document.getElementById(y);
			if (p == "") {
				c2.innerHTML = '<img class="imgSize"  src="${pageContext.request.contextPath}/social/img/accommodation/X.png">'
						+ z + '不可為空白';
			} else {
				for (let i = 0; i < p.length; i++) {
					if (unn.includes(p.charAt(i))) {
						c2.innerHTML = '<img class="imgSize"  src="${pageContext.request.contextPath}/social/img/accommodation/X.png">'
								+ z + '不可含特殊字元';
					}
				}
			}

		}
	</script>


	<section class="featured-places" id="blog"
		style="background-color: #FFFFFF">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-heading">
						<span></span>
						<h2>旅宿資料新增</h2>
					</div>
				</div>
			</div>

			<div style="width: 600px; margin: 0 auto; text-align: center">
				<form name="form1 "
					action="${pageContext.request.contextPath}/accommodation/edit/controller/EditServlet"
					method="post">
					<fieldset >
						<legend>新增人資料</legend>

						<div>
							<label>姓名:<input type="text" name="Uname" id="name" disabled
								  value="${sessionScope.LoginOK.memberName}" onblur="checkName()"
								onkeydown="keyDown('check1')"></label> <br><span id="check1"></span>
						</div>
						<div>
							<label>電話:<input type="tel" name="Utel"  disabled
								 value="${sessionScope.LoginOK.memberCellPhone}" pattern="[0-9]{10}" ></label><br>
							<span id="check2"></span>
						</div>

						<div>
							<label>電郵:
							<input type="email" name="Uemail" disabled
								 required value="${sessionScope.LoginOK.memberEmail}"></label><br>
						</div>

					
					</fieldset>


					<fieldset>
						<legend>新增旅宿資料</legend>

						<div>
							<label>名稱: <input type="text" name="Hname" id="Hname"
								placeholder="請輸入旅宿名稱" required value=""
								onblur="checkHname('Hname','check11','旅宿名稱')"
								onkeydown="keyDown('check11')" maxlength="20">
							</label><br> <span id="check11"></span>
						</div>
						<div>
							<label>電話: <input type="tel" name="Htel" placeholder="09"
								required pattern="[0-9]{10}" maxlength="10">
							</label>
						</div>
						<div>
							<label>電郵: <input type="email" name="Hemail"
								placeholder="請輸入旅宿電郵" required value=""></label>
						</div>

						<div>
							<label>官網: <input type="url" name="Hweb"
								placeholder="https://" required value="">
							</label>
						</div>
						<div>
							<label>縣市: <select name="Hregion" id="rs"
								onchange="test();putAddr('rs');" required>
									<option value="0">請選擇</option>
									<option value="1">臺北市</option>
									<option value="2">新北市</option>
							</select>
							</label> <label>鄉(鎮市區): <select name="Htown" id="ts" required
								onchange="putAddr('ts');">
									<option value="0">請選擇</option>
							</select>
							</label><br>
						</div>
						<div>

							<label>地址: <input type="text" name="Haddr" id="Haddr"
								placeholder="請輸入旅宿地址" required onkeydown="keyDown('check12')" />
							</label> <span id="check12"></span>
						</div>
						<div>
							<label>最低價: <input type="number" name="Hprice" required
								value="3000"></label><br>
						</div>
						<input type="reset"  class="button"> 
						<input
							type="hidden" name="status" value="insert"> 
							<input
							type="submit" class="button">
					</fieldset>
				</form>
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