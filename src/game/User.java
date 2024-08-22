package game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
	private String name;
	private String symbol = " ";
	private int wins = 0;

	public static User getWinner(User user1, User user2, String symbol) {
		if (user1.getSymbol() == symbol) {
			return user1;
		} else {
			return user2;
		}
	}

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

	public int getWins() {
		return this.wins;
	}

	public void checkDatabase() throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				insert into users (username)
				select ?
				where not exists (select 1 from users where username = ?);
				""";
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
				where username = ?;
				""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, this.getName());
		stmt.execute();
		stmt.close();
		connection.close();
	}

	public void getWin() throws SQLException {
		Connection connection = ConnectionMySQL.getConnection();
		String sql = """
				select wins
				from users
				where username = ?;
				""";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, this.getName());
		ResultSet result = stmt.executeQuery();
		if (result.next()) {
			this.wins = result.getInt("wins");
		}
		result.close();
		stmt.close();
		connection.close();

	}
}
