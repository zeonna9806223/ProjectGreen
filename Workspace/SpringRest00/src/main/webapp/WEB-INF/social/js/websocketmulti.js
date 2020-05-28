var pair = -1;
var receiveBy;
var conncetCount = 0;
var statusOutput = document.getElementById("statusOutput");
var webSocket;
var cardbody= document.getElementById("cardbody");
var clickCount = 1;
//$("#fileUpload").hide();
//document.getElementById("fileUpload").disabled=true;
document.getElementById("my-img").onclick=null;
    // hide the lorem ipsum text
$(".ajax").click(function() {
//	var xxx = $('#abcd').data("ajax0");
	if(pair != $(this).data("pair")){
		$("#cardbody").empty();
		clickCount = 1;
	}
        	$.ajax({
        		url : ajax00,
        		type : "Post",
        		data : {
				H : $(this).data("id")
				} ,
//				async:false,
				dataType: "json",
				success: function(data){
//					alert(data);
				var dataLength = data.length; //NumOfJData=1
//        		alert(dataLength);
            	for (var i = 0; i < dataLength; i++) {
            	var memberId = data[i]["memberName"]
            	var gender = data[i]["gender"]
            	var memberBithday = data[i]["memberBithday"]
            	var memberIntroduce = data[i]["memberIntroduce"]
            	var profileHeight = data[i]["profileHeight"]
            	var profileWeight = data[i]["profileWeight"]
            	var profile = data[i]["profile"]
        	  }
           		  $('#friendInfo0').html("<img src='"+profile+"' style='width=220px;'>");  
            	  $('#friendInfo1').text("名字："+memberId);
                  $('#friendInfo2').text("性別："+gender);
                  $('#friendInfo3').text("年齡："+memberBithday);
                  $('#friendInfo4').text("自我介紹："+memberIntroduce);
                  $('#friendInfo5').text("身高："+profileHeight);
                  $('#friendInfo6').text("身材："+profileWeight);
                  if ( profileHeight == "高挑") {
                	  document.querySelector("#background").style.backgroundColor="#FF95CA" 
                  }else if (profileHeight == "中等"){
                	  document.querySelector("#background").style.backgroundColor="#7AFEC6" 
                  }
                  else{
                	  document.querySelector("#background").style.backgroundColor="#F9F900" 
                  }
            }
        	});
        	
        	if(pair != $(this).data("pair")){
        	$.ajax({
        		url : ajax01,
        		type : "Post",
        		data : {
				Z : $(this).data("pair"),
				H : $(this).data("id")
				} ,
//				async:false,
				dataType: "json",
				success: function(data){
//					alert(data);
				var dataLength = data.length; //NumOfJData=1
//        		alert("t"+dataLength);
            	for (var i = 0; i < dataLength; i++) {
            	var memberId1 = data[i]["memberId1"]
            	var memberId2 = data[i]["memberId2"]
            	var text0 = data[i]["text"]
            	var messageDate = data[i]["messageDate"]
            	var messageBy = data[i]["messageBy"]
            	messageOrImg(text0,messageBy,receiveBy);
        	  }
            	}
        	});
        	}
//        	alert(conncetCount);
        	if(conncetCount == 1){
        		disconnect();
        	}
        	pair = $(this).data("pair");
    		receiveBy = $(this).data("id");
        	connect();
//        	document.getElementById("fileUpload").disabled=false;
        	document.getElementById("my-img").onclick=aaa;
	});



$("#showMore").click(function() {
        	$.ajax({
        		url : ajax02,
        		type : "Post",
        		data : {
				Z : pair,
				H : receiveBy,
				C : clickCount
				} ,
				dataType: "json",
				success: function(data){
				var dataLength = data.length; //NumOfJData=1
            	for (var i = 0; i < dataLength; i++) {
            	var memberId1 = data[i]["memberId1"]
            	var memberId2 = data[i]["memberId2"]
            	var text0 = data[i]["text"]
            	var messageDate = data[i]["messageDate"]
            	var messageBy = data[i]["messageBy"]
            	messageOrImg(text0,messageBy,receiveBy);
        	  }
            	}
        	});
        	clickCount += 1;
	});

