<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <script src="https://code.jquery.com/jquery-1.12.4.js"></script> -->
<!-- <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->

<style>
fieldset {
	border: 0;
}

label {
	display: inline-block;
	margin: 30px 0 0 0;
}

#table {

	width: 1200px
}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/top.jsp"/>
	<div class="container">
		<h1>找餐廳</h1>
		<form action='selectRestaurant' method='Get'>
			<fieldset style="font-size: Large">
				<label for="speed">餐廳類型</label> <select name="type" id="type">
					<option selected="selected">請選擇</option>
					<option>南洋</option>
					<option>飲品</option>
					<option>麵包、點心</option>
					<option>中式合菜</option>
					<option>日韓</option>
					<option>複合式餐飲</option>
					<option>速食漢堡</option>
					<option>素食</option>
					<option>早餐店</option>
					<option>日、西式料理(含速食)</option>
					<option>地方小吃</option>
					<option>歐</option>
					<option>美墨</option>
				</select> <label for="files">區域</label> <select name="zone" id="zone">
					<option selected="selected">請選擇</option>
					<optgroup label="台北市">
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
					</optgroup>
					<optgroup label="新北市">
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
					</optgroup>

				</select> <input type="submit" value="搜尋"> 
				<input type="button" value="查所有餐廳" onclick="location.href='queryallRestaurant'"> 
				<input type="button" value="新增餐廳" onclick="location.href='insertintoRestaurant'">
			</fieldset>

		</form>
	</div>

	<div class="container">
		<table class="table table-striped" id="table">
			<thead>
				<tr>
					<th>餐廳ID</th>
					<th>餐廳名字</th>
					<th>餐廳類型</th>
					<th>餐廳區域</th>
					<th>餐廳地址</th>
					<th>電話</th>
					<th>訂位</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty queryresult}">
						<tr height='36'>
							<td colspan='7' align='center'><font color='red'>歡迎查餐廳</font></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach varStatus='vs' var='rest' items='${queryresult}'>
							<tr>
								<td align='left'>${rest.restaurantID}&nbsp;</td>
								<td align='left'>${rest.restaurantName}&nbsp;</td>
								<td align='left'>&nbsp;${rest.restaurantType}</td>
								<td align='left'>${rest.restaurantZone}</td>
								<td align='left'>&nbsp;${rest.restaurantAddress}</td>
								<%-- 								<td align='center'>${rest.restaurantPx}</td> --%>
								<%-- 								<td align='right'>${rest.restaurantPy}&nbsp;</td> --%>
								<td align='center'>${rest.restaurantPhone}</td>
								
								<!-- 										再偷傳一份給新增刪除 -->							
								<td><FORM action='deleteRes' method="Get" name="delete">
										<Input type='hidden' name='id' value='${rest.restaurantID}'> 
										<Input type='hidden' name='name' value='${rest.restaurantName}'> 
										<Input type='hidden' name='zone' value='${rest.restaurantZone}'> 
										<Input type='hidden' name='address' value='${rest.restaurantAddress}'> 
										<Input type='hidden' name='type' value='${rest.restaurantType}'>
										<Input type='hidden' name='px' value='${rest.restaurantPx}'>
										<Input type='hidden' name='py' value='${rest.restaurantPy}'>
										<Input type='hidden' name='phone' value='${rest.restaurantPhone}'> 
										<input type="submit" value="刪除" name="delete" onclick="window.alert('確定刪除?');">
									</FORM>
									<FORM action='updateRestaurant' method="Get" name="update">
										<Input type='hidden' name='id' value='${rest.restaurantID}'> 
										<Input type='hidden' name='name' value='${rest.restaurantName}'> 
										<Input type='hidden' name='zone' value='${rest.restaurantZone}'> 
										<Input type='hidden' name='address' value='${rest.restaurantAddress}'> 
										<Input type='hidden' name='type' value='${rest.restaurantType}'>
										<Input type='hidden' name='px' value='${rest.restaurantPx}'>
										<Input type='hidden' name='py' value='${rest.restaurantPy}'>
										<Input type='hidden' name='phone' value='${rest.restaurantPhone}'> 
										<input type="submit" value="修改" name="update">
									</FORM>
								</td>
								
								<td><c:if test="${ not empty rest.restaurantPhone}">

							<!-- 偷傳給訂位的資料 -->
										<FORM action='showBookingHome' method="Get">
										<Input type='hidden' name='id' value='${rest.restaurantID}'> 
										<Input type='hidden' name='name' value='${rest.restaurantName}'> 
										<Input type='hidden' name='zone' value='${rest.restaurantZone}'> 
										<Input type='hidden' name='address' value='${rest.restaurantAddress}'> 
										<Input type='hidden' name='type' value='${rest.restaurantType}'>
										<Input type='hidden' name='px' value='${rest.restaurantPx}'>
										<Input type='hidden' name='py' value='${rest.restaurantPy}'>
										<Input type='hidden' name='phone' value='${rest.restaurantPhone}'> 
										<input type="submit" value="訂位">
										</FORM>
									</c:if></td>
							</tr>
							<!-- 							資料傳給下一個JSP -->

						</c:forEach>
					</c:otherwise>
				</c:choose>

			</tbody>
		</table>
	</div>

</body>

</html>