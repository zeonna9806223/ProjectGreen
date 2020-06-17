package transportation.ubike.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Component(value = "ybTPC")
@Table(name = "YouBikeTPC")
public class YouBikeTPC {
	@Id @Column(name = "STATIONID") @GeneratedValue(strategy = GenerationType.AUTO)
	private String stationId;
	@Column(name = "STATIONNAME")
	private String stationName;
	@Column(name = "ACTIVITY")
	private boolean activity;
	@Column(name = "TOTAL")
	private int total;
	@Column(name = "AVAILABLE")
	private int available;
	@Column(name = "VACANCY")
	private int vacancy;
	@Column(name = "CITY")
	private String city;
	@Column(name = "DISTRICT")
	private String district;
	@Column(name = "AREA")
	private String area;
	@Column(name = "LATITUDE")
	private Double latitude;
	@Column(name = "LONGITUDE")
	private Double longitude;
	@Column(name = "UPDATETIME")
	private Timestamp updateTime;
	
	// 建構子們
	public YouBikeTPC() {
	}
	public YouBikeTPC(String stationId, String stationName, boolean activity, int total, int available, int vacancy,
			String city, String district, String area, Double latitude, Double longitude, Timestamp updateTime) {
		this.stationId = stationId;
		this.stationName = stationName;
		this.activity = activity;
		this.total = total;
		this.available = available;
		this.vacancy = vacancy;
		this.city = city;
		this.district = district;
		this.area = area;
		this.latitude = latitude;
		this.longitude = longitude;
		this.updateTime = updateTime;
	}
	
	// getter and setter
	public String getStationId() {
		return stationId;
	}
	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public boolean isActivity() {
		return activity;
	}
	public void setActivity(boolean activity) {
		this.activity = activity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public int getVacancy() {
		return vacancy;
	}
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
}
