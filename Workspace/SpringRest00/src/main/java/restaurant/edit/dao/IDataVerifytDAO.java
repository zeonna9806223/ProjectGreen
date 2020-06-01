package restaurant.edit.dao;

import restaurant.model.DataVerifyBean;

public interface IDataVerifytDAO {
	
	Integer save(DataVerifyBean db);
	Integer query(DataVerifyBean db);
	Integer delete(DataVerifyBean db);

}
