package social.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import javax.naming.InitialContext;

import social.model.MemberBean2;

public class UserDao {
	//JNDI以名尋物
	String jndiString = "java:comp/env" + "jdbc/BookDataSQLver";
	
	DataSource ds;
	
	//建構子
	public UserDao(){

		try {
			//透過JNDI搜尋
			InitialContext ctx = new InitialContext();
			ds =(DataSource)ctx.lookup(jndiString);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
	

	public List<MemberBean2> queryUsers() {
		//<>型別寫一次即可
		List<MemberBean2> allMembers = new ArrayList<>();
		//每抓到一筆資料放到MemberBean,每個Membean放到List
		
		String sql = "SELECT * FROM Member2";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()
		) {
				//只要還有下一筆資料，就取出
				while (rs.next()) {
					//get成java型別資料
					MemberBean2 mem = new MemberBean2(rs.getInt(1),rs.getString(2),rs.getString(3),
													rs.getString(4),rs.getInt(5),rs.getDate(6),
													rs.getString(7),rs.getString(8),rs.getString(9),
													rs.getTimestamp(10),rs.getInt(11),rs.getString(12));
					//最後裝入allmembers裡
					allMembers.add(mem);
			}
		
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#queryMember()發生例外: " 
					+ ex.getMessage());
		}
		return allMembers;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
