package accommodation.edit.model;

import java.util.List;
import java.util.Map;

import accommodation.edit.model.EditBean;

public interface EditDao {
	
	List<Object>Region();
	List<Object>Town(String region);
	String regionToTown(String region);
	String getRegionName(String RegionId);
	EditBean regionTown(String townId);
	EditBean findUser();
	EditBean findUserHotel(String user);
	void insertA(EditBean newHotel);
	void insertM(EditBean hotelEditor);
	void insertE(EditBean newHotel, EditBean hotelEditor, String status);
	void delete(String hname);
	void update(EditBean newHotel);
	

}
