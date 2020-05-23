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
</style>

<body>
	<jsp:include page="../top.jsp" />
	
	

	<div class="container" style="max-width: 50rem;">
		<form:form Method="POST" modelAttribute="RestaurantBean"
			enctype="application/x-www-form-urlencoded">

			  	<div class="form-group">
			  	<fieldset>
						<form:label path="" class="control-label">餐聽名稱</form:label>
						<form:input path="restaurantName" class="form-control" />
						<form:errors path="restaurantName" style="color:red"/>
						
						
				 </fieldset>
				</div>
	
				<div class="form-group">
			  	<fieldset>
						<form:label path="" class="control-label">餐聽類型</form:label>
						<form:input path="restaurantType" class="form-control" />
						<form:errors path="restaurantType"  style="color:red" />
				</fieldset>
				</div>
				
				<div class="form-group">
			  	<fieldset>		
						<form:label path="" class="control-label">餐聽區域</form:label>
						<form:input path="restaurantZone" class="form-control"/>
						<form:errors path="restaurantZone" style="color:red"/>
				</fieldset>
				</div>
				
				<div class="form-group">
			  	<fieldset>	
						<form:label path="" class="control-label">餐廳地址</form:label>
						<form:input path="restaurantAddress" class="form-control"/>
						<form:errors path="restaurantAddress"  style="color:red"/>
				</fieldset>
				</div>
				<div class="form-group">
			  	<fieldset>	
				
						<form:label path="" class="control-label">餐廳經度</form:label>
						<form:input path="restaurantPx" class="form-control"/>
						<form:errors path="restaurantPx"  style="color:red"/>
				</fieldset>
				</div>
				<div class="form-group">
			  	<fieldset>
						<form:label path="" class="control-label">餐廳緯度</form:label>
						<form:input path="restaurantPy" class="form-control"/>
						<form:errors path="restaurantPy" style="color:red"/>
				</fieldset>
				</div>
				
				<div class="form-group">
			  	<fieldset>
						<form:label path="" class="control-label">餐廳電話</form:label>
						<form:input path="restaurantPhone" class="form-control"/>
						<form:errors path="restaurantPhone"  style="color:red"/>
				</fieldset>
				</div>
						<button type="submit" class="btn btn-default">送出</button>
		</form:form>
	</div>
</body>
</html>