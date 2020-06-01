package restaurant.orderService;

import restaurant.orderBean.OrederBean;
import restaurant.orderDAO.IOrderDAO;
import restaurant.orderDAO.OrderDAOImp;

public class BookingServiceImp implements IBookingService {
	IOrderDAO dao;

	public BookingServiceImp() {
		this.dao = new OrderDAOImp();
	}

	@Override
	public int insertBooking(OrederBean bb) {

		return dao.insertBooking(bb);
	}

}
