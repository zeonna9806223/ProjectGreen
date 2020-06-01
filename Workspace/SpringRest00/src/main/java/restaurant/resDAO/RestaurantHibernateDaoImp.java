package restaurant.resDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import javax.sql.DataSource;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import restaurant.resBean.RestaurantBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
@Repository

public class RestaurantHibernateDaoImp implements IRestarurantDao {

	@Autowired
	SessionFactory factory;

	public RestaurantHibernateDaoImp() {}

	@SuppressWarnings("unchecked")
	@Override
	public List<RestaurantBean> search(String type, String zone) {
		if ((!zone.equals("請選擇")) && (!type.equals("請選擇"))) {
			Session session = factory.getCurrentSession();
			String hql="from RestaurantBean r where r.restaurantType='" + type + "' And r.restaurantZone='" + zone + "'";
			List<RestaurantBean> list = new ArrayList<RestaurantBean>();
			list= session.createQuery(hql).getResultList();			
			return list;

//			sql = " select * from ResturantInfo where ( RestaurantType= ? and RestaurantZone =?)";
//			try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
//
//				stmt.setString(1, type);
//				stmt.setString(2, zone);
//				ResultSet rs = stmt.executeQuery();
//				while (rs.next()) {
//					RestaurantBean rest = new RestaurantBean(rs.getInt("restaurantID"), rs.getString("restaurantType"),
//							rs.getString("restaurantName"), rs.getString("restaurantZone"),
//							rs.getString("restaurantAddress"), rs.getString("restaurantPx"),
//							rs.getString("restaurantPy"), rs.getString("restaurantPhone"));
//					searchRestaurant.add(rest);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		} else if (zone.equals("請選擇") && (!type.equals("請選擇"))) {
			Session session = factory.getCurrentSession();
			String hql="from RestaurantBean r where r.restaurantType='" + type + "'";
			List<RestaurantBean> list = new ArrayList<RestaurantBean>();
			list= session.createQuery(hql).getResultList();			
			return list;
			
//			sql = "select * from ResturantInfo where RestaurantType= ?";
//			try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
////				System.out.println("type");
//				stmt.setString(1, type);
//				ResultSet rs = stmt.executeQuery();
//				while (rs.next()) {
//					RestaurantBean rest = new RestaurantBean(rs.getInt("restaurantID"), rs.getString("restaurantType"),
//							rs.getString("restaurantName"), rs.getString("restaurantZone"),
//							rs.getString("restaurantAddress"), rs.getString("restaurantPx"),
//							rs.getString("restaurantPy"), rs.getString("restaurantPhone"));
//					searchRestaurant.add(rest);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

		} else {
			Session session = factory.getCurrentSession();
			String hql="from RestaurantBean r where r.restaurantZone='" + zone + "'";
			List<RestaurantBean> list = new ArrayList<RestaurantBean>();
			list= session.createQuery(hql).getResultList();			
			return list;
//			sql = "select * from ResturantInfo where RestaurantZone= ?";
//			try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
////				System.out.println("zone");
//				stmt.setString(1, zone);
//				ResultSet rs = stmt.executeQuery();
//				while (rs.next()) {
//					RestaurantBean rest = new RestaurantBean(rs.getInt("restaurantID"), rs.getString("restaurantType"),
//							rs.getString("restaurantName"), rs.getString("restaurantZone"),
//							rs.getString("restaurantAddress"), rs.getString("restaurantPx"),
//							rs.getString("restaurantPy"), rs.getString("restaurantPhone"));
//					searchRestaurant.add(rest);
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return searchRestaurant;
		}

	}

	@SuppressWarnings("rawtypes")
	@Override

	public List<RestaurantBean> getAllRestaurant() throws SQLException {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from RestaurantBean", RestaurantBean.class);
		@SuppressWarnings("unchecked")
		List<RestaurantBean> list = query.list();
		return list;

//		List<RestaurantBean> queryresult = new ArrayList<>();
//		try (Connection conn = ds.getConnection();
//				PreparedStatement stmt = conn.prepareStatement("SELECT * from  ResturantInfo");
//				ResultSet rs = stmt.executeQuery();) {
//			while (rs.next()) {
//				RestaurantBean rest = new RestaurantBean(rs.getInt("restaurantID"), rs.getString("restaurantType"),
//						rs.getString("restaurantName"), rs.getString("restaurantZone"),
//						rs.getString("restaurantAddress"), rs.getString("restaurantPx"), rs.getString("restaurantPy"),
//						rs.getString("restaurantPhone"));
//				
//				queryresult.add(rest);
//			}
//		}
//		return queryresult;

		// Query <RestaurantBean> query=factory.getCurrentSession().createQuery("from
		// RestaurantInfo",RestaurantBean.class);

	}

