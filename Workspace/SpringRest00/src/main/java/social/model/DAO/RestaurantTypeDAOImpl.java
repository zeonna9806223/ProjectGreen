package social.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantTypeDAOImpl implements RestaurantTypeDAO {

	@Autowired
	SessionFactory factory;
//	@Autowired
//	ServletContext ctx;
//	private Session session;
//	public RestaurantTypeDAOImpl() {
//	}
//	public RestaurantTypeDAOImpl(Session session) {
//		this.session = session;
//	}

	public List<String> queryRestaurantTypes() {
		List<String> list=new ArrayList<>();
			String hql = "SELECT distinct restaurantType FROM RestaurantTypeBean";
			Session session = factory.getCurrentSession();
			list = session.createQuery(hql).list();
		return list;
	}
}
