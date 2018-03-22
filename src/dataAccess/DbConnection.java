package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static String driver = "org.gjt.mm.mysql.Driver";
	private static String preURL = "jdbc:mysql://";
	private static String host = "localhost";
	private static String port = "3306";
	private static String db = "teatru";
	private static String user = "root";
	private static String pass = "";
	public static Connection conn;
	static String connURL = preURL + host + ":" + port + "/" + db;
	
	public static Connection getConnection() throws Exception{
		  //Connect to the Database
		 
    	
    		if(conn != null && !conn.isClosed()) 
    		{
    			return conn;
    		}
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(connURL, user, pass);
			return conn;
			
			
	}
}