package accommodation.sql;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SQLDao implements ISQLDao{

	public static String selectTable() {
		String line = null;
		try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JDBCDB",
				"scott", "tiger");
				FileInputStream fis = new FileInputStream("D:\\77883.json");
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn
						.prepareStatement("select distinct Town from Accommodation  where Region = '新北市'");
				PreparedStatement pstmt2 = conn
						.prepareStatement("select distinct Town from Accommodation  where Region = '臺北市'");
				ResultSet rs = pstmt.executeQuery();
				ResultSet rs2 = pstmt2.executeQuery();) {

			StringBuilder builder = new StringBuilder();
			line = "";
			while (rs.next()) {
				line = rs.getString(1);
				builder.append(line).append(",");
			}

			line = builder.deleteCharAt(builder.length() - 1).toString();

			StringBuilder builder2 = new StringBuilder();
			String line2;
			while (rs2.next()) {
				line2 = rs2.getString(1);
				builder2.append(line2).append(",");
			}
			line += "@" + builder2.deleteCharAt(builder2.length() - 1).toString();
//			builder.

			return line;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return line;
	}

	

//	 public static void connectionDB() {
//		 try {
//			Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JDBCDB",
//						"scott", "tiger");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		 
//	 }

	public void buildTable() {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ProjectGreen", "scott",
				"tiger");
				FileInputStream fis = new FileInputStream("D:\\me\\住宿.json");
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(
						"insert into Accommodation values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		) {
//				URL fis = new URL("https://gis.taiwan.net.tw/XMLReleaseALL_public/hotel_C_f.json");
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}

//				Reader in = new InputStreamReader(new FileInputStream("D:\\77882.json"), StandardCharsets.UTF_8);
//				JSONArray array = new JSONArray(new JSONTokener(in));System.out.println(array);
//				System.out.println(array);
//				in.close();
//				String s="["+builder.toString().substring(1,builder.toString().length()-1)+"]";
////				try (FileOutputStream fos = new FileOutputStream("x" + ".json");
//						OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF8");
//						BufferedWriter bw = new BufferedWriter(osw);) {
//					bw.write(s);
//				}
			stmt.executeUpdate("truncate table Accommodation");
			JSONArray array = new JSONArray(builder.toString());
//				System.out.println(array.length());
			int counter = 0;
