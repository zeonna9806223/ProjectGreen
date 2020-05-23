package restaurant.orderDAO;

import java.util.List;

import restaurant.orderBean.OrederBean;

public interface IOrderDAO {
	
	int insertBooking (OrederBean ob);
	int deleteBooking (OrederBean ob);
	List<OrederBean>selectBooking(OrederBean ob);
}
