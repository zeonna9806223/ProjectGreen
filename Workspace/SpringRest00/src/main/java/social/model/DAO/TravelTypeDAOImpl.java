package social.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TravelTypeDAOImpl implements TravelTypeDAO {
	
	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext ctx;
//	private Session session;
//	public Session getSession() {
//		return session;
//	}
	public TravelTypeDAOImpl() {
	}
//	public TravelTypeDAOImpl(Session session) {
//		this.session = session;
//	}

//	@Override
	public List<String> queryTravelTypes() {
		List<String> list = new ArrayList<>();
			String hql = "SELECT travelType FROM TravelTypeBean ";
			Session session = factory.getCurrentSession();
			list = session.createQuery(hql).list();
		return list;
	}
}
