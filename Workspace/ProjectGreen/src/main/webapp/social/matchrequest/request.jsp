<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- <link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css' /> --%>
<meta charset="UTF-8">
<title>新增配對申請</title>
</head>
<body>
<p>&nbsp;</p>
<hr>
<H1>配對申請</H1>
<form  action='insertMrequest.do'  method='POST'  >

AgeTopLike:<input type='text'     name='ageTopLike' value='${param.ageTopLike}'><br>
<font color='red' ></font>${error.ageTopLike}<br>
AgeBottomLike:<input type='text'  name='ageBottomLike'   value='${param.ageBottomLike}'> <br> 
<font color='red' ></font>${error.ageBottomLike}<br>
LivingAreaLike:<input type='text' name='livingAreaLike' value='${param.livingAreaLike}'><br>
<font color='red' ></font><br>
HeightLike:<input type='text'      name='heightLike' value='${param.heightLike}'><br>
<font color='red' ></font><br>
WeightLike:<input type='text'      name='weightLike' value='${param.weightLike}'><br>
<font color='red' ></font><br>
GenderLike:<input type='text'     name='genderLike'   value='${param.genderLike}'> <br> 
<font color='red' ></font><br>
InterestedRestaurantType:<input type='text'  name='interestedRestaurantType' value='${param.interestedRestaurantType}'><br>
<font color='red' ></font><br>
TourTypeLike:<input type='text'   name='tourTypeLike' value='${param.tourTypeLike}'><br>
<font color='red' ></font><br>

<input type='submit'      name='submit' value='提交' >
<input type='reset'      name='reset' value='還原' ><br><br>	
</form>

<%-- <a href='${pageContext.request.contextPath}/mod27/index.jsp'>回到會員管理</a> --%>
</body>
</html>