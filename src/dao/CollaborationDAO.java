/** 
 * File name: CollaborationDAO.java
 * Purpose of file: this file contains the CollaborationDAO class and its methods.   
 * Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Blog;
import model.Publication;
import model.CollaborativePublication;

/**
 * Class name: CollaborationDAO
 * Purpose of class: This class has the methods used to connect to the database 
 * and execute methods to list and make changes related publications.
 */
public class CollaborationDAO  extends ConnectionFactory implements PublicationGeneral{

	Publication publicationCollaborative = new Publication();
	Blog blog = new Blog();

	/** 
	 * Method name: createPublication
	 * Purpose of method: Method responsible to insert the publication in the 
	 * database.  
	 * @param idBlog: unique identifier for the blog to be included publication..
	 * @param publication: instance the object publication that will be included
	 * in blog.
	 */
	public void createPublication(int idBlog, Publication publication){
		assert(idBlog > 0 ) : "Unexpected error: the blog identifier less than 0";
		assert(publication != null ) : "Unexpected error: the publication object "
				                       + "is receiving null";
		
		try {
			Connection connection = getConnection();
			PreparedStatement pstm = connection.
					prepareStatement("INSERT INTO Publicacao (tituloPublicacao, "
									 + "categoriaPublicacao, "
							         + "conteudoPublicacao,"
							         + "idBlog, "
							         + "notaPublicacao,"
							         + "statusPublicacao)"
							         + "VALUES (?,?,?,?,0,false)");

			pstm.setString(1, publicationCollaborative.getTitlePublication());
			pstm.setString(2, publicationCollaborative.getCategoryPublication());
			pstm.setString(3, publicationCollaborative.getContentPublication());
			pstm.setInt(4, idBlog);
			pstm.execute();
			pstm.close();
			connection.close();

		} catch (Exception e) {
			System.out.println("Erro adicionar Publicação Colaborativa");
			e.printStackTrace();
		}
	}

	/** 
	 * Method name: listCollaborationApprove
	 * Purpose of method: Method responsible for listing the publications for 
	 * approval.  
	 * @param idBlog: unique identifier for the blog to be listing the 
	 * publications for approval.
	 * @return pubCollaborative: list of publications for aproval.
	 */
	public List<Publication> listCollaborationApprove(int idBlog){
		assert(idBlog > 0 ) : "Unexpected error: the blog identifier less than 0";
		List<Publication>  pubCollaborative= new ArrayList<>();
		System.out.println("Listar Colaboração");
		System.out.println(idBlog + "fdffff");

		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Publicacao where statusPublicacao=0 and idBlog="
				                                          +idBlog+"");
			System.out.println("Select * from Publicacao where statusPublicacao=0 and idBlog="+idBlog+"");
			while (rs.next()) {
				publicationCollaborative.setIdPublication(rs.getInt("idPublication"));
				publicationCollaborative.setTitlePublication(rs.getString("titlePublication"));
				publicationCollaborative.setCategoryPublication(rs.getString("categoryPublication"));
				publicationCollaborative.setContentPublication(rs.getString("contentPublication"));
				pubCollaborative.add(publicationCollaborative);
				System.out.println("Passou aqui");
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu Erro lista colaborações para aprovar");
		}
		return pubCollaborative;
	}

	/** 
	 * Method name: ApprovePublication
	 * Purpose of method: Method responsible for approving publications.  
	 * @param idPublication: unique identifier for the publication to be approval
	 * @param publicationCollaborative: instance the object CollaborativePublication
	 * that will be approve publication
	 */
	public void ApprovePublication(int idPublication, CollaborativePublication 
			publicationCollaborative){
		assert(idPublication > 0 ) : "Unexpected error: the publication identifier "
								     + "less than 0";
		assert(publicationCollaborative != null ) : "Unexpected error: the "
							+ "publicationCollaborative object is receiving null";
		try {
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("update "
									+ "Publicacao set tituloPublicacao=?,"
					                + "categoriaPublicacao=?,"
					                + "conteudoPublicacao=?,"
					                + "notaPublicacao=?"
					                + "where idPublicacao=?");
			pstm.setString(1, publicationCollaborative.getTitlePublication());
			pstm.setString(2, publicationCollaborative.getCategoryPublication());
			pstm.setString(3, publicationCollaborative.getContentPublication());
			pstm.execute();
			pstm.close();
			connection.close();

		} catch (Exception e) {
			System.out.println("Erro ao aprovar Publicação Colaborativa");
			e.printStackTrace();
		}
	}

	/** 
	 * Method name: listPublication
	 * Purpose of method: Method responsible for listing publication.  
	 * @param idPublication: unique identifier for the publication to be listed.
	 * @return publication: return the publication
	 */
	public Publication listPublication(String idPublication) {
		assert(idPublication != null) : "Unexpected error: the attribute "
										+ "idPublication is receiving null";
		Publication publication = new Publication();
		publication.setTitlePublication("");
		
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Publicacao where idPublicacao="
				                                         +idPublication);
			while (rs.next()) {
				publication.setIdPublication(rs.getInt("idPublication"));
				publication.setTitlePublication(rs.getString("titlePublication"));
				publication.setCategoryPublication(rs.getString("categoryPublication"));
				publication.setContentPublication(rs.getString("contentPublication"));
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return publication;}


}
