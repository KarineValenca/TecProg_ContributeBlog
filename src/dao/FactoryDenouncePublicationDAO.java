/** 
 * File name: FactoryDenouncePublicationDAO.java
 * Purpose of file: this file contains the interface FactoryDenouncePublication
 * DAO and its methods.   
 * Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import model.Denounce;
import model.User;

/**
 * Class name: FactoryDenouncePublicationDAO
 * Purpose of class: This class has the methods used to connect to the database 
 * and execute methods to create the publication denounces. Class responsible for
 * the connection to the database. It is used by other classes of data persistence.
 */
public class FactoryDenouncePublicationDAO extends ConnectionFactory implements FactoryDenounceDAO {
	Date now = new Date();
	java.sql.Date sqlDate = new java.sql.Date(now.getTime());

	/** 
	 * Method name: listDenounce
	 * Purpose of method: Method responsible for creating the denounces of publication.  
	 * @param idPublicaton: unique identify of publication.
	 * @param denounce: object denounce.
	 * @param user: object user. User is responsible of denounce. 
	 */	
	public void createDenounce(int idPublication, Denounce denounce, User user){
		assert(idPublication >= 1 ) : "Unexpected error: the publication identifier"
				+ " is receiving null";
		assert (denounce != null) : "unexpected error: the denounce object is null";
		assert (user != null) : "unexpected error: the user object is null";		
		try{

			Connection connection = getConnection();
			String sqlInsert = "INSERT INTO Denuncia (dataDenuncia, conteudoDenuncia, "
					+ "idPublicacao, idUtilizador) VALUES (?,?,?,?)";
			PreparedStatement pstm = connection.prepareStatement(sqlInsert);
			pstm.setDate(1, sqlDate);
			pstm.setString(2, denounce.getContentDenounce());
			pstm.setInt(3, idPublication);
			pstm.setInt(4, user.getId());
			pstm.execute();
			pstm.close();
			connection.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
