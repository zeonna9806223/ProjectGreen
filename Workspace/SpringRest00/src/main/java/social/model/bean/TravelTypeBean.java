package social.model.bean; 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table; 

@Entity
@Table(name="[Attractions.Category]")
public class TravelTypeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Column(name="ClassNumber")
	private Integer classNumber;
	@Column(name="Definition")
	private String travelType;
		
	public TravelTypeBean() {
	}
	

	public TravelTypeBean(Integer classNumber, String travelType) {
		super();
		this.classNumber = classNumber;
		this.travelType = travelType;
	}


	public Integer getClassNumber() {
		return classNumber;
	}


	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}


	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}
	
	public String getTravelType() {
		return this.travelType;
	}
	
}