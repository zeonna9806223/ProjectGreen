package restaurant.resBean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Component
@Table(name = "RestaurantInfo")
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
	
	@Id @Column(name="RestaurantID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRestaurantID() {
		return restaurantID;
	}
	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	@Column(name="RestaurantType")
	public String getRestaurantType() {
		return restaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
	@Column(name="RestaurantName")
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	@Column(name="RestaurantZone")
	public String getRestaurantZone() {
		return restaurantZone;
	}
	public void setRestaurantZone(String restaurantZone) {
		this.restaurantZone = restaurantZone;
	}
	@Column(name="RestaurantAddress")
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	@Column(name="RestaurantPx")
	public String getRestaurantPx() {
		return restaurantPx;
	}
	public void setRestaurantPx(String restaurantPx) {
		this.restaurantPx = restaurantPx;
	}
	@Column(name="RestaurantPy")
	public String getRestaurantPy() {
		return restaurantPy;
	}
	public void setRestaurantPy(String restaurantPy) {
		this.restaurantPy = restaurantPy;
	}
	@Column(name="RestaurantPhone")
	public String getRestaurantPhone() {
		return restaurantPhone;
	}
	public void setRestaurantPhone(String restaurantPhone) {
		this.restaurantPhone = restaurantPhone;
	}
	
	
}