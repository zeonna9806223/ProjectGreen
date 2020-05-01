package transportation.dao;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.util.List;

import transportation.model.TaipeiMRTBean;
import transportation.model.YouBikeBean;

public interface TransportationDao {
	
	public void setConnection(Connection conn);
	
	// YouBike
//	public List<YouBikeBean> queryAllYouBike();
	public List<String> queryDist(String city);
	public List<YouBikeBean> queryDistYouBike(String city,String district) throws MalformedURLException;
	public Boolean updateYouBike() throws MalformedURLException;
	
	// 台北捷運
	public List<String> queryLine(String line);
	public List<TaipeiMRTBean> queryMRT(String stationName);
	
}
