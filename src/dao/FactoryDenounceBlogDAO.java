/** 
* File name: FactoryDenounceBlogDAO.java
* Purpose of file: this file contains the FactoryDenounceBlogDAO class and its methods.   
* Copyright: This software follows GPL license.
**/

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Blog;
import model.Denounce;
import model.DenounceBlog;
import model.DenouncePublication;
import model.User;

/**
* Class name: FactoryDenounceBlogDAO
* Purpose of class: This class has the methods used to connect to the database and 
* execute methods to create the blog denounces. Class responsible for the connection
* to the database. It is used by other classes of data persistence.
**/
public class FactoryDenounceBlogDAO extends ConnectionFactory implements FactoryDenounceDAO {
	
	Date now = new Date();
	java.sql.Date sqlDate = new java.sql.Date(now.getTime());

	/** 
	* Method name: createDenounce
	* Purpose of method: this method is responsible responsible for creating the 
	* denounces in database.  
	* @param idBlog: unique identify of blog that will be created denounce.
	* @param denounce: object of denounce.
	* @param user: object of user. User is responsible of denounce.
	* @return: there is no return.
	**/		
	public void createDenounce(int idBlog, Denounce denounce, User user){
		assert(idBlog >= 0 ) : "Unexpected error: the blog identifier is receiving null";
		assert (denounce != null) : "unexpected error: the denounce object is null";
		assert (user != null) : "unexpected error: the user object is null";
		try{			
			Connection connection = getConnection();
			PreparedStatement pstm = connection.
					prepareStatement("INSERT INTO Denuncia (dataDenuncia, conteudoDenuncia, idBlog, idUtilizador) VALUES (?,?,?,?)");
			pstm.setDate(1, sqlDate);
			pstm.setString(2, denounce.getContentDenounce());
			pstm.setInt(3, idBlog);
			pstm.setInt(4, user.getId());
			pstm.execute();
			pstm.close();
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
