<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="width=device-width, initial-scale=1.0"><!-- changed -->
    <title>鳩咪><</title><!-- changed -->

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>
<jsp:include page="top.jsp" />
 
    <section class="banner" id="top">
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="banner-caption">
                        <div class="line-dec"></div>
                        <h2>景點/行程/美食/住宿</h2>
                        <span>結伴同遊，匯聚旅行的渴望</span>
                        <div class="blue-button">
                            <a class="scrollTo" data-scrollTo="popular" href="#">探索更多</a>
                        </div>
                    </div>
                    <div class="submit-form">
                        <form id="form-submit" action="" method="get">
                            <div class="row">
                                <div class="col-md-3 first-item">
                                    <fieldset>
                                        <input name="name" type="text" class="form-control" id="name" placeholder="Your name..." required="">
                                    </fieldset>
                                </div>
                                <div class="col-md-3 second-item">
                                    <fieldset>
                                        <input name="location" type="text" class="form-control" id="location" placeholder="Type location..." required="">
                                    </fieldset>
                                </div>
                                <div class="col-md-3 third-item">
                                    <fieldset>
                                        <select required name='category' onchange='this.form.()'>
                                            <option value="">Select category...</option>
                                            <option value="Shops">Shops</option>
                                            <option value="Hotels">Hotels</option>
                                            <option value="Restaurants">Restaurants</option>
                                            <option value="Events">Events</option>
                                            <option value="Meetings">Meetings</option>
                                            <option value="Fitness">Fitness</option>
                                            <option value="Cafes">Cafes</option>
                                        </select>
                                    </fieldset>
                                </div>
                                <div class="col-md-3">
                                    <fieldset>
                                        <button type="submit" id="form-submit" class="btn">Search Now</button>
                                    </fieldset>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>





    <section class="featured-places" id="blog">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-heading">
                        <span id="subtitle">呼朋引伴</span>
                        <h2>尋找一樣喜歡旅行的你</h2>
                    </div>
                </div>
            </div>
            <div class="rowFx" >
                <div class="col-md-4 fixed" style="width:36%">
                    <div class="featured-item">
                        <div class="thumb">
                            <img src="${pageContext.request.contextPath}/social/img/group2.jpg" alt="" style="height:280px">
                            <div class="down-content">
                                <h4>五彩繽紛的旅程，都有我的身影</h4>
                                <span>會員專屬</span>
                                <p>推薦、自選，小團、大團，純吃飯或多日台北遊，隨您喜好。安排、出發！</p>
                            </div>
                            <div class="blue-button2">
                                <a href="Event.html">我要揪團！</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 fixed " style="width:36%">
                    <div class="featured-item">
                        <div class="thumb">
                            <img src="${pageContext.request.contextPath}/social/img/pair.jpg" alt="" style="height:280px">
                            <div class="down-content">
                                <h4>旅途身旁，一直未曾注意的夥伴</h4>
                                <span>會員專屬</span>
                                <p>依據您的旅行偏愛、喜好，於午夜時分尋找旅途未曾發現的夥伴</p>
                            </div>
                            <div class="blue-button2">
                                <a href="${pageContext.request.contextPath}/social/match">旅伴配對~</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>

	<section class="popular-places" id="popular" style="padding:50px">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="section-heading">
						<span>Top 10 餐廳</span>
						<h2>Integer sapien odio</h2>
					</div>
				</div>
			</div>
			<div class="owl-carousel owl-theme">
				<div class="item popular-item">
					<div class="thumb">
						<a href="../restaurant/rSearchResult.jsp"><img src="img/popular_item_1.jpg" alt="" ></a>
						<div class="text-content">
							<h4>Mauris tempus</h4>
							<span>76 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
				<div class="item popular-item">
					<div class="thumb">
					<a href="../restaurant/rSearchResult.jsp"><img src="img/popular_item_2.jpg" alt="" ></a>
						<div class="text-content">
							<h4>Aenean dolor</h4>
							<span>18 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
				<div class="item popular-item">
					<div class="thumb">
						<a href="../restaurant/rSearchResult.jsp"><img src="img/popular_item_3.jpg" alt="" ></a>
						<div class="text-content">
							<h4>Nunc at quam</h4>
							<span>55 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
				<div class="item popular-item">
					<div class="thumb">
						<a href="../restaurant/rSearchResult.jsp"><img src="img/popular_item_4.jpg" alt="" ></a>
						<div class="text-content">
							<h4>Fusce ac turpis</h4>
							<span>66 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
				<div class="item popular-item">
					<div class="thumb">
						<a href="../restaurant/rSearchResult.jsp"><img src="img/popular_item_5.jpg" alt="" ></a>
						<div class="text-content">
							<h4>Lorem ipsum</h4>
							<span>82 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
				<div class="item popular-item" >
					<div class="thumb">
					<a href="../restaurant/rSearchResult"><img src="img/popular_item_6.jpg" alt="" ></a>
						<div class="text-content">
							<h4>Lorem ipsum</h4>
							<span>82 listings</span>
						</div>
						<div class="plus-button">
							<a href="#"><i class="fa fa-plus"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

    <section id="accommodation" style="background-color: #F4F4F4;">
        <div class="container">
         <div class="row">
                <div class="col-md-12" >
                    <div class="section-heading">
                        <span>Accommodation</span>
                        <h2>住宿查詢</h2>
                    </div>
                </div> 
            </div> 
            <div class="row">
                <div class="col-md-12 col-md-offset-1">
                    <div class="submit-form">
                        <form id="form-submit" name="form1" action="${pageContext.request.contextPath}/accommodation/search/controller/SearchPageServlet" method="post">
                            <div class="row">
                                <div class="col-md-4 first-item">
                                    <fieldset>
                                        <label>縣市: 
											<select name="region" id="rs" onchange="test();">
													<option value="0">請選擇</option>
													<option value="臺北市">臺北市</option>
													<option value="新北市">新北市</option>
											</select>
										</label>
                                    </fieldset>
                                </div>
                                <div class="col-md-4 second-item">
                                    <fieldset>
                                      <label>鄉(鎮市區): 
										<select name="town" id="ts" >
												<option value="0">請選擇</option>
										</select>
									</label>
                                    </fieldset>
                                </div>
                                
                                <div class="col-md-4">
                                    <fieldset>
                                    	 <button type="submit" id="form-submit" class="btn">Search Now</button>
