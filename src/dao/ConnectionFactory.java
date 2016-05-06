/**
 *File name: ConnectionFactory.java
 *Purpose of File: This file is composed by ConnectionFactory class and methods.
 *Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *Class name: ConnectionFactory
 *Purpose of class: This class is responsible for the database connections.
 *Used by other data persistence classes. 
 */
public class ConnectionFactory {
	
	/**
	 * Method name: getConnection
	 * Purpose of method: This method trys to stablish database connections. 
	 * @return connection The method trys to stablish a connection to return 
	 * the variable connection. Connection states is equal null.  
	 */
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