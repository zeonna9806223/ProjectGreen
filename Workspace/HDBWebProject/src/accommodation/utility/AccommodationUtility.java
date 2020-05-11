package accommodation.utility;

import java.util.List;
import java.util.Map;

public class AccommodationUtility {
	
	public String jsonParse(List<Map> list) {
		String json = "[";
		json += "{\"value\":\" 0 \",\"text\":\"請選擇 \"},";
		for (int i = 0; i < list.size(); i++) {
			json += "{\"value\":\"" + list.get(i).get("townId") + "\",\"text\":\"" + list.get(i).get("town") + "\"},";
		}
		json = json.substring(0, (json.length() - 1));
		json += "]";
		return json;
	}
	
}