<!--                                         <input type="submit"  class="btn"> -->
                                    </fieldset>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section class="our-services" id="accommodationEdit"
		style="background-color: #F4F4F4;">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="section-heading">
					<a href="https://icons8.com/icon/104153/add">Add icon by Icons8</a>
						<span>Accommodation - Edit</span>
						<h2>住宿資料編輯</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<a
					href="${pageContext.request.contextPath}/accommodation/edit/Insert2.jsp">
					<div class="col-md-4">
						<div class="service-item">
							<div class="icon">
								<img src="https://img.icons8.com/carbon-copy/100/000000/add.png"/>
							</div>
							<h4>新增</h4>
							
						</div>
					</div>
				</a> <a
					href="${pageContext.request.contextPath}/accommodation/edit/Update2.jsp">
					<div class="col-md-4">
						<div class="service-item">
							<div class="icon">
								<img src="https://img.icons8.com/carbon-copy/100/000000/edit--v1.png"/>
							</div>
							<h4>修改</h4>
							
						</div>
					</div>
				</a> <a
					href="${pageContext.request.contextPath}/accommodation/edit/Delete2.jsp">
					<div class="col-md-4">
						<div class="service-item">
							<div class="icon">
								<img src="https://img.icons8.com/carbon-copy/100/000000/delete-forever--v1.png"/>
							</div>
							<h4>刪除</h4>
							
						</div>
					</div>
				</a>
			</div>
			<div class="row" style="margin: 50px"></div>
		</div>
	</section>



    <section class="pricing-tables" id="transportation">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-heading">
                        <span>Transportation</span>
                        <h2>雙北大眾交通方式</h2>
                    </div>
                </div> 
            </div> 
            <div class="row">
                <div class="col-md-4" >
                    <div class="table-item">
                        <div class="top-content">
                            <h1>雙北YouBike</h1>
                        </div>
	                        <p>推廣民眾騎乘自行車作為短程接駁交通工具，藉由市區自行車道路網搭配自行車租賃站服務，鼓勵民眾使用低污染、低耗能的公共自行車作為短程接駁運具，減少及移轉私人機動車輛之持有及使用，以達改善都市道路交通擁擠、環境污染及能源損耗目的。 </p>
	                        <p>秉持著提升都市生活文化，響應全球節能減碳風潮，台北市及新北市政府與台灣捷安特攜手啟動了公共自行車租賃系統服務計畫，簡稱為「YouBike微笑單車」。</p>
	                        <p>YouBike微笑單車使用電子無人自動化管理系統，提供自行車甲租乙還的租賃服務，盼以自行車做為大眾運輸系統最後一哩的接駁工具，藉此鼓勵更多民眾樂意使用大眾運輸系統，同時達到環保與節能的目的，打造全新的台北通勤文化。</p>
                        <div class="blue-button">
                            <a href="../june/Transportation/Youbike.jsp">前往查詢</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="table-item">
                        <div class="top-content">
                            <h1>台北捷運</h1>
                        </div>
                        <div class="content" >
							<p>台北捷運全名『臺北都會區大眾捷運系統』，是臺灣第一個都會區捷運系統，不僅是臺灣交通的里程碑，更提供台北民眾舒適又便捷的交通。</p>
							<p>台北捷運營運範圍目前只僅於台北市和新北市，預計桃園機場捷運完工後將與桃園捷運相互連結。</p>
							<p>通車路線以台北車站為中心區分為文山內湖線、淡水線、中和線、小南門線、新店線、南港線、板橋線、土城線、蘆洲線、新莊線及信義線等11條，其中屬中運量的木柵線率先於1996年以全台首條無人駕駛的模式通車，
									之後陸續完工迄今的營運路線長達121.3公里，是大台北地區相當重要的大眾運輸工具。</p>
                        </div>
                        <div class="blue-button">
                            <a href="../june/Transportation/TaipeiMRT.jsp">前往查詢</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</section>

