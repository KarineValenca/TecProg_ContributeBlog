package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.plaf.synth.SynthScrollBarUI;

import model.Blog;
import model.Comentario;
import model.Publicacao;
import model.Utilizador;

public class PublicacaoDAO extends ConnectionFactory implements PublicacaoGeral{

	Publicacao publicacao = new Publicacao();
	Blog blog = new Blog();
	
	
	public void publicar( int blog, Publicacao publicacao){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.
					prepareStatement("INSERT INTO Publicacao (tituloPublicacao, categoriaPublicacao, "
							+ "conteudoPublicacao, idBlog, notaPublicacao) VALUES (?,?,?,?,0)");
			pstm.setString(1, publicacao.getTituloPublicacao());
			pstm.setString(2, publicacao.getCategoriaPublicacao());
			pstm.setString(3, publicacao.getConteudoPublicacao());
			pstm.setInt(4, blog);
			pstm.execute();
			pstm.close();
			conexao.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void editarPublicacao(Publicacao publicacao, String idPublicacao){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("update Publicacao set tituloPublicacao=?, "
					+ "categoriaPublicacao=?, conteudoPublicacao=? where idPublicacao=?");
			pstm.setString(1, publicacao.getTituloPublicacao());
			pstm.setString(2, publicacao.getCategoriaPublicacao());
			pstm.setString(3, publicacao.getConteudoPublicacao());
			
			pstm.setString(4, idPublicacao);
			
			pstm.execute();
			pstm.close();
			conexao.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Publicacao listar(String idPublicacao) {
		Publicacao publicacao = new Publicacao();
		publicacao.setTituloPublicacao("");
		try {
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Publicacao where idPublicacao="+idPublicacao);
			while (rs.next()) {
				publicacao.setIdPublicacao(rs.getInt("idPublicacao"));
				publicacao.setTituloPublicacao(rs.getString("tituloPublicacao"));
				publicacao.setCategoriaPublicacao(rs.getString("categoriaPublicacao"));
				publicacao.setConteudoPublicacao(rs.getString("conteudoPublicacao"));
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return publicacao;
	}
	
	public void excluirPublicacao(String idPublicacao){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("Delete from Publicacao where idPublicacao =" +idPublicacao);
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void avaliarPublicacao(Publicacao publicacao, String nota, String idPublicacao){
		try{
			Connection conexao = getConexao();
			PreparedStatement pstm = conexao.prepareStatement("Update Publicacao set notaPublicacao = notaPublicacao + ? where idPublicacao = ?");
			pstm.setInt(1, publicacao.getNota());
			pstm.setString(2, idPublicacao);
			pstm.execute();
			pstm.close();
			conexao.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Comentario> listarComentarios(String idPublicacao){
		List<Comentario> comentarios = new  ArrayList<>();
		
		
		try{
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Comentario where idPublicacao="+idPublicacao);
			while (rs.next()) {
				Comentario comentario = new Comentario();
				
				comentario.setIdComentario(rs.getInt("idComentario"));
				comentario.setConteudoComentario(rs.getString("conteudoComentario"));
				comentario.setDataComentario(rs.getDate("dataCriacaoComentario"));
				
				int idUtilizador = rs.getInt("idUtilizador");
				String apelidoUtilizador = identificarUsuario(idUtilizador);
				comentario.setUtilizadorComentario(apelidoUtilizador);
				
				comentarios.add(comentario);
			}
			stm.close();
			conexao.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return comentarios;
		
	}
	
	public String identificarUsuario(int idUtilizador){
		String apelido = null;
		try{
			Connection conexao = getConexao();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from Utilizador where id="+idUtilizador);
			while (rs.next()) {
				apelido = rs.getString("apelido");
				System.out.println(apelido);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return apelido;
	}

}
