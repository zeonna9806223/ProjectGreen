package restaurant.booking_S;

import restaurant.bookingDAO.BookingDAOImp;
import restaurant.bookingDAO.IBookingDAO;
import restaurant.model.BookingBean;

public class BookingServiceImp implements IBookingService {
	IBookingDAO dao;

	public BookingServiceImp() {
		this.dao = new BookingDAOImp();
	}

	@Override
	public int insertBooking(BookingBean bb) {

		return dao.insertBooking(bb);
	}

}
