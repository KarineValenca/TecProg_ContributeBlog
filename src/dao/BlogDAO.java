/**
 * File name: BlogDAO.java
 * Purpose of class: This file corresponds to persistence class Blog.
 * Copyright: This software follows GPL license.
 */

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

/**
 * Class name: BlogDAO
 * Purpose of class: This class is used to create, list, delete and list blog publication
 */
public class BlogDAO extends ConnectionFactory {

	/**
	 * Method name: createBlog
	 * Purpose of method: This method is used for the User to create a blog in the system
	 * @param Blog: Used to receive blog you want to create
	 * @param donoBlog: Given regarding the blog owner object
	 */
	public void createBlog(Blog blog, BlogOwner donoBlog) {
		assert(blog != null) : "Unexpected error: the attribute blog is receiving null";
		assert(donoBlog != null ) : "Unexpected error: the donoBlog is receiving null";
		Date now = new Date();
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		try {
			Connection connetion = getConnection();
			PreparedStatement pstm = connetion.prepareStatement("INSERT INTO Blog"
										   +" (titulo"
						                   			   +",categoria"
						                		                +", dataCriacao"
						                 		                +", idUtilizador)"
						                 		                +" VALUES(?,?,?,?);");
			pstm.setString(1, blog.getTitle());
			pstm.setString(2, blog.getCategorie());
			pstm.setDate(3, sqlDate);
			pstm.setInt(4,donoBlog.getId());
			pstm.execute();
			pstm.close();
			connetion.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method name: listBlog
	 * Purpose of method: This method is used to list all the blogs of the system
	 * @return: Returns a list of blogs
	 */
	public List<Blog> listBlog() {
		List<Blog> listBlog = new ArrayList<>();
		assert(listBlog != null) : "Unexpected error: the attribute listBlog is receiving null";
		try {
			Connection connetion = getConnection();
			Statement stm = connetion.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Blog");

			while (rs.next()) {
				Blog blog = new Blog();
				
				blog.setIdBlog(rs.getInt("idBlog"));
				blog.setTitle(rs.getString("titulo"));
				blog.setCategorie(rs.getString("categoria"));
				listBlog.add(blog);
			}
			stm.close();
			connetion.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listBlog;
	}

	/**
     * Method name: deleteBlog
     * Purpose of method: This method allows you to permanently delete a system blog
     * @param idBlog: Unique identification of a blog
     */
	public void deleteBlog(String idBlog) {
		// FIX-ME: THERE IS AN ERROR, THE IDBLOG ATTRIBUTE SHOULD BE INT NOT STRING.
		assert(idBlog!= null) : "Unexpected error: the attribute idBlog is receiving null";
		try {
			Connection connetion = getConnection();
			PreparedStatement pstm = connetion
					.prepareStatement("Delete from Blog where idBlog ="+idBlog);

			pstm.execute();
			pstm.close();
			connetion.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
     * Method name: listPublicationsBlog
     * Purpose of method: This method allows you to list comments of a publication.
     * @param idBlog: Unique identification of a blog
     * @return: Returns a list of blog publication
     */
	public List<Publication> listPublicationBlog(String idBlog) {
		// FIX-ME: THERE IS AN ERROR, THE IDBLOG ATTRIBUTE SHOULD BE INT NOT STRING.
		assert(idBlog!= null) : "Unexpected error: the attribute idBlog is receiving null";
		List<Publication> listPublicationBlog = new ArrayList<>();
		try {
			Connection connetion = getConnection();
			Statement stm = connetion.createStatement();
			ResultSet rs = stm.executeQuery("Select * from Publicacao where idBlog="+idBlog);

			while (rs.next()) {
				Publication publication = new Publication();
				publication.setIdPublication(rs.getInt("idPublication"));
				publication.setTitlePublication(rs.getString("titlePublication"));
				publication.setCategoryPublication(rs.getString("categoryPublication"));
				publication.setContentPublication(rs.getString("contentPublication"));
				publication.setGradePublication(rs.getInt("gradePublication"));
				listPublicationBlog.add(publication);
			}
			stm.close();
			connetion.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listPublicationBlog;
	}
}
