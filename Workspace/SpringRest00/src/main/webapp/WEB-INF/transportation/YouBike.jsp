<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>雙北YouBike站點查詢</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!--  -->
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<style>
		body {
		    font-family: 微軟正黑體;
		}
	</style>
</head>
<body>
	<jsp:include page="../top.jsp"/>
	<div class="container">
		<h2>雙北YouBike站點查詢</h2>
		請輸入查詢條件：<br>
		<form id="searchYB"  action="${pageContext.request.contextPath}/transportation/YouBike/searchYB" method="POST">
			<select id="ybCity"  name="ybCity" onchange="searchYBDist();">
				<option value="0">請選擇</option>
				<option value="台北市">台北市</option>
				<option value="新北市">新北市</option>
			</select>
			<br>
			<select id="ybDistrict" name="ybDistrict" onchange="test();">
				<option value="0">請選擇</option>
			</select>
			<br>
			<button type="submit" id="ybSubmit" type="button" class="btn btn-primary">查詢</button>
		</form>
		<br>
		<c:choose>
			<c:when test="${errorMessage !=null}">${errorMessage}</c:when>
			<c:otherwise>搜尋條件：${city}／${district}</c:otherwise>
		</c:choose>
		<hr>
	</div>
	<div class="container">
		<c:choose>
			<c:when test="${errorMessage !=null}"></c:when>
			<c:otherwise>
				<div class="accordion">
					<c:forEach var="s" items="${stations}">
						<div class="card">
						<div class="card-header" data-toggle="collapse" href="#${s.stationId}">
						<h4>${s.stationId}：${s.stationName}</h4>
						</div>
						<div id="${s.stationId}" class="collapse" data-parent="#accordion">
						<div class="card-body">
							<p>城市：${s.city}</p>
					        <p>區域：${s.district}</p>
					        <p>位址：${s.area}</p>
					        <p>經緯度：${s.latitude}，${s.longitude}</p>
					        <p>是否營運：
					            <c:choose>
					            	<c:when test="${s.activity==true}">營運中</c:when>
					            	<c:otherwise>暫停營運</c:otherwise>
					            </c:choose>
				            	</p>
				            	<div>
					            	<table border="1px">
					            		<thead>
					            			<tr>
							            		<td>總車位</td>
							            		<td>可供租借數量</td>
							            		<td>空位數</td>
						            		</tr>
						            	</thead>
						            	<tbody style="text-align:right">
							            	<tr>
							            		<td>${s.total}</td>
							            		<td>${s.available}</td>
							            		<td>${s.vacancy}</td>
							            	</tr>
						            	</tbody>
					            	</table>
				            	</div>
				            	<p>資料時間：${s.updateTime}</p>
				            </div>
				            </div>
				            </div>
						</c:forEach>
					</div>
			</c:otherwise>
		</c:choose>
		</div>
	
	<script type="text/javascript">
// 	各別查詢雙北有YouBike的區域
	function searchYBDist(){
		$.ajax({
			url:"${pageContext.request.contextPath}/transportation/YouBike/searchYBDis",
			type:"GET",
			data:{
				ybCityChoosen:$("#ybCity").val(),
			},
			dataType:"json",
			success: function(data) {
				$("#ybDistrict option").remove();
				for (i=0;i<data.length;i++){
// 					console.log(data[i]);
					$("#ybDistrict").append($("<option></option>").attr("value", data[i]).text(data[i]));
				}
			},
			error:function(){
				console.log("回到ajax，data==null");
				$("#ybDistrict option").remove();
				$("#ybDistrict").append($("<option></option>").attr("value", "0").text("請選擇"));
			}
		})
	}

	function test(){
		var city = $("#ybCity").val();
		var district = $("#ybDistrict").val();
		console.log("city："+city+"／district："+district);
	}

	</script>
</body>
</html>