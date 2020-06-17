package social.model.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

public interface TravelTypeDAO {

	public List<String> queryTravelTypes();
	
}