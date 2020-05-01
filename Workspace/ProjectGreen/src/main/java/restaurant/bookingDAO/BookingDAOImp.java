package restaurant.bookingDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import restaurant.model.BookingBean;

public class BookingDAOImp implements IBookingDAO {
	
	String jndiLookup = "java:comp/env/jdbc/ProjectGreen";
	DataSource ds;
	public BookingDAOImp() {

		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(jndiLookup);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insertBooking(BookingBean bb) {
		String sql;
		int n=0;
			sql = " INSERT [dbo].[ResturantOrderInfo] ( [RestaurantID], "
					+ "[MemberID], [NumberOfPeople], [ReservationDate], "
					+ "[ReservationTime], [ReservationUnder], [ContactPhone]"
					+ ", [Remark], [OrderTime]) VALUES (?,?,?,?,?,?,?,?,?)";
			try (Connection conn = ds.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);
					) {
	
				//stmt.setInt(1, rb.getRestaurantID());
				stmt.setInt(1, bb.getRestaurantID());
				stmt.setInt(2, bb.getMemberID());
				stmt.setInt(3, bb.getNumberOfPeople());
				Date d = new Date(bb.getReservationDate().getTime());
				stmt.setDate(4,d);
				Time t= new Time(bb.getReservationTime().getTime());
				stmt.setTime(5, t);
				stmt.setString(6, bb.getReservationUnder());
				stmt.setString(7, bb.getContactPhone());
				stmt.setString(8, bb.getRemark());
				
				Timestamp ts = new Timestamp(bb.getOrderTimestamp().getTime());
				stmt.setTimestamp(9,ts);
				stmt.executeUpdate();
				
				
			
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return n;
	}
	
	
	

}
