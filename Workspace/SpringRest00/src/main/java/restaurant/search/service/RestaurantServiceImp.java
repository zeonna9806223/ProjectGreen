package restaurant.search.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import restaurant.model.RestaurantBean;
import restaurant.search.dao.RestaurantHibernateDaoImp;

@Service
@Transactional
@EnableTransactionManagement
public class RestaurantServiceImp implements IRestaurantService {
	@Autowired
	RestaurantHibernateDaoImp dao;

	@Override
	public List<RestaurantBean> search(String type, String zone,String city) throws SQLException {
		return dao.search(type,zone,city);
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

	// 姿君把throws SQLException拿掉了
	@Override
	public List<String> typeList(String district) {
		return dao.typeList(district);
	}

	// 姿君把throws SQLException拿掉了
	@Override
	public List<String> zoneList(String city) {
		return dao.zoneList(city);
	}

}