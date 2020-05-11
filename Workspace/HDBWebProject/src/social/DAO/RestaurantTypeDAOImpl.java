package social.DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class RestaurantTypeDAOImpl implements RestaurantTypeDAO {

	private Session session;
	
	public RestaurantTypeDAOImpl(Session session) {
		this.session = session;
	}

	public List<String> queryRestaurantTypes() {
		List<String> list=new ArrayList<>();
			String hql = "SELECT distinct restaurantType FROM RestaurantTypeBean";
			list = session.createQuery(hql).list();
		return list;
	}
}
