package accommodation.mod02.service;

import accommodation.mod02.model.AccNumBean;

public interface AccNumService {
	String updateBookNum(int hotel);
	int getHotelId(String hotel);
	void updateViewNum(int hotel);
}
