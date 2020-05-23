<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible"
	content="width=device-width, initial-scale=1.0">
<!-- changed -->
<title>揪me</title>
<!-- changed -->

<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://code.jquery.com/jquery-1.9.1.js"></script>
<script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/social/css/body.css">

<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">

<script
	src="${pageContext.request.contextPath}/social/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
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
                                        <li><a class="scrollTo" data-scrollTo="subtitle" href="<c:url value="/social/match"/>">旅伴配對~</a></li>
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
										<a href="<c:url value="/Login"/>">
				     						登入 
										</a>
              						</c:if>
                            	</li>
                            	
                            	<li>
                            		<!-- 註冊 -->
                            		<c:if test="${empty LoginOK}">
			   							<a href="<c:url value="SignUp"/>"> 註冊 </a>
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
									<a href=${pageContext.request.contextPath}/Logout>登出</a>
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
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<div class="banner-caption">
						<div class="line-dec"></div>
						<h2>景點/行程/美食/住宿</h2>
						<span>結伴同遊，匯聚旅行的渴望</span>
						<div class="blue-button">
							<a class="scrollTo" data-scrollTo="popular" href="#">探索更多</a>
						</div>
					</div>
					<div class="submit-form">
						<form id="form-submit" action="" method="get">
							<div class="row">
								<div class="col-md-3 first-item">
									<fieldset>
										<input name="name" type="text" class="form-control" id="name"
											placeholder="Your name..." required="">
									</fieldset>
								</div>
								<div class="col-md-3 second-item">
									<fieldset>
										<input name="location" type="text" class="form-control"
											id="location" placeholder="Type location..." required="">
									</fieldset>
								</div>
								<div class="col-md-3 third-item">
									<fieldset>
										<select required name='category' onchange='this.form.()'>
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
		</div>
	</section>





    <section class="featured-places" id="blog">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-heading">
                        <span id="subtitle">呼朋引伴</span>
                        <h2>尋找一樣喜歡旅行的你</h2>
                    </div>
                </div>
            </div>
            <div class="rowFx" >
                <div class="col-md-4 fixed" style="width:36%">
                    <div class="featured-item">
                        <div class="thumb">
                            <img src="${pageContext.request.contextPath}/social/img/group2.jpg" alt="" style="height:280px">
                            <div class="down-content">
                                <h4>五彩繽紛的旅程，都有我的身影</h4>
                                <span>會員專屬</span>
                                <p>推薦、自選，小團、大團，純吃飯或多日台北遊，隨您喜好。安排、出發！</p>
                            </div>
                            <div class="blue-button2">
                                <a href="Event.html">我要揪團！</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 fixed " style="width:36%">
                    <div class="featured-item">
                        <div class="thumb">
                            <img src="${pageContext.request.contextPath}/social/img/pair.jpg" alt="" style="height:280px">
                            <div class="down-content">
                                <h4>旅途身旁，一直未曾注意的夥伴</h4>
                                <span>會員專屬</span>
                                <p>依據您的旅行偏愛、喜好，於午夜時分尋找旅途未曾發現的夥伴</p>
                            </div>
                            <div class="blue-button2">
                                <a href="${pageContext.request.contextPath}/social/match">旅伴配對~</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>

	<section class="popular-places" id="popular" style="padding: 50px">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="section-heading">
						<span>Top 10 餐廳</span>
						<h2>Integer sapien odio</h2>
					</div>
				</div>
			</div>
			<div class="owl-carousel owl-theme">
				<div class="item popular-item">
					<div class="thumb">
						<a
							href="${pageContext.request.contextPath}/restaurant/restaurantHome"><img
							src="<c:url value="social/img/popular_item_1.jpg"/>" alt=""></a>
						<div class="text-content">
							<h4>Mauris tempus</h4>
							<span>76 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
				<div class="item popular-item">
					<div class="thumb">
						<a
							href="${pageContext.request.contextPath}/restaurant/restaurantHome"><img
							src="<c:url value="social/img/popular_item_2.jpg"/>" alt=""></a>
						<div class="text-content">
							<h4>Aenean dolor</h4>
							<span>18 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
				<div class="item popular-item">
					<div class="thumb">
						<a
							href="${pageContext.request.contextPath}/restaurant/restaurantHome"><img
							src="<c:url value="social/img/popular_item_3.jpg"/>" alt=""></a>
						<div class="text-content">
							<h4>Nunc at quam</h4>
							<span>55 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
				<div class="item popular-item">
					<div class="thumb">
						<a
							href="${pageContext.request.contextPath}/restaurant/restaurantHome"><img
							src="<c:url value="social/img/popular_item_4.jpg"/>" alt=""></a>
						<div class="text-content">
							<h4>Fusce ac turpis</h4>
							<span>66 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
				<div class="item popular-item">
					<div class="thumb">
						<a
							href="${pageContext.request.contextPath}/restaurant/restaurantHome"><img
							src="<c:url value="social/img/popular_item_5.jpg"/>" alt=""></a>
						<div class="text-content">
							<h4>Lorem ipsum</h4>
							<span>82 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
				<div class="item popular-item">
					<div class="thumb">
						<a
							href="${pageContext.request.contextPath}/restaurant/restaurantHome"><img
							src="<c:url value="social/img/popular_item_6.jpg"/>" alt=""></a>
						<div class="text-content">
							<h4>Lorem ipsum</h4>
							<span>82 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section id="accommodation" style="background-color: #F4F4F4;">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-heading">
						<span>Accommodation</span>
						<h2>住宿查詢</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 col-md-offset-1">
					<div class="submit-form">
						<form id="form-submit" name="form1"
							action='<c:url value="/search"/>' method="post">
							<div class="row">
								<div class="col-md-4 first-item">
									<fieldset>
										<label>縣市: <select name="region" id="rs"
											onchange="test();">
												<option value="0">請選擇</option>
												<option value="臺北市">臺北市</option>
												<option value="新北市">新北市</option>
										</select>
										</label>
									</fieldset>
								</div>
								<div class="col-md-4 second-item">
									<fieldset>
										<label>鄉(鎮市區): <select name="town" id="ts">
												<option value="0">請選擇</option>
										</select>
										</label>
									</fieldset>
								</div>

								<div class="col-md-4">
									<fieldset>
										<button type="submit" id="form-submit" class="btn">Search
											Now</button>
										<!--                                         <input type="submit"  class="btn"> -->
									</fieldset>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="our-services" id="accommodationEdit"
		style="background-color: #F4F4F4;">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-heading">
						<a href="https://icons8.com/icon/104153/add">Add icon by
							Icons8</a> <span>Accommodation - Edit</span>
						<h2>住宿資料編輯</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<%-- 				<a href="${pageContext.request.contextPath}/edit/insert"> --%>
				<a href="${pageContext.request.contextPath}/edit/insert">
					<div class="col-md-4">
						<div class="service-item">
							<div class="icon">
								<img src="https://img.icons8.com/carbon-copy/100/000000/add.png" />
							</div>
							<h4>新增</h4>

						</div>
					</div>
				</a> <a href="${pageContext.request.contextPath}/edit/update">
					<div class="col-md-4">
						<div class="service-item">
							<div class="icon">
								<img
									src="https://img.icons8.com/carbon-copy/100/000000/edit--v1.png" />
							</div>
							<h4>修改</h4>

						</div>
					</div>
				</a> <a href="${pageContext.request.contextPath}/edit/delete">
					<div class="col-md-4">
						<div class="service-item">
							<div class="icon">
								<img
									src="https://img.icons8.com/carbon-copy/100/000000/delete-forever--v1.png" />
							</div>
							<h4>刪除</h4>

						</div>
					</div>
				</a>
			</div>
			<div class="row" style="margin: 50px"></div>
		</div>
	</section>



 <section class="our-services" id="transportation">
		<div class="container">
			<div class="row">
				<a href="${pageContext.request.contextPath}/transportation/YouBike/YouBike.do">
					<div class="col-md-4">
						<div class="service-item">
							<div class="icon">
								<img src="https://img.icons8.com/material-sharp/96/000000/bike-path--v2.png"/>
							</div>
							<h4>雙北YouBike</h4>
							<p>騎乘微笑單車，盡情暢遊雙北</p>
						</div>
					</div>
				</a>
				<a href="${pageContext.request.contextPath}/transportation/TaipeiMRT/TaipeiMRT.do">
					<div class="col-md-4">
						<div class="service-item">
							<div class="icon">
								<img src="https://img.icons8.com/small/96/000000/subway.png"/>
							</div>
							<h4>台北捷運</h4>
							<p>四通八達的路線，條條大路通雙北</p>
						</div>
					</div>
				</a>
