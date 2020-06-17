package transportation.ubike.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import transportation.ubike.model.YouBikeNTPC;
import transportation.ubike.model.YouBikeTPC;

@Repository
public class YouBikeDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	YouBikeTPC youBikeTPC;
	@Autowired
	YouBikeNTPC youBikeNTPC;
	
// 查詢
	// （查詢）YouBike區域
	@SuppressWarnings("unchecked")
	public List<String> searchYBDistrict(String city) {
		System.out.println("進YouBikeDAO_#searchYBDistrict");
		List<String> districts = new ArrayList<>();
		String sqlNTPC = "select distinct District from YouBikeNTPC";
		String sqlTPC = "select distinct District from YouBikeTPC";
		Session session = sessionFactory.getCurrentSession();
		if (city.equals("台北市")) {
			districts = (List<String>) session.createNativeQuery(sqlTPC).getResultList();
			System.out.println("台北市結果："+districts);
		} else if (city.equals("新北市")) {
			districts = (List<String>) session.createNativeQuery(sqlNTPC).getResultList();
			System.out.println("新北市結果："+districts);
		} else {
			districts=null;
		}
		return districts;
	}
	
	// （查詢）YouBike站點(以城市及區域查詢)
	// 1. 台北市站點
	@SuppressWarnings("unchecked")
	public List<YouBikeTPC> ybStationTPC(String district) throws MalformedURLException{
//		System.out.println("進YouBikeDAO_#searchYBDistrict");
		this.updateYBTPC();
//		System.out.println("台北市YouBike資料表更新完成！");
//		System.out.println("查詢區域："+district);
		List<YouBikeTPC> list = new ArrayList<YouBikeTPC>();
		// 方法一：hql語法
		String hqlTPC = "select y from YouBikeTPC y where y.district =:district";
		list = sessionFactory.getCurrentSession().createQuery(hqlTPC).setParameter("district", district).list();
		// 方法二：原生sql語法（createSQLQuery）
//		 String sqlTPC = "select * from YouBikeTPC where district =:district";
//		 list = sessionFactory.getCurrentSession().createSQLQuery(sqlTPC).addEntity(YouBikeTPC.class).setParameter("district", district).getResultList();
//		System.out.println("query.getResultList()成功，list長度："+list.size());
//		System.out.println("準備出dao，回到service");
		return list;
	}
	// 2. 新北市站點
	@SuppressWarnings("unchecked")
	public List<YouBikeNTPC> ybStationNTPC(String district) throws MalformedURLException{
//		System.out.println("進YouBikeDAO_#ybStationNTPC");
		this.updateYBNTPC();
//		System.out.println("新北市YouBike資料表更新完成！");
		List<YouBikeNTPC> list = new ArrayList<>();
		// 方法一：hql語法
		// String hqlTPC = "select y from YouBikeTPC y where y.district =:district";
		// list = sessionFactory.getCurrentSession().createQuery(hqlTPC).setParameter("district", district).list();
		// 方法二：原生sql語法
		String sqlNTPC = "select * from YouBikeNTPC where district =:district";
		list = sessionFactory.getCurrentSession().createNativeQuery(sqlNTPC).addEntity(YouBikeNTPC.class).setParameter("district", district).getResultList();
//		System.out.println("query.getResultList()成功，result長度："+list.size());
//		System.out.println("準備出dao，回到service");
		return list;
	}
	
	// （查詢）YouBike站點(以經緯度範圍查詢)
	
	
