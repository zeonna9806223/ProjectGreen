package restaurant.search_S;

import java.sql.SQLException;
import java.util.List;

import restaurant.model.RestaurantBean;
import restaurant.searchDAO.RestaurantDaoImp;

public class RestaurantServiceImp implements IRestaurantService {
	RestaurantDaoImp dao;

	public RestaurantServiceImp() throws Exception {
		this.dao = new RestaurantDaoImp();
		
	}
	


	@Override
	public List<RestaurantBean> search(String type, String zone) throws SQLException {
		return dao.search(type,zone);
	}



	@Override
	public List<RestaurantBean> getAllRestaurant() throws SQLException {
			return dao.getAllRestaurant();
	}

	@Override
	public List<RestaurantBean> searchName(String name) throws SQLException {

		return dao.searchName(name);

	}

	@Override
	public List<RestaurantBean> searchZone(String zone) throws SQLException {
		return dao.searchZone(zone);
	}



	@Override
	public int insertRestaurant(RestaurantBean rb) throws SQLException {
		
		return dao.insertRestaurant(rb);
	}



	@Override
	public Boolean restauranExists(String name) {
	
		return dao.restauranExists(name);
	}

}