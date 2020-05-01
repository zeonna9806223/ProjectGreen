package social.service;

import java.util.List;

import social.DAO.RestaurantTypeDAO;
import social.DAO.RestaurantTypeDAOImpl;
import social.bean.RestaurantTypeBean;

public class RestaurantTypeImpl implements RestaurantType {
	
	RestaurantTypeDAO restaurantTypeDAO;

	public RestaurantTypeImpl() {
		restaurantTypeDAO = new RestaurantTypeDAOImpl();
	}

	@Override
	public List<RestaurantTypeBean> queryRestaurantTypes() {
		return restaurantTypeDAO.queryRestaurantTypes();
	}
	
}
