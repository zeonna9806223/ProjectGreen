package member.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import member.dao.MemDao;
import member.model.Mem;



@Repository
public class MemDaoImpl implements MemDao {

	private SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public Session getConnection() {
		return this.factory.getCurrentSession();
	}

	public MemDaoImpl() { 	}

	@Override
	public Mem getMem(int id) {

		Mem bean = null;
//		Session session = factory.getCurrentSession();
//		String hql  = "FROM Mem mem WHERE mem.memId = :id";
//		try {
//			bean = (Mem)session.createQuery(hql)
//									.setParameter("id", id)
//									.getSingleResult();
//		} catch(NoResultException e) {
//			;  // 表示查無紀錄
//		}
//		
//		return bean;
		try {
			String hql = "FROM Mem mem WHERE mem.memId = :id";
			Query<Mem> query = this.getConnection().createQuery(hql, Mem.class);
			query.setParameter("id", id);

			bean = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mem> getMems() {
		Session session = factory.getCurrentSession();
		String hql  = "FROM Mem";
		List<Mem> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}

	@Override
	public Object saveMem(Mem bean) {
		Session session = factory.getCurrentSession();
		return session.save(bean);
	}
	@Override
	public void updateMem(Mem bean) {
		Session session = factory.getCurrentSession();
		session.update(bean);
		
	}

	@Override
	public void deleteMem(int key) {
		Session session = factory.getCurrentSession();
		Mem mem = new Mem();
		mem.setMemId(key);
		session.delete(mem);
	}

	@Override
	public Mem getMem(String memberAccount) {

		Mem bean = null;

		try {
			String hql = "FROM Mem mem WHERE mem.memberAccount = :memberAccount";
			Query<Mem> query = this.getConnection().createQuery(hql, Mem.class);
			query.setParameter("memberAccount", memberAccount);

			bean = query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bean;
	}

	


}
