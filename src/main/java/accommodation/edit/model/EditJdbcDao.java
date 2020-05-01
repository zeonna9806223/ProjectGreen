package accommodation.edit.model;

import java.net.NetPermission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import accommodation.edit.model.EditDao;
import accommodation.edit.model.EditBean;

public class EditJdbcDao implements EditDao {

	String resource = "java:comp/env/jdbc/DB";

	@Override
	public void update(EditBean newHotel) {
		
		String sql = "update Accommodation set Name=?, Address=?, RegionID=?, Region=?, TownID=?, Town=?, "
				+ "Tel=?, Website=?, LowestPrice=?, IndustryEmail=?  where Name=?";
		String sql2 = "select RegionID, Region, TownID, Town from AccommodationTown where TownID = ?";
		
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					PreparedStatement pstmt2 = con.prepareStatement(sql2);
			) {

				String name = newHotel.getHname();
				String tel = newHotel.getHtel();
				String email = newHotel.getHemail();
				String web = newHotel.getHweb();
				String rid = newHotel.getHregion();
				String tid = newHotel.getHtown();
				String addr = newHotel.getHaddr();
				String price = newHotel.getHprice();

				pstmt.setString(11, name);
				
				pstmt2.setString(1, tid);
				ResultSet rs2 = pstmt2.executeQuery();
				String r = null;
				String t2 = null;
				if (rs2.next()) {
					r = rs2.getString(2);
					t2 = rs2.getString(4);
				}

				int b = 1;
				pstmt.setString(b++, name);
				pstmt.setString(b++, addr);
				pstmt.setString(b++, rid);
				pstmt.setString(b++, r);
				pstmt.setString(b++, tid);
				pstmt.setString(b++, t2);
				pstmt.setString(b++, tel);
				pstmt.setString(b++, web);
				pstmt.setString(b++, price);
				pstmt.setString(b++, email);
				pstmt.executeUpdate();

				rs2.close();
				System.out.println("===Update===");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;

	}

