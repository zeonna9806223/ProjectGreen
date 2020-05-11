package restaurant.resService;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import restaurant.resBean.RestaurantBean;
import restaurant.resDAO.RestaurantHibernateDaoImp;

public class RestaurantServiceImp implements IRestaurantService {
	private RestaurantHibernateDaoImp dao;
	@SuppressWarnings("unused")
	private Session session;
	private List<RestaurantBean> result;

	public RestaurantServiceImp(Session sessoin) throws Exception {
		this.session=sessoin;
		dao = new RestaurantHibernateDaoImp(sessoin);
		
	}
	


	@Override
	public List<RestaurantBean> search(String type, String zone) throws SQLException {
//		session.beginTransaction();
		result =dao.search(type,zone);
//		session.getTransaction().commit();
		return result;
	}



	@Override
	public List<RestaurantBean> getAllRestaurant() throws SQLException {
//		session.beginTransaction();	
		result = dao.getAllRestaurant();
//		session.getTransaction().commit();
		return result;
	}


	@Override
	public int insertRestaurant(RestaurantBean rb) throws SQLException {
		
		return dao.insertRestaurant(rb);
	}



	@Override
	public int deleteRestaurant(RestaurantBean rb) throws SQLException {
		return dao.deleteRestaurant(rb);
	}



	@Override
	public int updateRestaurant(RestaurantBean rb) throws SQLException {
		return dao.updateRestaurant(rb);
	}

}