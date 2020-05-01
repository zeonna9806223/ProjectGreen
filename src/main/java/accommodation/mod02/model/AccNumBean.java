package accommodation.mod02.model;

public class AccNumBean {

	int hotelId;
	int viewNum;
	int BookNum;
	
	public AccNumBean(int hotelId, int viewNum, int bookNum) {
		super();
		this.hotelId = hotelId;
		this.viewNum = viewNum;
		BookNum = bookNum;
	}
	public AccNumBean() {
		super();
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getViewNum() {
		return viewNum;
	}
	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}
	public int getBookNum() {
		return BookNum;
	}
	public void setBookNum(int bookNum) {
		BookNum = bookNum;
	}
	
	
	
}
