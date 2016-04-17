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

public class CollaborationDAO  extends ConnectionFactory implements PublicationGeneral{

	Publication publicationCollaborative = new Publication();
	Blog blog = new Blog();


	public void createPublication(int idBlog, Publication publication){
		try {
			Connection connection = getConnection();
			PreparedStatement pstm = connection.
					prepareStatement("INSERT INTO Publicacao (tituloPublicacao, categoriaPublicacao, "
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


	public List<Publication> listCollaborationApprove(int idBlog){
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

	public void ApprovePublication(int idPublication, CollaborativePublication publicationCollaborative){
		try {
			Connection connection = getConnection();
			PreparedStatement pstm = connection.prepareStatement("update Publicacao set tituloPublicacao=?,"
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


	public Publication listPublication(String idPublication) {
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
