package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import dao.BlogDAO;
import dao.PublicationDAO;
import model.Blog;
import model.Publication;

public class PublicationDAOTest {
	
	@Test	
	public void TestCreatePublication(){
			
		Publication publication = new Publication();
		publication.setIdPublication(100);
		publication.setTitlePublication("test");
		publication.setCategoryPublication("catTest"); 
		publication.setContentPublication("test test"); 
		publication.setGradePublication(0);
		
		PublicationDAO publicationDAO = new PublicationDAO();
		boolean wasCreated = false;
		wasCreated = publicationDAO.createPublication(102, publication);
		assertTrue(wasCreated);
	}
	
	@Test	
	public void TestFailCreatePublication(){
		
		Publication publication = new Publication();
		publication.setIdPublication(100);
		publication.setTitlePublication("test");
		publication.setCategoryPublication("catTest"); 
		publication.setContentPublication("test test"); 
		publication.setGradePublication(0);
		
		PublicationDAO publicationDAO = new PublicationDAO();
		boolean wasCreated = false;
		wasCreated = publicationDAO.createPublication(-1, publication);
		assertFalse(wasCreated);
	}
	
	@Test
	public void testDeletePublication() {
		
		PublicationDAO publicationDAO = new PublicationDAO();
		assertTrue(publicationDAO.deletePublication(100));	
	}
	
	@Test
	public void testFailDeletePublication() {
		
		PublicationDAO publicationDAO = new PublicationDAO();
		assertFalse(publicationDAO.deletePublication(-1));	
	}
}
