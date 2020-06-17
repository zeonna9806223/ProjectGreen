package restaurant.orderDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;


import javax.sql.DataSource;

import restaurant.orderBean.OrederBean;

public class OrderDAOImp implements IOrderDAO {
	
	String jndiLookup = "java:comp/env/jdbc/ProjectGreen";
	DataSource ds;
	public OrderDAOImp() {

//		try {
//			InitialContext ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup(jndiLookup);
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public int insertBooking(OrederBean bb) {
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

	@Override
	public int deleteBooking(OrederBean ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrederBean> selectBooking(OrederBean ob) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
