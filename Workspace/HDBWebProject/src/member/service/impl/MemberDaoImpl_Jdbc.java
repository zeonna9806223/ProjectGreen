package member.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import member.model.MemberBean;
import member.model.MemberDao;
import member.model.MemberDetailBean;
import member.model.MemberDetailDao;
import member.service.GlobalService;

// 本類別使用為標準的JDBC技術來存取資料庫。
public class MemberDaoImpl_Jdbc implements MemberDao,MemberDetailDao {

	private DataSource ds = null;
	private Connection conn = null;
	public MemberDaoImpl_Jdbc() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#建構子發生例外: " + ex.getMessage());
		}
	}
	// 儲存MemberBean物件，將參數mb新增到Member表格內。
	
	public int saveMember(MemberBean mb) {
		String sql = "insert into Member3 " 
				+ " (memberAccount, MemberName, MemberPWD, MemberAddress, MemberEmail, "
				+ " MemberCellPhone, MemberJoinDate, MemberImage, Gender, FileName)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, mb.getMemberAccount());
			ps.setString(2, mb.getMemberName());
			
			ps.setString(3, mb.getMemberPWD());
			ps.setString(4, mb.getMemberAddress());
			ps.setString(5, mb.getMemberEmail());
			ps.setString(6, mb.getMemberCellPhone());
			ps.setTimestamp(7, mb.getMemberJoinDate());
			ps.setBlob(8, mb.getMemberImage());
			ps.setString(9, mb.getGender());
			ps.setString(10, mb.getFileName());
			n = ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#saveMember()發生例外: " 
										+ ex.getMessage());
		}
		return n;
	}
	
	
//	public int saveMember(MemberBean mb) {
//		String sql = "insert into Member2 " 
//				+ " (MemberAccount, MemberPWD, MemberName, Gender, MemberPhone, "
//				+ " MemberEmail, MemberAddress,userType ,registerTime,memberImage,   fileName,comment)" 
//				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		int n = 0;
//		try (
//			Connection con = ds.getConnection(); 
//			PreparedStatement ps = con.prepareStatement(sql);
//		) {
//			ps.setString(1, mb.getMemberId());
//			ps.setString(2, mb.getPassword());
//			ps.setString(3, mb.getName());
//			ps.setString(4, mb.getGender());
//			
//			ps.setString(6, mb.getTel());
//			ps.setString(7, mb.getEmail());
//			ps.setString(8, mb.getAddress());
//			
//			
//			
//			ps.setString(12, mb.getUserType());
//			ps.setTimestamp(13, mb.getRegisterTime());
//			ps.setBlob(14, mb.getMemberImage());
//			ps.setString(15, mb.getFileName());
//			ps.setClob(16, mb.getComment());
//			n = ps.executeUpdate();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			throw new RuntimeException("MemberDaoImpl_Jdbc類別#saveMember()發生例外: " 
//										+ ex.getMessage());
//		}
//		return n;
//	}
	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
	// 否則傳回false，表示此id可使用。
	@Override
	public boolean idExists(String id) {
		boolean exist = false;
		String sql = "SELECT * FROM Member3 WHERE MemberAccount = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
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
	
	// 由參數 id (會員帳號) 到Member表格中 取得某個會員的所有資料，傳回值為一個MemberBean物件，
	// 如果找不到對應的會員資料，傳回值為null。
	@Override
	public MemberBean queryMember(String id) {
		MemberBean mb = null;
		String sql = "SELECT * FROM Member3 WHERE MemberAccount = ?";
		try (
			Connection connection = ds.getConnection(); 
			PreparedStatement ps = connection.prepareStatement(sql);
		) {
			ps.setString(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberBean();
					mb.setPKey(rs.getInt("MemberID"));
					mb.setMemberAccount(rs.getString("MemberAccount"));
					mb.setMemberName(rs.getString("MemberName"));
					mb.setMemberPWD(rs.getString("MemberPWD"));
					mb.setMemberAddress(rs.getString("MemberAddress"));
					mb.setMemberEmail(rs.getString("MemberEmail"));
					mb.setMemberCellPhone(rs.getString("MemberCellPhone"));
					mb.setMemberJoinDate(rs.getTimestamp("MemberJoinDate"));
					mb.setMemberImage(rs.getBlob("MemberImage"));
					mb.setGender(rs.getString("gender"));
					mb.setFileName(rs.getString("FileName"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#queryMember()發生例外: " 
					+ ex.getMessage());
		}
		return mb;
	}
	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
	// 否則傳回 null。
	@Override
	public MemberBean checkIDPassword(String userId, String password) {
		MemberBean mb = null;
		String sql = "SELECT * FROM Member3  WHERE memberAccount = ? and memberPWD = ?";
		try (
			Connection con = ds.getConnection(); 
			PreparedStatement ps = con.prepareStatement(sql);
		) {
			ps.setString(1, userId);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					mb = new MemberBean();
					mb.setPKey(rs.getInt("MemberID"));
					mb.setMemberAccount(rs.getString("MemberAccount"));
					mb.setMemberName(rs.getString("MemberName"));
					mb.setMemberPWD(rs.getString("MemberPWD"));
					mb.setMemberAddress(rs.getString("MemberAddress"));
					mb.setMemberEmail(rs.getString("MemberEmail"));
					mb.setMemberCellPhone(rs.getString("MemberCellPhone"));
					mb.setMemberJoinDate(rs.getTimestamp("MemberJoinDate"));
					mb.setMemberImage(rs.getBlob("MemberImage"));
					mb.setGender(rs.getString("Gender"));
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("MemberDaoImpl_Jdbc類別#checkIDPassword()發生SQL例外: " 
					+ ex.getMessage());
		}
		return mb;
	}


	
	@Override
	public void setConnection(Connection conn) {
        this.conn = conn;
	}

	@Override
	public MemberDetailBean query(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertProfile(MemberDetailBean mdb) {
			String sql = "insert into MemberProfile " 
					+ " (birthday, height, weight,fitlook, "
					+ " introducing, isMemberAvailable, userType, isVip,)"
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			int n = 0;
			try (
				Connection con = ds.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql);
			) {
				ps.setDate(1, mdb.getBirthday());
				ps.setFloat(2, mdb.getHeight());
				ps.setFloat(3, mdb.getWeight());
				ps.setInt(4, mdb.getFitlook());
				ps.setClob(5, mdb.getIntroducing());
				ps.setInt(6, mdb.getIsMemberAvailable());
				ps.setInt(7, mdb.getUserType());
				ps.setInt(8, mdb.getIsVip());

				n = ps.executeUpdate();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("MemberDaoImpl_Jdbc類別#insertProfile()發生例外: " 
											+ ex.getMessage());
			}
			return n;
		
	}
}
