package social.model.bean; 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RestaurantInfo")
public class RestaurantTypeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @Column(name="RestaurantID")
	private Integer restaurantId;
	@Column(name="RestaurantType")
	private String restaurantType;
		
	public RestaurantTypeBean() {
	}
	
	public RestaurantTypeBean(Integer restaurantID, String restaurantType) {
		this.restaurantId = restaurantID;
		this.restaurantType = restaurantType;
	}

	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
	
	public String getRestaurantType() {
		return this.restaurantType;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantID) {
		restaurantId = restaurantID;
	}
	
}