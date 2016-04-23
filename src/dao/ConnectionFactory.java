/*
 *Class name: ConnectionFactory.java
 *Purpose of class: This class is responsible for the database connections.
 *Used by other data persistence classes. 
 *Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * this method trys to stablish database connections passing user, password and
 * name databases.
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