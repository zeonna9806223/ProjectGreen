package accommodation.mod02.dao;

import java.util.List;

import accommodation.mod02.model.AccNumBean;

public interface AccNumDao {
	
	void insertAccNum();
	int getHotelId(String hotel);
	String updateBookNum(int hotel);
	void updateViewNum(int hotel);
}
