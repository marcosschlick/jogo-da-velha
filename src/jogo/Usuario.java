package jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario {
	String nome;
	String simbolo = " ";

	public void definirNome(String n) {
		this.nome = n;
	}

	public String obterNome() {
		return this.nome;
	}

	public void definirSimbolo(String n) {
		this.simbolo = n;
	}

	public String obterSimbolo() {
		return this.simbolo;
	}

	public void verificarBanco(Usuario u) throws SQLException {
		Connection conexao = Conexao.getConexao();
		String sql = """
				INSERT INTO users (username)
				SELECT ?
				WHERE NOT EXISTS (SELECT 1 FROM users WHERE username = ?)""";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, u.obterNome());
		stmt.setString(2, u.obterNome());
		stmt.execute();
		stmt.close();
		conexao.close();
	}

	public void adicionarVitoria(Usuario u) throws SQLException {
		Connection conexao = Conexao.getConexao();
		String sql = """
			    update users
				set wins = + 1
				where username = ?""";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, u.obterNome());
		stmt.execute();
		stmt.close();
		conexao.close();
	}
}
