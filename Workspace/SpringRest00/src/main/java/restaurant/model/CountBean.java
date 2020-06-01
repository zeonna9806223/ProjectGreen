package restaurant.model;

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
@Table(name = "RestaurantOverview")
public class CountBean implements Serializable {
	private static final long serialVersionUID = 5776283567459887757L;
	private Integer restaurantID;
	private String restaurantName;
	private Integer viewCount;
	private Integer likeCount;
	private Integer dislikeCount;
	private Integer bookingCount;

	public CountBean() {
	}

	public CountBean(Integer restaurantID, String restaurantName, Integer viewCount, Integer bookingCount,Integer likeCount,Integer dislikeCount) {
		this.restaurantID = restaurantID;
		this.restaurantName = restaurantName;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.viewCount = viewCount;
		this.bookingCount = bookingCount;
	}

	@Id
	@Column(name = "RestaurantID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(Integer restaurantID) {
		this.restaurantID = restaurantID;
	}

	@Column(name = "RestaurantName")
	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	@Column(name = "ViewCount")
	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	@Column(name = "BookingCount")
	public Integer getBookingCount() {
		return bookingCount;
	}

	public void setBookingCount(Integer bookingCount) {
		this.bookingCount = bookingCount;
	}
	
	@Column(name = "likeCount")
	public Integer getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}
	@Column(name = "DisLikeCount")
	public Integer getDislikeCount() {
		return dislikeCount;
	}

	public void setDislikeCount(Integer dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

}
