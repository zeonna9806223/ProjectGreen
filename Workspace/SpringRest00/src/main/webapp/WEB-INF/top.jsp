<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="width=device-width, initial-scale=1.0"><!-- changed -->
    <title>鳩咪><</title><!-- changed -->

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	<script src="//code.jquery.com/jquery-1.9.1.js"></script>
 	<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/social/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/social/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/social/css/fontAwesome.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/social/css/hero-slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/social/css/owl-carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/social/css/datepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/social/css/templatemo-style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/social/css/body.css">

    <link href="https://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/social/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
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



<script >
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

function p(){
	var a =event.srcElement.firstChild.textContent;
	window.location.href="${pageContext.request.contextPath}/accommodation/search/controller/ShowPageServlet?h="+a;
}

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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js" type="text/javascript"></script>
    <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/social/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

    <script src="${pageContext.request.contextPath}/social/js/vendor/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/social/js/datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/social/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/social/js/main.js"></script>
</body>

</html>