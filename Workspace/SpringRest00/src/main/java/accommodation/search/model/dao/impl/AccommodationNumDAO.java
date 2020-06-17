package accommodation.search.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import accommodation.search.model.bean.AccommodationNum;
import accommodation.search.model.dao.IAccommodationNumDAO;

@Repository
public class AccommodationNumDAO implements IAccommodationNumDAO {
	private Session session;

	private SessionFactory factory;

	public AccommodationNumDAO() {
	}

	@Autowired
	public AccommodationNumDAO(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public Session getSession() {
		return session = factory.getCurrentSession();
	}

	@Override
	public void updateBookNum(int hotelId) {
		AccommodationNum anBean = getSession().get(AccommodationNum.class, hotelId);
		anBean.setBookNum(anBean.getBookNum() + 1);
		getSession().update(anBean);
		System.out.println("====BookNum+1====");
	}

	@Override
	public void updateViewNum(int hotelId) {
		System.out.println(hotelId);
		AccommodationNum anBean = getSession().get(AccommodationNum.class, hotelId);
		anBean.setViewNum(anBean.getViewNum() + 1);
		getSession().update(anBean);
//		System.out.println("DAO new hotel in VNUM");
		System.out.println("====ViewNum+1====");
	}

	@Override
	public void insertNewHotel(int hotelId, String hotelName) {
		AccommodationNum anBean = new AccommodationNum();
		anBean.setHotelId(hotelId);
		anBean.setHotelName(hotelName);
		getSession().save(anBean);
//		System.out.println("new hotel in NUM");
	}

	@Override
	public void updateHotelName(int hotelId, String hotelName) {
//		System.out.println("getSession():" + getSession() == null);
		AccommodationNum anBean = getSession().get(AccommodationNum.class, hotelId);
		anBean.setHotelName(hotelName);
		getSession().update(anBean);
	}

}
