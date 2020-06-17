package accommodation.search.service;

import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import accommodation.search.model.dao.impl.AccommodationDAO;
import accommodation.search.model.dao.impl.AccommodationTownDAO;
@Service
@Transactional
@EnableTransactionManagement
public class AccommodationTownService implements IAccommodationTownService{
	@Autowired
	private AccommodationTownDAO atDao;


	public AccommodationTownService() {
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
