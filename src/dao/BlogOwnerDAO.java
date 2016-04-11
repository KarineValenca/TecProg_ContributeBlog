package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Blog;

public class BlogOwnerDAO extends ConnectionFactory{

	public BlogOwnerDAO() {
		
	}
	
		
	public List<Blog> listBlogOwner(String blogOwner) {
		List<Blog> listBlog = new ArrayList<>();
		try {
			Connection connection = getConnection();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Blog where idUtilizador=" + blogOwner);
			
			while (rs.next()) {
				Blog blog = new Blog();
				blog.setIdBlog(rs.getInt("idBlog"));
				blog.setTitle(rs.getString("titulo"));
				blog.setCategorie(rs.getString("categoria"));
				blog.setCreationDate(rs.getDate("dataCriacao"));
				listBlog.add(blog);
				
			}
			stm.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listBlog;
	}
	

}
