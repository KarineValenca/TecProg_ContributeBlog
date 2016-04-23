/*
 * Class name: BlogOwnerDAO.java
 * Purpose of class: This class is responsible to create a blogs list.
 * Copyright: This software follows GPL license.
 */

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
	
	/* this method is used to trys to stablish a connection database and 
	   creates a blogs list. The list is composed by id, title, creation
	   date and category. */
	public List<Blog> listBlogOwner(String blogOwner) {
		assert (blogOwner != null) : "The blogOwner parameter is null";
		
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
