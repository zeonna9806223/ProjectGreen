package social.service;

import java.util.List;
import org.hibernate.Session;
import social.DAO.RestaurantTypeDAO;
import social.DAO.RestaurantTypeDAOImpl;

public class RestaurantTypeImpl implements RestaurantType {
	
	private RestaurantTypeDAO restaurantTypeDAO;
	
	public  RestaurantTypeImpl(Session session) {
		restaurantTypeDAO = new RestaurantTypeDAOImpl(session);
	}
	
	@Override
	public List<String> queryRestaurantTypes() {
		return restaurantTypeDAO.queryRestaurantTypes();
	}
	
}
