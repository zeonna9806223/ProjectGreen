package member.dao.impl;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.dao.LoginDao;
import member.model.MemberBean;

@Repository("loginDaoImpl")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public Session getConnection() {
		return this.factory.getCurrentSession();
	}

	public LoginDaoImpl() { 	}

	
	@Override
	public MemberBean getLogin(String email, String password) {

		
		Session session = factory.getCurrentSession();
		Query query = session.createNativeQuery("SELECT * FROM Member3 m WHERE m.memberEmail = ? and m.memberPWD = ?", MemberBean.class);
		query.setParameter(1, email);
		query.setParameter(2, password);
		Iterator iterator = query.getResultList().iterator();
		MemberBean mem = null;
		while (iterator.hasNext()) {
			mem = (MemberBean) iterator.next();
		}
		return mem;
		
	}
	
	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
	// 否則傳回 null。
	@Transactional
	@Override
	public MemberBean checkIDPassword(String memberAccount, String password) {
//		Mem mem = new Mem();
		
		Session session = factory.getCurrentSession();
		Query query = session.createNativeQuery("SELECT * FROM Member3 m WHERE m.memberAccount = ? and m.memberPWD = ?", MemberBean.class);
		query.setParameter(1, memberAccount);
		query.setParameter(2, password);
		Iterator iterator = query.getResultList().iterator();
		MemberBean mem = null;
		while (iterator.hasNext()) {
			mem = (MemberBean) iterator.next();
		}
		return mem;
		
	}
	

}
