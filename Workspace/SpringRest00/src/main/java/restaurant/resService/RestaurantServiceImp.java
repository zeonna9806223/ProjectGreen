package restaurant.resService;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import restaurant.resBean.RestaurantBean;
import restaurant.resDAO.RestaurantHibernateDaoImp;

@Service
@Transactional
@EnableTransactionManagement
public class RestaurantServiceImp implements IRestaurantService {
	@Autowired
	RestaurantHibernateDaoImp dao;

	@Override
	public List<RestaurantBean> search(String type, String zone) throws SQLException {
		return dao.search(type,zone);
	}



	@Override
	public List<RestaurantBean> getAllRestaurant() throws SQLException {
		return dao.getAllRestaurant();
	}


	@Override
	public int insertRestaurant(RestaurantBean rb) throws SQLException {
		
		return dao.insertRestaurant(rb);
	}



	@Override
	public int deleteRestaurant(Integer id) throws SQLException {
		return dao.deleteRestaurant(id);
	}

	@Override
	public int updateRestaurant(RestaurantBean rb) throws SQLException {
		return dao.updateRestaurant(rb);
	}



	@Override
	public RestaurantBean searchById(Integer id) throws SQLException {
		
		return dao.searchById(id);
	}



}