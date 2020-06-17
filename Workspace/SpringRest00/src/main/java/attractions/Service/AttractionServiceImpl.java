package attractions.Service;

import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import attractions.Bean.AttractionEdited;
import attractions.Dao.AttractionsHibernateDaoImpl;

@Service
@Transactional
@EnableTransactionManagement
public class AttractionServiceImpl implements AttractionService{

	@Autowired
	AttractionsHibernateDaoImpl dao;
	
	@Override
	public List<AttractionEdited> search(String region, String town) throws SQLException {
    return dao.search(region,town);
}
	@Override
	public List<AttractionEdited> getAllAttraction() throws SQLException {
		return dao.getAllAttraction();
	}


	@Override
	public int insertAttraction(AttractionEdited ab) throws SQLException {
		
		return dao.insertAttraction(ab);
	}



	@Override
	public int deleteAttraction(Integer id) throws SQLException {
		return dao.deleteAttraction(id);
	}

	@Override
	public int updateAttraction(AttractionEdited ab) throws SQLException {
		return dao.updateAttraction(ab);
	}



	@Override
	public AttractionEdited searchById(Integer id) throws SQLException {
		
		return dao.searchById(id);
	}



}
	
	
