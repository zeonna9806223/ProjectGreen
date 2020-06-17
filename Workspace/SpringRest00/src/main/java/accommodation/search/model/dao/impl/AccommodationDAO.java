package accommodation.search.model.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import accommodation.edit.model.bean.EditDetail;
import accommodation.search.model.bean.Accommodation;
import accommodation.search.model.dao.IAccommodationDAO;
@Repository
public class AccommodationDAO implements IAccommodationDAO {
	@Autowired
	private SessionFactory factory;
	private Session session;

	public AccommodationDAO() {

	}

	public Session getSession() {
		return factory.getCurrentSession();
	}

//	public AccommodationDAO(SessionFactory factory) {
//		super();
//		this.factory = factory;
//	}
	@Override
	public int insert(EditDetail eBean, String region, String town) {
		Accommodation aBean = new Accommodation();
		aBean.setName(eBean.getName());
		aBean.setRegionId(eBean.getRegionId());
		aBean.setRegion(region);
		aBean.setTownId(eBean.getTownId());
		aBean.setTown(town);
		aBean.setAddress(eBean.getAddress());
		aBean.setTel(eBean.getTel());
		aBean.setIndustryEmail(eBean.getEmail());
		aBean.setWebsite(eBean.getWebsite());
		aBean.setLowestPrice(eBean.getLowestPrice());
		int memberHotelId = (Integer) getSession().save(aBean);
		return memberHotelId;
	}
	@Override
	public void update(EditDetail eBean, String region, String town) {
//		String d = "update Accommodation set lowestPrice = ?1 where id=?2";
//		Query query = getSession().createQuery(d);
//		query.setParameter(1, eBean.getLowestPrice());
//		query.setParameter(2, eBean.getHotelId());
//		query.executeUpdate();
		Accommodation aBean = getSession().get(Accommodation.class, eBean.getHotelId());
		aBean.setName(eBean.getName());
		aBean.setRegionId(eBean.getRegionId());
		aBean.setRegion(region);
		aBean.setTownId(eBean.getTownId());
		aBean.setTown(town);
		aBean.setAddress(eBean.getAddress());
		aBean.setTel(eBean.getTel());
		aBean.setIndustryEmail(eBean.getEmail());
		aBean.setWebsite(eBean.getWebsite());
		aBean.setLowestPrice(eBean.getLowestPrice());
		getSession().update(aBean);
	
		
	}
	
	@Override
	public void delete(EditDetail eBean) {
		Accommodation aBean = getSession().get(Accommodation.class, eBean.getHotelId());
		getSession().delete(aBean);
		
	}


	@Override
	public List<Map> hotelChoice(String town) {
		String sql = "select new map ( name as name, tel as tel, address as addr, lowestPrice as price) from Accommodation where town = ?1";
		Query query = getSession().createQuery(sql);
		query.setString(1, town);
		List<Map> list = query.list();
		return list;
	}
	@Override
	public List<Map> hotelInfo(String hotel) {
		String sql = "select  new map ( address as addr, tel as tel, industryEmail as email, website as web, lowestPrice as price, picture1 as picture1, picdescribe1 as pInfo, picture2 as picture2, picdescribe2 as pInfo2, picture3 as picture3, picdescribe3 as  pInfo3) "
				+ "from Accommodation where name = ?1";
		Query query = getSession().createQuery(sql);
		query.setString(1, hotel);
		List<Map> list = query.list();
		return list;
	}
	@Override
	public List<Map> hotelShow(int hotelId) {
		String sql = "select  new map ( address as addr, tel as tel, industryEmail as email, website as web, lowestPrice as price, regionId as regionId, townId as  townId, name as name) "
				+ "from Accommodation where id = ?1";
		Query query = getSession().createQuery(sql);
		query.setInteger(1, hotelId);
		List<Map> list = query.list();
		return list;
	}
	@Override
	public int getHotelId(String hotel) {
		String sql = "select id from Accommodation where name = ?1 ";
		Query query = getSession().createQuery(sql);
		query.setString(1, hotel);
		List<Integer> list = query.list();
		int hotelId = list.get(0);
		System.out.println(hotelId);
		return hotelId;
	}
}
