package social.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import social.model.DAO.TravelTypeDAO;
@Service
@Transactional // *****所有方法都自動begin trans then commit or rollback
@EnableTransactionManagement
public class TravelTypeImpl implements TravelType {
	@Autowired
	TravelTypeDAO travelTypeDAO;
//	private TravelTypeDAO travelTypeDAO;

//	public TravelTypeImpl(Session session) {
//		travelTypeDAO = new TravelTypeDAOImpl(session);
//	}
	
	@Override
	public List<String> queryTravelTypes() {
		return travelTypeDAO.queryTravelTypes();
	}
	
}
