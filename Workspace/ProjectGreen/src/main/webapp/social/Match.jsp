<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible"
	content="width=device-width, initial-scale=1.0">
<!-- changed -->
<title>Match</title>
<!-- changed -->

<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">


<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/fontAwesome.css">
<link rel="stylesheet" href="css/hero-slider.css">
<link rel="stylesheet" href="css/owl-carousel.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/templatemo-style.css">

<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">

<script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!--
	Venue Template
	http://www.templatemo.com/tm-522-venue
-->

<script type="text/javascript">
	function cancel() {
		if (confirm("真的要重來嗎？") ) {
			return true
		} else {
			return false
		}
	}
	function reconfirm() {
		if (confirm("確定好了？")) {
			// 		document.forms[0].finalDecision.value = "ORDER";
			return true;
		} else {
			return false;
		}
	}
</script>
</head>

<body>

	<div class="wrap">
        <header id="header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <button id="primary-nav-button" type="button">Menu</button>
                        <a href="${pageContext.request.contextPath}/social/Index.html">
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/social/img/logo.png" alt="Venue Logo">
                            </div>
                        </a>
                        <nav id="primary-nav" class="dropdown cf">
                            <ul class="dropdown menu">
                                <!-- changed -->
                                <li><a>呼朋引伴</a>
                                    <ul class="sub-menu">
                                        <li><a class="scrollTo" data-scrollTo="subtitle" href="Match.jsp">旅伴配對~</a></li>
                                        <li><a class="scrollTo" data-scrollTo="subtitle" href="Event.html">我要揪團！</a></li>
                                    </ul>
                                </li>
                                <!-- changed -->
                              
<!--                                 <li><a class="scrollTo" data-scrollTo="services" href="#">Our Services</a></li> -->
<!--                                 <li><a class="scrollTo" data-scrollTo="transportation" href="#">交通方式</a></li> -->
                                <li><a class="scrollTo" data-scrollTo="popular" href="#">找餐廳</a></li>
<!--                                 <li><a class="scrollTo" data-scrollTo="Attractions" href="#">景點選擇</a></li> -->
<!--                                 <li><a class="scrollTo" data-scrollTo="popular" href="#">找餐廳</a></li> -->
                                   <li><a href="#">住宿選擇</a>
									<ul class="sub-menu">
										<li><a class="scrollTo" data-scrollTo="accommodation"
											href="#">住宿查詢</a></li>
										<li><a class="scrollTo" data-scrollTo="accommodationEdit">住宿資料編輯</a></li>
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

	<section class="banner" id="top">
		<div class="container">
			<div class="col-md-10 col-md-offset-1">

				<div class="submit-form" style="border: 2px solid #4883ff">
					<form id="form-submit" action="" method="get">
						<div class="row">
							<div class="col-md-3 first-item">
								<fieldset>
									<input name="name" type="text" class="form-control" id="name"
										placeholder="Your name..." >
								</fieldset>
							</div>
							<div class="col-md-3 second-item">
								<fieldset>
									<input name="location" type="text" class="form-control"
										id="location" placeholder="Type location..." >
								</fieldset>
							</div>
							<div class="col-md-3 third-item">
								<fieldset>
									<select  name='category' onchange='this.form()'>
										<option value="">Select category...</option>
										<option value="Shops">Shops</option>
										<option value="Hotels">Hotels</option>
										<option value="Restaurants">Restaurants</option>
										<option value="Events">Events</option>
										<option value="Meetings">Meetings</option>
										<option value="Fitness">Fitness</option>
										<option value="Cafes">Cafes</option>
									</select>
								</fieldset>
							</div>
							<div class="col-md-3">
								<fieldset>
									<button type="submit" id="form-submit" class="btn">Search
										Now</button>
								</fieldset>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
