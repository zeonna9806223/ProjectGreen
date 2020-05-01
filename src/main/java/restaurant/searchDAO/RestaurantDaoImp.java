package  restaurant.searchDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import restaurant.model.RestaurantBean;

public class RestaurantDaoImp implements IRestarurantDao {
//	Context ctx;
	// String jndiLookup = SystemConfiguration.getJndiLookup();
	String jndiLookup = "java:comp/env/jdbc/ProjectGreen";
	DataSource ds;
	public RestaurantDaoImp() {

		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(jndiLookup);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<RestaurantBean> search(String type,String zone) {
		List<RestaurantBean> searchRestaurant = new ArrayList<>();
		String sql;
		if ((!zone.equals("請選擇") )&& (!type.equals("請選擇"))) {
			sql = " select * from ResturantInfo where ( RestaurantType= ? and RestaurantZone =?)";
			try (Connection conn = ds.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);
					) {
				
				stmt.setString(1,type);
				stmt.setString(2,zone);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					RestaurantBean rest = new RestaurantBean(rs.getInt("restaurantID"),
							rs.getString("restaurantType"),	rs.getString("restaurantName"),
							rs.getString("restaurantZone"),rs.getString("restaurantAddress"),
							rs.getString("restaurantPx"), rs.getString("restaurantPy"),
							rs.getString("restaurantPhone"));
					searchRestaurant.add(rest);
				}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		else if (zone.equals("請選擇") && (!type.equals("請選擇"))) {
			sql = "select * from ResturantInfo where RestaurantType= ?";
			try (Connection conn = ds.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);
					) {
//				System.out.println("type");
				stmt.setString(1,type);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					RestaurantBean rest = new RestaurantBean(rs.getInt("restaurantID"), rs.getString("restaurantType"),
							rs.getString("restaurantName"), rs.getString("restaurantZone"),
							rs.getString("restaurantAddress"), rs.getString("restaurantPx"), rs.getString("restaurantPy"),
							rs.getString("restaurantPhone"));
					searchRestaurant.add(rest);
				}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}else{
			sql = "select * from ResturantInfo where RestaurantZone= ?";
			try (Connection conn = ds.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);
					) {
//				System.out.println("zone");
				stmt.setString(1,zone);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {	
					RestaurantBean rest = new RestaurantBean(rs.getInt("restaurantID"), rs.getString("restaurantType"),
							rs.getString("restaurantName"), rs.getString("restaurantZone"),
							rs.getString("restaurantAddress"), rs.getString("restaurantPx"), rs.getString("restaurantPy"),
							rs.getString("restaurantPhone"));
					System.out.println(rs.getInt("restaurantID")+ rs.getString("restaurantType")+
							rs.getString("restaurantName")+ rs.getString("restaurantZone")+
							rs.getString("restaurantAddress")+ rs.getString("restaurantPx")+ rs.getString("restaurantPy")+
							rs.getString("restaurantPhone"));
					searchRestaurant.add(rest);
				}
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	
		return searchRestaurant;
	}

	@Override

	public List<RestaurantBean> getAllRestaurant() throws SQLException {

		// DataSource ds = (DataSource) ctx.lookup(jndiLookup);
		List<RestaurantBean> queryresult = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * from  ResturantInfo");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				RestaurantBean rest = new RestaurantBean(rs.getInt("restaurantID"), rs.getString("restaurantType"),
						rs.getString("restaurantName"), rs.getString("restaurantZone"),
						rs.getString("restaurantAddress"), rs.getString("restaurantPx"), rs.getString("restaurantPy"),
						rs.getString("restaurantPhone"));
				
				queryresult.add(rest);
			}
		}
		return queryresult;
	}

	@Override
	public List<RestaurantBean> searchName(String name) throws SQLException {
		List<RestaurantBean> queryresult = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * from  ResturantInfo");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				RestaurantBean rest = new RestaurantBean(rs.getInt("restaurantID"), rs.getString("restaurantType"),
						rs.getString("restaurantName"), rs.getString("restaurantZone"),
						rs.getString("restaurantAddress"), rs.getString("restaurantPx"), rs.getString("restaurantPy"),
						rs.getString("restaurantPhone"));
				queryresult.add(rest);
			}
		}
		return queryresult;
	}

	@Override
	public List<RestaurantBean> searchZone(String zone) throws SQLException {
		List<RestaurantBean> queryresult = new ArrayList<>();
		try (Connection conn = ds.getConnection();
				PreparedStatement stmt = conn.prepareStatement("SELECT * from  ResturantInfo");
				ResultSet rs = stmt.executeQuery();) {
			while (rs.next()) {
				RestaurantBean rest = new RestaurantBean(rs.getInt("restaurantID"), rs.getString("restaurantType"),
						rs.getString("restaurantName"), rs.getString("restaurantZone"),
						rs.getString("restaurantAddress"), rs.getString("restaurantPx"), rs.getString("restaurantPy"),
						rs.getString("restaurantPhone"));
				queryresult.add(rest);
			}
		}
		return queryresult;
	}
	
	
	@Override
	public Boolean restauranExists(String name) {
		boolean exist = false;
		String sql = "SELECT * FROM ResturantInfo WHERE RestaurantName = ?";
		try (
				Connection connection = ds.getConnection(); 
				PreparedStatement ps = connection.prepareStatement(sql);
			) {
				ps.setString(1, name);
				try (ResultSet rs = ps.executeQuery();) {
					if (rs.next()) {
						exist = true;
					}
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				throw new RuntimeException("MemberDaoImpl_Jdbc類別#idExists()發生例外: " 
						+ ex.getMessage());
			}
			return exist;
	}
	
	@Override
	public int insertRestaurant(RestaurantBean rb) throws SQLException {
		String sql;
		int n=0;
			sql = " INSERT [dbo].[ResturantInfo] ( [RestaurantType], "
					+ "[RestaurantName], [RestaurantZone], [RestaurantAddress], "
					+ "[RestaurantPx], [RestaurantPy], [RestaurantPhone])"
					+ " VALUES (?,?,?,?,?,?,?)";
			try (Connection conn = ds.getConnection();
					PreparedStatement stmt = conn.prepareStatement(sql);
					) {
	
				//stmt.setInt(1, rb.getRestaurantID());
				stmt.setString(1, rb.getRestaurantType());
				stmt.setString(2, rb.getRestaurantName());
				stmt.setString(3, rb.getRestaurantZone());
				stmt.setString(4, rb.getRestaurantAddress());
				stmt.setString(5, rb.getRestaurantPx());
				stmt.setString(6, rb.getRestaurantPy());
				stmt.setString(7, rb.getRestaurantPhone());
				stmt.executeUpdate();
				
				
			
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return n;
	}

	

}
