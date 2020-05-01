package restaurant.model;

import java.io.Serializable;

public class RestaurantBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int restaurantID;
	private String restaurantType;
	private String restaurantName;
	private String restaurantZone;
	private String restaurantAddress;
	private String restaurantPx;
	private String restaurantPy;
	private String restaurantPhone;
	
	
	public RestaurantBean () {	
	}
	public RestaurantBean (int restaurantID,String restaurantType,String restaurantName,
			String restaurantZone,String restaurantAddress,String restaurantPx,String restaurantPy,String restaurantPhone) {	
		super();
		this.restaurantID= restaurantID;
		this.restaurantType= restaurantType;
		this.restaurantName= restaurantName;
		this.restaurantZone= restaurantZone;	
		this.restaurantAddress = restaurantAddress;
		this.restaurantPx=restaurantPx;
		this.restaurantPy=restaurantPy;
		this.restaurantPhone=restaurantPhone;
	}
	public int getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	public String getRestaurantType() {
		return restaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantZone() {
		return restaurantZone;
	}
	public void setRestaurantZone(String restaurantZone) {
		this.restaurantZone = restaurantZone;
	}
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public String getRestaurantPx() {
		return restaurantPx;
	}
	public void setRestaurantPx(String restaurantPx) {
		this.restaurantPx = restaurantPx;
	}
	public String getRestaurantPy() {
		return restaurantPy;
	}
	public void setRestaurantPy(String restaurantPy) {
		this.restaurantPy = restaurantPy;
	}
	public String getRestaurantPhone() {
		return restaurantPhone;
	}
	public void setRestaurantPhone(String restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}
	
	
}