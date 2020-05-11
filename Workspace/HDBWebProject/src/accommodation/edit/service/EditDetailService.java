package accommodation.edit.service;

import org.hibernate.SessionFactory;

import accommodation.edit.model.bean.EditDetail;
import accommodation.edit.model.dao.EditDetailDAO;

public class EditDetailService implements IEditDetailService{

	private EditDetailDAO edDao;
	private SessionFactory factory;


	public EditDetailService() {
	}

	public EditDetailService(SessionFactory factory) {
		edDao = new EditDetailDAO(factory);
	}
	
	
	
	@Override
	public int findHotelId(int memberId) {
		return edDao.findHotelId(memberId);
	}

	@Override
	public int insert(EditDetail eBean) {
		return edDao.insert(eBean);
	}

	@Override
	public int insert(EditDetail eBean, int hotelId) {
		return edDao.insert(eBean, hotelId);
	}

}
