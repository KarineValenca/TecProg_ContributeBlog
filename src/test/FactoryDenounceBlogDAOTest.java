package test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;

import org.junit.Test;
	
import dao.FactoryDenounceBlogDAO;
import model.Denounce;
import model.User;

public class FactoryDenounceBlogDAOTest {

	@Test
	public void testCreateDenounce() throws ParseException {
		
		Date now = new Date(0);
		int idBlog = 1;
		Denounce denounce = new Denounce();
		denounce.idDenounce = 1;
		denounce.dateDenounce = now;
		denounce.contentDenounce = "teste";
		denounce.idBlog = 1;
		User user = new User();
		user.id = 1;		
		FactoryDenounceBlogDAO factoryDenounceBlogDAO = new FactoryDenounceBlogDAO();
		assertTrue(factoryDenounceBlogDAO.createDenounce(idBlog, denounce, user));
	}
	
	@Test
	public void testFailCreateDenounce() {
		Date now = new Date(0);
		int idBlog = 1;
		Denounce denounce = new Denounce();
		denounce.idDenounce = 1;
		denounce.dateDenounce = now;
		denounce.contentDenounce = "teste";
		denounce.idBlog = 1;
		User user = new User();
		user.id = 1;		
		FactoryDenounceBlogDAO factoryDenounceBlogDAO = new FactoryDenounceBlogDAO();
		assertFalse(factoryDenounceBlogDAO.createDenounce(idBlog, denounce,null));
	}
	
}
