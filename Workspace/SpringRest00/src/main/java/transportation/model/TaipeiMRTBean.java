package transportation.model;

public class TaipeiMRTBean {
	Integer mrtNo;
	String exitName;
	String exitNo;
	String stationName;
	Double lon;
	Double lati;

	public TaipeiMRTBean(Integer mrtNo, String exitName, String exitNo, String stationName, Double lon, Double lati) {
		this.mrtNo = mrtNo;
		this.exitName = exitName;
		this.exitNo = exitNo;
		this.stationName = stationName;
		this.lon = lon;
		this.lati = lati;
	}
	
	public TaipeiMRTBean() {
	}
	
	
	// getter and setter
	public Integer getMrtNo() {
		return mrtNo;
	}
	public void setMrtNo(Integer mrtNo) {
		this.mrtNo = mrtNo;
	}

	public String getExitName() {
		return exitName;
	}
	public void setExitName(String exitName) {
		this.exitName = exitName;
	}

	public String getExitNo() {
		return exitNo;
	}
	public void setExitNo(String exitNo) {
		this.exitNo = exitNo;
	}

	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}

	public Double getLati() {
		return lati;
	}
	public void setLati(Double lati) {
		this.lati = lati;
	}
	
}
