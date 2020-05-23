package restaurant.orderBean;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;

public class OrederBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private int OrderId;
	private int restaurantID;
	private int memberID;
	private int numberOfPeople;
	private Date reservationDate;
	private Time reservationTime;
	private String reservationUnder;
	private String contactPhone;
	private String remark;
	private Timestamp orderTimestamp;
	
	public OrederBean() {
		
	}

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public int getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Time getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Time reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getReservationUnder() {
		return reservationUnder;
	}

	public void setReservationUnder(String reservationUnder) {
		this.reservationUnder = reservationUnder;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Timestamp getOrderTimestamp() {
		return orderTimestamp;
	}

	public void setOrderTimestamp(Timestamp orderTimestamp) {
		this.orderTimestamp = orderTimestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	
	
	
	

}
