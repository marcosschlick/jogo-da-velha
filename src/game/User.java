package game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
	private String name;
	private String symbol = " ";

	public void setName(String n) {
		this.name = n;
	}

	public String getName() {
		return this.name;
	}

	public void setSymbol(String n) {
		this.symbol = n;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void checkDatabase() throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				insert into users (username)
				select ?
				where not exists (select 1 from users where username = ?)""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, this.getName());
		stmt.setString(2, this.getName());
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public void addWin() throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				   update users
				set wins = wins + 1
				where username = ?""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, this.getName());
		stmt.execute();
		stmt.close();
		connection.close();
	}
}
