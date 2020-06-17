package transportation.ubike.service;

import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import transportation.ubike.dao.YouBikeDAO;
import transportation.ubike.model.YouBikeNTPC;
import transportation.ubike.model.YouBikeTPC;

@Service
@Transactional
@EnableTransactionManagement
public class YouBikeService {
	
	@Autowired
	private YouBikeDAO ybDao;
	
	// 查詢雙北有YouBike站點的區域
	public List<String> searchYBDistrict(String city){
		return ybDao.searchYBDistrict(city);
	}
	
	// 各別查詢雙北YouBike站點（依該市的區域）
	public List<YouBikeTPC> ybStationTPC(String district) throws MalformedURLException{
//		List<YouBikeTPC> list = ybDao.ybStationTPC(district);
//		System.out.println("準備回到controller");
//		return list;
		return ybDao.ybStationTPC(district);
	}
	public List<YouBikeNTPC> ybStationNTPC(String district) throws MalformedURLException{
//		List<YouBikeNTPC> list = ybDao.ybStationNTPC(district);
//		System.out.println("準備回到controller");
//		return list;
		return ybDao.ybStationNTPC(district);
	}

}
