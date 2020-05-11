package accommodation.search.service;

import org.hibernate.SessionFactory;

import accommodation.search.model.dao.AccommodationNumDAO;

public class AccommodationNumService implements IAccommodationNumService{

	private AccommodationNumDAO anDao;
	private SessionFactory factory;


	public AccommodationNumService() {
	}

	public AccommodationNumService(SessionFactory factory) {
		anDao = new AccommodationNumDAO(factory);
	}
	
	
	@Override
	public void updateBookNum(int hotelId) {
		anDao.updateBookNum(hotelId);
	}

	@Override
	public void updateViewNum(int hotelId) {
		anDao.updateViewNum(hotelId);
	}

	@Override
	public void insertNewHotel(int hotelId, String hotelName) {
		anDao.insertNewHotel(hotelId, hotelName);
	}

	@Override
	public void updateHotelName(int hotelId, String hotelName) {
		anDao.updateHotelName(hotelId, hotelName);
	}

}
