package accommodation.search.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name = "AccommodationNum")
public class AccommodationNum {
//	private int pk;
	private int hotelId;
	private String hotelName;
	private int viewNum;
	private int bookNum;
	
	public AccommodationNum() {
	}
	@Id
	@Column(name = "HotelID")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
//	@Id@Column(name = "pk")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	public int getPk() {
//		return pk;
//	}
//
//	public void setPk(int pk) {
//		this.pk = pk;
//	}

	@Column(name = "HotelName")
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	@Column(name = "ViewNum")
	public int getViewNum() {
		return viewNum;
	}
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}
	@Column(name = "BookNum")
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	

}
