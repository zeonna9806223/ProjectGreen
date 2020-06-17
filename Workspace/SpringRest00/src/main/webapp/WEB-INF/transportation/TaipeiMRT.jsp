<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>台北捷運</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<!--  -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<style>
	body {
	    font-family: 微軟正黑體;
	}
</style>
<body>
	<jsp:include page="../top.jsp"/>
	<div class="container">
		<h2>台北捷運車站出口查詢</h2>
		請輸入查詢條件：<br>
		<form id="searchMRT"  action="${pageContext.request.contextPath}/transportation/TaipeiMRT/searchMRTStationExit" method="POST">
			<select id="mrtLine"  name="mrtLine" onchange="searchMRTLine();">
				<option value="0" >請選擇路線</option>
				<option value="BL" >板南線</option>
				<option value="BR">文湖線</option>
				<option value="R">淡水信義線</option>
				<option value="G">松山新店線</option>
				<option value="O">中和新蘆線</option>
				<option value="Y">環狀線</option>
			</select>
			<br>
			<select id="mrtStation" name="mrtStation" onchange="test();">
				<option value="0">請選擇</option>
			</select>
			<br>
			<button type="submit" id="mrtSubmit" type="button" class="btn btn-primary">查詢</button>
		</form>
		<br>
		<c:choose>
			<c:when test="${errorMessage !=null}">
				${errorMessage}
			</c:when>
			<c:otherwise>
				搜尋條件：${lineName}／${station}
			</c:otherwise>
		</c:choose>
		<hr>
	</div>
	<div class="container">
		<c:choose>
			<c:when test="${errorMessage !=null}"></c:when>
			<c:otherwise>
				<div id="accordion">
					<c:forEach var="e" items="${exits}">
						<div class="card">
						<div class="card-header" data-toggle="collapse" href="#${e.no}">
							<c:choose>
								<c:when test="${e.exitNo != 0}">
									<h4>${e.stationName}：${e.exitNo}號出口</h4>
								</c:when>
								<c:otherwise>
									<h4>${e.stationName}：出口</h4>
								</c:otherwise>
							</c:choose>
						</div>
						<div id="${e.no}" class="collapse" data-parent="#accordion">
						<div class="card-body">
					        <p>經緯度：</p>
				        	<table border="1px">
				        		<thead>
				        			<tr>
							            <td>經度</td>
							            <td>緯度</td>
						            </tr>
						        </thead>
						        <tbody style="text-align:right">
							        <tr>
							        	<td>${e.longitude}</td>
							        	<td>${e.latitude}</td>
							        </tr>
						        </tbody>
						    </table>
				        </div>
				        </div>
				        </div>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	
	<script type="text/javascript">
	// 用路線查詢站點
	function searchMRTLine(){
		$.ajax({
			url:"${pageContext.request.contextPath}/transportation/TaipeiMRT/searchMRTStation",
			type:"GET",
			data:{
				mrtLineChoosen:$("#mrtLine").val(),
			},
			dataType:"json",
			success: function(data) {
				$("#mrtStation option").remove();
				for (i=0;i<data.length;i++){
					console.log(data[i]);
					$("#mrtStation").append($("<option></option>").attr("value", data[i]).text(data[i]));
				}
			},
			error:function(){
				console.log("回到ajax，data==null");
				$("#mrtStation option").remove();
				$("#mrtStation").append($("<option></option>").attr("value", "0").text("請選擇"));
			}
		})
	}

	function test(){
		var district = $("#mrtStation").val();
		console.log("district："+district);
	}
	</script>
</body>
</html>