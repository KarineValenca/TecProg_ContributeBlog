/**
 * File name: PublicationDAO.java
 * Purpose of class: This file contains the PublicationDAO class and its methods.
 * Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.synth.SynthScrollBarUI;

import model.Blog;
import model.Comment;
import model.Publication;

/**
 * Class name: PublicationDAO
 * Purpose of class: Establish database conection and execute methods for create and delete and
 * list publications and review publication and comment list and identify User.
 */
public class PublicationDAO extends ConnectionFactory implements PublicationGeneral{

	Blog blog = new Blog();

	/**
	 * Method name: createPublication
	 * Purpose of method: Represents the association of a text publication with a blog.
	 * @param idBlog: used to identify the blog.
	 * @param publicacao: The text of the publication that will be associated with the blog
	 * @param idPublication: the text identifier in the system
	 */
	public boolean createPublication( int blog, Publication publication){
		assert(blog >= 0) : "Unexpected error: the attribute blog less than 0";
		assert(publication != null ) : "Unexpected error: the publication is receiving null";
		boolean wasCreated = false;
		try{
			Connection connection = getConnection();
			PreparedStatement pstm = connection.
					prepareStatement("INSERT INTO Publicacao (tituloPublicacao,"
							      + "categoriaPublicacao, "
							      + "conteudoPublicacao,"
							      + "idBlog,"
							      + "notaPublicacao)"
							      + "VALUES (?,?,?,?,0)");

			pstm.setString(1, publication.getTitlePublication());
			pstm.setString(2, publication.getCategoryPublication());
			pstm.setString(3, publication.getContentPublication());
			pstm.setInt(4, blog);
			pstm.execute();
			pstm.close();
			connection.close();
			wasCreated = true;

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return wasCreated;
	}

    /**
     * Method name: editPublication
     * Purpose of method: This method allows the User edit publication data.
     * @param publicacao: The text of the publication that will be associated with the blog
     * @param idPublication: the text identifier in the system
     */
	public void editPublication(Publication publication, String idPublication){
		// FIX-ME: THERE IS AN ERROR, THE IDPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		assert(idPublication != null) : "Unexpected error: the attribute idPublication is receiving null";
		assert(publication != null ) : "Unexpected error: the publication is receiving null";
		try{
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("update Publicacao"
										      +"set tituloPublicacao=?, "
					                                                                      + "categoriaPublicacao=?,"
					                                                                      + "conteudoPublicacao=? "
					                                                                      + "where idPublicacao=?");

			pstm.setString(1, publication.getTitlePublication());
			pstm.setString(2, publication.getCategoryPublication());
			pstm.setString(3, publication.getContentPublication());
			pstm.setString(4, idPublication);
			pstm.execute();
			pstm.close();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * Method name: listPublication
     * Purpose of method: Matches the publication of Data Display you want to input the
     * identification attribute it.
     * @param idPublication: used to identify the publication.
     * @return: Returns a list of publications
     */
	public Publication listPublication (String idPublication) {
		// FIX-ME: THERE IS AN ERROR, THE IDPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		assert(idPublication!= null) : "Unexpected error: the attribute idPublication is receiving null";
		Publication publicationListPublication = new Publication();
		publicationListPublication.setTitlePublication("");
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Publicacao where idPublicacao="
				                                           +idPublication);
			while (rs.next()) {
				publicationListPublication.setIdPublication(rs.getInt("idPublication"));
				publicationListPublication.setTitlePublication(rs.getString("titlePublication"));
				publicationListPublication.setCategoryPublication(rs.getString("categoryPublication"));
				publicationListPublication.setContentPublication(rs.getString("contentPublication"));
			}
			stm.close();
			connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return publicationListPublication;
	}

    /**
     * Method name: listPublication
     * Purpose of method: This method allows the User to delete a publication that he does not
     * want to continue on a blog
     * @param idPublication: used to identify the publication.
     */
	public boolean deletePublication(int idPublication){
		//assert(idPublication >= 1) : "Unexpected error: the publication less than 1";
		boolean wasDeleted = false;
		try{
			if(idPublication >= 1){
				Connection connection = getConnection();
				String sql = "Delete from Publicacao where idPublicacao =";
				PreparedStatement pstm = connection.prepareStatement(sql+idPublication);
				pstm.execute();
				pstm.close();
				connection.close();
				wasDeleted = true;
			} 
			else {
				wasDeleted = false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return wasDeleted;
	}

    /**
     * Method name: ratePublication
     * Purpose of method: This method allows the User to evaluate a publication of someone blog.
     * @param idPublication: used to identify the publication.
     * @param publicacao: The text of the publication that will be associated with the blog
     * @param gradePublication: Used to give the rate.
     */
	public void ratePublication(Publication publication, String gradePublication, String idPublication){
		assert(publication!= null) : "Unexpected error: the attribute publication is receiving null";
		assert(gradePublication!= null) : "Unexpected error: the attribute gradePublication is receiving null";
		assert(idPublication != null) : "Unexpected error: the attribute idPublication is less than 1";
		// FIX-ME: THERE IS AN ERROR, THE IDPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		// FIX-ME: THERE IS AN ERROR, THE GRADEPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		try{
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("Update Publicacao"
										     +" set notaPublicacao = "
										     +"notaPublicacao + ? "
										     +"where idPublicacao = ?");
			pstm.setInt(1,  publication.getGradePublication());
			pstm.setString(2, idPublication);
			pstm.execute();
			pstm.close();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * Method name: listComents
     * Purpose of method: This method allows you to list comments of a publication.
     * @param idPublication: used to identify the publication.
     * @return: Returns a list of comments
     */
	public List<Comment> listComents(String idPublication){
		// FIX-ME: THERE IS AN ERROR, THE IDPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		assert(idPublication != null) : "Unexpected error: the attribute idPublication is receiving null";
		List<Comment> comments = new  ArrayList<>();

		try{
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Comentario where idPublicacao="
				                                          +idPublication);
			while (rs.next()) {
				Comment comment = new Comment();
				int idUser = rs.getInt("idUser");
				String nickUser = findUser(idUser);

				comment.setIdComment(rs.getInt("idComentario"));
				comment.setCommentContent(rs.getString("conteudoComentario"));
				comment.setCommentDate(rs.getDate("dataCriacaoComentario"));
				comment.setCommentUser(nickUser);
				comments.add(comment);
			}
			stm.close();
			connection.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return comments;
	}

    /**
     * Method name: findUser
     * Purpose of method: This method looks for a User with id
     * @param idUser: used to identify the user.
     * @return: Returns the nickname used.
     */
	public String findUser(int idUser){
		assert(idUser >= 0) : "Unexpected error: the attribute idUser is less than 0";
		String nickname = null;
		try{
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from Utilizador where id="+idUser);
			while (rs.next()) {
				nickname = rs.getString("apelido");
				System.out.println(nickname);

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return nickname;
	}

}
