<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>jQuery UI Tabs - Collapse content</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css"
        integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ=="
        crossorigin="" />
<script>
	$(function() {
		$("#tabs").tabs({
			collapsible : true
		});
	});

	$(function() {
		$("#datepicker").datepicker({
			showButtonPanel : true
		});
	});
</script>
</head>
<style>
   #mapid { 
        width: 500px;
        height: 500px;
        margin: 0;
        padding: 0;
    }
#tabs {
	width: 750px;
	height: 700px;
}

.form-control {
	width: 300px;
}
</style>

<body>
<jsp:include page="../top.jsp"/>
	
	<div class=container id="tabs">
		<ul>
			<li><a href="#tabs-1">訂位 GO</a></li>
			<li><a href="#tabs-3">看地圖</a></li>
		</ul>
		<form:form action="resBookingServlet.do" method="post">
		<div id="tabs-1">
			<p>
				<strong>餐廳名稱 : ${resBeselect.restaurantName}  </strong>
					
			</p>
			<p>
				<strong>餐廳類型 : ${resBeselect.restaurantType}</strong>
			</p>
			<p>
				<strong>餐廳區域 : ${resBeselect.restaurantZone}</strong>
			</p>
			<p>
				<strong>餐廳地址 : ${resBeselect.restaurantAddress}</strong>
			</p>
			<p>
				<strong>餐廳電話 : ${resBeselect.restaurantPhone}</strong>
			</p>
			<p>
<!-- 				<strong>開放預定數 :</strong> -->
			</p>
			<p>
<!-- 				<strong>剩餘預定數 : </strong> -->
			</p>
			<p>
<!-- 				<label for="usr">訂位人 :</label><input type="text" -->
<!-- 					class="form-control" id="usr"> -->
			</p>
			<p>
<!-- 				<label for="usr">手機號碼 :</label><input type="text" -->
<!-- 					class="form-control" id="usr"> -->
			</p>
			<p>
				<label for="usr">選擇日期 : </label><input type="date" >
			</p>
			<p>
				<label for="usr">選擇時間 :</label><input type="time" class="form-control"
					id="usr">
			</p>
			<p>
				<label for="usr">訂位人數 :</label>
				<select class="form-control" id="sel1">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
				</select>
			</p>
			<p>
				<label for="usr"><input type="submit" value="確定訂位"></label>
			</p>
		</div>
		</form:form>
		<div class=container id="tabs-3">
			 <div id="mapid"></div>
    <script src="https://unpkg.com/leaflet@1.3.4/dist/leaflet.js"
        integrity="sha512-nMMmRyTVoLYqjP9hrbed9S+FzjZHW5gY1TWCHA5ckwXZBadntCNs8kEqAWdrb9O7rxbCaA4lKTIWjDXZxflOcA=="
        crossorigin=""></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script>
        // (function ($) {
        //     $(document).ready(function () {
        //         $('#mapid').height(window.innerHeight);
        //     });
        // })($)

        // $('#mapid').height(window.innerHeight);


        // 建立 Leaflet 地圖,設定經緯度座標 
        var myMap = L.map('mapid', {
            center: [${resBeselect.restaurantPy},${resBeselect.restaurantPx}],
            zoom: 16
        });
        // 設定圖資來源
        L.tileLayer('https://{s}.tile.opentopomap.org/{z}/{x}/{y}.png', {
            maxZoom: 17,
            attribution: 'Map data: © <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>, <a href="http://viewfinderpanoramas.org">SRTM</a> | Map style: © <a href="https://opentopomap.org">OpenTopoMap</a> (<a href="https://creativecommons.org/licenses/by-sa/3.0/">CC-BY-SA</a>)'
        }).addTo(myMap);

        //以 L.marker 加入 marker：
        var marker = L.marker([${resBeselect.restaurantPy},${resBeselect.restaurantPx}]).addTo(myMap);

        // 以 L.circle 加入圓圈：
        var circle = L.circle(
            [${resBeselect.restaurantPy},${resBeselect.restaurantPx}],   // 圓心座標
            500,                // 半徑（公尺）
            {
                color: 'red',      // 線條顏色
                fillColor: 'lightblue', // 填充顏色
                fillOpacity: 0.5   // 透明度
            }
        ).addTo(myMap);

        // 以 L.polygon 加入多邊形：
//         var polygon = L.polygon([
//             [25.033505, 121.530112],
//             [25.052067, 121.543104],
//             [24.941545, 121.338691],
//             [24.983062, 121.537363]
//         ]).addTo(myMap);


        //以 bindPopup 將圖標加上訊息方塊：
        marker.bindPopup("<strong>${resBeselect.restaurantName}</strong><br>").openPopup();
        circle.bindPopup("這是圓圈。");
        polygon.bindPopup("這是多邊形。");

//         //也可以在地圖上建立獨立的訊息方塊：
//         var popup = L.popup()
//             .setLatLng([${resBeselect.restaurantPy},${resBeselect.restaurantPx}])
//             .setContent("獨立的訊息方塊。")
//             .openOn(myMap);


    </script>
		</div>
	</div>


</body>

</html>