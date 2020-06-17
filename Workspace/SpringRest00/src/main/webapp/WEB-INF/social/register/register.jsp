<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>加入會員</title>
<style type="text/css">
<!--
*, *:before, *:after {
    box-sizing: border-box;
    margin: 0;
    padding: 0;
}

body {
    font-family: 'Open Sans', Helvetica, Arial, sans-serif;
    background: #ededed;
}

input, button{
    border: none;
    outline: none;
    background: none;
    font-family: 'Open Sans', Helvetica, Arial, sans-serif;
}

.tip {
    font-size: 20px;
    margin: 40px auto 50px;
    text-align: center;
}

.content {
    overflow: hidden;
    position: absolute;
    left: 50%;
    top: 50%;
    width: 900px;
    height: 550px;
    margin: -300px 0 0 -450px;
    background: #fff;
}

.form {
    position: relative;
    width: 640px;
    height: 100%;
    transition: -webkit-transform 0.6s ease-in-out;
    transition: transform 0.6s ease-in-out;
    transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
    padding: 50px 30px 0;
}

.sub-cont {
    overflow: hidden;
    position: absolute;
    left: 640px;
    top: 0;
    width: 900px;
    height: 100%;
    padding-left: 260px;
    background: #fff;
    transition: -webkit-transform 0.6s ease-in-out;
    transition: transform 0.6s ease-in-out;
    transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
}

.content.s--signup .sub-cont {
    -webkit-transform: translate3d(-640px, 0, 0);
    transform: translate3d(-640px, 0, 0);
}

button {
    display: block;
    margin: 0 auto;
    width: 260px;
    height: 36px;
    border-radius: 30px;
    color: #fff;
    font-size: 15px;
    cursor: pointer;
}

.img {
    overflow: hidden;
    z-index: 2;
    position: absolute;
    left: 0;
    top: 0;
    width: 260px;
    height: 100%;
    padding-top: 360px;
}

.img:before {
    content: '';
    position: absolute;
    right: 0;
    top: 0;
    width: 900px;
    height: 100%;
    background-image: url(../images/bg.jpg);
    background-size: cover;
    transition: -webkit-transform 0.6s ease-in-out;
    transition: transform 0.6s ease-in-out;
    transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
}

.img:after {
    content: '';
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    background: rgba(0, 0, 0, 0.6);
}

.content.s--signup .img:before {
    -webkit-transform: translate3d(640px, 0, 0);
    transform: translate3d(640px, 0, 0);
}

.img__text {
    z-index: 2;
    position: absolute;
    left: 0;
    top: 50px;
    width: 100%;
    padding: 0 20px;
    text-align: center;
    color: #fff;
    transition: -webkit-transform 0.6s ease-in-out;
    transition: transform 0.6s ease-in-out;
    transition: transform 0.6s ease-in-out, -webkit-transform 0.6s ease-in-out;
}

.img__text h2 {
    margin-bottom: 10px;
    font-weight: normal;
}

.img__text p {
    font-size: 14px;
    line-height: 1.5;
}

.content.s--signup .img__text.m--up {
    -webkit-transform: translateX(520px);
    transform: translateX(520px);
}
.img__text.m--in {
    -webkit-transform: translateX(-520px);
    transform: translateX(-520px);
}

.content.s--signup .img__text.m--in {
    -webkit-transform: translateX(0);
    transform: translateX(0);
}

.img__btn {
    overflow: hidden;
    z-index: 2;
    position: relative;
    width: 100px;
    height: 36px;
    margin: 0 auto;
    background: transparent;
    color: #fff;
    text-transform: uppercase;
    font-size: 15px;
    cursor: pointer;
}
.img__btn:after {
    content: '';
    z-index: 2;
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    border: 2px solid #fff;
    border-radius: 30px;
}

.img__btn span {
    position: absolute;
    left: 0;
    top: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 100%;
    transition: -webkit-transform 0.6s;
    transition: transform 0.6s;
    transition: transform 0.6s, -webkit-transform 0.6s;
}

.img__btn span.m--in {
    -webkit-transform: translateY(-72px);
    transform: translateY(-72px);
}

.content.s--signup .img__btn span.m--in {
    -webkit-transform: translateY(0);
    transform: translateY(0);
}

.content.s--signup .img__btn span.m--up {
    -webkit-transform: translateY(72px);
    transform: translateY(72px);
}

h2 {
    width: 100%;
    font-size: 26px;
    text-align: center;
}

label {
    display: block;
    width: 260px;
    margin: 25px auto 0;
    text-align: center;
}

label span {
    font-size: 12px;
    color: #909399;
    text-transform: uppercase;
}

input {
    display: block;
    width: 100%;
    margin-top: 5px;
    padding-bottom: 5px;
    font-size: 16px;
    border-bottom: 1px solid rgba(0, 0, 0, 0.4);
    text-align: center;
}

