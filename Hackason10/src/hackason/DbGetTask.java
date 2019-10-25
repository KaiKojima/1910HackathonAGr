package hackason;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbGetTask {
	public static void main(String[] args) {

	}

	private static Connection getConnection() {
		Connection conn = null;
		//db.propertiesファイルの読込み
		ResourceBundle resourceBundle = ResourceBundle.getBundle("hackasondb");
		try {
			conn = (Connection) DriverManager.getConnection(
					resourceBundle.getString("jdbcUrl"),
					resourceBundle.getString("dbUser"),
					resourceBundle.getString("dbPassword"));
		} catch (SQLException e) {
			System.out.println("データベース接続エラーが発生しました");
		}
		return conn;
	}
}
