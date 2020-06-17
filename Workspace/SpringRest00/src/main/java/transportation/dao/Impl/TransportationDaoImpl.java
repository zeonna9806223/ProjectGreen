package transportation.dao.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import _00_init.util.GlobalService;
import transportation.dao.TransportationDao;
import transportation.model.TaipeiMRTBean;
import transportation.model.YouBikeBean;

public class TransportationDaoImpl implements TransportationDao {
	
	private DataSource ds = null;
	
	public TransportationDaoImpl() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(GlobalService.JNDI_DB_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
// 台北捷運
	// 查詢：以路線查詢站名
	@Override
	public List<String> queryLine(String line) {
		List<String> mrtLine = new ArrayList<>();
		String sql = "select * from TaipeiMRTLine where Line=? order by StationNo asc";
		try(
				Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				) {
			ps.setString(1, line);
			try(
					ResultSet rs = ps.executeQuery();
					) {
				while (rs.next()) {
					mrtLine.add(rs.getString("StationName"));
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("TransportationDaoImpl類別#queryLine()發生例外: " 
						+ e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("TransportationDaoImpl類別#queryLine()發生例外: " 
					+ e.getMessage());
		}
		return mrtLine;
	}
	
	// 查詢：以站名查詢出口
	@Override
	public List<TaipeiMRTBean> queryMRT(String stationName) {
		List<TaipeiMRTBean> stationExitList =new ArrayList<>();
		String sql ="select * from TaipeiMRTExit where StationName=? order by ExitNo asc";
		try(
				Connection con = ds.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				) {
			ps.setString(1, stationName);
			try(
					ResultSet rs = ps.executeQuery();
					){
				while (rs.next()) {
					TaipeiMRTBean mrtBean = new TaipeiMRTBean();
					mrtBean.setExitName(rs.getString("ExitName"));
					mrtBean.setStationName(rs.getString("StationName"));
					mrtBean.setLon(rs.getDouble("Longitude"));
					mrtBean.setLati(rs.getDouble("Latitude"));
					stationExitList.add(mrtBean);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("TransportationDaoImpl類別#queryMRT()發生例外: " 
						+ e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("TransportationDaoImpl類別#queryMRT()發生例外: " 
					+ e.getMessage());
		}
		return stationExitList;
	}



// 雙北YouBike
	// 查詢：以城市查詢地區
	@Override
	public List<String> queryDist(String city) {
		List<String> dist = new ArrayList<>();
		String sqlNTPC = "select District from YouBikeNTPC group by District order by count(*) desc";
		String sqlTPC = "select District from YouBikeTPC group by District order by count(*) desc";
		
		if (city.equals("新北市")) {
			try(
					Connection con = ds.getConnection();
					PreparedStatement ps = con.prepareStatement(sqlNTPC);
					ResultSet rs = ps.executeQuery();
					) {
				while (rs.next()) {
					String dis = rs.getString("District");
					dist.add(dis);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("TransportationDaoImpl類別#updateYouBike()發生例外: " 
						+ e.getMessage());
			}
		} else {
			try(
					Connection con = ds.getConnection();
					PreparedStatement ps = con.prepareStatement(sqlTPC);
					ResultSet rs = ps.executeQuery();
					) {
				while (rs.next()) {
					String dis = rs.getString("District");
					dist.add(dis);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("TransportationDaoImpl類別#updateYouBike()發生例外: " 
						+ e.getMessage());
			}
		}
		return dist;
	}
	
	// 查詢：全部站點
//	@Override
//	public List<YouBikeBean> queryAllYouBike() {
//		String sql = "select * from YouBikeNTPC union select * from YouBikeTPC";
//		List<YouBikeBean> list = new ArrayList<>();
//		try(
//				Connection con = ds.getConnection();
//				PreparedStatement ps = con.prepareStatement(sql);
//				ResultSet rs = ps.executeQuery();
//				) {
//			while (rs.next()) {
//				YouBikeBean yb = new YouBikeBean();
//				yb.setStationId(rs.getString("StationID"));
//				yb.setStationName(rs.getString("StationName"));
//				yb.setActivity(rs.getBoolean("Activity"));
//				yb.setTotal(rs.getInt("Total"));
//				yb.setAvailable(rs.getInt("Available"));
//				yb.setVacancy(rs.getInt("Vacancy"));
//				yb.setCity(rs.getString("City"));
//				yb.setDistirct(rs.getString("District"));
//				yb.setArea(rs.getString("Area"));
//				yb.setLati(rs.getDouble("Latitude"));
//				yb.setLon(rs.getDouble("Longitude"));
//				list.add(yb);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("TransportationDaoImpl類別#queryAllYouBike()發生例外: " 
//					+ e.getMessage());
//		}
//		return list;
//	}
	
	// 查詢：以區域查詢站點
	@Override
	public List<YouBikeBean> queryDistYouBike(String city,String district) throws MalformedURLException {
		updateYouBike();
		List<YouBikeBean> query = new ArrayList<>();
		String sqlNTPC = "select * from YouBikeNTPC where district=?";
		String sqlTPC = "select * from YouBikeTPC where district=?";
		
		if (city.equals("台北市")) {
			try(
					Connection con = ds.getConnection();
					PreparedStatement ps = con.prepareStatement(sqlTPC);
					){
				ps.setString(1, district);
				try(
					ResultSet rs = ps.executeQuery();
					) {
					while (rs.next()) {
						YouBikeBean yb = new YouBikeBean();
						yb.setStationId(rs.getString("StationID"));
						yb.setStationName(rs.getString("StationName"));
						yb.setActivity(rs.getBoolean("Activity"));
						yb.setTotal(rs.getInt("Total"));
						yb.setAvailable(rs.getInt("Available"));
						yb.setVacancy(rs.getInt("Vacancy"));
						yb.setCity(rs.getString("City"));
						yb.setDistirct(rs.getString("District"));
						yb.setArea(rs.getString("Area"));
						yb.setLati(rs.getDouble("Latitude"));
						yb.setLon(rs.getDouble("Longitude"));
						yb.setUpdate(rs.getTimestamp("UpdateTime"));
						query.add(yb);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("TransportationDaoImpl類別#queryDistYouBike()（台北市）發生例外: " 
						+ e.getMessage());
			}
		} else {
			try(
					Connection con = ds.getConnection();
					PreparedStatement ps = con.prepareStatement(sqlNTPC);
					) {
				ps.setString(1, district);
				try(
						ResultSet rs = ps.executeQuery();
						){
					while (rs.next()) {
						YouBikeBean yb = new YouBikeBean();
						yb.setStationId(rs.getString("StationID"));
						yb.setStationName(rs.getString("StationName"));
						yb.setActivity(rs.getBoolean("Activity"));
						yb.setTotal(rs.getInt("Total"));
						yb.setAvailable(rs.getInt("Available"));
						yb.setVacancy(rs.getInt("Vacancy"));
						yb.setCity(rs.getString("City"));
						yb.setDistirct(rs.getString("District"));
						yb.setArea(rs.getString("Area"));
						yb.setLati(rs.getDouble("Latitude"));
						yb.setLon(rs.getDouble("Longitude"));
						yb.setUpdate(rs.getTimestamp("UpdateTime"));
						query.add(yb);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("TransportationDaoImpl類別#queryDistYouBike()（新北市）發生例外: " 
						+ e.getMessage());
			}
		}
		return query;
	}
	
	// 更新資料表
	@Override
	public Boolean updateYouBike() throws MalformedURLException {
		// 新北市
		updateYouBikeNTPC();
		// 台北市
		updateYouBikeTPC();
		return null;
	}
	

	// YouBike更新：新北市
	private void updateYouBikeNTPC() throws MalformedURLException {
		URL urlNTPC = new URL("https://data.ntpc.gov.tw/api/v1/rest/datastore/382000000A-000352-001");
		String sqlNTPC = "insert into YouBikeNTPC ( StationID , StationName , Activity , Total , Available , Vacancy , City , District , Area , Latitude , Longitude  , UpdateTime ) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		try(
				InputStream is = urlNTPC.openStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement(sqlNTPC);
				){
			StringBuilder sb = new StringBuilder();
			String line;
			while ( ( line = br.readLine() ) != null ) {
				sb.append(line);
			}			
//			System.out.println(sb.toString());    // 確定載進來的資料串沒錯
			// 把sb轉成String，再轉成JSONObject
			JSONObject jo = new JSONObject(sb.toString());
			// 從整包的集合中，把result這個JSONObject取出來
			JSONObject resultobj = jo.getJSONObject("result");
			// 從result物件中，把records這個JSONArray取出來
			JSONArray array = resultobj.getJSONArray("records");
//			System.out.println(array.length());    // 確定資料筆數
			// 確定資料庫的資料表是空的
			stmt.executeUpdate("delete from YouBikeNTPC");
			// 要把日期資料格式化
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			
			// for迴圈取得JSONArray中的JSONObject，再用pstmt寫入資料庫
			int counter=0;
			for (int i = 0; i < array.length(); i++) {
				// 取得JSONArray中的JSONObject
				JSONObject ob = array.getJSONObject(i);
				String id = ob.getString("sno");
				String name = ob.getString("sna");
				String act = ob.getString("act");
				int total = ob.getInt("tot");
				int ava = ob.getInt("sbi");
				int vac = ob.getInt("bemp");
				String dis = ob.getString("sarea");
				String area = ob.getString("ar");
				String lat = ob.getString("lat");
				String lng = ob.getString("lng");
				String upd = ob.getString("mday");
				System.out.println(id+"："+name);
				// PreparedStatement指定放入的資料
				ps.setString( 1 , id );
				ps.setString( 2 , name );
				ps.setString( 3 , act );
				ps.setInt( 4 , total );
				ps.setInt( 5 , ava );
				ps.setInt( 6 , vac );
				ps.setString( 7 , "新北市" );
				ps.setString( 8 , dis );
				ps.setString( 9 , area );
				ps.setString( 10 , lat );
				ps.setString( 11 , lng );
				// 時間處理
				Date date = format.parse(upd);
				Timestamp timestamp = new java.sql.Timestamp(date.getTime());
				ps.setTimestamp(12, timestamp);
				
				ps.addBatch();
				counter++;
				// 每20筆執行批次寫入一次
				if ( counter%20 == 0 ) {
					ps.executeBatch();
					ps.clearBatch();					
				}
				// 剩下未滿20筆的批次在這裡寫入
				ps.executeBatch();
				ps.clearBatch();					
			}
			System.out.println("寫入筆數："+counter+"寫入資料庫成功");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("TransportationDaoImpl類別#updateYouBikeNTPC()發生例外: " 
					+ e.getMessage());
		} catch (SQLException e1) {
			e1.printStackTrace();
			throw new RuntimeException("TransportationDaoImpl類別#updateYouBikeNTPC()發生例外: " 
					+ e1.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("TransportationDaoImpl類別#updateYouBikeNTPC()發生例外: " 
					+ e.getMessage());
		} 
	}
	
	// YouBike更新：台北市
	private void updateYouBikeTPC() throws MalformedURLException {
		URL urlTPC = new URL("https://tcgbusfs.blob.core.windows.net/blobyoubike/YouBikeTP.json");
		String sqlTPC = "insert into YouBikeTPC ( StationID , StationName , Activity , Total , Available , Vacancy , City , District , Area , Latitude , Longitude  , UpdateTime ) values ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
		try(
				InputStream is = urlTPC.openStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				PreparedStatement ps = conn.prepareStatement(sqlTPC);
				){
			StringBuilder sb = new StringBuilder();
			String line;
			while ( ( line = br.readLine() ) != null ) {
				sb.append(line);
			}
//			System.out.println(sb.toString());    // 確定載進來的資料串沒錯
			// 把sb轉成String，再轉成JSONObject
			JSONObject jo = new JSONObject(sb.toString());
			// 從整包的集合中，把retVal這個JSONObject取出來
			JSONObject rvobj = jo.getJSONObject("retVal");
//			System.out.println(rvobj);     // 看看rvobj的狀況
			String[] keys = JSONObject.getNames(rvobj);
			// 先把資料表清乾淨
			stmt.executeUpdate("delete from YouBikeTPC");
			// 準備日期格式轉換
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			// 用for迴圈取出rvobj的values
			int counter=0;
			for (int i = 0; i < keys.length; i++) {
				JSONObject jso = rvobj.getJSONObject(keys[i]);
//				System.out.println(keys[i]+"："+jso);   // 確定取到的物件jso的樣子
				String id = jso.getString("sno");
				String name = jso.getString("sna");
				String act = jso.getString("act");
				int total = jso.getInt("tot");
				int ava = jso.getInt("sbi");
				int vac = jso.getInt("bemp");
				String dis = jso.getString("sarea");
				String area = jso.getString("ar");
				String lat = jso.getString("lat");
				String lng = jso.getString("lng");
				String upd = jso.getString("mday");
				System.out.println(id+"："+name);
				// PreparedStatement指定放入的資料
				ps.setString( 1 , id );
				ps.setString( 2 , name );
				ps.setString( 3 , act );
				ps.setInt( 4 , total );
				ps.setInt( 5 , ava );
				ps.setInt( 6 , vac );
				ps.setString( 7 , "台北市" );
				ps.setString( 8 , dis );
				ps.setString( 9 , area );
				ps.setString( 10 , lat );
				ps.setString( 11 , lng );
				// 時間處理
				Date date = format.parse(upd);
				Timestamp timestamp = new java.sql.Timestamp(date.getTime());
				ps.setTimestamp(12, timestamp);
				
				ps.addBatch();
				counter++;
				if (counter%20==0) {
					ps.executeBatch();
					ps.clearBatch();
				}
				ps.executeBatch();
				ps.clearBatch();		
			}
			System.out.println("寫入筆數："+counter+"寫入資料庫成功");
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new RuntimeException("TransportationDaoImpl類別#updateYouBikeTPC()發生例外: " 
					+ e1.getMessage());
		} catch (JSONException e) {
			e.printStackTrace();
			throw new RuntimeException("TransportationDaoImpl類別#updateYouBikeTPC()發生例外: " 
					+ e.getMessage());
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new RuntimeException("TransportationDaoImpl類別#updateYouBikeTPC()發生例外: " 
					+ e2.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("TransportationDaoImpl類別#updateYouBikeTPC()發生例外: " 
					+ e.getMessage());
		}
	}
	
	
	
	@Override
	public void setConnection(Connection conn) {
	}
	
}
