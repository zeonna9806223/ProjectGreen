package accommodation.search.model.dao;

import java.util.List;
import java.util.Map;

public interface IAccommodationTownDAO {

	public String getRegionName(String regionId);
	public String getTownName(String townId);
	public List<Map> townChoice(String region);
}
