package accommodation.search.service;

import java.util.List;
import java.util.Map;

import accommodation.edit.model.bean.EditDetail;

public interface IAccommodationService {
	
	public int insert(EditDetail eBean, String region, String town);
	public void update(EditDetail eBean, String region, String town);
	public void delete(EditDetail eBean);
	public List<Map> hotelChoice(String town);
	public List<Map> hotelInfo(String hotel);
	public List<Map> hotelShow(int hotelId);
	public int getHotelId(String hotel);
}
