package accommodation.search.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import accommodation.search.model.bean.AccommodationNum;

public class AccommodationNumDAO implements IAccommodationNumDAO {
	private Session session;
	private SessionFactory factory;

	public AccommodationNumDAO() {
	}

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
		AccommodationNum anBean = getSession().get(AccommodationNum.class, hotelId);
		anBean.setViewNum(anBean.getViewNum() + 1);
		getSession().update(anBean);
		System.out.println("====ViewNum+1====");
	}
	
	@Override
	public void insertNewHotel(int hotelId, String hotelName) {
		AccommodationNum anBean = new AccommodationNum();
		anBean.setHotelId(hotelId);
		anBean.setHotelName(hotelName);
		getSession().save(anBean);
	}
	
	@Override
	public void updateHotelName(int hotelId, String hotelName) {
		AccommodationNum anBean = getSession().get(AccommodationNum.class, hotelId);
		anBean.setHotelName(hotelName);
		getSession().update(anBean);
	}


}
