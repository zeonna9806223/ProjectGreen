<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css//bootstrap.min.css">
</head>

<style>
#table {
	width: 700px
}
</style>

<body>
	<jsp:include page="../top.jsp" />
	<div class=container id="table">
		<form:form Method="POST" modelAttribute="RestaurantBean"
			enctype="application/x-www-form-urlencoded">

			<fieldset>
				<legend>餐聽資訊</legend>
				<table class="table table-striped" id="table">
					<tr>
						<td>餐聽名稱</td>
						<td><form:input path="restaurantName" /><br>&nbsp;</td>
						<td><form:errors path="restaurantName" /></td>
					</tr>
					<tr>
						<td>餐聽類型</td>
						<td><form:input path="restaurantType" /><br>&nbsp;</td>
						<td><form:errors path="restaurantType" /></td>
					</tr>
					<tr>
						<td>餐廳地區</td>
						<td><form:input path="restaurantZone" /><br>&nbsp;</td>
						<td><form:errors path="restaurantZone" /></td>
					</tr>
					<tr>

						<td>餐廳地址</td>
						<td><form:input path="restaurantAddress" /><br>&nbsp;</td>
						<td><form:errors path="restaurantZone" /></td>
					</tr>
					<tr>

						<td>餐廳經度</td>
						<td><form:input path="restaurantPx" /><br>&nbsp;</td>
						<td><form:errors path="restaurantPx" /></td>
					</tr>
					<tr>
						<td>餐廳緯度</td>
						<td><form:input path="restaurantPy" /><br>&nbsp;</td>
						<td><form:errors path="restaurantPy" /></td>
					</tr>
					<tr>
						<td>餐廳電話</td>
						<td><form:input path="restaurantPhone" /><br>&nbsp;</td>
						<td><form:errors path="restaurantPhone" /></td>
					</tr>
					<tr>
						<td colspan='3' align='center'><input type='submit'
							value='提交'></td>
					</tr>
				</table>
			</fieldset>
		</form:form>
	</div>
	<div class=container id="table">
		<form:form Method="POST" modelAttribute="RestaurantBean"
			enctype="application/x-www-form-urlencoded">

				<legend>餐聽資訊</legend>
			  	<div class="form-group row">
						<form:label path="" class="col-sm-2 col-form-label">餐聽名稱</form:label>
						<div class="col-sm-10">
						<form:input path="restaurantName" class="form-control-plaintext"/>
						<form:errors path="restaurantName"  />
						</div>
				</div>
				<div class="form-group">
						<form:label path="">餐聽類型</form:label>
						<form:input path="restaurantType" />
						<form:errors path="restaurantType" />
				</div>
				<div class="form-group">		
						<td>餐廳地區</td>
						<form:input path="restaurantZone" />
						<form:errors path="restaurantZone" />
</div>
				<div class="form-group">
						<form:label path="">餐廳地址</form:label>
						<form:input path="restaurantAddress" />
						<form:errors path="restaurantZone" />
</div>
				<div class="form-group">
						<form:label path="">餐廳經度</form:label>
						<form:input path="restaurantPx" />
						<form:errors path="restaurantPx" />
						</div>
				<div class="form-group">
						<form:label path="">餐廳緯度</form:label>
						<form:input path="restaurantPy" />
						<form:errors path="restaurantPy" />
						</div>
				<div class="form-group">
						<form:label path="">餐廳電話</form:label>
						
						<form:input path="restaurantPhone" />
						<form:errors path="restaurantPhone" />
						</div>
						<button type="submit" class="btn btn-default">送出</button>
		</form:form>
	</div>
</body>
</html>