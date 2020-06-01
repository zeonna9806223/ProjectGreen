package restaurant.search.service;

import java.sql.SQLException;
import java.util.List;

import restaurant.model.RestaurantBean;

public interface IRestaurantService {

	List<RestaurantBean> getAllRestaurant() throws SQLException;
	
	List<RestaurantBean> search(String type,String zone,String city) throws SQLException;
	
	List<String> typeList(String district);
	List<String> zoneList(String city);
	// 梅姬原本的code
//	List<String> typeList(String district) throws SQLException;
//	List<String> zoneList(String city) throws SQLException;
	RestaurantBean searchById(Integer id) throws SQLException;

//	List<RestaurantBean> searchName(String name) throws SQLException;

//	List<RestaurantBean> searchZone(String zone) throws SQLException;

	int insertRestaurant(RestaurantBean rb) throws SQLException ;
	int deleteRestaurant(Integer id) throws SQLException ;
	int updateRestaurant(RestaurantBean rb) throws SQLException ;
//	Boolean restauranExists(String name);

}
