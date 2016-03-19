package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Blog;
import model.Comentario;
import model.Publicacao;
import model.Utilizador;

public class ComentarioDAO extends ConnectionFactory{
	
	Comentario comentario = new Comentario();
	Utilizador utilizador = new Utilizador();
	Publicacao publicacao = new Publicacao();
	
	Date agora = new Date();
	java.sql.Date sqlDate = new java.sql.Date(agora.getTime());
	
	public void criarComentario(Comentario comentario, Utilizador utilizador, int idPublicacao){
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
	
	public List<Comentario> listarComentarioBlog(String idPublicacao) {
		List<Comentario> listaComentario = new ArrayList<Comentario>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from Comentario where idPublicacao=" + idPublicacao);
			
			while (rs.next()) {
				Comentario comentario = new Comentario();
				comentario.setIdComentario(rs.getInt("idComentario"));
				System.out.println(comentario.getIdComentario());
				comentario.setConteudoComentario(rs.getString("conteudoComentario"));
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
	public List<Comentario> listarComentarioBlogDelete(String idBlog) {
		List<Comentario> listaComentario = new ArrayList<Comentario>();
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from Comentario where idBlog" + idBlog);
			
			while (rs.next()) {
				Comentario comentario = new Comentario();
				comentario.setIdComentario(rs.getInt("idComentario"));
				System.out.println(comentario.getIdComentario());
				comentario.setConteudoComentario(rs.getString("conteudoComentario"));
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
