package accommodation.edit.service;

import accommodation.edit.model.bean.EditDetail;

public interface IEditDetailService {

	public int findHotelId(int memberId);
	public int insert(EditDetail eBean);
	public int insert(EditDetail eBean, int hotelId);
	
}
