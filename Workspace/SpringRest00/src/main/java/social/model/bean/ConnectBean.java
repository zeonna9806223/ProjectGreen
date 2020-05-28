package social.model.bean;

import javax.websocket.Session;

public class ConnectBean {
	Integer pair;
	Session session;
	public ConnectBean() {
	}
	public ConnectBean(Integer pair, Session session) {
		this.pair = pair;
		this.session = session;
	}
	public Integer getPair() {
		return pair;
	}
	public void setPair(Integer pair) {
		this.pair = pair;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
}
