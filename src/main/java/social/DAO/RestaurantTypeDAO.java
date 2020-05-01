package social.DAO;

import java.util.List;

import social.bean.RestaurantTypeBean;

public interface RestaurantTypeDAO {

	public List<RestaurantTypeBean> queryRestaurantTypes();
	
}