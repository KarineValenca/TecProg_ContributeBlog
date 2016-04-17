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
	
	public void deleteComment(String idComment){
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
	
	public List<Comment> listBlogComment(String idPublication) {
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
	public List<Comment> listBlogCommentDelete(String idBlog) {
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
