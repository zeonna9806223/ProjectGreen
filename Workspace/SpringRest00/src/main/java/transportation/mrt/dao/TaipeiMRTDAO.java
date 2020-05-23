package transportation.mrt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import transportation.mrt.model.TaipeiMRTExit;
import transportation.mrt.model.TaipeiMRTLine;
import transportation.mrt.model.TaipeiMRTStation;

@Repository
public class TaipeiMRTDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	TaipeiMRTExit mrtExit;
	@Autowired
	TaipeiMRTLine mrtLine;
	@Autowired
	TaipeiMRTStation mrtStation;
	
// 查詢
	// 1-1. 撈出路線
//	@SuppressWarnings("unchecked")
//	public List<String> queryMRTLines () {
//		List<String> lines = new ArrayList<>();
//		String hql = "from TaipeiMRTLine";
//		lines = sessionFactory.getCurrentSession().createQuery(hql).getResultList();
//		return lines;
//	}
	// 1-2. 撈出路線中文名稱
	public String queryMRTLineName (String lineId) {
		String sql = "select line from TaipeiMRTLine where lineCode=:lineId";
		String lineName = sessionFactory.getCurrentSession().createNativeQuery(sql).setParameter("lineId", lineId).getSingleResult().toString();
		return lineName;
	}
	
	// 2. 用路線查詢車站
	@SuppressWarnings("unchecked")
	public List<String> queryMRTStationsByLine (String line) {
		List<String> stations = new ArrayList<>();
		String sql = "select StationName from TaipeiMRTStation where Line=:line";
		stations = (List<String>) sessionFactory.getCurrentSession().createNativeQuery(sql).setParameter("line", line).getResultList();
		return stations;
	}
	
	// 3. 用車站查詢出口
	@SuppressWarnings("unchecked")
	public List<TaipeiMRTExit> queryMRTExits (String station) {
		List<TaipeiMRTExit> stationExits = new ArrayList<>();
		String sql = "select * from TaipeiMRTExit where StationName = :station";
		stationExits = sessionFactory.getCurrentSession().createNativeQuery(sql).addEntity(TaipeiMRTExit.class).setParameter("station", station).getResultList();
		return stationExits;
	}
}
