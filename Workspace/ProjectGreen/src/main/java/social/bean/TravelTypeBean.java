package social.bean; 

import java.io.Serializable; 
import java.sql.Date;
import java.sql.Timestamp;

public class TravelTypeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String travelType;
		
	public TravelTypeBean() {
	}
	
	public TravelTypeBean(String travelType) {
		this.travelType = travelType;
	}

	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}
	
	public String getTravelType() {
		return this.travelType;
	}
	
}