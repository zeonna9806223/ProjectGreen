package social.DAO;

import java.util.List;

import social.bean.RestaurantTypeBean;
import social.bean.TravelTypeBean;

public interface TravelTypeDAO {

	public List<TravelTypeBean> queryTravelTypes();
	
}