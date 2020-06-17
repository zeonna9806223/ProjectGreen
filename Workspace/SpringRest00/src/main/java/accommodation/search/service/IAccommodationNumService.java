package accommodation.search.service;

public interface IAccommodationNumService {

	public void updateBookNum(int hotelId);
	public void updateViewNum(int hotelId);
	public void insertNewHotel(int hotelId, String hotelName);
	public void updateHotelName(int hotelId, String hotelName);
	
}
