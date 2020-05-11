package social.DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class TravelTypeDAOImpl implements TravelTypeDAO {
	private Session session;

	public Session getSession() {
		return session;
	}

	public TravelTypeDAOImpl(Session session) {
		this.session = session;
	}

//	@Override
	public List<String> queryTravelTypes() {
		List<String> list = new ArrayList<>();
			String hql = "SELECT travelType FROM TravelTypeBean ";
			list = session.createQuery(hql).list();
		return list;
	}
}
