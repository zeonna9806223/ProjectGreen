package transportation.mrt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import transportation.mrt.dao.TaipeiMRTDAO;
import transportation.mrt.model.TaipeiMRTExit;

@Service
@Transactional
@EnableTransactionManagement
public class TaipeiMRTService {
	@Autowired
	TaipeiMRTDAO mrtDao;
	
//	public List<String> queryMRTLines () {
//		return mrtDao.queryMRTLines();
//	}
	
	public String queryMRTLineName (String lineId) {
		return mrtDao.queryMRTLineName(lineId);
	}
	
	public List<String> queryMRTStationsByLine (String line) {
		return mrtDao.queryMRTStationsByLine(line);
	}
	
	public List<TaipeiMRTExit> queryMRTExits (String station) {
		return mrtDao.queryMRTExits(station);
	}
}