.forgot-pass {
    margin-top: 15px;
    text-align: center;
    font-size: 12px;
    color: #cfcfcf;
}

.forgot-pass a {
    color: #cfcfcf;
}

.submit {
    margin-top: 40px;
    margin-bottom: 20px;
    background: #d4af7a;
    text-transform: uppercase;
}

.fb-btn {
    border: 2px solid #d3dae9;
    color: #8fa1c7;
}
.fb-btn span {
    font-weight: bold;
    color: #455a81;
}

.sign-in {
    transition-timing-function: ease-out;
}
.content.s--signup .sign-in {
    transition-timing-function: ease-in-out;
    transition-duration: 0.6s;
    -webkit-transform: translate3d(640px, 0, 0);
    transform: translate3d(640px, 0, 0);
}

.sign-up {
    -webkit-transform: translate3d(-900px, 0, 0);
    transform: translate3d(-900px, 0, 0);
}
.content.s--signup .sign-up {
    -webkit-transform: translate3d(0, 0, 0);
    transform: translate3d(0, 0, 0);
}
-->
</style>
<script type="text/javascript">
//由<body>的onLoad事件處理函數觸發此函數
function setFocusToUserId(){   
	 document.forms[0].mid.focus();   // 將游標放在mid欄位內
}

function register(){
	var obj = document.getElementById("register.do");
	obj.action = "<c:url value='register.do' />";
	obj.submit();
}


</script>
</head>
<body>


<form ENCTYPE="multipart/form-data" method="POST" action="" name="fo" id="register.do" >
    <div class="content">
    
            
<!-- 註冊block -->
			<c:set var="funcName" value="REG" scope="session"/>
            <div class="form sign-in" style= overflow:auto> 
                <h2>立即註冊</h2>
             <label>
                <span>帳號</span>
                <input type="text" name="mid" value="${param.mid}">
                        
            	<font size="-1" color="#FF0000">
            		${MsgMap.errorIDEmpty}${MsgMap.errorIDDup}
            	</font>
            
            </label>

      
            <label>
            	<span>密碼</span>
             	<input type="password" name="password" value="${param.password}">
      		 
      			<font color="red" size="-1">
      				${MsgMap.errorPasswordEmpty}
      			</font> 
            </label>
            
      		<label>
      			<span>密碼確認</span>
      			<input type="password" name="password2" value="${param.password2}">
      			<font color="red" size="-1">
      				${MsgMap.errorPassword2Empty}
      			</font>            
      		</label>
      		
      		<label>
      			<span>姓名</span>
      			<input type="text" name="name" value="${param.name}">
      	    	<font color="red" size="-1">${MsgMap.errorName}
      	    	</font>          
      		</label>  

      		<label>
      			<span>地址</span>
      			<input type="text" name="address" value="${param.address}">
      			<font color="red" size="-1">${MsgMap.errorAddr}</font>     
      		</label>  

      		<label>
      			<span>電話</span>
      			<input type="text"  name="tel" value="${param.tel}">
      			<font color="red" size="-1">${MsgMap.errorTel}</font>     
      		</label>  

      		<label>
      			<span>電子郵件</span>
          		<input type="text"  name="eMail" value="${param.eMail}">
          		<font color="red" size="-1">${MsgMap.errorEmail}</font>        
      		</label>  

      		<label>
      			<span>照片</span>
				<Input Type="file" size="40" name="file1"><BR>
      		</label>  


		<div id="btnArea" onclick="register()" align="left" style="float:left;margin-bottom:10px">
         	<input type="submit" class="submit" name="submit" id="submit" value="註冊" style="
         		display: block;
    			margin: 0 auto;
    			width: 260px;
    			height: 36px;
    			border-radius: 30px;
    			color: #fff;
    			font-size: 15px;
    			cursor: pointer;">
        </div>
        
        <div align="right" style="margin-bottom:10px ;">
        	<input type="reset" class ="submit" name="cancel" id="cancel" value="重填" style="
        		display: block;
   				margin: 0 auto;
    			width: 260px;
    			height: 36px;
    			border-radius: 30px;
    			color: #fff;
    			font-size: 15px;
    			cursor: pointer;">
      	</div>


            <!--    <button type="button" class="fb-btn">使用 <span>facebook</span> 帳號註冊</button>
				<button type="button" class="fb-btn">使用 <span>google</span> 帳號註冊</button> -->
            </div>
        </div>
    </div>

</form>
    <script defer = "defer">
    document.querySelector('.img__btn').addEventListener('click', function() {
        document.querySelector('.content').classList.toggle('s--signup')
    })
    </script>
	
	<div style="text-align:center;">
</div>
</body>
</body>
</html>