package restaurant.search.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import restaurant.search.dao.MapDAO;

@Service
@Transactional
@EnableTransactionManagement
public class MapService implements IMapService {
	@Autowired
	MapDAO dao;
	

	@Override
	public List<String> mapYoubikeTP() {
		
		return dao.mapYoubikeTP();
	}

	@Override
	public List<String> mapYoubikeNTP() {
		System.out.println("新北市service");
		return dao.mapYoubikeNTP();
	}

	@Override
	public List<String> mapMRT() {
		return dao.mapMRT();
	}

}
