package jogo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

	public static Connection getConnection() {
		try {
			final String url = "jdbc:mysql://localhost:3306/jogo_da_velha?verifyServerCertificate=false&useSSL=true";
			final String user = "root";
			final String password = "12345678";
			return DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}