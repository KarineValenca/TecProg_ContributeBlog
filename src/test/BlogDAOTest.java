package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dao.BlogDAO;
import model.Blog;
import model.BlogOwner;
import model.Publication;

public class BlogDAOTest {

	@Test
	public void testCreateBlog() {
		BlogOwner donoBlog = new BlogOwner();
		List<Publication> publications = new ArrayList<>();
		Blog blog = new Blog();
		boolean wasCreated = false;
		BlogDAO blogDAO = new BlogDAO();
		wasCreated = blogDAO.createBlog(blog, donoBlog);
		assertTrue(wasCreated);
	}

}
