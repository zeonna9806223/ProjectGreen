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

public class showDao {
	private DataSource ds = null;
	
	public showDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/ProjectGreen");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<showBean> show(String town){
		String city = "Select * from AttractionsEdited WHERE Town = ?";
		
		List<showBean> showBeans = new ArrayList();
		
		try {
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(city);
			pstmt.setString(1, town);
			ResultSet rs = pstmt.executeQuery();
			String r = null;
			String t = null;
			while (rs.next()) {
				showBean sb = new showBean(rs.getString("Name"),rs.getString("Tel"),rs.getString("Add"));
				showBeans.add(sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return showBeans;
	}
}
//			List<String> rlist = new ArrayList<>();
//			List<String> tList = new ArrayList<>();
//				cityBean cb = new cityBean(rs.getString("Region"),rs.getString("Town"));
//				if((rs.getString("Region") != r || rs.getString("Town") != t)) {
//					showBean sb = new showBean(rs.getString("Name"),rs.getString("Tel"),rs.getString("Add"));
//					showBeans.add(sb);
//				}
//				r = rs.getString("Region");
//				t = rs.getString("Town");			
