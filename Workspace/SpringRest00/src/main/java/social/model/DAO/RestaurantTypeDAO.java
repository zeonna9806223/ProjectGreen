package social.model.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface RestaurantTypeDAO {

	public List<String> queryRestaurantTypes();
	
}