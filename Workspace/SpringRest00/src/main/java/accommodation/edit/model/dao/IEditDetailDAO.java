package accommodation.edit.model.dao;

import accommodation.edit.model.bean.EditDetail;

public interface IEditDetailDAO {

	public int findHotelId(int memberId);
	public int insert(EditDetail eBean);
	public int insert(EditDetail eBean, int hotelId);
	
}