<%-- ***** form → onsubmit="return (false)" --%>
		<section class="our-services" id="services">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="section-heading">
							<h2>Hi!${LoginOK.memberName}</h2>
							<span>尋找一樣喜歡旅行的你</span>
							<h2>旅伴配對</h2>
						</div>
					</div>
				</div>

				<div class="col-md-12">
					<div class="down-services-match">
						<div class="row">
							<div class="col-md-5 col-md-offset-1">
								<div class="left-content" style="display: inline-block;">
									<h4 style="text-align: center;">現在，出發尋找夥伴的旅程！</h4>
									<div style="text-align: center; color: red">${error.over}${error.noFill}</div>
									<p style="text-align: justify;">什麼樣的夥伴最吸引你？選擇右方條件，最完整地為我們描繪他/她的輪廓，在午夜時分，未知的配對 結果將會悄悄降臨。<br>
										<br>配對夥伴出現後，選擇進一步認識對方，將會進入探索階段，暫時可以使用好友的留言傳情功能。但請小心，探索期間內若沒有配對成功，那麼夥伴將再度隱沒在各自的旅行人海。
									</p>
<!-- 										<select style="width:100%; float: left" -->
<!-- 											 name='trans' id="trans" onchange='this.form()'> -->
<!-- 												<option value="" disabled selected hidden>配對條件</option> -->
<!-- 												<option value="1">跟我相像的</option> -->
<!-- 												<option value="0">想來點不一樣的</option> -->
<!-- 										</select> -->
<c:choose>
 	<c:when test="${already==1}">
	<form id="form1" action="" method="post" onsubmit="return false">
									<div style="justify-content: center" >
										<input style="width:100%;text-align:center" name="nosubmit" type="submit" class="blue-button3"
											id="submit" value="今日已送出配對需求">
									</div> 	
	</form>
 	</c:when>
 	<c:when test="${already==0}">
	<form id="form0" action="mr.do" method="post" onsubmit="return reconfirm()" onreset="return cancel()">
									
									<div style="width: 40%; float: left;">
										<input name="submit" type="submit" class="blue-button3"
											id="submit" value="都選好了，送出！">
									</div>
									<div style="width: 40%; float: right;">
										<!-- 									<a href="#">等等...重來一下</a> -->
										<input name="reset" type="reset" class="blue-button3"
											id="reset" value="等等...重來一下">
									</div>
 	</c:when>
</c:choose>
	

								</div>
							</div>

							<div class="col-md-5">
								<div class="accordions">
									<ul class="accordion" style="text-align: center;">
										<li><a>配對說明</a>
											<p style="text-align: justify;">
												請為我們提供配對的條件，越清楚越好，如果沒有完全符合條件的夥伴，將配對其他可能也適合您的夥伴。</p>
										</li>
										<li><a>旅行類型偏好</a> <!-- <p>旅行類型偏好</p> -->
											<p>請選擇，您最喜歡的旅遊類型</p> 
											<select style="width: 100%" name="tLike"
											onchange='this.form()'>
												<option value="" disabled selected hidden>請選擇</option>
												<c:forEach var='tType' items='${tTypes}' varStatus="vs">
													<option id="tType${vs.index}" value="${tType}">${tType}</option>
												</c:forEach>
												<option value="-1">沒關係，都可以</option>
										</select></li>
										<li><a>美食類型偏好</a>
											<p>請選擇，您最喜歡的美食種類</p> <select style="width: 100%" 
											name='fLike' id="rType" onchange='this.form()'>
												<option value="" disabled selected hidden>請選擇</option>
												<c:forEach var='resType' items='${resTypes}' varStatus="vs">
													<option id="resType${vs.index}" value="${resType}">${resType}</option>
												</c:forEach>
												<option value="-1">沒關係，都可以</option>
										</select></li>
										<li><a>旅伴性別偏好</a>
											<p style:"height:10px">請選擇，您想要配對的旅伴性別</p> 
											<select style="width: 100%;" 
											name='gLike' id="tType" onchange='this.form()'>
												<option value="" disabled selected hidden>請選擇</option>
												<option value="1" id="male">男</option>
												<option value="0" id="female">女</option>
												<option value="-1">沒關係，都可以</option>
										</select></li>
										<li><a>旅伴年齡偏好</a>
											<p>請選擇，您希望的旅伴年紀(年齡下限為18歲，年齡上限為100歲)</p>
