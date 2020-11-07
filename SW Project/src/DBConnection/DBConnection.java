package DBConnection;
import java.sql.*;

public class DBConnection {
	
	Connection connection = null;

	public Connection makeConnection() throws SQLException {
		
		try {
			String dbURL = "jdbc:mysql://localhost:8080/mysql";
			String userName = "root";
			String passWord = "";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbURL, userName, passWord);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
