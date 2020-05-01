package accommodation.mod02.service;

import accommodation.mod02.dao.AccNumDao;
import accommodation.mod02.dao.AccNumDaoImpl;
import accommodation.mod02.model.AccNumBean;

public class AccNumServiceImpl implements AccNumService {

	@Override
	public String updateBookNum(int hotel) {
		AccNumDao dao = new AccNumDaoImpl();
		return dao.updateBookNum(hotel);
	}

	@Override
	public int getHotelId(String hotel) {
		AccNumDao dao = new AccNumDaoImpl();
		return dao.getHotelId(hotel);
	}

	@Override
	public void updateViewNum(int hotel) {
		AccNumDao dao = new AccNumDaoImpl();
		dao.updateViewNum(hotel);
	}
}
