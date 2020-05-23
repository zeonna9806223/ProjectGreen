package social.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import social.model.DAO.RestaurantTypeDAO;

@Service(value="RestaurantTypeImpl")
@Transactional // *****所有方法都自動begin trans then commit or rollback
@EnableTransactionManagement
public class RestaurantTypeImpl implements RestaurantType {
	@Autowired 
	RestaurantTypeDAO restaurantTypeDAO;
//	public  RestaurantTypeImpl() {
//		restaurantTypeDAO = new RestaurantTypeDAOImpl();
//	}
	
	@Override
	public List<String> queryRestaurantTypes() {
		return restaurantTypeDAO.queryRestaurantTypes();
	}
	
}
