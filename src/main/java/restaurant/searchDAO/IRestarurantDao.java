package restaurant.searchDAO;

import java.sql.SQLException;
import java.util.List;

import restaurant.model.RestaurantBean;

public interface IRestarurantDao {

	List<RestaurantBean> getAllRestaurant() throws SQLException;

	List<RestaurantBean> search(String type,String zone) throws SQLException;

	List<RestaurantBean> searchName(String name) throws SQLException;

	List<RestaurantBean> searchZone(String zone) throws SQLException;

	int insertRestaurant(RestaurantBean rb) throws SQLException ;

	Boolean restauranExists(String name);
}
