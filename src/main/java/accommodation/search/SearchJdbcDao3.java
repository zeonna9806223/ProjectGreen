package accommodation.search;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SearchJdbcDao3 implements SearchDao{

	String resource = "java:comp/env/jdbc/DB";
	
	public String jsonParse(List<String> list) {
//	SearchJdbcDao3 ss = new SearchJdbcDao3();
	String json = "[";
	json += "{\"value\":\" 0 \",\"text\":\"請選擇 \"},";
//	List<String> list5 = ss.townChoice(region);
	for (int i = 0; i < list.size(); i++) {
		int j = i;
		json += "{\"value\":\"" + list.get(i) + "\",\"text\":\"" + list.get(i) + "\"},";
	}
//	System.out.println(json);
	json = json.substring(0, (json.length() - 1));
	json += "]";
	return json;
	}

	public List<String> regionChoice() {
		String sql = "select distinct Region from Accommodation";
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
		return list;
	}

	public List<String> townChoice(String region) {
		String sql = "select distinct Town from Accommodation where Region = '" + region + "'";
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
		return list;
	}

//	public List<String> hotelChoice(String town) {
////	public Map<String,Object> hotelChoice(String town) {
////		String sql = "select Name, Tel, Email, LowestPrice from Accommodation where Town = '" + town + "'";
////		String sql = "select Name, Tel, IndustryEmail, LowestPrice from Accommodation where Town = '" + "大安區" + "'";
//		String sql = "select Name from Accommodation where Town = '大安區'";
////		Map<String,Object> map = new HashMap<String,Object>();
//		List<String> list = new ArrayList<String>();
//		try {
//			InitialContext context = new InitialContext();
//			DataSource ds = (DataSource) context.lookup(resource);
//			try (Connection con = ds.getConnection();
//					PreparedStatement pstmt = con.prepareStatement(sql);
//					ResultSet rs = pstmt.executeQuery();) {
//				while (rs.next()) {
//					list.add(rs.getString(1));
//					list.add(rs.getString(2));
//					list.add(rs.getString(3));
//					list.add(rs.getString(4));
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return list;
//	}
//}

	public Map<Integer, TestBean> hotelChoice(String town) {
//	public Map<String,Object> hotelChoice(String town) {
		String sql = "select Name, Tel, Address, LowestPrice from Accommodation where Town = '" + town + "'";
//		String sql = "select Name, Tel, IndustryEmail, LowestPrice from Accommodation where Town = '" + "大安區" + "'";
//		String sql = "select Name from Accommodation where Town = '大安區'";
//		Map<String,Object> map = new HashMap<String,Object>();
		TestBean tb;
		Map<Integer, TestBean> map = new HashMap<Integer, TestBean>();
//		List<List<String>> hoteIinfoList = new ArrayList<>();
//		List<String> listName = new ArrayList<String>();
//		List<String> listTel = new ArrayList<String>();
//		List<String> listEmail = new ArrayList<String>();
//		List<String> listLowPrice = new ArrayList<String>();
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();) {
				int i = 0;
				while (rs.next()) {
					tb = new TestBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
					map.put(i++, tb);

//					listName.add(rs.getString(1));
//					listTel.add(rs.getString(2));
//					listEmail.add(rs.getString(3));
//					listLowPrice.add(rs.getString(4));
				}

//				hoteIinfoList.add(listName);
//				hoteIinfoList.add(listTel);
//				hoteIinfoList.add(listEmail);
//				hoteIinfoList.add(listLowPrice);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return map;
	}

	public Map<String, TestBean42> hotelInfo(String hotel) {
//public Map<String,Object> hotelChoice(String town) {
//String sql = "select Name, Tel, IndustryEmail, LowestPrice from Accommodation where Name = '" + hotel + "'";
		String sql = "select Address, Tel, IndustryEmail, Website, LowestPrice, Px, Py , Picture1, Picdescribe1, Picture2, Picdescribe2, Picture3, Picdescribe3 "
				+ "from Accommodation where Name = '" + hotel + "'";

		Map<String, TestBean42> map = new HashMap<String, TestBean42>();
//		List<String> list = new ArrayList<String>();
//		List<String> list2 = new ArrayList<String>();
//		List<String> list3 = new ArrayList<String>();
//		List<List<String>> list4 = new ArrayList<List<String>>();

		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(resource);
			try (Connection con = ds.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();) {
				TestBean42 tb;
				while (rs.next()) {
					int a = 1;
					tb = new TestBean42(rs.getString(a++), rs.getString(a++), rs.getString(a++), rs.getString(a++),
							rs.getString(a++), rs.getString(a++), rs.getString(a++), rs.getString(a++),
							rs.getString(a++), rs.getString(a++), rs.getString(a++), rs.getString(a++),
							rs.getString(a++));
					
					map.put("h1", tb);

//					list.add("地址: " + rs.getString(a++));
//					list.add("電話: " + rs.getString(a++));
//					list.add("信箱: " + rs.getString(a++));
//					list.add("官網: " + rs.getString(a++));
//					list.add("最低價: " + rs.getString(a++));
//
//					list2.add(rs.getString(a++));
//					list2.add(rs.getString(a++));
//
//					list3.add(rs.getString(a++));
//					list3.add(rs.getString(a++));
//					list3.add(rs.getString(a++));
//					list3.add(rs.getString(a++));
//					list3.add(rs.getString(a++));
//					list3.add(rs.getString(a++));

				}
//				list4.add(list);
//				list4.add(list2);
//				list4.add(list3);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return map;
	}
}
