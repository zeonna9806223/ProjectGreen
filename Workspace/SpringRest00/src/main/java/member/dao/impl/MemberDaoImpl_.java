package member.dao.impl;


import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import member.model.MemberBean;
import member.dao.MemberDao_;

@Repository
public class MemberDaoImpl_ implements MemberDao_ {

	private SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public Session getConnection() {
		return this.factory.getCurrentSession();
	}

	public MemberDaoImpl_() { 	}

	@Override
	public MemberBean getMem(int id) {

		MemberBean bean = null;

		try {
			String hql = "FROM MemberBean mem WHERE mem.memId = :id";
			Query<MemberBean> query = this.getConnection().createQuery(hql, MemberBean.class);
			query.setParameter("id", id);

			bean = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberBean> getMems() {
		Session session = factory.getCurrentSession();
		String hql  = "FROM MemberBean";
		List<MemberBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public Object saveMem(MemberBean bean) {
		Session session = factory.getCurrentSession();
		return session.save(bean);
	}
	@Override
	public void updateMem(MemberBean bean) {
		Session session = factory.getCurrentSession();
		session.update(bean);
		
	}

	@Override
	public void deleteMem(int key) {
		Session session = factory.getCurrentSession();
		MemberBean mem = new MemberBean();
		mem.setPKey(key);
		session.delete(mem);
	}

	@Override
	public MemberBean getMem(String memberAccount) {

		MemberBean bean = null;

		try {
			String hql = "FROM MemberBean mem WHERE mem.memberAccount = :memberAccount";
			Query<MemberBean> query = this.getConnection().createQuery(hql, MemberBean.class);
			query.setParameter("memberAccount", memberAccount);

			bean = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

	

}
