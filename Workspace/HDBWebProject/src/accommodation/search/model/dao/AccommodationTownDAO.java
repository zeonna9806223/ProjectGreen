package accommodation.search.model.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;


public class AccommodationTownDAO implements IAccommodationTownDAO{

	private Session session;
	private SessionFactory factory;

	public AccommodationTownDAO() {
	}

	public AccommodationTownDAO(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public Session getSession() {
		return session = factory.getCurrentSession();
	}

	@Override
	public String getRegionName(String regionId) {
		String sql = "select distinct region from AccommodationTown where regionId = ?1";
		Query<String> query = getSession().createQuery(sql);
		query.setString(1, " " + regionId);
		List<String> list = query.list();
		return list.get(0);
	}

	@Override
	public String getTownName(String townId) {
		String sql = "select town from AccommodationTown where townId = ?1";
		Query<String> query = getSession().createQuery(sql);
		query.setString(1, " " + townId);
		List<String> list = query.list();
		return list.get(0);
	}
	
	@Override
	public List<Map> townChoice(String region) {
		String sql = "select distinct new map ( town as town, townId as townId ) from AccommodationTown where region = ?1";
		Query<Map> query = getSession().createQuery(sql);
		query.setString(1, region);
		List<Map> list = query.list();
		return list;
	}
}
