/**
 * File name: BlogOwnerDAO.java
 * Purpose of file: This file is composed by a BlogOwner class and methods.
 * Copyright: This software follows GPL license.
 */

package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Blog;

/**
 * Class name: BlogOwnerDAO
 * Purpose of class: This class is responsible to create a blogs list.
 */
public class BlogOwnerDAO extends ConnectionFactory{
	
	/**
	 * Method name: BlogOwnerDAO
	 * Purpose of method: This is a constructor method of class.
	 */
	public BlogOwnerDAO() {
		
	}
	
	/**
	 * Method name: listBlogOwner
	 * Purpose of method: This method is used to trys to stablish a connection 
	 * database and creates a blogs list.
	 * @param blogOwner Type of blog user (string).
	 * @return listBlog ArrayList of Blog object instance to store the blogs.
	 */
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