<!-- 											<p style="width:50%;float:left;padding:0px">年齡下限</p><p style="width:50%;float:left;padding:0px">年齡上限</p> -->
											<select	style="width: 50%;"  name='aBLike' id="aBType"
											onchange='this.form()'>
												<option value="" disabled selected hidden>年齡下限</option>
												<c:forEach var='b' begin="18" end="100">
													<option id="b${b}" value="${b}">${b}</option>
												</c:forEach>
												<option value="-1">沒關係，都可以</option>
										</select> 
										<select style="width: 50%; float: right" name='aTLike' id="aTType" 
										onchange='this.form()'>
												<option value="" disabled selected hidden>年齡上限</option>
												<c:forEach var='t' begin="18" end="100">
													<option id="t${t}" value="${t}">${t}</option>
												</c:forEach>
												<option value="-1">沒關係，都可以</option>
										</select></li>
										<li><a>旅伴外型偏好</a>
											<p>外在與內在同樣重要</p>
<!-- 											<p style="width:50%;float:left;padding:0px">身高</p><p style="width:50%;float:left;padding:0px">身材</p>  -->
											<select style="width: 50%; float: left"
											 name='hLike' id="tType" onchange='this.form()'>
												<option value="" disabled selected hidden>身高</option>
												<option value="3">高挑</option>
												<option value="2">中等</option>
												<option value="1">小隻</option>
												<option value="-1">沒關係，都可以</option>
										</select> <select style="width: 50%; float: left"  name='wLike'
											id="tType" onchange='this.form()'>
												<option value="" disabled selected hidden>身材</option>
												<option value="3">肉肉</option>
												<option value="2">中等</option>
												<option value="1">偏瘦</option>
												<option value="-1">沒關係，都可以</option>
										</select></li>
									</ul>
									<!-- / accordion -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</form>
	<section class="pricing-tables">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-heading">
						<span>好友列表</span>
						<h2>留言傳情</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="table-item" style="height:400px;width:290px;overflow:auto">
						<div class="top-content" style="padding:10px">
							<h4 >今日配對</h4>
						</div>
						
						<ul style="margin:8px">
							<c:forEach var="c" items="${showTodayMatch}">
								<li style="margin:8px">
<%-- 										<a href=""><p  style="width:50%;float:left;text-align:center;font-size:16px;font-weight: 500;'">夥伴：${c.memberName}</p></a> --%>
										<p  class="ajax" id="match${c.memberId2}" data-id="${c.memberId2}" style="width:33%;float:left;text-align:center;font-size:10px;font-weight: 500;'">夥伴：${c.memberName}</p>
										<p  style="width:40%;float:left;text-align:right;font-size:10px;font-weight: 500;"><fmt:formatDate value="${c.pairDate}" pattern="yyyy年MM月dd日"/></p>
										<form action="mr8.do" method="post" onsubmit="return reconfirm()">
											<input class="tpdaypair" name="new" type='hidden' value="${c.memberId2}">
											<p  style="width:20%;float:left;text-align:right;font-size:8px;font-weight: 100;"><input type="submit" style="width:70px;border:none;color:midnightblue" value="+好友"></p> 
										</form>
								</li>													
							</c:forEach>
						</ul>
						<div class="top-content" style="padding:10px;clear:both">
							<h4>好友列表</h4>
						</div>
						<ul style="margin:1px">
							<c:forEach var="b" items="${showFriends}">
										<p  class="ajax" id="friend${b.memberId2}" data-id="${b.memberId2}" style="width:33%;float:left;text-align:center;font-size:12px;font-weight: 500;">夥伴：${b.memberName}</p>
										
										<p  style="width:40%;float:left;text-align:right;font-size:10px;font-weight: 500;"><fmt:formatDate value="${b.friendDate}" pattern="yyyy年MM月dd日"/></p>
										<form action="mr8.do" method="post" onsubmit="return reconfirm()">
<%-- 										<p  class="ajax" data-id="d${b.memberId2}" style="width:33%;float:left;text-align:right;font-size:8px;font-weight: 100;">刪除好友</p> --%>
											<input class="friend" name="delete" type='hidden' value="${b.memberId2}">
											<p  style="width:20%;float:left;text-align:right;font-size:8px;font-weight: 100;"><input type="submit" style="width:70px;border:none;color:midnightblue" value="刪除好友"></p> 
										</form>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-md-4">
					<div class="table-item" id="background" style="height:400px;width:290px;overflow:auto">
						<div class="top-content" style="padding:20px">
							<h4>小檔案</h4>
