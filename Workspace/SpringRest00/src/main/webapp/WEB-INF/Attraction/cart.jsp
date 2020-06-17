<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/fontAwesome.css">
<link rel="stylesheet" href="css/hero-slider.css">
<link rel="stylesheet" href="css/owl-carousel.css">
<link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/templatemo-style.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link
	href="https://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">


<script>
	$(function() {
		$("#speed").selectmenu();

		$("#files").selectmenu();

		$("#number").selectmenu().selectmenu("menuWidget").addClass("overflow");

		$("#salutation").selectmenu();
	});
</script>
<style>
fieldset {
	border: 0;
}

label {
	display: inline-block;
	margin: 30px 0 0 0;
}

.overflow {
	height: 200px;
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
            					
            				<!--  	<li>
                            		<c:if test="${empty LoginOK}">
										<a href="<c:url value='/Attractions/cart.jsp' />">
				     						<img src ="img/cart.jpg"  width="30" height="30" alt="">
										</a>
              						</c:if>
                            	</li>
            				-->
            				
                            </ul>
                        </nav><!-- / #primary-nav -->
                    </div>
                </div>
            </div>
        </header>
    </div>

	<div class="container">
		<h1>選擇列表</h1>
		
		<!--  
	<form action='selectRestaurant' method='Get'>
			<fieldset style="font-size: Large">
				<label for="speed">景點城市</label> <select name="type" id="type">
					<option selected="selected">請選擇</option>
					<c:forEach var='Attractions' items='${Attractions}'>
					<tr>
					    
					    <td style="text-align:center">${attractions.town}</td>
					    
					</tr>
					</c:forEach>
				</select> <label for="files">區域</label> <select name="zone" id="zone">
					<option selected="selected">請選擇</option>
					
						<option value="大安區">大安區</option>
						<option value="中山區">中山區</option>
						<option value="內湖區">內湖區</option>
						<option value="信義區">信義區</option>
						<option value="士林區">士林區</option>
						<option value="中正區">中正區</option>
						<option value="松山區">松山區</option>
						<option value="北投區">北投區</option>
						<option value="文山區">文山區</option>
						<option value="大同區">大同區</option>
						<option value="南港區">南港區</option>
						<option value="萬華區">萬華區</option>
						<option value="板橋區">板橋區</option>
						<option value="三重區">三重區</option>
						<option value="新莊區">新莊區</option>
						<option value="中和區">中和區</option>
						<option value="新店區">新店區</option>
						<option value="汐止區">汐止區</option>
						<option value="樹林區">樹林區</option>
						<option value="土城區">土城區</option>
						<option value="林口區">林口區</option>
						<option value="淡水區">淡水區</option>
						<option value="永和區">永和區</option>
						<option value="蘆洲區">蘆洲區</option>
						<option value="鶯歌區">鶯歌區</option>
						<option value="五股區">五股區</option>
						<option value="三峽區">三峽區</option>
						<option value="泰山區">泰山區</option>
						<option value="八里區">八里區</option>
						<option value="金山區">金山區</option>
						<option value="深坑區">深坑區</option>
						<option value="瑞芳區">瑞芳區</option>
					

				</select> <input type="submit" value="搜尋"> 
				
			</fieldset>

		</form>  
		
		-->
	</div>

	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>景點編號</th>
					<th>景點名稱</th>
					<th>景點地址</th>
					<th>景點電話</th>
					
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty queryresult}">
						<tr height='36'>
							<td colspan='7' align='center'><font color='red'>景點查詢</font></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach varStatus='vs' var='i' items='${show}'>
							<tr>
								<tr>
						<td ><b></b>&nbsp;${i.num}</td>
						<td ><p onclick="p();">${i.name}</p></td>
						<td ><b></b>&nbsp;${i.add}</td>
						<td ><b></b>&nbsp;${i.tel}</td>
					</tr>
								
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
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