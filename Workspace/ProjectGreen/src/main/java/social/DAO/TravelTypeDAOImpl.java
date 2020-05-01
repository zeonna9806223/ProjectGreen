package social.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import social.bean.RestaurantTypeBean;
import social.bean.TravelTypeBean;

public class TravelTypeDAOImpl implements TravelTypeDAO {

	String jndiString = "java:comp/env/" + "jdbc/ProjectGreen";
//	String jndiString = "java:comp/env/" + "juntos/social";
	// *****context的NAMEEEEEEEEEEEEEEEEEEEEEEEEEEEE
	DataSource ds;

	// *****預設建構連線參數
	public TravelTypeDAOImpl() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(jndiString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

//	@Override
	public List<TravelTypeBean> queryTravelTypes() {
		List<TravelTypeBean> tTypes = new ArrayList<>();
		String sql = "SELECT Definition FROM [Attractions.Category] ";
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				TravelTypeBean rst = new TravelTypeBean(rs.getString(1));
				tTypes.add(rst);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別發生SQL例外: " + ex.getMessage());
		}
		return tTypes;
	}
}