<!-- 							<h1>$45</h1> -->
<!-- 							<span>/monthly</span> -->
						</div>
						<ul style="margin:10px;">
							<li  id="friendInfo1">名字</li>
							<li  id="friendInfo2">性別</li>
							<li  id="friendInfo3">年齡</li>
							<li  id="friendInfo4">自我介紹</li>
							<li  id="friendInfo5">身高</li>
							<li  id="friendInfo6">身高</li>
						</ul>
<!-- 						<div class="blue-button"> -->
<!-- 							<a href="#">Buy It Now</a> -->
<!-- 						</div> -->
					</div>
				</div>
				<div class="col-md-4">
					<div class="table-item" >
						<div class="top-content">
<!-- 							<h1>留言板</h1> -->
							<h4>留言板</h4>
							<span>留言板</span>
						</div>
						<ul style="margin:15px">
<!-- 							<li><a href="#">400 Suspendisse dapibus</a></li> -->
<!-- 							<li><a href="#">40x Paleo celiac enamel</a></li> -->
<!-- 							<li><a href="#">Williamsburg organic post ironic</a></li> -->
<!-- 							<li><a href="#">Helvetica pinterest yuccie</a></li> -->
							<li  style="margin:0px"><a href="#">施工中...</a></li>
						</ul>
<!-- 						<div class="blue-button"> -->
<!-- 							<a href="#">Buy It Now</a> -->
<!-- 						</div> -->
					</div>
				</div>
			</div>
		</div>
	</section>



	<section class="contact" id="contact">
		<div id="map">
			<!-- How to change your own map point
                           1. Go to Google Maps
                           2. Click on your location point
                           3. Click "Share" and choose "Embed map" tab
                           4. Copy only URL and paste it within the src="" field below
                    -->

			<iframe
				src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1197183.8373802372!2d-1.9415093691103689!3d6.781986417238027!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xfdb96f349e85efd%3A0xb8d1e0b88af1f0f5!2sKumasi+Central+Market!5e0!3m2!1sen!2sth!4v1532967884907"
				width="100%" height="500px" frameborder="0" style="border: 0"
				allowfullscreen></iframe>
		</div>
		<div class="container">
			<div class="col-md-10 col-md-offset-1">
				<div class="wrapper">
					<div class="section-heading">
						<span>Contact Us</span>
						<h2>Vivamus nec vehicula felis</h2>
					</div>
					<!-- Modal button -->
					<button id="modBtn" class="modal-btn">Talk to us</button>
				</div>
				<div id="modal" class="modal">
					<!-- Modal Content -->
					<div class="modal-content">
						<div class="row">
							<div class="col-md-8">
								<div class="left-content">
									<div class="row">
										<div class="col-md-12">
											<div class="section-heading">
												<span>Talk To Us</span>
												<h2>Let's have a discussion</h2>
											</div>
										</div>
										<div class="col-md-6">
											<fieldset>
												<input name="name" type="text" class="form-control"
													id="name" placeholder="Your name..." >
											</fieldset>
										</div>
										<div class="col-md-6">
											<fieldset>
												<input name="subject" type="text" class="form-control"
													id="subject" placeholder="Subject..." >
											</fieldset>
										</div>
										<div class="col-md-12">
											<fieldset>
												<textarea name="message" rows="6" class="form-control"
													id="message" placeholder="Your message..." ></textarea>
											</fieldset>
										</div>
										<div class="col-md-12">
											<fieldset>
												<button type="submit" id="form-submit" class="btn">Send
													Message</button>
											</fieldset>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="right-content">
									<div class="row">
										<div class="col-md-12">
											<div class="content">
												<div class="section-heading">
													<span>More About Us</span>
													<h2>Venue Company</h2>
												</div>
												<p>Etiam viverra nibh at lorem hendrerit porta non nec
													ligula. Donec hendrerit porttitor pretium. Suspendisse
													fermentum nec risus eu bibendum.</p>
												<ul>
													<li><span>Phone:</span><a href="#">010-050-0550</a></li>
													<li><span>Email:</span><a href="#">hi@company.co</a></li>
													<li><span>Address:</span><a href="#">company.co</a></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
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
							<img src="img/footer_logo.png" alt="Venue Logo">
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

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"
		type="text/javascript"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')
	</script>

	<script src="js/vendor/bootstrap.min.js"></script>

	<script src="js/datepicker.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
</body>

</html>