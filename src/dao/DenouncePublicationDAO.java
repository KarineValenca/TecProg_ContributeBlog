/** 
 * File name: DenouncePublicarionDAO.java
 * Purpose of file: this file contains the DenouncePublicationDAO class and its methods.   
 * Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Denounce;
import model.DenouncePublication;

/**
 * Class name: DenouncePublicationDAO
 * Purpose of class: This class has the methods used to connect to the database 
 * and execute methods to list and make changes related to denounces. It is used
 * by other classes of data persistence.
 */
public class DenouncePublicationDAO extends ConnectionFactory implements DenounceDAO{

	/** 
	 * Method name: listDenounce
	 * Purpose of method: this method is responsible for listing the denounces.  
	 * @param: there is no param.
	 * @return list: array list of denounces blog.
	 */	
	public List<Denounce> listDenounce() {
		List<Denounce> list = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			String sqlSelect = "Select * from Denuncia where idPublicacao IS NOT NULL";
			ResultSet rs = stm.executeQuery(sqlSelect);
			
			while (rs.next()) {
				Denounce denouncePublication = new DenouncePublication();
				denouncePublication.setIdDenounce(rs.getInt("idDenounce"));
				denouncePublication.setContentDenounce(rs.getString("contentDenounce"));
				list.add(denouncePublication);
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/** 
	 * Method name: deleteDenounce
	 * Purpose of method: This method is responsible for making the exclusion of a denounce database.  
	 * @param idDenounce: unique identify of denounce to be deleted.
	 */	
	public boolean deleteDenounce(String idDenounce) {
		assert(idDenounce != null ) : "Unexpected error: the denounce identifier is receiving null";
		boolean wasDelete = false;
		try {
			Connection connection = getConnection();
			String sqlDelete = "Delete from Denuncia where idDenuncia ="+idDenounce;
			PreparedStatement pstm = connection.prepareStatement(sqlDelete);
		
			pstm.execute();
			pstm.close();
			connection.close();
			wasDelete = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wasDelete;
	}

}