	@Override
	public List<Object> Region() {
		String sql = "select distinct  RegionID, Region from Accommodation";
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<Object> list3 = new ArrayList<Object>();
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					list.add(rs.getString(1));
					list2.add(rs.getString(2));
				}
				list3.add(list);
				list3.add(list2);
			} catch (Exception e) {
				e.printStackTrace();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list3;
	}

	@Override
	public List<Object> Town(String region) {
		String sql = "select distinct TownID, Town from AccommodationTown where Region = '" + region + "'";
//		Map<String, String> map = new HashMap<String, String>();
		List<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		List<Object> list3 = new ArrayList<Object>();
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					list.add(rs.getString(1));
					list2.add(rs.getString(2));
				}
				list3.add(list);
				list3.add(list2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list3;
	}

	@Override
	public String regionToTown(String region) {
		System.out.println(region+"RRRRRRRRRRRRRRRRrrrrrr");
		String json = "[{\"value\":\" 0 \",\"text\":\"請選擇\"},";
		List<Object> list2 = Town(region);
		List<String> list = (List<String>) list2.get(1);
		if (region.equals("臺北市")) {
				for (int i = 0; i < list.size(); i++) {
			int j = i;
			json += "{\"value\":\"" + (++j) + "\",\"text\":\"" + list.get(i) + "\"},";
				}
		}else {
			for (int i = 0; i < list.size(); i++) {
				int j = i+12;
				json += "{\"value\":\"" + (++j) + "\",\"text\":\"" + list.get(i) + "\"},";
					}
		}
		System.out.println("AAAAAAA");
		json = json.substring(0, (json.length() - 1));
		json += "]";
		return json;

	}

	@Override
	public void insertA(EditBean newHotel) {
		String sql = "insert into Accommodation(Name, Address, RegionID, Region, TownID, Town, Tel, "
				+ "Website, LowestPrice, IndustryEmail) values (?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "select RegionID, Region, TownID, Town from AccommodationTown where TownID = ?";
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					PreparedStatement pstmt2 = con.prepareStatement(sql2);) {

				String name = newHotel.getHname();
				String tel = newHotel.getHtel();
				String email = newHotel.getHemail();
				String web = newHotel.getHweb();
				String rid = newHotel.getHregion();// 數字字串
				String tid = newHotel.getHtown();
				String addr = newHotel.getHaddr();
				String price = newHotel.getHprice();

//				System.out.println(name);
				pstmt2.setString(1, tid);
				ResultSet rs2 = pstmt2.executeQuery();

				String r = null;
				String t = null;
				if (rs2.next()) {
					r = rs2.getString(2);
					t = rs2.getString(4);
//					System.out.println(r+t);
				}

				int b = 1;
				pstmt.setString(b++, name);
				pstmt.setString(b++, addr);
				pstmt.setString(b++, rid);
				pstmt.setString(b++, r);
				pstmt.setString(b++, tid);
				pstmt.setString(b++, t);
				pstmt.setString(b++, tel);
				pstmt.setString(b++, web);
				pstmt.setString(b++, price);
				pstmt.setString(b++, email);
				pstmt.executeUpdate();
//				System.out.println(a);

				rs2.close();
				System.out.println("===insertA===");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;

	}

	@Override
	public void insertM(EditBean hotelEditor) {
		String sql = "insert into EditMembers (Name, Tel, Email) values (?,?,?)";

		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

				int b = 1;
				pstmt.setString(b++, hotelEditor.getUname());
				pstmt.setString(b++, hotelEditor.getUtel());
				pstmt.setString(b++, hotelEditor.getUemail());
				pstmt.executeUpdate();
				System.out.println("====insertM====");

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;
	}

	@Override
	public void insertE(EditBean newHotel, EditBean hotelEditor, String status) {
		String sql = "insert into EditDetail  values (?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "select ID from Accommodation where Name = ? ";
		String sql3 = "select pk from EditMembers where Name = ?";
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					PreparedStatement pstmt2 = con.prepareStatement(sql2);
					PreparedStatement pstmt3 = con.prepareStatement(sql3);) {
				int hotelID = 0;

				
				pstmt2.setString(1, newHotel.getHname());
				ResultSet rs2 = pstmt2.executeQuery();
				
				
				if (rs2.next()) {
					hotelID = rs2.getInt(1);
				}
//				System.out.println(hotelID);
				
				pstmt3.setString(1, hotelEditor.getUname());
				ResultSet rs3 = pstmt3.executeQuery();
				int EditorID = 0;
				if (rs3.next()) {
					EditorID = rs3.getInt(1);
				}

				Date date = new Date();
				Timestamp ts = new Timestamp(date.getTime());

				String name = newHotel.getHname();
				String tel = newHotel.getHtel();
				String email = newHotel.getHemail();
				String web = newHotel.getHweb();
				String rid = newHotel.getHregion();
//				System.out.println(rid);

				String tid = newHotel.getHtown();
				String addr = newHotel.getHaddr();
				int price = new Integer(newHotel.getHprice());

				int a = 1;

				pstmt.setInt(a++, EditorID);
				pstmt.setTimestamp(a++, ts);
				pstmt.setInt(a++, hotelID);
				pstmt.setString(a++, name);
				pstmt.setString(a++, rid);
				pstmt.setString(a++, tid);
				pstmt.setString(a++, addr);
				pstmt.setString(a++, tel);
				pstmt.setString(a++, email);
				pstmt.setString(a++, web);
				pstmt.setInt(a++, price);
				pstmt.setString(a++, status);

				pstmt.executeUpdate();

				rs3.close();
				rs2.close();
				System.out.println("====insertE====");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;
	}

	public void updateE(EditBean newHotel, EditBean hotelEditor, String status) {
		String sql = "insert into EditDetail  values (?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 = "select ID from Accommodation where Name = ? ";
		String sql3 = "select pk from EditMembers where Name = ?";
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					PreparedStatement pstmt2 = con.prepareStatement(sql2);
					PreparedStatement pstmt3 = con.prepareStatement(sql3);) {
				int hotelID = 0;

				pstmt3.setString(1, hotelEditor.getUname());
				ResultSet rs3 = pstmt3.executeQuery();
				int EditorID = 0;
				if (rs3.next()) {
					EditorID = rs3.getInt(1);
				}
				
				pstmt2.setString(1, newHotel.getHname());
				ResultSet rs2 = pstmt2.executeQuery();

				if (rs2.next()) {
					hotelID = rs2.getInt(1);
				}
				
//				System.out.println(hotelID);
				
				Date date = new Date();
				Timestamp ts = new Timestamp(date.getTime());

				String name = newHotel.getHname();
				String tel = newHotel.getHtel();
				String email = newHotel.getHemail();
				String web = newHotel.getHweb();
				String rid = newHotel.getHregion();
//				System.out.println(rid);

				String tid = newHotel.getHtown();
				String addr = newHotel.getHaddr();
				int price = new Integer(newHotel.getHprice());

				int a = 1;

				pstmt.setInt(a++, EditorID);
				pstmt.setTimestamp(a++, ts);
				pstmt.setInt(a++, hotelID);
				pstmt.setString(a++, name);
				pstmt.setString(a++, rid);
				pstmt.setString(a++, tid);
				pstmt.setString(a++, addr);
				pstmt.setString(a++, tel);
				pstmt.setString(a++, email);
				pstmt.setString(a++, web);
				pstmt.setInt(a++, price);
				pstmt.setString(a++, status);

				pstmt.executeUpdate();

				rs3.close();
				rs2.close();
				System.out.println("====insertE====");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return;
	}

	
	@Override
	public EditBean findUserHotel(String user) {
		String sql = "select pk from EditMembers where Name =?";
		String sql2 = "select HotelID from EditDetail where EditorID = ? and status <> 'delete'";
		String sql3 = "select name, address, RegionID, Region, TownID,town, tel, website,LowestPrice, IndustryEmail  from Accommodation"
				+ " where id =?";

		EditBean eb2 = null;
		int upk = 0;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					PreparedStatement pstmt3 = con.prepareStatement(sql3);
					PreparedStatement pstmt2 = con.prepareStatement(sql2);) {

				pstmt.setString(1, user);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					upk = rs.getInt(1);
					System.out.println(upk);
				}
				
				pstmt2.setInt(1, upk);
				ResultSet rs2 = pstmt2.executeQuery();
				List<Integer> hotelIdlLsit = new ArrayList<Integer>();
				while (rs2.next()) {
					hotelIdlLsit.add(rs2.getInt(1));
					System.out.println(hotelIdlLsit);
				}
				pstmt3.setInt(1, hotelIdlLsit.get(0));//只拿第一筆
				System.out.println(hotelIdlLsit.get(0));
