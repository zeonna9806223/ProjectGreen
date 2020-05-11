package accommodation.edit.model.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import accommodation.edit.model.bean.EditDetail;

public class EditDetailDAO implements IEditDetailDAO{
	private SessionFactory factory;
	private Session session;

	public EditDetailDAO(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public EditDetailDAO() {
	}

	public Session getSession() {
		return session = factory.getCurrentSession();
	}

	@Override
	public int findHotelId(int memberId) {
		String sql = "select e.hotelId from EditDetail e, Accommodation a where e.hotelId = a.id and e.editorId=?1 ";
		  
		Query query = getSession().createQuery(sql);
		query.setInteger(1, memberId);
		List<Integer> list = query.list();
		return list.get(0);
	}

	@Override
	public int insert(EditDetail eBean) {
		Date date = new Date();
		Timestamp t = new Timestamp(date.getTime());
		eBean.setEditId(eBean.getEditId());
		eBean.setEditorName(eBean.getEditorName());
		eBean.setUpdateTime(t);
		eBean.setHotelId(eBean.getHotelId());
		eBean.setName(eBean.getName());
		eBean.setRegionId(eBean.getRegionId());
		eBean.setTownId(eBean.getTownId());
		eBean.setAddress(eBean.getAddress());
		eBean.setTel(eBean.getTel());
		eBean.setEmail(eBean.getEmail());
		eBean.setWebsite(eBean.getWebsite());
		eBean.setLowestPrice(eBean.getLowestPrice());
		eBean.setStatus(eBean.getStatus());
		int editId = (Integer)getSession().save(eBean);
		return editId;
	}

	@Override
	public int insert(EditDetail eBean, int hotelId) {
		Date date = new Date();
		Timestamp t = new Timestamp(date.getTime());
		eBean.setEditId(eBean.getEditId());
		eBean.setEditorName(eBean.getEditorName());
		eBean.setUpdateTime(t);
		eBean.setHotelId(hotelId);
		eBean.setName(eBean.getName());
		eBean.setRegionId(eBean.getRegionId());
		eBean.setTownId(eBean.getTownId());
		eBean.setAddress(eBean.getAddress());
		eBean.setTel(eBean.getTel());
		eBean.setEmail(eBean.getEmail());
		eBean.setWebsite(eBean.getWebsite());
		eBean.setLowestPrice(eBean.getLowestPrice());
		eBean.setStatus(eBean.getStatus());
		int editId = (Integer)getSession().save(eBean);
		return editId;
	}
	
}
