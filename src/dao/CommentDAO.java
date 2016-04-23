/*
 * Class name: CommentDao.java
 * Purpose of class: This class is responsible to establish database conection 
 * and execute methods for create and delete comments and list of comments.
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

public class CommentDAO extends ConnectionFactory{
	
	Comment comment = new Comment();
	User user = new User();
	Publication publication = new Publication();
	
	Date now = new Date();
	java.sql.Date sqlDate = new java.sql.Date(now.getTime());
	
	/* this method establishs a connection database and creates a comment using
	   the comment, user and publication ID. */
	public void createComment(Comment comment, User user, int idPublication){
		assert (comment != null) : "The comment paramater is null";
		assert (user != null) : "The user paramater is null";
		assert (idPublication >= 0) : "The idPublication paramater is equal or less than zero";
		
		try{
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("INSERT INTO Comment (commentContent, "
					+ "commentCreateDate, idUser, idPublication) VALUES (?,?,?,?);");
			pstm.setString(1, comment.getCommentContent());
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
	
	/* this method establishs a connection database and deletes a comment of 
	   database using the comment ID. */
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
	
	/* this method establishs a connection database to adds a comment in a 
	   comments list using the publication ID and returns a comment list. */
	public List<Comment> listBlogComment(String idPublication) {
		// FIX-ME: HERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
		assert (idPublication != null) : "The idPublication paramater is null";
		
		List<Comment> listComment = new ArrayList<Comment>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from Comentario where idPublication=" + idPublication);
			
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setIdComment(rs.getInt("idComment"));
				System.out.println(comment.getIdComment());
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentUser(rs.getString("idUser"));
				System.out.println(comment.getCommentContent());
				listComment.add(comment);
				
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listComment;
	}
	
	/* this method establishs a connection database to delete a comment of a 
	   comments list and return a comments list. */
	public List<Comment> listBlogCommentDelete(String idBlog) {
		// FIX-ME: HERE IS AN ERROR, THE ID ATTRIBUTE SHOULD BE INT NOT STRING.
		assert (idBlog != null) : "The idBlog paramater is null";
		
		List<Comment> listComment = new ArrayList<Comment>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from Comentario where idBlog" + idBlog);
			
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setIdComment(rs.getInt("idComment"));
				System.out.println(comment.getIdComment());
				comment.setCommentContent(rs.getString("commentContent"));
				comment.setCommentUser(rs.getString("idUser"));
				System.out.println(comment.getCommentContent());
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
