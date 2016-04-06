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
	
	Comment comentario = new Comment();
	User utilizador = new User();
	Publication publicacao = new Publication();
	
	Date agora = new Date();
	java.sql.Date sqlDate = new java.sql.Date(agora.getTime());
	
	public void criarComentario(Comment comentario, User utilizador, int idPublicacao){
		try{
			
			
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("INSERT INTO Comentario (conteudoComentario, "
					+ "dataCriacaoComentario, idUtilizador, idPublicacao) VALUES (?,?,?,?);");
			pstm.setString(1, comentario.getConteudoComentario());
			pstm.setDate(2, sqlDate);
			pstm.setInt(3, utilizador.getId());
			pstm.setInt(4, idPublicacao);
			
			pstm.execute();
			pstm.close();
			conexao.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void excluirComentario(String idComentario){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("Delete from Comentario where idComentario =" +idComentario);
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Comment> listarComentarioBlog(String idPublicacao) {
		List<Comment> listaComentario = new ArrayList<Comment>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from Comentario where idPublicacao=" + idPublicacao);
			
			while (rs.next()) {
				Comment comentario = new Comment();
				comentario.setIdComentario(rs.getInt("idComentario"));
				System.out.println(comentario.getIdComentario());
				comentario.setCommentContent(rs.getString("conteudoComentario"));
				comentario.setUtilizadorComentario(rs.getString("idUtilizador"));
				System.out.println(comentario.getConteudoComentario());
				listaComentario.add(comentario);
				
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaComentario;
	}
	public List<Comment> listarComentarioBlogDelete(String idBlog) {
		List<Comment> listaComentario = new ArrayList<Comment>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from Comentario where idBlog" + idBlog);
			
			while (rs.next()) {
				Comment comentario = new Comment();
				comentario.setIdComentario(rs.getInt("idComentario"));
				System.out.println(comentario.getIdComentario());
				comentario.setCommentContent(rs.getString("conteudoComentario"));
				comentario.setUtilizadorComentario(rs.getString("idUtilizador"));
				System.out.println(comentario.getConteudoComentario());
				listaComentario.add(comentario);
				
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaComentario;
	}
	
	
	
	
	
	
	
		
	
		
}