//			short c = 1;
			for (int i = 0; i < array.length(); i++) {
				JSONObject object = array.getJSONObject(i);
//					JSONObject ry = (JSONObject)object.get("XML_Head");
//					JSONObject gy = (JSONObject)ry.get("Infos");
//					ry.get("Infos");
//					System.out.println(gy);
				Object region = object.get("Region");

				if (region.toString().contains("北")) {

					String name = object.getString("Name");
					String description = object.getString("Description");
					String address = object.getString("Add");
					Object town = object.get("Town");
					String tel = object.getString("Tel").substring(4);
					tel = "0" + tel;
					String fax = object.getString("Fax").substring(4);
					fax = "0" + fax;

					String website = object.getString("Website");
					String pic1 = object.getString("Picture1");
					String pic2 = object.getString("Picture2");
					String pic3 = object.getString("Picture3");
					String picdescribe1 = object.getString("Picdescribe1");
					String picdescribe2 = object.getString("Picdescribe2");
					String picdescribe3 = object.getString("Picdescribe3");
					String nclass = object.getString("Class");
//					String nmap = object.getString("Map");
					String spec = object.getString("Spec");
					String serviceinfo = object.getString("Serviceinfo");
					String parkinginfo = object.getString("Parkinginfo");
					Object nemail = object.get("IndustryEmail");
					String grade = object.getString("Grade");
//					System.out.println(grade.equals(""));
//					int grade = object.getInt("Grade");
					Object totalNumberofRooms = object.get("TotalNumberofRooms");
					Object lowestPrice = object.get("LowestPrice");
					Object ceilingPrice = object.get("CeilingPrice");
					Object totalNumberofPeople = object.get("TotalNumberofPeople");
					Object parkingSpace = object.get("ParkingSpace");
					BigDecimal px = new BigDecimal(Double.toString(object.getDouble("Px")));
					BigDecimal py = new BigDecimal(Double.toString(object.getDouble("Py")));

					short grade1 = grade.equals("") ? 0 : new Short(grade);
//					short totalNumberofRooms1 = (short)totalNumberofRooms;
//					short lowestPrice1 = (short)lowestPrice;
//					short ceilingPrice1 = (short)ceilingPrice;
//					short totalNumberofPeople1 = (short)totalNumberofPeople;
//					short parkingSpace1 = (short)parkingSpace;
					
//					!!!後來有多加欄位，需要重新匯入要調整!!!
					
					int a = 1;
//					short nid = c;
//					System.out.println(nid);
//					nid += 1;

//					pstmt.setShort(a++, nid);
//					c++;
//					System.out.println(a);
					pstmt.setString(a++, name);
//					String ttString=description.length()<10?description:		description.substring(0,10);
//					pstmt.setString(a++, ttString);
					pstmt.setString(a++, description);
					pstmt.setShort(a++, grade1);
					pstmt.setString(a++, address);
					if (region.toString().trim().equals("臺北市")) {
						pstmt.setString(a++, "1");
					}else {
						pstmt.setString(a++, "2");
					}
					pstmt.setString(a++, region.toString());
					pstmt.setString(a++, "b");
					pstmt.setString(a++, town.toString());
					pstmt.setString(a++, tel);
					pstmt.setString(a++, fax);
					pstmt.setString(a++, website);
					pstmt.setString(a++, pic1);
					pstmt.setString(a++, picdescribe1);
					pstmt.setString(a++, pic2);
					pstmt.setString(a++, picdescribe2);
					pstmt.setString(a++, pic3);
					pstmt.setString(a++, picdescribe3);
					pstmt.setBigDecimal(a++, px);
					pstmt.setBigDecimal(a++, py);
					pstmt.setString(a++, nclass);
//					pstmt.setString(a++, nmap);
					pstmt.setString(a++, spec);
					pstmt.setString(a++, serviceinfo);
					pstmt.setString(a++, parkinginfo);
//					if(totalNumberofRooms.toString()==null) {
//						System.out.println("Yes");
//					}
					pstmt.setInt(a++, new Integer(
							totalNumberofRooms.toString().equals("null") ? 0 + "" : totalNumberofRooms.toString()));
//					pstmt.setShort(a++, grade1);
					pstmt.setInt(a++,
							new Integer(lowestPrice.toString().equals("null") ? 0 + "" : lowestPrice.toString()));
					pstmt.setInt(a++,
							new Integer(ceilingPrice.toString().equals("null") ? 0 + "" : ceilingPrice.toString()));
					pstmt.setString(a++, nemail.toString());
					pstmt.setInt(a++, new Integer(
							totalNumberofPeople.toString().equals("null") ? 0 + "" : totalNumberofPeople.toString()));
					pstmt.setInt(a++,
							new Integer(parkingSpace.toString().equals("null") ? 0 + "" : parkingSpace.toString()));

					pstmt.addBatch();
				}

				counter++;
				if (counter % 30 == 0) {
					pstmt.executeBatch();
					pstmt.clearBatch();

				}

			}
			pstmt.executeBatch();
			pstmt.clearBatch();

			System.out.println("===START===");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	public static void buildTableTown() {
		try (Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=DDB", "scott",
				"tiger");
				FileInputStream fis = new FileInputStream("D:\\me\\住宿.json");
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement("insert into AccommodationTown values (?,?,?,?)");) {

//			URL fis = new URL("https://gis.taiwan.net.tw/XMLReleaseALL_public/hotel_C_f.json");

			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}

			stmt.executeUpdate("delete from AccommodationTown");
			JSONArray array = new JSONArray(builder.toString());
			int counter = 0;
			for (int i = 0; i < array.length(); i++) {
				JSONObject object = array.getJSONObject(i);

				Object region = object.get("Region");
				Object town = object.get("Town");
				Object zipcode = object.get("Zipcode");

				int a = 1;
				if (region.toString().contains("北")) {
					if (region.toString().contains("臺")) {
						pstmt.setString(a++, "1");
					} else {
						pstmt.setString(a++, "2");
					}
					pstmt.setString(a++, region.toString());
					pstmt.setString(a++, zipcode.toString());
					pstmt.setString(a++, town.toString());

					pstmt.addBatch();
				}
				counter++;
				if (counter % 30 == 0) {
					pstmt.executeBatch();
					pstmt.clearBatch();
				}
			}
			pstmt.executeBatch();
			pstmt.clearBatch();
			System.out.println("===START===");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

}