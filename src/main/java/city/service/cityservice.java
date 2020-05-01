package city.service;

import java.util.List;

import citty.model.cityBean;
import citty.model.cityDao;
import citty.model.showBean;
import citty.model.showDao;

public class cityservice {
	cityDao cDao;
	showDao sDao;
	
	public cityservice() {
		cDao = new cityDao();
		sDao = new showDao();
	}
	public List<cityBean> city(){
		return cDao.city();
	}
	public List<showBean> show(String town){
		return sDao.show(town);
	}
}
