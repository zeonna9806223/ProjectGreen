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

public class RestaurantTypeDAOImpl implements RestaurantTypeDAO {

	String jndiString = "java:comp/env/" + "jdbc/ProjectGreen";
//	String jndiString = "java:comp/env/" + "juntos/social";
	// *****context的NAMEEEEEEEEEEEEEEEEEEEEEEEEEEEE
	DataSource ds;

	// *****預設建構連線參數
	public RestaurantTypeDAOImpl() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(jndiString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

//	@Override
	public List<RestaurantTypeBean> queryRestaurantTypes() {
		List<RestaurantTypeBean> resTypes = new ArrayList<>();
		String sql = "SELECT distinct RestaurantType FROM Resturants ";
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				RestaurantTypeBean rst = new RestaurantTypeBean(rs.getString(1));
				resTypes.add(rst);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別發生SQL例外: " + ex.getMessage());
		}
		return resTypes;
	}
}
