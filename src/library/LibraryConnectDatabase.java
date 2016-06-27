package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryConnectDatabase {
	

	public Connection getConnectMySQL() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/daugia?useUnicode=true&characterEncoding=UTF-8", "root", "");
		} catch (Exception e) {
			e.getStackTrace();
		}
		return conn;
	}

	public void closeDB(Connection conn, Statement stm, ResultSet rs) {
		try {
			rs.close();
			stm.close();
			conn.close();
		} catch (Exception e) {
		}
	}
	public void closeDB(Connection conn, PreparedStatement pstm, ResultSet rs) {
		try {
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
		}
	}
}
