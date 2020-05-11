package social.service;

import java.util.List;

import org.hibernate.Session;

import social.DAO.TravelTypeDAO;
import social.DAO.TravelTypeDAOImpl;

public class TravelTypeImpl implements TravelType {
	
	private TravelTypeDAO travelTypeDAO;

	public TravelTypeImpl(Session session) {
		travelTypeDAO = new TravelTypeDAOImpl(session);
	}
	
	@Override
	public List<String> queryTravelTypes() {
		return travelTypeDAO.queryTravelTypes();
	}
	
}
