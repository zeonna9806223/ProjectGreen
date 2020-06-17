package accommodation.search.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import accommodation.search.model.dao.impl.AccommodationNumDAO;
@Service
@Transactional
@EnableTransactionManagement
public class AccommodationNumService implements IAccommodationNumService{
	@Autowired
	private AccommodationNumDAO anDao;


	public AccommodationNumService() {
	}

	
	
	@Override
	public void updateBookNum(int hotelId) {
		anDao.updateBookNum(hotelId);
	}

	@Override
	public void updateViewNum(int hotelId) {
		System.out.println("service update hotel VNUM");
		anDao.updateViewNum(hotelId);
	}

	@Override
	public void insertNewHotel(int hotelId, String hotelName) {
		System.out.println("service new hotel NUM");
		anDao.insertNewHotel(hotelId, hotelName);
	}

	@Override
	public void updateHotelName(int hotelId, String hotelName) {
		anDao.updateHotelName(hotelId, hotelName);
	}

}
