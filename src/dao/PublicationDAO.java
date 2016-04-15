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

public class PublicationDAO extends ConnectionFactory implements PublicationGeneral{

	Publication publication = new Publication();
	Blog blog = new Blog();
        unsigned int blog

	public void createPublication( int blog, Publication publication){
		assert(blog >= 0) : "Unexpected error: the attribute blog less than 0";
		assert(publication != null ) : "Unexpected error: the publication is receiving null";
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

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	public void editPublication(Publication publication, String idPublication){
		// FIX-ME: THERE IS AN ERROR, THE IDPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		assert(idPublication != null) : "Unexpected error: the attribute idPublication is receiving null";
		assert(publication != null ) : "Unexpected error: the publication is receiving null";
		try{
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("update Publicacao set tituloPublicacao=?, "
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

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Publication listPublication (String idPublication) {
		// FIX-ME: THERE IS AN ERROR, THE IDPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		Publication publication = new Publication();
		publication.setTitlePublication("");
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Publicacao where idPublicacao="+idPublication);
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
		return publication;
	}

	public void deletePublication(String idPublication){
		// FIX-ME: THERE IS AN ERROR, THE IDPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		assert(publication != null ) : "Unexpected error: the publication is receiving null";
		try{
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("Delete from Publicacao where idPublicacao ="
			                                                                                          +idPublication);
			pstm.execute();
			pstm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ratePublication(Publication publication, String gradePublication, String idPublication){
		// FIX-ME: THERE IS AN ERROR, THE IDPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		// FIX-ME: THERE IS AN ERROR, THE GRADEPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		try{
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("Update Publicacao set notaPublicacao = notaPublicacao + ? where idPublicacao = ?");
			pstm.setInt(1, publication.getGradePublication());
			pstm.setString(2, idPublication);
			pstm.execute();
			pstm.close();
			connection.close();

		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<Comment> listComents(String idPublication){
		// FIX-ME: THERE IS AN ERROR, THE IDPUBLICATION ATTRIBUTE SHOULD BE INT NOT STRING.
		List<Comment> comments = new  ArrayList<>();

		try{
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Comentario where idPublicacao="
				                                          +idPublication);
			while (rs.next()) {
				Comment comment = new Comment();

				comment.setIdComment(rs.getInt("idComentario"));
				comment.setCommentContent(rs.getString("conteudoComentario"));
				comment.setCommentDate(rs.getDate("dataCriacaoComentario"));

				int idUser = rs.getInt("idUser");
				String nickUser = findUser(idUser);
				comment.setCommentUser(nickUser);

				comments.add(comment);
			}
			stm.close();
			connection.close();

		}catch(Exception e){
			e.printStackTrace();
		}

		return comments;

	}

	public String findUser(int idUser){
		String nickname = null;
		try{
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("select * from Utilizador where id="+idUser);
			while (rs.next()) {
				nickname = rs.getString("apelido");
				System.out.println(nickname);

			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return nickname;
	}

}