	@SuppressWarnings("rawtypes")
	@Override
	public int insertRestaurant(RestaurantBean rb) throws SQLException {

		int n = 0;
		System.out.println(rb.getRestaurantName());
//		RestaurantBean rBean = getSession().get(RestaurantBean.class, rb.getRestaurantName());
		// if(rBean == null) {
		String sql;
		Session session = factory.getCurrentSession();
		sql = " INSERT [dbo].[RestaurantInfo] ([RestaurantType], "
				+ "[RestaurantName], [RestaurantZone], [RestaurantAddress], "
				+ "[RestaurantPx], [RestaurantPy], [RestaurantPhone])" + " VALUES (?,?,?,?,?,?,?)";
		Query query = session.createSQLQuery(sql);
		//query.setParameter(1, rb.getRestaurantID());
		query.setParameter(1, rb.getRestaurantType());
		query.setParameter(2, rb.getRestaurantName());
		query.setParameter(3, rb.getRestaurantZone());
		query.setParameter(4, rb.getRestaurantAddress());
		query.setParameter(5, rb.getRestaurantPx());
		query.setParameter(6, rb.getRestaurantPy());
		query.setParameter(7, rb.getRestaurantPhone());
		query.executeUpdate();

//		}

//		String sql;
//		sql = " INSERT [dbo].[ResturantInfo] ( [RestaurantType], "
//				+ "[RestaurantName], [RestaurantZone], [RestaurantAddress], "
//				+ "[RestaurantPx], [RestaurantPy], [RestaurantPhone])" + " VALUES (?,?,?,?,?,?,?)";
//		try (Connection conn = ds.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {
//
//			// stmt.setInt(1, rb.getRestaurantID());
//			stmt.setString(1, rb.getRestaurantType());
//			stmt.setString(2, rb.getRestaurantName());
//			stmt.setString(3, rb.getRestaurantZone());
//			stmt.setString(4, rb.getRestaurantAddress());
//			stmt.setString(5, rb.getRestaurantPx());
//			stmt.setString(6, rb.getRestaurantPy());
//			stmt.setString(7, rb.getRestaurantPhone());
//			stmt.executeUpdate();
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return n;
	}

	@SuppressWarnings("rawtypes")
	@Override

	public int deleteRestaurant(Integer id) throws SQLException {
		int n = 0;
		Session session = factory.getCurrentSession();
		// 不知道為什麼delete不用寫,Restaurant.bean 網路寫:delete语句执行createQuery的时候，不能传对象类。
		Query query = session.createQuery("delete RestaurantBean where RestaurantID= :id");
		query.setParameter("id", id);
		query.executeUpdate();

		return n;
	}


	@Override
	public int updateRestaurant(RestaurantBean rb) throws SQLException {
		int n = 0;
		Session session = factory.getCurrentSession();
		// 不知道為什麼delete不用寫,Restaurant.bean 網路寫:delete语句执行createQuery的时候，不能传对象类。
//		String hql = " update [dbo].[RestaurantInfo] set [RestaurantType] =? ,"
//				+ "[RestaurantName]=?, [RestaurantZone]=?, [RestaurantAddress]=?, "
//				+ "[RestaurantPx]=?, [RestaurantPy]=?, [RestaurantPhone]=? where RestaurantID = ? ";
//		Query query = session.createSQLQuery(hql);
//		query.setParameter(1, rb.getRestaurantType());
//		query.setParameter(2, rb.getRestaurantName());
//		query.setParameter(3, rb.getRestaurantZone());
//		query.setParameter(4, rb.getRestaurantAddress());
//		query.setParameter(5, rb.getRestaurantPx());
//		query.setParameter(6, rb.getRestaurantPy());
//		query.setParameter(7, rb.getRestaurantPhone());
//		query.setParameter(8, rb.getRestaurantID());
//		query.executeUpdate();
//
		
		session.update(rb);
		return n;
		
		
	}

	@Override
	public RestaurantBean searchById(Integer id) throws SQLException {
		Session session = factory.getCurrentSession();
		String hql="from RestaurantBean r where r.restaurantID=:id";
		RestaurantBean rb =(RestaurantBean)session.createQuery(hql).setParameter("id", id).getSingleResult();
		return rb;
		
	}

}
