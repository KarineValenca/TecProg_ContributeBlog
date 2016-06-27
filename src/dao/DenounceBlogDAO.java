/**
 * File name: BlogDAO.java
 * Purpose of file: This file is composed by a DenounceBlogDAO class and methods.
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
import model.DenounceBlog;

/**
 * Class name: DenounceBlogDAO
 * Purpose of class: This class has the methods used to connect to the database
 * and execute methods to list and make changes related to denounces. It is 
 * used by other classes of data persistence.
 */
public class DenounceBlogDAO extends ConnectionFactory implements DenounceDAO{

	/**
	 * Method name: listDenounce
	 * Purpose of method: This method is responsible for listing the denounces.
	 * @return list: array list of denounces blog.
	 */
	public List<Denounce> listDenounce() {
		List<Denounce> list = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			String sqlSelect = "Select * from Denuncia where idPublicacao IS NULL";
			ResultSet rs = stm.executeQuery(sqlSelect);

			while (rs.next()) {
				Denounce denounceBlog = new DenounceBlog();
				denounceBlog.setIdDenounce(rs.getInt("idDenounce"));
				denounceBlog.setContentDenounce(rs.getString("contentDenounce"));
				//blog.setDataCriacao(rs.getDate("dataCriacao"));
				list.add(denounceBlog);
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
	 * Purpose of method: This method is responsible for for making the exclusion
	 * of a denounce database.
	 * @param idDenounce: unique identifier of denounce will be deleted.
	 * @return list: array list of denounces blog.
	 */	
	public boolean deleteDenounce(String idDenounce) {
		assert(idDenounce != null ) : "Unexpected error: the denounce identifier"
									  + " is receiving null";	
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

	/**
	 * Method name: searchBlogDenounce
	 * Purpose of method: This method is responsible for for making the exclusion
	 * of a denounce database.
	 * @param idDenounce: unique identifier of denounce will be searched.
	 * @return denounce: denounce searched.
	 */	
	public Denounce searchBlogDenounce(String idDenounce) {
		assert(idDenounce != null ) : "Unexpected error: the denounce identifier"
									  + " is receiving null";
		Denounce denounceBlog = new Denounce();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			String sqlSelectDenounce = "Select * from Denuncia where "
					+ "idDenuncia ="+idDenounce;
			ResultSet rs = stm.executeQuery(sqlSelectDenounce);

			while (rs.next()) {
				denounceBlog.setIdDenounce(rs.getInt("idDenounce"));
				denounceBlog.setContentDenounce(rs.getString("contentDenunce"));
				denounceBlog.setIdBlog( rs.getInt("idBlog"));
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return denounceBlog;
	}
}
