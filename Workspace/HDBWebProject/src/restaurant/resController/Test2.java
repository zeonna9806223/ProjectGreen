package restaurant.resController;

import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import restaurant.resBean.RestaurantBean;
import restaurant.resDAO.RestaurantHibernateDaoImp;
import _00_init.util.HibernateUtil;

public class Test2 {

	public static void main(String[] args) throws SQLException {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		try {
			int id= 1330;
			String type = "飲品";
			String name = "黃君";
			String zone = "新莊區";
			String address = "qwertyuioasdfghjklzxcvbnm";
			RestaurantHibernateDaoImp dao = new RestaurantHibernateDaoImp(session);
			RestaurantBean rBean = new RestaurantBean();
			
			rBean.setRestaurantID(id);
			rBean.setRestaurantName(name);
			rBean.setRestaurantType(type);
			rBean.setRestaurantZone(zone);
			rBean.setRestaurantAddress(address);
		
			dao.updateRestaurant(rBean);
//			dao.insertRestaurant(rBean);
//			dao.deleteRestaurant(rBean);
			session.getTransaction().commit();
//					session.close();
			HibernateUtil.closeSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
