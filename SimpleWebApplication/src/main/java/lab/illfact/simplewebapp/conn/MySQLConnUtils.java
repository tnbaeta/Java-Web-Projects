package lab.illfact.simplewebapp.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class MySQLConnUtils {
	
	private MySQLConnUtils() {
		throw new IllegalStateException("Utility class");
	}
 
 public static Connection getMySQLConnection()
         throws ClassNotFoundException, SQLException {
	 // Note: Change the connection parameters accordingly.
     String hostName = "mysql.cs";
     String dbName = "simplewebdatabase";
     String userName = "root";
     String password = "VMware1!";
     return getMySQLConnection(hostName, dbName, userName, password);
 }
 
 public static Connection getMySQLConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException {
   
     Class.forName("com.mysql.cj.jdbc.Driver");
     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
 
     return DriverManager.getConnection(connectionURL, userName,
             password);
 }
}
