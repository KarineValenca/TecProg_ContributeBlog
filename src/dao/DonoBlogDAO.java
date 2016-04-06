package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Blog;

public class DonoBlogDAO extends ConnectionFactory{

	public DonoBlogDAO() {
		
	}
	
		
	public List<Blog> listarBlogDono(String donoBlog) {
		List<Blog> lista = new ArrayList<>();
		try {
			Connection conexao = getConnection();
			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Blog where idUtilizador=" + donoBlog);
			
			while (rs.next()) {
				Blog blog = new Blog();
				blog.setIdBlog(rs.getInt("idBlog"));
				blog.setTitulo(rs.getString("titulo"));
				blog.setCategoria(rs.getString("categoria"));
				blog.setDataCriacao(rs.getDate("dataCriacao"));
				lista.add(blog);
				
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	

}
