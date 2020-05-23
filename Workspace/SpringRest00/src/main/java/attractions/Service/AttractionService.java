package attractions.Service;

import java.sql.SQLException;
import java.util.List;

import attractions.Bean.AttractionEdited;

public interface AttractionService {

	List<AttractionEdited> getAllAttraction() throws SQLException;

	List<AttractionEdited> search(String region, String town)throws SQLException;

	AttractionEdited searchById(Integer id) throws SQLException;
	
	int insertAttraction(AttractionEdited ab) throws SQLException ;
	int deleteAttraction(Integer id) throws SQLException ;
	int updateAttraction(AttractionEdited ab) throws SQLException ;
//	Boolean restauranExists(String name);
}