//				String whereId = hotelIdlLsit.get(0) + "";
//				if (hotelIdlLsit.size() < 2) {
//					pstmt3.setInt(1, hotelIdlLsit.get(0));
//					System.out.println(hotelIdlLsit.get(0));
//
//				} else {
//					for (int i = 1; i < hotelIdlLsit.size(); i++) {
//						pstmt3.setInt(1, hotelIdlLsit.get(0));
//						sql3 += " or id= " + hotelIdlLsit.get(i);
//					}
////					pstmt3.setString(1, whereId);
//				}

//				System.out.println(whereId);
				ResultSet rs3 = pstmt3.executeQuery();
				while (rs3.next()) {

					eb2 = new EditBean(rs3.getString(1), rs3.getString(2), rs3.getString(3), rs3.getString(4),
							rs3.getString(5), rs3.getString(6), rs3.getString(7), rs3.getString(8), rs3.getInt(9),
							rs3.getString(10));

//					System.out.println(rs3.getString(10));
				}
				rs2.close();
				rs3.close();
			}
			System.out.println("====findUserHotel====");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eb2;

	}

	@Override
	public EditBean findUser() {
		String sql = "select Name from EditMembers ";

		EditBean eb = new EditBean();
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
				eb.setUserName(list);
			}
			System.out.println("====findUser====");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return eb;
	}

	@Override
	public void delete(String hname) {
		String sql = "delete  from Accommodation where Name=?";
		System.out.println(hname);
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
				pstmt.setString(1, hname);
				pstmt.executeUpdate();
			}
			System.out.println("====delete====");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getRegionName(String RegionId) {
		if (RegionId.equals("1")) {
			return "臺北市";
		} else {
			return "新北市";
		}
	}

	@Override
	public EditBean regionTown(String townId) {
		String sql = "select RegionID, Region, TownID, Town from AccommodationTown where TownID = ?";
		EditBean eBean = null;
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

				pstmt.setString(1, townId);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					eBean = new EditBean(rs.getString(2), rs.getString(1), rs.getString(4), rs.getInt(3));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eBean;

	}
}