// 更新YouBike資料
	// 1. 更新：台北市YouBike資料
	@SuppressWarnings("rawtypes")
	private void updateYBTPC() throws MalformedURLException {
		URL url = new URL("https://tcgbusfs.blob.core.windows.net/blobyoubike/YouBikeTP.json");
		try(
				InputStream is = url.openStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ( ( line = br.readLine() ) != null ) {
				sb.append(line);
			}
//			System.out.println(sb.toString());    // 確定趴進來的資料串沒錯
			// 把sb轉成String，再轉成JSONObject
			JSONObject jo = new JSONObject(sb.toString());
			// 從整包的集合中，把retVal這個JSONObject取出來
			JSONObject rvobj = jo.getJSONObject("retVal");
//			System.out.println(rvobj);     // 看看rvobj的狀況
			String[] keys = JSONObject.getNames(rvobj);
			// 準備日期格式轉換
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			
			// 資料庫連線
			Session session = sessionFactory.getCurrentSession();
			// 先把資料表清乾淨
			String sqlClean = "delete from YouBikeTPC";
			session.createNativeQuery(sqlClean).executeUpdate();
			// 準備塞進資料表
			String sql = "insert into YouBikeTPC ( StationID , StationName , Activity , Total , Available , Vacancy , City , District , Area , Latitude , Longitude  , UpdateTime ) values ( :id , :name , :act , :total , :ava , :vac , :city , :dis , :area , :lat , :lng , :upd)";
			Query queryUpdate = session.createNativeQuery(sql).addEntity(YouBikeTPC.class);
			// 用for迴圈取出rvobj的values
			int counter=0;
			int fail=0;
			int keyAmount = keys.length;
			for (int i = 0; i < keyAmount; i++) {
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
				System.out.println(id+"："+name+"："+upd);
				// 檢查：有站名才能新增
				if(name.length()==0) {
					fail++;
					continue;
				} else if(name !=null || name.length()!=0) {
					queryUpdate.setParameter("id", id);
					queryUpdate.setParameter("name", name);
					queryUpdate.setParameter("act", act);
					queryUpdate.setParameter("total", total);
					queryUpdate.setParameter("ava", ava);
					queryUpdate.setParameter("vac", vac);
					queryUpdate.setParameter("city", "台北市");
					queryUpdate.setParameter("dis", dis);
					queryUpdate.setParameter("area", area);
					queryUpdate.setParameter("lat", lat);
					queryUpdate.setParameter("lng", lng);
					// 時間處理
					Date date = format.parse(upd);
					Timestamp timestamp = new Timestamp(date.getTime());
					queryUpdate.setParameter("upd", timestamp);
					queryUpdate.executeUpdate();
					counter++;
					System.out.println("新增成功！");
				}
			}
			System.out.println("==== 台北市YouBike資料更新狀況 ====");
			System.out.println("1. 資料總筆數："+keyAmount);
			System.out.println("2. 寫入筆數："+counter+"，寫入資料庫成功");
			System.out.println("3. 失敗筆數："+fail);
			System.out.println("-------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("（出錯）IOException：YouBikeDAO_updateYBTPC（台北市）");
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("（出錯）ParseException：YouBikeDAO_updateYBTPC（台北市）");
		}
	}
	// 2. 更新：新北市YouBike資料
	@SuppressWarnings("rawtypes")
	private void updateYBNTPC() throws MalformedURLException {
		URL url = new URL("https://data.ntpc.gov.tw/api/v1/rest/datastore/382000000A-000352-001");
		try(
				InputStream is = url.openStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ( ( line = br.readLine() ) != null ) {
				sb.append(line);
			}
//			System.out.println(sb.toString());    // 確定趴進來的資料串沒錯
			// 把sb轉成String，再轉成JSONObject
			JSONObject jo = new JSONObject(sb.toString());
			// 從整包的集合中，把result這個JSONObject取出來
			JSONObject resultobj = jo.getJSONObject("result");
			// 從result物件中，把records這個JSONArray取出來
			JSONArray array = resultobj.getJSONArray("records");
//			System.out.println(array.length());    // 確定資料筆數
			// 準備日期格式轉換
			DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			// 資料庫連線
			Session session = sessionFactory.getCurrentSession();
			// 先把資料表清乾淨
			String sqlClean = "delete from YouBikeNTPC";
			session.createNativeQuery(sqlClean).executeUpdate();
			// 準備塞進資料表
			String sql = "insert into YouBikeNTPC ( StationID , StationName , Activity , Total , Available , Vacancy , City , District , Area , Latitude , Longitude  , UpdateTime ) values ( :id , :name , :act , :total , :ava , :vac , :city , :dis , :area , :lat , :lng , :upd)";
			Query queryUpdate = session.createNativeQuery(sql).addEntity(YouBikeNTPC.class);
			// for迴圈取得JSONArray中的JSONObject，再用pstmt寫入資料庫
			int counter=0;
			int fail=0;
			int dataSize = array.length();
			for (int i = 0; i < dataSize; i++) {
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
				System.out.println(id+"："+name+"："+upd);
				// 檢查：有站名才能新增
				if (name.length()==0) {
					fail++;
					continue;
				} else if(name !=null || name.length()!=0) {
					queryUpdate.setParameter("id", id);
					queryUpdate.setParameter("name", name);
					queryUpdate.setParameter("act", act);
					queryUpdate.setParameter("total", total);
					queryUpdate.setParameter("ava", ava);
					queryUpdate.setParameter("vac", vac);
					queryUpdate.setParameter("city", "新北市");
					queryUpdate.setParameter("dis", dis);
					queryUpdate.setParameter("area", area);
					queryUpdate.setParameter("lat", lat);
					queryUpdate.setParameter("lng", lng);
					// 時間處理
					Date date = format.parse(upd);
					Timestamp timestamp = new Timestamp(date.getTime());
					queryUpdate.setParameter("upd", timestamp);
					queryUpdate.executeUpdate();
					counter++;
					System.out.println("新增成功！");
				}
			}
			System.out.println("==== 新北市YouBike資料更新狀況 ====");
			System.out.println("1. 資料總筆數："+dataSize);
			System.out.println("2. 寫入筆數："+counter+"，寫入資料庫成功");
			System.out.println("3. 失敗筆數："+fail);
			System.out.println("-------------------------------------------");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("（出錯）IOException：YouBikeDAO_updateYBNTPC（新北市）");
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("（出錯）ParseException：YouBikeDAO_updateYBNTPC（新北市）");
		}
	}
}
