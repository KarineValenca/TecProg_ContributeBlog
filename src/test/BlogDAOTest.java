package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
	
import dao.ConnectionFactory;
import dao.BlogDAO;
import dao.BlogOwnerDAO;
import dao.UserDAO;
import model.Blog;
import model.BlogOwner;
import model.Publication;
import model.User;

public class BlogDAOTest {

	@Test
	public void testCreateBlog() throws ParseException {
		
		Date now = new Date(0);
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		
		User user = new User();
		user.setName("test2");
		user.setLastName("test2");
		user.setEmail("test2@test.com");
		user.setGender("Masculino");
		user.setPassword("test2");
		user.setNickname("test2");
		user.setBirthDate(sqlDate);
		
		UserDAO userDAO = new UserDAO();
		userDAO.createUser(user);
        
		BlogOwner donoBlog = new BlogOwner();
		donoBlog.setId(100);
        
		List<Publication> publications = new ArrayList<>();
		
		Blog blog = new Blog();
		blog.setTitle("testeeeeee");
		blog.setCategorie("tester");
		blog.setCreationDate(sqlDate);
		blog.setIdOwnerBlog(donoBlog);
		blog.setPublications(publications);
		
		boolean wasCreated1 = false;
		BlogDAO blogDAO = new BlogDAO();
		wasCreated1 = blogDAO.createBlog(blog, donoBlog);
		assertTrue(wasCreated1);
	}
	
	@Test
	public void testFailCreateBlog() {
		
		BlogOwner donoBlog = new BlogOwner();
		
		List<Publication> publications = new ArrayList<>();
		Date now = new Date(0);
		java.sql.Date sqlDate = new java.sql.Date(now.getTime());
		Blog blog = new Blog();
		
		blog.setTitle("testeeeeee");
		blog.setCategorie("tester");
		blog.setCreationDate(sqlDate);
		blog.setIdOwnerBlog(donoBlog);
		blog.setPublications(publications);
		
		boolean wasCreated = false;
		BlogDAO blogDAO = new BlogDAO();
		wasCreated = blogDAO.createBlog(blog, donoBlog);
		assertFalse(wasCreated);
	}
	
	@Test
	public void testDeleteBlog() {
		boolean wasDeleted = false;
		BlogDAO blogDAO = new BlogDAO();
		
		wasDeleted = blogDAO.deleteBlog(100);
		
		assertTrue(wasDeleted);	
	}
		
	@Test
	public void testFailDeleteBlog(){
		boolean wasDeleted = false;
		BlogDAO blogDAO = new BlogDAO();
		
		wasDeleted = blogDAO.deleteBlog(-1);
		
		assertFalse(wasDeleted);	
		
	}

}
