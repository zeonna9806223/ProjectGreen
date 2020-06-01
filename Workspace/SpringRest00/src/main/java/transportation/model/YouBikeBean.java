package transportation.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class YouBikeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String stationId;
	private String stationName;
	private boolean activity;
	private Integer total;
	private Integer available;
	private Integer vacancy;
	private String city;
	private String distirct;
	private String area;
	private Double lati;
	private Double lon;
	private Timestamp update;


	public YouBikeBean(String stationId, String stationName, boolean activity, Integer total, Integer available,
			Integer vacancy, String city, String distirct, String area, Double lati, Double lon, Timestamp update) {
		this.stationId = stationId;
		this.stationName = stationName;
		this.activity = activity;
		this.total = total;
		this.available = available;
		this.vacancy = vacancy;
		this.city = city;
		this.distirct = distirct;
		this.area = area;
		this.lati = lati;
		this.lon = lon;
		this.update=update;
	}
	
	public YouBikeBean() {
	}
	
	
	// getter and setter
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String string) {
		this.stationId = string;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getStationName() {
		return stationName;
	}
	
	public void setActivity(boolean activity) {
		this.activity = activity;
	}
	public boolean isActivity() {
		return activity;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getTotal() {
		return total;
	}
	
	public void setAvailable(Integer available) {
		this.available = available;
	}
	public Integer getAvailable() {
		return available;
	}
	
	public void setVacancy(Integer vacancy) {
		this.vacancy = vacancy;
	}
	public Integer getVacancy() {
		return vacancy;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	public String getCity() {
		return city;
	}

	public void setDistirct(String distirct) {
		this.distirct = distirct;
	}
	public String getDistirct() {
		return distirct;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	public String getArea() {
		return area;
	}
	
	public void setLati(Double lati) {
		this.lati = lati;
	}
	public Double getLati() {
		return lati;
	}
	
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLon() {
		return lon;
	}

	public Timestamp getUpdate() {
		return update;
	}
	public void setUpdate(Timestamp update) {
		this.update = update;
	}
	
}
