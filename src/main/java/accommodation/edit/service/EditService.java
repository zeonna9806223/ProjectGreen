package accommodation.edit.service;

import java.util.List;
import java.util.Map;

import accommodation.edit.model.EditBean;

public interface EditService {
	
	List<Object>Region();
	List<Object>Town(String region);
	String regionToTown(String region);
	void insertA(EditBean newHotel);
	void insertM(EditBean hotelEditor);
	void insertE(EditBean newHotel, EditBean hotelEditor, String status);
	EditBean findUser();
	EditBean findUserHotel(String user);
	void delete(String hname);
	void update(EditBean newHotel);
	String getRegionName(String RegionId);
}
