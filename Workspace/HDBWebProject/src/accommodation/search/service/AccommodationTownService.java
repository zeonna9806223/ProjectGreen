package accommodation.search.service;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;

import accommodation.search.model.dao.AccommodationDAO;
import accommodation.search.model.dao.AccommodationTownDAO;

public class AccommodationTownService implements IAccommodationTownService{

	private AccommodationTownDAO atDao;
	private SessionFactory factory;


	public AccommodationTownService() {
	}

	public AccommodationTownService(SessionFactory factory) {
		atDao = new AccommodationTownDAO(factory);
	}
	
	
	@Override
	public String getRegionName(String regionId) {
		return atDao.getRegionName(regionId);
	}

	@Override
	public String getTownName(String townId) {
		return atDao.getTownName(townId);
	}

	@Override
	public List<Map> townChoice(String region) {
		return atDao.townChoice(region);
	}

}
