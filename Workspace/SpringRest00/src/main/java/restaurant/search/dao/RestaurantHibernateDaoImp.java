package restaurant.search.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import restaurant.model.RestaurantBean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository
public class RestaurantHibernateDaoImp implements IRestarurantDao {

	@Autowired
	SessionFactory factory;

	public RestaurantHibernateDaoImp() {}

	@SuppressWarnings("unchecked")
	@Override
	public List<RestaurantBean> search(String type, String zone,String city) {
		String citytemp= "%"+city+"%";
		Session session = factory.getCurrentSession();
		List<RestaurantBean> list = new ArrayList<RestaurantBean>();
				
		if ((!zone.equals("請選擇")) && (!type.equals("請選擇"))) {
			// zone和type都有選擇(city一定有選才會成立)
			String hql="from RestaurantBean r where r.restaurantType='" + type + "' And r.restaurantZone='" + zone + "' AND r.restaurantAddress like'" +citytemp+"'" ;
			list= session.createQuery(hql).getResultList();			
		} else if (zone.equals("請選擇") && (!type.equals("請選擇"))) {
			// 只有type有選擇(city一定有選才會成立)
			String hql="from RestaurantBean r where r.restaurantType='" + type + "'AND r.restaurantAddress like'" +citytemp+"'";
			list= session.createQuery(hql).getResultList();			
		} else if (!zone.equals("請選擇") && (type.equals("請選擇"))) {
			// 只有zone有選擇(city一定有選才會成立)
			String hql="from RestaurantBean r where r.restaurantZone='" + zone + "'"+ "'AND r.restaurantAddress like'" +citytemp+"'";
			list= session.createQuery(hql).getResultList();			
		}else{
			//只有city有選 其他都是"請選擇"
			String hql="from RestaurantBean r where r.restaurantAddress like'" +citytemp+"'";
			list= session.createQuery(hql).getResultList();
		}
		return list;

	}

	@SuppressWarnings("rawtypes")
	@Override

	public List<RestaurantBean> getAllRestaurant() throws SQLException {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from RestaurantBean", RestaurantBean.class);
		@SuppressWarnings("unchecked")
		List<RestaurantBean> list = query.list();
		return list;
	}

	@Override
	public int insertRestaurant(RestaurantBean rb) throws SQLException {

		int n = 0;
		System.out.println(rb.getRestaurantName());
		Session session = factory.getCurrentSession();
		session.save(rb);
		return n;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int deleteRestaurant(Integer id) throws SQLException {
		int n = 0;
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("delete RestaurantBean where RestaurantID= :id");
		query.setParameter("id", id);
		query.executeUpdate();
		return n;
	}

	@Override
	public int updateRestaurant(RestaurantBean rb) throws SQLException {
		int n = 0;
		Session session = factory.getCurrentSession();
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

	@SuppressWarnings({"unchecked" })
	@Override
	public List<String> typeList(String district) {
		System.out.println("type DAO");
		String zoneString= "%"+district+"%";
		Session session = factory.getCurrentSession();
		String sql = "select distinct RestaurantType from RestaurantInfo where RestaurantZone like :zoneSelected";
		// 2. 用createNativeQuery去執行sql指令，且要把傳入的參數(city)放進sql指令的指定位置(citySelected)，然後就getResultList（或是用.list()好像也可以）
		List<String> list = new ArrayList<>();
		list = session.createNativeQuery(sql).setParameter("zoneSelected", zoneString).getResultList();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> zoneList(String city) {
		System.out.println("Zone DAO");
		System.out.println("進入DAO_#RestaurantHibernateDaoImp，傳入資料："+city);    // checkpoint
		Session session = factory.getCurrentSession();
		// 梅姬原本的sql指令
		// 姿君有兩個sql指令，是因為YouBike有分成台北市和新北市各一張資料表，所以必須要分開下sql指令去叫不同的資料表
//		String sqlntp = "select distinct RestaurantZone from RestaurantInfo as r where r.RestaurantAddress like '%新北市%'";
//		String sqltp = "select distinct RestaurantZone from RestaurantInfo as r where r.RestaurantAddress like '%台北市%'";
//		if(city.equals("台北市")) {
//			Query query = session.createSQLQuery(sqltp);
//			List<String> list = query.list();
//			return list;
//		}else {
//			Query query = session.createSQLQuery(sqlntp);
//			List<String> list = query.list();
//			return list;
//		}
		
		// 姿君改的code如下：
		List<String> list = new ArrayList<>();
		// 0. 先加工傳入的參數(city)：因為要用模糊查詢（例如：%台北市%）
		String cityfuzzy = "%"+city+"%";
		System.out.println("確認cityfuzzy字串內容："+cityfuzzy);    // checkpoint
		// 1. 用sql指令
		String sql = "select distinct RestaurantZone from RestaurantInfo where RestaurantAddress like :citySelected  order by RestaurantZone";
		// 2. 用createNativeQuery去執行sql指令，且要把傳入的參數(city)放進sql指令的指定位置(citySelected)，然後就getResultList（或是用.list()好像也可以）
		list = session.createNativeQuery(sql).setParameter("citySelected", cityfuzzy).getResultList();
		System.out.println("DAO的結果："+list.size());    // checkpoint
		System.out.println("準備回RestaurantServiceImp和resController_#zonelist");    // checkpoint
		return list;
	}
}
