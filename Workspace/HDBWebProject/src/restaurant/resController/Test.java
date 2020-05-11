package restaurant.resController;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import restaurant.resBean.RestaurantBean;
import restaurant.resDAO.RestaurantHibernateDaoImp;
import _00_init.util.HibernateUtil;

public class Test {

	private static String zone;
	private static String type;

	public static void main(String[] args) throws SQLException {

//		Session	session = sessionFactory.openSession();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();   
		session.beginTransaction();
		try {
			type = "南洋";
			zone = "大安區";
			RestaurantHibernateDaoImp dao = new RestaurantHibernateDaoImp(session);
			//List<RestaurantBean> restaurants = dao.getAllRestaurant();
			List<RestaurantBean> restaurants = dao.search(type, zone);
			for (RestaurantBean rBean : restaurants) {
				System.out.println(rBean.getRestaurantID());
				System.out.println(rBean.getRestaurantAddress());
				System.out.println(rBean.getRestaurantName());
				System.out.println(rBean.getRestaurantType());
				System.out.println(rBean.getRestaurantZone());
			}
			session.getTransaction().commit();
//				session.close();
			HibernateUtil.closeSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
