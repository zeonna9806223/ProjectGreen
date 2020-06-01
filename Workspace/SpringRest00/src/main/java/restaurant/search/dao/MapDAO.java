package restaurant.search.dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import transportation.mrt.model.TaipeiMRTExit;
import transportation.ubike.model.YouBikeNTPC;
import transportation.ubike.model.YouBikeTPC;


@Repository
public class MapDAO implements IMapDao{
	
	@Autowired
	SessionFactory factory;
	
	public MapDAO() {}
	
	@SuppressWarnings({"unchecked", "rawtypes" })
	@Override
	public List<String> mapYoubikeTP() {
		System.out.println("台北市DAO");
		Session session = factory.getCurrentSession();
        Query query = session.createQuery("from YouBikeTPC",YouBikeTPC.class);
        List<String> list = new ArrayList<>();
        list= query.list();  
        return list;    
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<String> mapYoubikeNTP() {
		System.out.println("新北市DAO");
		Session session = factory.getCurrentSession();
        Query query = session.createQuery("from YouBikeNTPC",YouBikeNTPC.class);
        List<String> list = new ArrayList<>();
        list= query.list();  
        
        return list;    
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<String> mapMRT() {
		Session session = factory.getCurrentSession();
        Query query = session.createQuery("from TaipeiMRTExit",TaipeiMRTExit.class);
        List<String> list = new ArrayList<>();
        list= query.list();  

        return list;    
	}

}
