package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe responsável pela Conexão com o Banco de dados. É utilizada por outras
 * classes de persistência de dados.
 * 
 */
public class ConnectionFactory {
	public static synchronized Connection getConnection() {
		Connection connection = null;
		String user = "root";
		String password = "root";
		String dataBaseName = "teste";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+dataBaseName,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}