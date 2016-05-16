package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.AuthenticationDAO;
import dao.UserDAO;
import model.User;

public class AuthenticationDAOTest {

	@Test
	public void testSuccessAuthentication() {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		User user = new User();
		String email = "admin@admin.com";
		String password = "admin";
		
		user = authenticationDAO.authenticateUser(email, password);
		
		assertEquals("admin@admin.com", user.getEmail());
		assertEquals("admin", user.getPassword());
	}
	
	@Test
	public void testFailAuthentication() {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		User user = new User();
		String email = "error@error.com";
		String password = "error";
				
		user = authenticationDAO.authenticateUser(email, password);
		
		assertNotEquals("error@error.com", user.getEmail());
		assertEquals("Not authorized", user.getEmail());
		assertNotEquals("error", user.getPassword());
		assertEquals("Not authorized", user.getPassword());
	}
	
	@Test
	public void testFailAuthenticationWrongEmail() {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		User user = new User();
		String email = "error@admin.com";
		String password = "admin";
		
		user = authenticationDAO.authenticateUser(email, password);
		
		assertNotEquals("error@admin.com", user.getEmail());
		assertEquals("Not authorized", user.getEmail());
		assertNotEquals("admin", user.getPassword());
		assertEquals("Not authorized", user.getPassword());
	}

}