<%-- 				<a href="${pageContext.request.contextPath}/comment/AccomComment/AccomComment.do"> --%>
<!-- 					<div class="col-md-4"> -->
<!-- 						<div class="service-item"> -->
<!-- 							<div class="icon"> -->
<!-- 							<img src="https://img.icons8.com/material-outlined/96/000000/speech-bubble-with-dots.png"/> -->
<!-- 							</div> -->
<!-- 							<h4>進去試試Comment新增功能</h4> -->

<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</a> -->
			</div>
			<div class="row" style="margin: 50px"></div>
		</div>
	</section>

	<section class="pricing-tables" id="Attractions">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-heading">
						<span>Attractions</span>
						<h2>景點選擇</h2>
						<div class="blue-button">
							<a href="${pageContext.request.contextPath}/Attraction/Attractionme">前往查詢</a>
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
//取得所有cookie 並整理
function getCookie(cname) {
	  var name = cname + "=";
	  var decodedCookie = decodeURIComponent(document.cookie);
	  var ca = decodedCookie.split(';');
	  for(var i = 0; i <ca.length; i++) {
	    var c = ca[i];
	    while (c.charAt(0) == ' ') {
	      c = c.substring(1);
	    }
	    if (c.indexOf(name) == 0) {
	      return c.substring(name.length, c.length);
	    }
	  }
	  return "";
}

// 網頁開始時執行
$( document ).ready(function(){
	// 取得sesion 有登入時顯示 
	if (getCookie("MID"))
	{
		$("#account").html("asdasdasd")
		console.log(getCookie("pic"))
	}
});

// 點擊登出 刪除所有 cookie
$("#logout").click(function(){
	clearAllCookie()
	console.log("logout")
	alert("你已登出本系統，頁面將刷新")
	window.location.reload()
	console.log("...")

})

// 登出 刪除所有cookie
function clearAllCookie() {
	console.log("???")
	var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
	if(keys) {
		for(var i = keys.length; i--;)
			document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
	}
}

// function p(){
// 	var a =event.srcElement.firstChild.textContent;
// 	window.location.href="${pageContext.request.contextPath}/accommodation/search/controller/ShowPageServlet?h="+a;
// }

function test(){
 $.ajax({
        url: "${pageContext.request.contextPath}/searchRegion", // It's  my servlet
        type : "GET",
        data : { 
         region : $("#rs").val(),
        },
        dataType: "json",
        success: function(data){
          $("#ts option").remove();
          for(i=0;i<data.length;i++){
           $('#ts').append($("<option></option>").attr("value", data[i].townId).text(data[i].town));
          }
        }
    });
}
</script>
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
