package restaurant.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity @Component
@Table(name = "NewItemsSystem")
public class DataVerifyBean {

	@Id
	@Column(name = "RequestID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer requestID;
	@Column(name = "Category")
	private String category;
	@Column(name = "RestaurantID")
	private String  restaurantID;
	@Column(name = "AccommodationID")
	private String  accommodationID;
	@Column(name = "EntertainmentID")
	private String  entertainmentID;
	@Column(name = "UserID")
	private String  userID;
	@Column(name = "AdminFeedback")
	private String  adminFeedback;
	@Column(name = "FinalStatus")
	private String  finalStatus;
	@Column(name = "UerRequestTime")
	private Timestamp uerRequestTime;
	
}
