package social.model.bean;

import javax.websocket.Session;

public class ConnectBean {
	String pair;
	Session session;
	public ConnectBean() {
	}
	public ConnectBean(String pair, Session session) {
		this.pair = pair;
		this.session = session;
	}
	public String getPair() {
		return pair;
	}
	public void setPair(String pair) {
		this.pair = pair;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
}
