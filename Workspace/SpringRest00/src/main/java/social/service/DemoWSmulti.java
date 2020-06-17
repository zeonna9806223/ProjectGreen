package social.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import social.model.bean.ConnectBean;
@Component
@ServerEndpoint("/DemoWSmulti/{pair}")
public class DemoWSmulti {
	private static final Set<Session> connectedSessions = Collections.synchronizedSet(new HashSet<>());
	private static Set<ConnectBean> smallC = Collections.synchronizedSet(new HashSet<>());

//	private String pair;
//	private static Map<String, Session> userMap = Collections.synchronizedMap(new HashedMap<>());
	@OnOpen
	public void onOpen(Session userSession, @PathParam("pair") String pair) throws IOException {
		ConnectBean connectBean = new ConnectBean(pair, userSession);
		connectedSessions.add(userSession); // client連線時將連線session放入set內儲存
		smallC.add(connectBean);
		String text = String.format("Session ID = %s, connected;", userSession.getId());
//		userMap.put(pair, userSession);
		System.out.println("pair: " + pair);
		System.out.println(text);
		System.out.println("size:" + smallC.size());
//		this.pair = pair;
	}

	@OnMessage
	public void onMessage(Session userSession, String message, @PathParam("pair") String pair) {
		// 收到訊息時 message
		// 在此可以做分流比如說room number
		String msg = null;
		for (ConnectBean c : smallC) {
			if (c.getSession().isOpen()) {
				if (c.getPair().equals(pair)) {
					if (c.getSession().equals(userSession)) {
						msg = "<div>發信人" + message + "</div>";
					} else {
						msg = "<div>收信人" + message + "</div>";
					}
					c.getSession().getAsyncRemote().sendText(msg); // 送訊息回client
				}
			}
		}
//		Set<Entry<String, Session>> entrySet = userMap.entrySet();
//
//		for (Entry<String, Session> entry : entrySet) {
//			if (entry.getValue().isOpen()) {
//				if (entry.getKey().equals(pair)) {
//					if (entry.getValue().equals(userSession)) {
////						msg = "<div class='d-flex justify-content-end mb-4'><div class='msg_cotainer_send'>" + message
////								+ "<span class='msg_time_send'><!-- 時間 --></span></div><div class='img_cont_msg'><img src='images/suda.jpeg' class='rounded-circle user_img_msg'></div></div>";
//						msg = "<div>發信人" + message+"</div>";
//					} else {
//						msg = "<div>收信人" + message+"</div>";
//					}
//
//				}
//			}
//			entry.getValue().getAsyncRemote().sendText(msg); // 送訊息回client
//		}
//		for (Session session1 : connectedSessions) {
//			if (session1.isOpen()) {
//				if (session1.equals(userSession)) {
//					msg = "<div class='d-flex justify-content-end mb-4'><div class='msg_cotainer_send'>" + message
//							+ "<span class='msg_time_send'><!-- 時間 --></span></div><div class='img_cont_msg'><img src='images/suda.jpeg' class='rounded-circle user_img_msg'></div></div>";
//				} else {
//					msg = "<div class='d-flex justify-content-start mb-4'><div class='img_cont_msg'><img src='images/nemotsukensi.jpg' class='rounded-circle user_img_msg'></div><div class='msg_cotainer'>"
//							+ message + "<span class='msg_time'><!-- 時間 --></span></div></div>";
//				}
//
//			}
//			session1.getAsyncRemote().sendText(msg); // 送訊息回client
//		}

		System.out.println("Session ID =" + userSession.getId() + " ,Message received:" + message);
	}

	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		connectedSessions.remove(userSession);
		String text = String.format("session ID = %s, disconnected; close code = %d; reason phrase = %s",
				userSession.getId(), reason.getCloseCode().getCode(), reason.getReasonPhrase());
		System.out.println(text);
	}

	@OnError
	public void onError(Session userSession, Throwable e) {
		System.out.println("Error: " + e.toString());
	}

}
