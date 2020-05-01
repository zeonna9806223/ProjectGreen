package accommodation.search;

import java.util.List;
import java.util.Map;

public interface SearchDao {
	
	String resource = "java:comp/env/jdbc/DB";

	List<String> regionChoice();
	List<String> townChoice(String region);
	Map<Integer, TestBean> hotelChoice(String town);
	Map<String, TestBean42> hotelInfo(String hotel);
	String jsonParse(List<String> list) ;


}
