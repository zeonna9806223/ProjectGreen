package accommodation.search.service;

import java.util.List;
import java.util.Map;

public interface IAccommodationTownService {
	public String getRegionName(String regionId);
	public String getTownName(String townId);
	public List<Map> townChoice(String region);
}