<!--         <section class="pricing-tables" id="comment"> -->
<!--         <div class="container"> -->
<!--             <div class="row"> -->
<!--                 <div class="col-md-12"> -->
<!--                     <div class="section-heading"> -->
<!--                         <span>Comment</span> -->
<!--                         <h2>評論及留言</h2> -->
<!--                     </div> -->
<!--                 </div>  -->
<!--             </div>  -->
<!--             <div class="row"> -->
<!--                 <div class="col-md-4" > -->
<!--                     <div class="table-item"> -->
<!--                         <div class="top-content"> -->
<!--                             <h1>景點</h1> -->
<!--                         </div> -->
<!--                         <div class="blue-button"  style="margin-top:30px"> -->
<!--                             <a href="../june/Comment/AttractionComment.jsp">前往評論</a> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-md-4"> -->
<!--                     <div class="table-item"> -->
<!--                         <div class="top-content"> -->
<!--                             <h1>餐廳</h1> -->
<!--                         </div> -->
<!--                         <div class="blue-button"  style="margin-top:30px"> -->
<!--                             <a href="../june/Comment/RestaurantComment.jsp">前往評論</a> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <div class="col-md-4"> -->
<!--                     <div class="table-item"> -->
<!--                         <div class="top-content"> -->
<!--                             <h1>住宿</h1> -->
<!--                         </div> -->
<!--                         <div class="blue-button"  style="margin-top:30px"> -->
<!--                             <a href="/june/Comment/AccommodationComment.jsp">前往評論</a> -->
<!--                         </div> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
<!--     </section> -->

      <section class="pricing-tables" id="Attractions">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="section-heading">
                        <span>Attractions</span>
                        <h2>景點選擇</h2>
                        <div class="blue-button">
                            <a href="../Attraction/test.jsp">前往查詢</a>
                        </div>
                    </div>
                </div> 
            </div> 
    	</div> 
    </section>




    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <div class="about-veno">
                        <div class="logo">
                            <img src="${pageContext.request.contextPath}/social/img/footer_logo.png" alt="Venue Logo">
                        </div>
                        <p>Mauris sit amet quam congue, pulvinar urna et, congue diam. Suspendisse eu lorem massa.
                            Integer sit amet posuere tellus, id efficitur leo. In hac habitasse platea dictumst.</p>
                        <ul class="social-icons">
                            <li>
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-rss"></i></a>
                                <a href="#"><i class="fa fa-dribbble"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="useful-links">
                        <div class="footer-heading">
                            <h4>Useful Links</h4>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <ul>
                                    <li><a href="#"><i class="fa fa-stop"></i>Help FAQs</a></li>
                                    <li><a href="#"><i class="fa fa-stop"></i>Register</a></li>
                                    <li><a href="#"><i class="fa fa-stop"></i>Login</a></li>
                                    <li><a href="#"><i class="fa fa-stop"></i>My Profile</a></li>
                                    <li><a href="#"><i class="fa fa-stop"></i>How It Works?</a></li>
                                    <li><a href="#"><i class="fa fa-stop"></i>More About Us</a></li>
                                </ul>
                            </div>
                            <div class="col-md-6">
                                <ul>
                                    <li><a href="#"><i class="fa fa-stop"></i>Our Clients</a></li>
                                    <li><a href="#"><i class="fa fa-stop"></i>Partnerships</a></li>
                                    <li><a href="#"><i class="fa fa-stop"></i>Blog Entries</a></li>
                                    <li><a href="#"><i class="fa fa-stop"></i>Contact Us</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="contact-info">
                        <div class="footer-heading">
                            <h4>Contact Information</h4>
                        </div>
                        <p>Praesent iaculis gravida elementum. Proin fermentum neque facilisis semper pharetra. Sed
                            vestibulum vehicula tincidunt.</p>
                        <ul>
                            <li><span>Phone:</span><a href="#">010-050-0550</a></li>
                            <li><span>Email:</span><a href="#">hi@company.co</a></li>
                            <li><span>Address:</span><a href="#">company.co</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <div class="sub-footer">
        <p>Copyright &copy; 2018 Company Name

            - Design: <a rel="nofollow" href="http://www.templatemo.com">Template Mo</a></p>
    </div>

</body>

</html>