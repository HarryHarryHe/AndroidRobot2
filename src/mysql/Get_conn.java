package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Get_conn {
	static String DRIVER = "com.mysql.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://127.0.0.1:3306/user";
	static String USER = "root";
	static String PWD = "19990428";

	public static Connection get_conn() {
		Connection conn = null;

		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
