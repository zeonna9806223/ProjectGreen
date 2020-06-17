<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
<jsp:include page="../top.jsp"/>
	<div class="container">
		<h1>尋找景點</h1>
		<form action='selectAttraction' method='Get'>
			<fieldset style="font-size: Large">
				<label for="speed">城市</label> <select name="region" id="region">
					<option selected="selected">請選擇</option>
					<option>臺北市</option>
					<option>新北市</option>
				
				</select> <label for="files">區域</label> <select name="town" id="town">
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
				<input type="button" value="查所有景點" onclick="location.href='queryallAttraction'"> 
				<input type="button" value="新增景點" onclick="location.href='insertintoAttraction'">
			</fieldset>

		</form>
	</div>

	<div class="container">
		<table class="table table-striped" id="table">
			<thead>
				<tr>
					<th>景點ID</th>
					<th>景點名稱</th>
					<th>景點地址</th>
					<th>景點電話</th>
					<th>景點區域</th>
					
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty queryresult}">
						<tr height='36'>
							<td colspan='7' align='center'><font color='red'>歡迎查尋景點</font></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach varStatus='vs' var='attr' items='${queryresult}'>
							<tr>
								<td align='left'>${attr.id}&nbsp;</td>
								<td align='left'>${attr.name}&nbsp;</td>
								<td align='left'>&nbsp;${attr.location}</td>
								<td align='left'>${attr.tel}</td>
								<td align='left'>&nbsp;${attr.town}</td>
								<%-- 								<td align='center'>${rest.restaurantPx}</td> --%>
								<%-- 								<td align='right'>${rest.restaurantPy}&nbsp;</td> --%>
								
								
								<!-- 										再偷傳一份給新增刪除 -->							
								<td><FORM action='deleteAttr' method="Get" name="delete">
										<Input type='hidden' name='id' value='${attr.id}'> 
										<Input type='hidden' name='name' value='${attr.name}'> 
										<Input type='hidden' name='location' value='${attr.location}'> 
										<Input type='hidden' name='tel' value='${attr.tel}'> 
										<Input type='hidden' name='region' value='${attr.region}'>
										<Input type='hidden' name='town' value='${attr.town}'>

										<input type="submit" value="刪除" name="delete" onclick="window.alert('確定刪除?');">
									</FORM>
									  <FORM action='updateAttraction' method="Get" name="update">
										<Input type='hidden' name='id' value='${attr.id}'> 
										<Input type='hidden' name='name' value='${attr.name}'> 
										<Input type='hidden' name='location' value='${attr.location}'> 
										<Input type='hidden' name='tel' value='${attr.tel}'> 
										<Input type='hidden' name='region' value='${attr.region}'>
										 
										<input type="submit" value="修改" name="update">
									</FORM>
								</td>
								
							
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