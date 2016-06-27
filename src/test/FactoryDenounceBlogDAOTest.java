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
import dao.FactoryDenounceBlogDAO;
import dao.BlogDAO;
import dao.BlogOwnerDAO;
import dao.UserDAO;
import model.Blog;
import model.BlogOwner;
import model.Denounce;
import model.Publication;
import model.User;

public class FactoryDenounceBlogDAOTest {

	@Test
	public void testCreateDenounce() throws ParseException {
		
		Date now = new Date(0);
		//java.sql.Date sqlDate = new java.sql.Date(now.getTime());
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
		//java.sql.Date sqlDate = new java.sql.Date(now.getTime());
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
