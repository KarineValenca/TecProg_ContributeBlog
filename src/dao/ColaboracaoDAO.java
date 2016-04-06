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
import model.PublicacaoColaborativa;

public class ColaboracaoDAO  extends ConnectionFactory implements PublicacaoGeral{

	Publication publicacaoColaborativa = new Publication();
	Blog blog = new Blog();
	
	
	public void publicar(int idBlog, Publication publicacao){
		try {
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao.
					prepareStatement("INSERT INTO Publicacao (tituloPublicacao, categoriaPublicacao, "
							+ "conteudoPublicacao, idBlog, notaPublicacao, statusPublicacao) VALUES (?,?,?,?,0,false)");
			pstm.setString(1, publicacaoColaborativa.getTituloPublicacao());
			pstm.setString(2, publicacaoColaborativa.getCategoriaPublicacao());
			pstm.setString(3, publicacaoColaborativa.getConteudoPublicacao());
			pstm.setInt(4, idBlog);
			pstm.execute();
			pstm.close();
			conexao.close();
				
		} catch (Exception e) {
			System.out.println("Erro adicionar Publicação Colaborativa");
			e.printStackTrace();
		}
	}
	
	
	public List<Publication> listarColaboracaAprovar(int idBlog){
		List<Publication>  pubColaborativas= new ArrayList<>();
		System.out.println("Listar Colaboração");
		System.out.println(idBlog + "fdffff");
		
		try {
			Connection conexao = getConnection();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Publicacao where statusPublicacao=0 and idBlog="+idBlog+"");
			System.out.println("Select * from Publicacao where statusPublicacao=0 and idBlog="+idBlog+"");
			while (rs.next()) {
				publicacaoColaborativa.setIdPublicacao(rs.getInt("idPublicacao"));
				publicacaoColaborativa.setTituloPublicacao(rs.getString("tituloPublicacao"));
				publicacaoColaborativa.setCategoriaPublicacao(rs.getString("categoriaPublicacao"));
				publicacaoColaborativa.setConteudoPublicacao(rs.getString("conteudoPublicacao"));
				pubColaborativas.add(publicacaoColaborativa);
				System.out.println("Passou aqui");
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Deu Erro lista colaborações para aprovar");
		}
		return pubColaborativas;
	}
	
	public void AprovarPublicacao(int idPublicacao, PublicacaoColaborativa publicacaoColaborativa){
		try {
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao.
					prepareStatement("update Publicacao set tituloPublicacao=?, categoriaPublicacao=?, conteudoPublicacao=?, notaPublicacao=? where idPublicacao=?");
			pstm.setString(1, publicacaoColaborativa.getTituloPublicacao());
			pstm.setString(2, publicacaoColaborativa.getCategoriaPublicacao());
			pstm.setString(3, publicacaoColaborativa.getConteudoPublicacao());
			pstm.execute();
			pstm.close();
			conexao.close();
				
		} catch (Exception e) {
			System.out.println("Erro ao aprovar Publicação Colaborativa");
			e.printStackTrace();
		}
	}


	public Publication listar(String idPublicacao) {
		Publication publicacao = new Publication();
		publicacao.setTituloPublicacao("");
		try {
			Connection conexao = getConnection();
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
		return publicacao;}
	
	
	
	
}
