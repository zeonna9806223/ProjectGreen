package accommodation.search.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import accommodation.edit.model.bean.EditDetail;
import accommodation.search.model.dao.AccommodationDAO;

public class AccommodationService implements IAccommodationService{
	
	private AccommodationDAO aDao;
	private SessionFactory factory;


	public AccommodationService() {
	}

	public AccommodationService(SessionFactory factory) {
		aDao = new AccommodationDAO(factory);
	}
	
	@Override
	public int insert(EditDetail eBean, String region, String town) {
		return aDao.insert(eBean, region, town);
	}

	@Override
	public void update(EditDetail eBean, String region, String town) {
		 aDao.update(eBean, region, town);
	}

	@Override
	public void delete(EditDetail eBean) {
		aDao.delete(eBean);
	}


	@Override
	public List<Map> hotelChoice(String town) {
		return aDao.hotelChoice(town);
	}

	@Override
	public List<Map> hotelInfo(String hotel) {
		return aDao.hotelInfo(hotel);
	}

	@Override
	public List<Map> hotelShow(int hotelId) {
		return aDao.hotelShow(hotelId);
	}

	@Override
	public int getHotelId(String hotel) {
		return aDao.getHotelId(hotel);
	}

}
