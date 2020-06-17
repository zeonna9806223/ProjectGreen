<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
	<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>加入會員</title>


<!--import Bootstrap CSS-->
		<link rel="stylesheet" href="css/register/bootstrap.css">
	
	<style>
		#d1{
		background-image:url(img/register/friend.jpg);
		background-size: 100%;
		}

	</style>



	</head>


	<body id="d1">

		<!--navigation-->
		<section class="bh-white py-3">
		<div class="container-fluid">
			<div class="row">
				<div class="col-12 text-center">
					<a href="../social/Index.jsp" class="heading-brand text-primary">回首頁</a>
				</div>
			</div>
		</div>
		</section>



<!--hero header-->
		<section class="py-5"  >
		<div class="container">
			<div class="row">
				<div class="col-md-7 my-md-auto" >
					<h1 class="text-center text-md-left">在這裡找到最麻吉的朋友吧!!</h1>
					
					<div class="row feature-grid">
						<div class="col-sm-6">
							<div class="media">
								<div class="icon-box">
									<div class="icon-box-inner">
										<span data-feather="unlock" width="28" height="28"></span>
									</div>
								</div>
								<div class="media-body">
									Access to premium freelancers
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="media">
								<div class="icon-box">
									<div class="icon-box-inner">
										<span data-feather="briefcase" width="28" height="28"></span>
									</div>
								</div>
								<div class="media-body">
									Work with specialized developers
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="media">
								<div class="icon-box">
									<div class="icon-box-inner">
										<span data-feather="gift" width="28" height="28"></span>
									</div>
								</div>
								<div class="media-body">
									Exclusive rewards and perks
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="media">
								<div class="icon-box">
									<div class="icon-box-inner">
										<span data-feather="users" width="28" height="28"></span>
									</div>
								</div>
								<div class="media-body">
									Manage remote software team
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="col-md-5 pl-md-5">
					<div class="card">
						<div class="card-body py-md-4">
               				<h2>立即加入我們</h2>
							
							
							
							<!-- form -->
							<form ENCTYPE="multipart/form-data" method="POST" action="<c:url value='register.do' />"  id="register.do" >
							<c:set var="funcName" value="REG" scope="session"/>
							
							<div style= overflow:auto> 
							
								<div class="form-group">
									<input type="text"  class="form-control" name="mid" value="${param.mid}" placeholder="請輸入帳號">
							
									<font size="-1" color="#FF0000">
            							${MsgMap.errorIDEmpty}${MsgMap.errorIDDup}
            						</font>
								</div>
								

																
								<div class="form-group">
									<input type="password" class="form-control" name="password" value="${param.password}" placeholder="請輸入密碼">
								
									<font color="red" size="-1">
      									${MsgMap.errorPasswordEmpty}
      								</font> 
								</div>
								

      							
      							<div class="form-group">
									<input type="password" class="form-control" name="password2" value="${param.password2}" placeholder="請確認密碼">
								
									<font color="red" size="-1">
      									${MsgMap.errorPassword2Empty}
      								</font>
								</div>
								

      							
      							<div class="form-group">
									<input type="text" class="form-control" name="name" value="${param.name}" placeholder="請輸入姓名">
									
									<font color="red" size="-1">
										${MsgMap.errorName}
      	    						</font>
								
								</div>    
								
								
								<div class="form-group">
									<input type="text" class="form-control" name="gender" value="${param.gender}" placeholder="請輸入性別">
								</div>  

      	    					
      							<div class="form-group">
									<input type="text" class="form-control" name="address" value="${param.address}" placeholder="請輸入地址">
									
									<font color="red" size="-1">
										${MsgMap.errorAddr}
									</font>
								</div>
								

								
								<div class="form-group">
									<input type="text" class="form-control" name="tel" value="${param.tel}" placeholder="請輸入電話">
									
									<font color="red" size="-1">
										${MsgMap.errorTel}
									</font>
								</div>
								

								    
								<div class="form-group">
									<input type="email" class="form-control" name="eMail" value="${param.eMail}" placeholder="請輸入電子郵件">
									
									<font color="red" size="-1">
										${MsgMap.errorEmail}
									</font>
								</div>

								<span>上傳一張照片讓大家認識你吧!</span>
								<Input Type="file" size="40" name="file1" style="padding:10px;"><BR>
							</div>
							
							<div id="btnArea" align="left" style="float:left;">
         						<input type="submit" class="btn btn-primary" name="submit" id="submit" value="註冊" >
        					</div>
        					
        					        
        					<div align="right">
        						<input type="reset" class="btn btn-primary" name="cancel" id="cancel" value="重填" >
      						</div>
        					
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		</section>
		
		<!--footer-->
		<footer>
		<div class="container">
			<div class="row">
				<div class="col-12 text-center">
					<ul class="list-inline">
						<li class="list-inline-item"><a href="#">About</a></li>
						<li class="list-inline-item"><a href="#">Privacy</a></li>
						<li class="list-inline-item"><a href="#">Terms</a></li>
					</ul>
				</div>
			</div>

		</div>
		</footer>
		
		
		

<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="js/register/jquery-3.2.1.min.js"></script>
<script src="js/register/feather.min.js"></script>
<script src="js/register/scripts.js"></script>

</body>
</html>