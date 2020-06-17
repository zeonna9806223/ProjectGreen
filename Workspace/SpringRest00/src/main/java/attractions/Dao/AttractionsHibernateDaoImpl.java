package attractions.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import attractions.Bean.AttractionEdited;

@Repository
public class AttractionsHibernateDaoImpl implements AttractionDao{

	@Autowired
	SessionFactory factory;
	
	public AttractionsHibernateDaoImpl() {}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AttractionEdited> search (String region, String town) throws SQLException{
		if ((!region.equals("請選擇")) && (!town.equals("請選擇"))) {
			Session session = factory.getCurrentSession();
			String hql="from AttractionEdited a where a.region='"+ region + "' And a.town='" + town + "'";
			List<AttractionEdited> list = new ArrayList<AttractionEdited>();
			list= session.createQuery(hql).getResultList();
			return list;
			
		} else if (region.equals("請選擇") && (!town.equals("請選擇"))) {
			Session session = factory.getCurrentSession();
			String hql="from AttractionEdited a where a.region='" + region + "'";
			List<AttractionEdited> list = new ArrayList<AttractionEdited>();
			list= session.createQuery(hql).getResultList();			
			return list;
			
		} else {
			Session session = factory.getCurrentSession();
			String hql="from AttractionEdited a where a.town ='" + town + "'";
			List<AttractionEdited> list = new ArrayList<AttractionEdited>();
			list= session.createQuery(hql).getResultList();			
			return list;
			
		}
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	
	public List<AttractionEdited> getAllAttraction() throws SQLException {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from AttractionEdited", AttractionEdited.class);
		@SuppressWarnings("unchecked")
		List<AttractionEdited> list = query.list();
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int insertAttraction(AttractionEdited ab) throws SQLException {
		
		int n = 0;
		System.out.println(ab.getName());
		String sql;
		Session session = factory.getCurrentSession();
		sql = " INSERT [dbo].[AttractionsEdited] ([name],"
				+ "[location], [tel], [region], [town])" + " VALUES (?,?,?,?,?)";
	    Query query = session.createSQLQuery(sql);
	    
		query.setParameter(1, ab.getName());
		query.setParameter(2, ab.getLocation());
		query.setParameter(3, ab.getTel());
		query.setParameter(4, ab.getRegion());
		query.setParameter(5, ab.getTown());
        query.executeUpdate();

        return n;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int deleteAttraction(Integer id) throws SQLException {
		int n = 0;
		Session session = factory.getCurrentSession();
		
		Query query = session.createQuery("delete AttractionEdited where id= :id");
	    query.setParameter("id", id);
	    query.executeUpdate();
	    
	    return n;
	}
	
	@Override
	public int updateAttraction(AttractionEdited ab) throws SQLException {
		int n = 0;
		Session session = factory.getCurrentSession();

		session.saveOrUpdate(ab);
		return n;
	}
	
	@Override
	public AttractionEdited searchById(Integer id) throws SQLException {
		Session session = factory.getCurrentSession();
		String hql="from AttractionEdited a where a.id=:id";
		AttractionEdited ab =(AttractionEdited)session.createQuery(hql).setParameter("id", id).getSingleResult();
		return ab;
		
	}

}