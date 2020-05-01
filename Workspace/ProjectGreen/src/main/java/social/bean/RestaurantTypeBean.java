package social.bean; 

import java.io.Serializable; 
import java.sql.Date;
import java.sql.Timestamp;

public class RestaurantTypeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String restaurantType;
		
	public RestaurantTypeBean() {
	}
	
	public RestaurantTypeBean(String restaurantType) {
		this.restaurantType = restaurantType;
	}

	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
	
	public String getRestaurantType() {
		return this.restaurantType;
	}
	
}