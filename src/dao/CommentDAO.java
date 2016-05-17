/**
 * File name: CommentDao.java
 * Purpose of file: This file is composed by CommentDAO class and methods.
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
import model.Comment;
import model.Publication;
import model.User;

/**
 * Class name: CommentDao
 * Purpose of class: This class is responsible to establish database conection 
 * and execute methods for create and delete comments and list of comments.
 */
public class CommentDAO extends ConnectionFactory{
	
	/**
	 * Method name: createComment
	 * Purpose of method: This method establishs a connection database and 
	 * creates a comment.
	 * @param comment Comment The comment to be published.
	 * @param user The name of who published the comment.
	 * @param idPublication Unique identifier of a publication for receive a 
	 * comment.
	 */
	public void createComment(Comment comment, User user, int idPublication){
		assert (comment != null) : "The comment paramater is null";
		assert (user != null) : "The user paramater is null";
		assert (idPublication >= 0) : "The idPublication paramater is equal or less than zero";
		
		try{
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("INSERT INTO Comment (commentContent, "
					+ "commentCreateDate, idUser, idPublication) VALUES (?,?,?,?);");
			
			String commentContentString = comment.getCommentContent();
			pstm.setString(1, commentContentString);
			
			Date now = new Date();
			java.sql.Date sqlDate = new java.sql.Date(now.getTime());
			pstm.setDate(2, sqlDate);
			
			
			pstm.setInt(3, user.getId());
			pstm.setInt(4, idPublication);
			
			pstm.execute();
			pstm.close();
			connection.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Method name: deleteComment
	 * Purpose of method: This method establishs a connection database and 
	 * deletes a comment of database.
	 * @param idComment Unique identifier of a comment. 
	 */
	public void deleteComment(String idComment){
		// FIX-ME: HERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
		assert (idComment != null) : "The idComment paramater is null";
		
		try{
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("Delete from Comentario where idComment =" +idComment);
			pstm.execute();
			pstm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method name: listBlogComment
	 * Purpose of method: This method establishs a connection database to adds 
	 * a comment in a comments list.
	 * @param idPublication Unique identifier of a publication for receive a 
	 * comment.
	 * @return listComment ArrayList of Comment object instance to store the 
	 * comments of a publication.
	 */
	public List<Comment> listBlogComment(String idPublication) {
		// FIX-ME: HERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
		assert (idPublication != null) : "The idPublication paramater is null";
		
		List<Comment> listComment = new ArrayList<Comment>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from Comentario where idPublication=" + idPublication);
			
			Boolean nextComment = rs.next();
			while (nextComment) {
				Comment comment = new Comment();
				
				Integer idCommentColumn = rs.getInt("idComment");
				comment.setIdComment(idCommentColumn);
				Integer integeridComment = comment.getIdComment();
				System.out.println(integeridComment);
				
				String commentContentColumn = rs.getString("commentContent");
				comment.setCommentContent(commentContentColumn);
				String stringCommentContent = comment.getCommentContent();
				System.out.println(stringCommentContent);
				
				String idUserColumn = rs.getString("idUser");
				comment.setCommentUser(idUserColumn);		
				
				listComment.add(comment);
				
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listComment;
	}
	
	/**
	 * Method name: listBlogCommentDelete
	 * Purpose of method: This method establishs a connection database to 
	 * delete a comment of a comments list.
	 * @param idBlog Unique identifier of a blog.
	 * @return listComment ArrayList of Comment object instance to store the 
	 * comments of a publication.
	 */
	public List<Comment> listBlogCommentDelete(String idBlog) {
		// FIX-ME: HERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
		assert (idBlog != null) : "The idBlog paramater is null";
		
		List<Comment> listComment = new ArrayList<Comment>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from Comentario where idBlog" + idBlog);
			
			Boolean nextComment = rs.next();
			while (nextComment) {
				Comment comment = new Comment();
				
				Integer idCommentColumn = rs.getInt("idComment");
				comment.setIdComment(idCommentColumn);
				Integer integeridComment = comment.getIdComment();
				System.out.println(integeridComment);
				
				String commentContentColumn = rs.getString("commentContent");
				comment.setCommentContent(commentContentColumn);
				String stringCommentContent = comment.getCommentContent();
				System.out.println(stringCommentContent);
				
				String idUserColumn = rs.getString("idUser");
				comment.setCommentUser(idUserColumn);		
				
				listComment.add(comment);
				
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listComment;
	}
	
}
