var pair;
//console.log(endPointURL);
var statusOutput = document.getElementById("statusOutput");
var webSocket;

function connect() {
	var MyPoint = "/DemoWSmulti";
	var MyPoint2 = "/DemoWSmulti/" + pair;
	var host = window.location.host;
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
		webSocket.send(message); //!!!! 送留言到endpoint
		inputMessage.value = "";
		inputMessage.focus();
	}
}

function disconnect() {
	webSocket.close();
}

var cardbody= document.getElementById("cardbody");
function writeToScreen(message) {
	console.log(message)
	cardbody.innerHTML+=message;
}


$(".ajax").click(function() {
	
		pair = $(this).data("pair");
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
//        	    alert(data[i]["memberId"]);   
//        	    alert(data[i]["memberName"]);    
//        	    alert(data[i]["gender"]); 
        	  }
//            	 var img1 = document.getElementById("friendInfo00");
//           			  img1.src = "data:image/jpeg;base64,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";
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
        connect();
	});


//	// 	window.addEventListener("load", init, false);