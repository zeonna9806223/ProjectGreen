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
</head>


<body>
<jsp:include page="../top.jsp"/>
	<form:form Method="POST" modelAttribute="RestaurantBean1">
				<form:hidden path="restaurantID" /> 
<!-- 				為了讓hibernate拿到ID所以埋一個hidden -->
				<fieldset class="fieldset-auto-width">
				<legend>餐聽資訊</legend>
				<table>
				<tr>
					<td>餐聽名稱</td> 
					<td><form:input path="restaurantName" value="${name}" /><br>&nbsp;</td>
					<td><form:errors path="restaurantName" /></td>
				</tr>
				<tr>
					<td>餐聽類型</td> 
					<td><form:input path="restaurantType" value="${type}" /><br>&nbsp;</td>
					<td><form:errors path="restaurantType" /></td>
				</tr>
				<tr>
					<td>餐廳地區</td> 	
					<td><form:input path="restaurantZone" value="${zone}" /><br>&nbsp;</td>
					<td><form:errors path="restaurantZone" /></td>
				</tr>
				<tr>
				
					<td>餐廳地址</td> 
					<td><form:input path="restaurantAddress" value="${address}" /><br>&nbsp;</td>
					<td><form:errors path="restaurantAddress" /></td>
				</tr>
				<tr>
			
					<td>餐廳經度</td> 
					<td><form:input path="restaurantPx" value="${px}" /><br>&nbsp;</td>
					<td><form:errors path="restaurantPx" /></td>
				</tr>
				<tr>
					<td>餐廳緯度</td> 
					<td><form:input path="restaurantPy" value="${py}" /><br>&nbsp;</td>
					<td><form:errors path="restaurantPy" /></td>
				</tr>
				<tr>
					<td>餐廳電話</td> 
					<td><form:input path="restaurantPhone" value="${phone}" /><br>&nbsp;</td>
					<td><form:errors path="restaurantPhone" /></td>
				</tr>
				<tr>
						<td colspan='3' align='center'>
						<input type='submit' value='提交'></td>
				</tr>
			</table>	
			</fieldset>
		</form:form>
</body>
</html>