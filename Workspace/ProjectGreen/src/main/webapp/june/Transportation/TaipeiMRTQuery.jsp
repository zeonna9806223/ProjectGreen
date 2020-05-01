<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>台北捷運站出口查詢</title>
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
    
    <h1 class="title" style="background: #FFF0AC">台北捷運站出口查詢</h1>
    <div class="container">
    	<div>
	        <p>請輸入查詢條件：</p>
	        <div class="dropdown">
		        <form name="line-form" action="${pageContext.request.contextPath}/june/Transportation/TaipeiMRTServlet.do" method="POST">
			    	<select name="line" id="select-line" onchange="document.line-form.submit()">
			        	<option class="line-opt" value="" >請選擇路線</option>
			        	<option class="line-opt" value="BL" >板南線</option>
			        	<option class="line-opt" value="BR">文湖線</option>
			        	<option class="line-opt" value="R">淡水信義線</option>
			        	<option class="line-opt" value="G">松山新店線</option>
			        	<option class="line-opt" value="O">中和新蘆線</option>
			        	<option class="line-opt" value="Y">環狀線</option>
			    	</select>
			    	<span>${line}</span>
			    </form>
		        <form name="station-form" action="${pageContext.request.contextPath}/june/Transportation/TaipeiMRTServlet.do" method="POST">
			    	<select name="station" id="select-station" >
			        	<option value="" >請選擇車站</option>
						<c:forEach var="s" items="${stations}">
							<option value="${s}">${s}</option>
						</c:forEach>
			    	</select>
		    	<span>${qStation}</span>
		    	<div>
			    	<input type="submit" value="查詢">
		    	</div>
	        </form>       
    	</div>
    </div>
        <div id="accordion" >
        	<c:forEach var="k" items="${stationExits}">
        		<h3>${k.exitName}</h3>
	            <div>
	            	<p>站名：${k.stationName}</p>
	            	<p>經緯度：${k.lati}，${k.lon}</p>
	            </div>
        	</c:forEach>
          </div>    
    </div>


    <script>
        $( function() {
        	$( "#accordion" ).css("font-family","微軟正黑體");
          $( "#accordion" ).accordion({
            collapsible: true
          });
          $( "#files" ).selectmenu();
        } );
    </script>
</body>
</html>