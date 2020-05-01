package citty.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

//import com.mysql.cj.xdevapi.Result;

public class cityDao {
	private DataSource ds = null;
	
	public cityDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/ProjectGreen");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<cityBean> city(){
		String city = "Select Distinct region,town from AttractionsEdited";
		
		List<cityBean> cityBeans = new ArrayList();
		
		try (
				Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(city);
				ResultSet rs = pstmt.executeQuery();				
		){
			String r = null;
			String t = null;
//			List<String> rlist = new ArrayList<>();
//			List<String> tList = new ArrayList<>();
			while (rs.next()) {
//				cityBean cb = new cityBean(rs.getString("Region"),rs.getString("Town"));
				if((rs.getString("Region") != r || rs.getString("Town") != t)) {
					cityBean cb = new cityBean(rs.getString("Region"),rs.getString("Town"));
					cityBeans.add(cb);
				}
				r = rs.getString("Region");
				t = rs.getString("Town");			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cityBeans;
	}
}
