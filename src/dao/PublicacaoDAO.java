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
import model.Comment;
import model.Publication;
import model.User;

public class PublicacaoDAO extends ConnectionFactory implements PublicacaoGeral{

	Publication publicacao = new Publication();
	Blog blog = new Blog();


	public void publicar( int blog, Publication publicacao){
		try{
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao.
					prepareStatement("INSERT INTO Publicacao (tituloPublicacao,"
							         + "categoriaPublicacao, "
							         + "conteudoPublicacao,"
							         + "idBlog,"
							         + "notaPublicacao)"
							         + "VALUES (?,?,?,?,0)");

			pstm.setString(1, publicacao.getTitlePublication());
			pstm.setString(2, publicacao.getCategoryPublication());
			pstm.setString(3, publicacao.getContentPublication());
			pstm.setInt(4, blog);
			pstm.execute();
			pstm.close();
			conexao.close();

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void editarPublicacao(Publication publicacao, String idPublication){
		try{
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao.prepareStatement("update Publicacao set tituloPublicacao=?, "
					                                          + "categoriaPublicacao=?,"
					                                          + "conteudoPublicacao=? "
					                                          + "where idPublicacao=?");

			pstm.setString(1, publicacao.getTitlePublication());
			pstm.setString(2, publicacao.getCategoryPublication());
			pstm.setString(3, publicacao.getContentPublication());

			pstm.setString(4, idPublication);

			pstm.execute();
			pstm.close();
			conexao.close();


		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Publication listar(String idPublication) {
		Publication publicacao = new Publication();
		publicacao.setTitlePublication("");
		try {
			Connection conexao = getConnection();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Publicacao where idPublicacao="+idPublication);
			while (rs.next()) {
				publicacao.setIdPublication(rs.getInt("idPublication"));
				publicacao.setTitlePublication(rs.getString("titlePublication"));
				publicacao.setCategoryPublication(rs.getString("categoryPublication"));
				publicacao.setContentPublication(rs.getString("contentPublication"));
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return publicacao;
	}

	public void excluirPublicacao(String idPublication){
		try{
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao.prepareStatement("Delete from Publicacao where idPublicacao ="
			                                                                                          +idPublication);
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void avaliarPublicacao(Publication publicacao, String gradePublication, String idPublication){
		try{
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao.prepareStatement("Update Publicacao set notaPublicacao = notaPublicacao + ? where idPublicacao = ?");
			pstm.setInt(1, publicacao.getGradePublication());
			pstm.setString(2, idPublication);
			pstm.execute();
			pstm.close();
			conexao.close();

		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Comment> listarComentarios(String idPublication){
		List<Comment> comentarios = new  ArrayList<>();


		try{
			Connection conexao = getConnection();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Comentario where idPublicacao="
				                                          +idPublication);
			while (rs.next()) {
				Comment comentario = new Comment();

				comentario.setIdComment(rs.getInt("idComentario"));
				comentario.setCommentContent(rs.getString("conteudoComentario"));
				comentario.setCommentDate(rs.getDate("dataCriacaoComentario"));

				int idUser = rs.getInt("idUser");
				String apelidoUtilizador = identificarUsuario(idUser);
				comentario.setCommentUser(apelidoUtilizador);

				comentarios.add(comentario);
			}
			stm.close();
			conexao.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		return comentarios;

	}

	public String identificarUsuario(int idUser){
		String apelido = null;
		try{
			Connection conexao = getConnection();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from Utilizador where id="+idUser);
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
