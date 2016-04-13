package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Blog;
import model.BlogOwner;
import model.Publication;

public class BlogDAO extends ConnectionFactory {

	Blog blog = new Blog();
	Date agora = new Date();
	java.sql.Date sqlDate = new java.sql.Date(agora.getTime());

	public void criarBlog(Blog blog, BlogOwner donoBlog) {
		try {
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao
					.prepareStatement("INSERT INTO Blog (titulo,categoria, dataCriacao, idUtilizador) VALUES(?,?,?,?);");
			pstm.setString(1, blog.getTitle());
			pstm.setString(2, blog.getCategorie());
			pstm.setDate(3, sqlDate);
			pstm.setInt(4,donoBlog.getId());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Blog> listarBlog() {
		List<Blog> lista = new ArrayList<>();
		try {
			Connection conexao = getConnection();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Blog");

			while (rs.next()) {
				Blog blog = new Blog();
				blog.setIdBlog(rs.getInt("idBlog"));
				blog.setTitle(rs.getString("titulo"));
				blog.setCategorie(rs.getString("categoria"));
				//blog.setDataCriacao(rs.getDate("dataCriacao"));
				lista.add(blog);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}


	public void excluir(String idBlog) {
		try {
			Connection conexao = getConnection();
			PreparedStatement pstm = conexao
					.prepareStatement("Delete from Blog where idBlog ="+idBlog);

			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Publication> listarPublicacaoBlog(String idBlog) {
		List<Publication> lista = new ArrayList<>();
		try {
			Connection conexao = getConnection();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Publicacao where idBlog=" + idBlog);

			while (rs.next()) {
				Publication publicacao = new Publication();
				publicacao.setIdPublication(rs.getInt("idPublication"));
				publicacao.setTitlePublication(rs.getString("titlePublication"));
				publicacao.setCategoriaPublicacao(rs.getString("categoriaPublicacao"));
				publicacao.setConteudoPublicacao(rs.getString("conteudoPublicacao"));
				publicacao.setNota(rs.getInt("notaPublicacao"));
				lista.add(publicacao);

			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
