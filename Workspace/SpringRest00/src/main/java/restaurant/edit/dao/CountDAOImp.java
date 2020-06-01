package restaurant.edit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import restaurant.model.CountBean;
@Repository
public class CountDAOImp implements ICountDAO{

	@Autowired
	SessionFactory factory;
	
	public CountDAOImp() {
	}

	@Override
	public int viewCountDecOne(Integer id) {
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int viewCountIncOne(Integer id) {
		
		Session session =factory.getCurrentSession();
		CountBean cb= searchById(id);
		int temp =cb.getViewCount();
		temp++;
		String hql="update CountBean set ViewCount=:temp where RestaurantID=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("temp",temp);
		query.executeUpdate();
		
		return temp;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int likeCountDecOne(Integer id) {
		Session session =factory.getCurrentSession();
		CountBean cb= searchById(id);
		int temp =cb.getLikeCount();
		temp--;
		String hql="update CountBean set LikeCount=:temp where RestaurantID=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("temp",temp);
		query.executeUpdate();
		
		return temp;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int likeCountIncOne(Integer id) {
		Session session =factory.getCurrentSession();
		CountBean cb= searchById(id);
		int temp =cb.getLikeCount();
		temp++;
		String hql="update CountBean set LikeCount=:temp where RestaurantID=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("temp",temp);
		query.executeUpdate();
		
		return temp;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int disLikeCountDecOne(Integer id) {
		Session session =factory.getCurrentSession();
		CountBean cb= searchById(id);
		int temp =cb.getDislikeCount();
		temp--;
		String hql="update CountBean set DislikeCount=:temp where RestaurantID=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("temp",temp);
		query.executeUpdate();
		
		return temp;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int disLikeCountIncOne(Integer id) {
		Session session =factory.getCurrentSession();
		CountBean cb= searchById(id);
		int temp =cb.getDislikeCount();
		temp++;
		String hql="update CountBean set DislikeCount=:temp where RestaurantID=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("temp",temp);
		query.executeUpdate();
		
		return temp;
	}

	@Override
	public int bookingCountDecOne(Integer id) {
		return 0;
	}

	@Override
	public int bookingCountIncOne(Integer id) {
		return 0;
	}

	@Override
	public CountBean searchById(Integer id) {
		Session session =factory.getCurrentSession();
		String hql ="from CountBean r where r.restaurantID=:id"; 
		CountBean cb= (CountBean)session.createQuery(hql).setParameter("id", id).getSingleResult();
		return cb;
	}

}
