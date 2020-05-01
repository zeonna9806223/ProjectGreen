<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>雙北YouBike查詢</title>
	<script src="../js/jquery-3.4.1.min.js"></script>
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    
    
<!--     這一段 -->
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
    <!--     這一段 -->
    
    
	<link rel="stylesheet" href="../css/Transportation.css">
	<style>
	body {
		 background-image: url("../img/bg.jpg");
		 background-size: cover;
		}
	#YouBike {
		width:200px;
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
                        <a href="${pageContext.request.contextPath}/social/index.html">
                            <div class="logo">
                                <img src="${pageContext.request.contextPath}/social/img/logo.png" alt="Venue Logo">
                            </div>
                        </a>
                        <nav id="primary-nav" class="dropdown cf">
                            <ul class="dropdown menu">
                                <!-- changed -->
                                <li><a href="../../social/Event.html">呼朋引伴</a>
                                    <ul class="sub-menu">
                                        <li><a class="scrollTo" data-scrollTo="subtitle" href="Match.jsp">旅伴配對~</a></li>
                                        <li><a href="../../social/Event.html">我要揪團！</a></li>
                                    </ul>
                                </li>
                                <!-- changed -->
                              
<!--                                 <li><a class="scrollTo" data-scrollTo="services" href="#">Our Services</a></li> -->
<!--                                 <li><a class="scrollTo" data-scrollTo="transportation" href="#">交通方式</a></li> -->
                                <li><a class="scrollTo"  href="../../restaurant/rSearchResult.jsp">找餐廳</a></li>
<!--                                 <li><a class="scrollTo" data-scrollTo="Attractions" href="#">景點選擇</a></li> -->
<!--                                 <li><a class="scrollTo" data-scrollTo="popular" href="#">找餐廳</a></li> -->
                                   <li><a href="#">住宿選擇</a>
									<ul class="sub-menu">
										<li><a class="scrollTo" data-scrollTo="accommodation"
											href="#">住宿查詢</a></li>
										<li><a class="scrollTo" data-scrollTo="accommodationEdit">住宿資料編輯</a></li>
									</ul></li>
                                <li><a class="scrollTo" href="">交通方式</a></li>
                                <li><a class="scrollTo"  href="../../Attraction/test.jsp">景點選擇</a></li>
									
<!--                                 <li><a class="scrollTo" data-scrollTo="comment" href="#">留言及評論</a></li> -->
            					<li><a href="../../social/index.jsp">回首頁</a></li>
                            </ul>
                        </nav><!-- / #primary-nav -->
                    </div>
                </div>
            </div>
        </header>
    </div>
    
    <h1 class="title" style="background: #FFF0AC">雙北YouBike查詢</h1>
    <div class="container">
    	<div>
    		<img src="../img/YouBike.png"  alt="YouBike"  id="YouBike"/>
	        <p>請輸入查詢條件：</p>
	        <div class="dropdown">
		        <form name="city-form" action="${pageContext.request.contextPath}/june/Transportation/Transportation.do" method="POST">
			    	<select name="city" id="select-city" onchange="document.city-form.submit()">
			        	<option class="city-opt" value="" >請選擇城市</option>
			        	<option class="city-opt" value="台北市" >台北市</option>
			        	<option class="city-opt" value="新北市">新北市</option>
			    	</select>
			    	<span>${city}</span>
			    </form>
		        <form name="district-form" action="${pageContext.request.contextPath}/june/Transportation/Transportation.do" method="POST">
			    	<select name="district" id="select-district" >
			        	<option value="" >請選擇區域</option>
						<c:forEach var="i" items="${districts}">
							<option value="${i}">${i}</option>
						</c:forEach>
			    	</select>
			    	<input type="submit" value="查詢">
		        </form>       
    	</div>
    </div>
</div>

    <script>
        $( function() {
          $( "#accordion" ).accordion({
            collapsible: true
          });
        } );
    </script>
</body>
</html>