package social.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import social.bean.FriendInfoBean;
import social.bean.MatchRequestBean;
import social.bean.MatchesBean;
import social.bean.MatchingBean;

public class MatchDAOImpl implements MatchDAO {

	String jndiString = "java:comp/env/" + "jdbc/ProjectGreen";
	// *****context的NAMEEEEEEEEEEEEEEEEEEEEEEEEEEEE
	DataSource ds;

	// *****預設建構連線參數
	public MatchDAOImpl() {
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(jndiString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void insertMatchRequest(MatchRequestBean mrb) {
		String sql = "Insert into MatchRequest(MemberID, AgeTopLike, AgeBottomLike,"
				+ "HeightLike, WeightLike, GenderLike, InterestedRestaurantType, TourTypeLike, RequestDay) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, mrb.getMemberID());
			pstmt.setInt(2, mrb.getAgeTopLike());
			pstmt.setInt(3, mrb.getAgeBottomLike());
			pstmt.setInt(4, mrb.getHeightLike());
			pstmt.setInt(5, mrb.getWeightLike());
			pstmt.setInt(6, mrb.getGenderLike());
			pstmt.setString(7, mrb.getInterestedRestaurantType());
			pstmt.setString(8, mrb.getTourTypeLike());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sdfst = sdf.format(mrb.getRequestDay());
			java.sql.Date date = java.sql.Date.valueOf(sdfst);
			pstmt.setDate(9, date);

			try {
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public List<MatchingBean> todayRequest() {

		List<MatchingBean> mbs = new ArrayList<>();
		String sql = "select MatchID, MR.MemberID, AgeTopLike, AgeBottomLike, "
				+ "HeightLike, WeightLike, GenderLike, InterestedRestaurantType, "
				+ "TourTypeLike, RequestDay, Everyday, GetMatch, MemberName,  "
				+ "MemberBirthday, ProfileHeight, ProfileWeight, Gender from MatchRequest as MR "
				+ "inner join Member2 as M2 on MR.MemberID = M2.MemberID"
				+ " inner join MemberProfile2 as MP on MR.MemberID = MP.ProfileID " + " where RequestDay = CONVERT (date, SYSDATETIME()) order by MatchID"; 
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				java.sql.Date date10 = rs.getDate(10);
				java.util.Date jdate10 = new java.util.Date(date10.getTime()); // *****sql轉util
				java.sql.Date date14 = rs.getDate(14);
				java.util.Date jdate14 = new java.util.Date(date14.getTime());
				MatchingBean mb = new MatchingBean(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9), jdate10, rs.getInt(11),
						rs.getInt(12), rs.getString(13), jdate14, rs.getInt(15), rs.getInt(16), rs.getInt(17));
				mbs.add(mb);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別發生SQL例外: " + ex.getMessage());
		}
		return mbs;
	}

	public void insertMatchResult(List<List<Integer>> matchResult) {
		if (matchResult == null) {
			System.out.println("無人配對");
			throw new IllegalArgumentException();
		}
		String sql = "Insert into Matches(MemberId1, MemberId2, PairDate) VALUES(?, ?, ?)";
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			System.out.println(matchResult.size());
			for (int l = 0; l < matchResult.size(); l++) {
				pstmt.setInt(1, (int) matchResult.get(l).get(0));
				pstmt.setInt(2, (int) matchResult.get(l).get(1));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String sdfst = sdf.format(new java.util.Date());
				java.sql.Date date = java.sql.Date.valueOf(sdfst);
				pstmt.setDate(3, date);
				pstmt.addBatch();
				pstmt.clearParameters();
			}
			try {
				pstmt.executeBatch();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void markMatch(Integer i) {
		String sql = "update Matches set Friends1=1 where MemberId2=? and "
				+ "MemberId1=1 and (Delete1!=1 and Delete2!=1) and PairDate= CONVERT(date, SYSDATETIME())";
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, i);
			try {
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void markPairDate(Integer i) {
		String sql = "update Matches set FriendDate=? where MemberId2=? and "
				+ "MemberId1=1 and (Delete1!=1 and Delete2!=1) and PairDate= CONVERT(date, SYSDATETIME())"
				+ " and Friends2=1";
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String sdfst = sdf.format(new java.util.Date());
			java.sql.Date date = java.sql.Date.valueOf(sdfst);
			pstmt.setDate(1, date);
			pstmt.setInt(2, i);
			try {
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<MatchesBean> showMatch() {
		List<MatchesBean> showMatch = new ArrayList<>();
		String sql = "select PairId, MemberId1, MemberId2,\r\n"
				+ " Friends1, Friends2, PairDate, FriendDate, Delete1, Delete2, ProfileHeight, ProfileWeight,\r\n"
				+ " MemberName, Gender, MemberBirthday, MemberIntroduce \r\n" + " from Matches as M\r\n"
				+ " inner join MemberProfile2 as MP \r\n" + " on M.MemberId2 =MP.ProfileID\r\n"
				+ " inner join Member2 as M2 on MP.ProfileID = M2.MemberID\r\n"
				+ "  where MemberId1  = 1 and delete1 != 1 ";
		// *****沒撈到東西也不會回傳Null
		try (Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
//				if (rs.wasNull()) {
				java.sql.Date date6 = rs.getDate(6);
				java.sql.Date date7 = rs.getDate(7);
				java.sql.Date date14 = rs.getDate(14);
				java.util.Date jdate6 = null;
				java.util.Date jdate7 = null;
				java.util.Date jdate14 = null;
				if (date6 != null) {
					jdate6 = new java.util.Date(date6.getTime()); // *****sql轉util
				}
				if (date7 != null) {
					jdate7 = new java.util.Date(date7.getTime()); // *****sql轉util
				}
				if (date14 != null) {
					jdate14 = new java.util.Date(date14.getTime()); // *****sql轉util
				}
				MatchesBean mb = new MatchesBean(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),
						jdate6, jdate7, rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getString(12),
						rs.getInt(13), jdate14, rs.getString(15));
				showMatch.add(mb);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別發生SQL例外: " + ex.getMessage());
		}
		return showMatch;
	}
	
	//ajax找單筆朋友資訊
	public FriendInfoBean showFriendInfo(Integer i) {
		FriendInfoBean fi = new FriendInfoBean();
		String sql = "  select MemberID, MemberName, Gender, MemberBirthday, MemberIntroduce,\r\n"
				+ "  ProfileHeight, ProfileWeight   from Member2 as M\r\n"
				+ "  inner join MemberProfile2 as MP  on M.MemberID =MP.ProfileID\r\n" 
				+ "  where MemberID  = ?";
		// *****沒撈到東西也不會回傳Null
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, i);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					java.sql.Date date4 = rs.getDate(4);
					java.util.Date jdate4 = null;
					if (date4 != null) {
						jdate4 = new java.util.Date(date4.getTime()); // *****sql轉util
					}
					fi = new FriendInfoBean(rs.getInt(1), rs.getString(2), rs.getInt(3), jdate4, rs.getString(5),
							rs.getInt(6), rs.getInt(7));
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				throw new RuntimeException("MemberDaoImpl_Jdbc類別發生SQL例外0: " + ex.getMessage());
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別發生SQL例外1: " + ex.getMessage());
		}
		return fi;
	}

	public void deleteFriend(Integer i) {
		String sql = "update Matches set Delete1=1 where MemberId2=? and "
				+ "MemberId1=1 and (Delete1!=1)";
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, i);
			try {
				pstmt.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
