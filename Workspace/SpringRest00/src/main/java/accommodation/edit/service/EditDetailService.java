package accommodation.edit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import accommodation.edit.model.bean.EditDetail;
import accommodation.edit.model.dao.EditDetailDAO;
@Service("editDetailService")
@Transactional
@EnableTransactionManagement
public class EditDetailService implements IEditDetailService{
	@Autowired
	private EditDetailDAO edDao;


	public EditDetailService() {
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