function connect() {
	var MyPoint = "/DemoWSmulti";
	var MyPoint2 = "/DemoWSmulti/" + pair +"/" + memberID + "/" + receiveBy;
	var host = window.location.host;
	conncetCount = 1;
//	console.log(host);
	var path = window.location.pathname;
//	console.log(path);
	var webCtx = path.substring(0, path.indexOf('/', 1));
//	console.log(webCtx);
	var endPointURL = "ws://" + window.location.host + webCtx + MyPoint2;
	document.getElementById("catalog").style.display='block';
	output = document.getElementById("output");
	// create a websocket
	alert(endPointURL);
	webSocket = new WebSocket(endPointURL);
	WebSocket.binaryType = "blob";
	webSocket.onopen = function(event) {
		onOpen(event)
	};

	webSocket.onmessage = function(event) {
		onMessage(event)
	};

	webSocket.onclose = function(event) {
		onClose(event)
	};
	webSocket.onerror = function(event) {
		onError(event)
	};
}
function onOpen(evt) { //連線時觸發
   writeToScreen("<p style='background-color:#ddd'>get connected</p>");
 
}
function onMessage(evt) { //收到訊息時觸發
	writeToScreen( evt.data);
	// 		websocket.close();
}
function onClose(evt) { //關閉連線時時觸發
//		writeToScreen("DISCONNECTED");
}

function onError(evt) {
	writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

function sendMessage() {

	var inputMessage = document.getElementById("textmssg");
	var message = inputMessage.value.trim();
	if (message === "") {
		alert("Input a message");
		inputMessage.focus();
	} else {
		// 			writeToScreen("SENT: " + message);
		var message0 = htmlEncodeJQ (message) 
		webSocket.send(message0); //!!!! 送留言到endpoint
		inputMessage.value = "";
		inputMessage.focus();
	}
}

function disconnect() {
	webSocket.close();
}

function writeToScreen(message) {
	if(message.substr(1,9)=="vjekoslav"){
		if (message.substring(0,1) == 0){
			cardbody.innerHTML+="<div class='msg_cotainer_send'>您：<img src='" + message.substr(10) + "'/></div>";		
		}else if(message.substring(0,1) == 1){
			cardbody.innerHTML+="<div class='msg_cotainer'>對方：<img src='" + message.substr(10) + "'/></div>";		
		}
	}else{
		if (message.substring(0,1) == 0){
			cardbody.innerHTML+="<div class='msg_cotainer_send'>您：" + message.substr(1) + "</div>";		
		}else if(message.substring(0,1) == 1){
			cardbody.innerHTML+="<div class='msg_cotainer'>對方：" + message.substr(1) + "</div>";		
		}
	}
	
}

function htmlDecode ( str ) {
	  var ele = document.createElement('span');
	  ele.innerHTML = str;
	  return ele.textContent;
	}

function htmlEncode ( str ) {
	  var ele = document.createElement('span');
	  ele.appendChild( document.createTextNode( str ) );
	  return ele.innerHTML;
	}

function htmlEncodeJQ ( str ) {
    return $('<span/>').text( str ).html();
}

function htmlDecodeJQ ( str ) {
    return $('<span/>').html( str ).text();
}

//$("#fileUpload").change(function () {
//	 var file = this.files[0];
//	 var reader = new FileReader();
//	 var readed = reader.readAsDataURL(file);
//	  reader.onload = function (e) {
//          var result = document.getElementById("kz");
//          var result2 = document.getElementById("kz2");
//          //显示文件
//          //显示文件
//          result2.innerHTML = this.result;
//          webSocket.send("vjekoslav"+this.result);
//          result.innerHTML = '<img src="' + this.result + '" alt="" />';
//          document.getElementById("fileUpload").value = ""
//	  }
//});

$("#img-upload").change(function () {
	 var file = this.files[0];
	 var reader = new FileReader();
	 var readed = reader.readAsDataURL(file);
	  reader.onload = function (e) {
         var result = document.getElementById("kz");
         var result2 = document.getElementById("kz2");
         //显示文件
         //显示文件
         result2.innerHTML = this.result;
         webSocket.send("vjekoslav"+this.result);
         result.innerHTML = '<img src="' + this.result + '" alt="" />';
         document.getElementById("img-upload").value = ""
	  }
});

function messageOrImg(text0,messageBy,receiveBy){
	if(text0.substring(0,9)=="vjekoslav"){
		if(messageBy == receiveBy){
			$("#cardbody").prepend("<div class='msg_cotainer'>對方：<img src='"+ text0.substr(9) + "'/></div>");
		}
		else{
			$("#cardbody").prepend("<div class='msg_cotainer_send'>您：<img src='"+ text0.substr(9) + "'/></div>");
		}
	}else{
		if(messageBy == receiveBy){
			$("#cardbody").prepend("<div class='msg_cotainer'>對方："+ text0 + "</div>");
		}
		else{
			$("#cardbody").prepend("<div class='msg_cotainer_send'>您："+ text0 + "</div>");
		}
	}
}
function aaa(){
//    $('#my-img').click(function(){
        $('#img-upload').click();
//    });
}
////形如"data:image/png;base64,iVBORw0KG..."逗号前内容为文件类型，格式，编码类型，逗号之后为base64编码内容
//	// 	window.addEventListener("load", init, false);