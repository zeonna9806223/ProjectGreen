package _00_init.util;

public class DBService {
	public static final String host = "127.0.0.1";
	public static final String DB_SQLSERVER = "SQLSERVER";

	public static final String DB_TYPE = DB_SQLSERVER;

	private static final String DBURL_SQLServer = "jdbc:sqlserver://" + host + ":1433;databaseName=ProjectGreen";
	public static final String USERID_SQLServer = "scott";
	public static final String PSWD_SQLServer = "tiger";


	public static String getDbUrl() {
		String url = null;
		if (DB_TYPE.equalsIgnoreCase(DB_SQLSERVER)) {
			url = DBURL_SQLServer;
		}
		return url;
	}

	public static String getUser() {
		String user = null;
		if (DB_TYPE.equalsIgnoreCase(DB_SQLSERVER)) {
			user = USERID_SQLServer;
		}
		return user;
	}

	public static String getPassword() {
		String pswd = null;
		if (DB_TYPE.equalsIgnoreCase(DB_SQLSERVER)) {
			pswd = PSWD_SQLServer;
		}
		return pswd;
	}

}
