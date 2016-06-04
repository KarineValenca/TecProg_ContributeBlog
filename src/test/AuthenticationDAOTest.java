package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.AuthenticationDAO;
import model.User;

public class AuthenticationDAOTest {

	@Test
	public void testSuccessAuthentication() {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		User user = new User();
		String email = "test@test.com";
		String password = "test";
		
		user = authenticationDAO.authenticateUser(email, password);
		
		assertEquals("test@test.com", user.getEmail());
		assertEquals("test", user.getPassword());
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
		String email = "error@test.com";
		String password = "test";
		
		user = authenticationDAO.authenticateUser(email, password);
		
		assertNotEquals("error@admin.com", user.getEmail());
		assertEquals("Not authorized", user.getEmail());
		assertNotEquals("test", user.getPassword());
		assertEquals("Not authorized", user.getPassword());
	}

	@Test
	public void testFailAuthenticationWrongPassword() {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		User user = new User();
		String email = "test@test.com";
		String password = "error";
		
		user = authenticationDAO.authenticateUser(email, password);
		
		assertNotEquals("test@test.com", user.getEmail());
		assertEquals("Not authorized", user.getEmail());
		assertNotEquals("error", user.getPassword());
		assertEquals("Not authorized", user.getPassword());
	}
}
