package restaurant.countBean;

import java.io.Serializable;

public class CountBean implements Serializable {
	private static final long serialVersionUID = 5776283567459887757L;
	private int restaurantID;
	private String restaurantName;
	private int viewCount;
	private int bookingCount;
	
	public CountBean() {
	}
	
	public CountBean(int restaurantID,String restaurantName,int viewCount,int bookingCount) {
		this.restaurantID=restaurantID;
		this.restaurantName=restaurantName;
		this.viewCount=viewCount;
		this.bookingCount=bookingCount;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getBookingCount() {
		return bookingCount;
	}

	public void setBookingCount(int bookingCount) {
		this.bookingCount = bookingCount;
	}


}
