package transportation.mrt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Component(value = "mrtStation")
@Table(name = "TaipeiMRTStation")
public class TaipeiMRTStation {
	@Id @Column(name = "ID") @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Column(name = "LINE")
	private String line;
	@Column(name = "STATIONNO")
	private String stationNo;
	@Column(name = "STATIONNAME")
	private String stationName;
	
	// 建構子們
	public TaipeiMRTStation() {
	}
	public TaipeiMRTStation(String line, String stationNo, String stationName) {
		this.line = line;
		this.stationNo = stationNo;
		this.stationName = stationName;
	}
	
	// getter and setter
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	public String getStationNo() {
		return stationNo;
	}
	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
}
