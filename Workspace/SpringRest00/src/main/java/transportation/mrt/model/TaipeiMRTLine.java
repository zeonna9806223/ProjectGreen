package transportation.mrt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Component(value = "mrtLine")
@Table(name = "TaipeiMRTLine")
public class TaipeiMRTLine {
	@Id @Column(name = "LINECODE") @GeneratedValue(strategy = GenerationType.AUTO)
	private String lineCode;
	@Column(name = "LINE")
	private String line;
	
	// 建構子們
	public TaipeiMRTLine() {
	}
	public TaipeiMRTLine(String lineCode, String line) {
		this.lineCode = lineCode;
		this.line = line;
	}
	
	// getter and setter
	public String getLineCode() {
		return lineCode;
	}
	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	
}
