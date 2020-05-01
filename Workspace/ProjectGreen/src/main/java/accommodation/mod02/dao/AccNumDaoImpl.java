package accommodation.mod02.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import accommodation.mod02.model.AccNumBean;

public class AccNumDaoImpl implements AccNumDao {

	String resource = "java:comp/env/jdbc/DB";

	@Override
	public void insertAccNum() {
		String sql = "insert distinct Town from AccommodationNum where Region =?";
		List<String> list = new ArrayList<String>();
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					list.add(rs.getString(1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public String updateBookNum(int hotel) {

		String sql = "update AccommodationNum set BookNum += 1 where HotelID = " + hotel;
//		AccNumBean ab = null;
//		List<String> list = new ArrayList<String>();
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					) {
				pstmt.executeUpdate();
				System.out.println("== BookNum +1 ==");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}return "NUM+1";
	}

	@Override
	public int getHotelId(String hotel) {
		String sql = "select ID from Accommodation where Name = '" + hotel + "'";
		int hotelId = 0;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					hotelId = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return hotelId;
	}

	@Override
	public void updateViewNum(int hotel) {
		String sql = "update AccommodationNum set ViewNum += 1 where HotelID = " + hotel;
//		AccNumBean ab = null;
//		List<String> list = new ArrayList<String>();
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					) {
				pstmt.executeUpdate();
				System.out.println("== ViewNum +1 ==");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
