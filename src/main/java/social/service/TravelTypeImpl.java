package social.service;

import java.util.List;

import social.DAO.TravelTypeDAO;
import social.DAO.TravelTypeDAOImpl;
import social.bean.TravelTypeBean;

public class TravelTypeImpl implements TravelType {
	
	TravelTypeDAO travelTypeDAO;

	public TravelTypeImpl() {
		travelTypeDAO = new TravelTypeDAOImpl();
	}

	@Override
	public List<TravelTypeBean> queryTravelTypes() {
		return travelTypeDAO.queryTravelTypes();
	}
	
}
