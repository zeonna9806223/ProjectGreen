package accommodation.edit.service;

import java.util.List;
import java.util.Map;

import accommodation.edit.model.EditDao;
import accommodation.edit.model.EditJdbcDao;
import accommodation.edit.model.EditBean;
import accommodation.edit.service.EditService;

public class EditServiceImpl implements EditService {

	@Override
	public List<Object> Region() {
		EditDao dao = new EditJdbcDao();
		return dao.Region();
	}

	@Override
	public List<Object> Town(String region) {
		EditDao dao = new EditJdbcDao();
		return dao.Town(region);
	}

	@Override
	public String regionToTown(String region) {
		EditDao dao = new EditJdbcDao();
		return dao.regionToTown(region);
	}

	@Override
	public void insertA(EditBean forInsertA) {
		EditDao dao = new EditJdbcDao();
		dao.insertA(forInsertA);
	}

	@Override
	public void insertM(EditBean forInsertM) {
		EditDao dao = new EditJdbcDao();
		dao.insertM(forInsertM);
	}

	@Override
	public void insertE(EditBean newHotel, EditBean hotelEditor, String status) {
		EditDao dao = new EditJdbcDao();
		dao.insertE(newHotel, hotelEditor, status);
	}

	@Override
	public EditBean findUser() {
		EditDao dao = new EditJdbcDao();

		return dao.findUser();
	}

	@Override
	public EditBean findUserHotel(String user) {
		EditDao dao = new EditJdbcDao();
		return dao.findUserHotel(user);
	}

	@Override
	public void update(EditBean newHotel) {
		EditDao dao = new EditJdbcDao();
		dao.update(newHotel);
	}

	@Override
	public void delete(String hname) {
		EditDao dao = new EditJdbcDao();
		dao.delete(hname);
		
	}

	@Override
	public String getRegionName(String RegionId) {
		EditDao dao = new EditJdbcDao();
		return dao.getRegionName(RegionId);
	}

}
