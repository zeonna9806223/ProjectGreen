package transportation.mrt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Component(value = "mrtExit")
@Table(name = "TaipeiMRTExit")
public class TaipeiMRTExit {
	@Id @Column(name = "NO") @GeneratedValue(strategy = GenerationType.AUTO)
	private int no;
	@Column(name = "EXITNAME")
	private String exitName;
	@Column(name = "EXITNO")
	private String exitNo;
	@Column(name = "STATIONNAME")
	private String stationName;
	@Column(name = "LONGITUDE")
	private Double longitude;
	@Column(name = "LATITUDE")
	private Double latitude;
	
	// 建構子們
	public TaipeiMRTExit() {
	}
	public TaipeiMRTExit(int no, String exitName, String exitNo, String stationName, Double longitude, Double latitude) {
		this.no = no;
		this.exitName = exitName;
		this.exitNo = exitNo;
		this.stationName = stationName;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	// getter and setter
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
