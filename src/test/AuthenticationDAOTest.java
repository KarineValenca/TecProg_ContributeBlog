package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.AuthenticationDAO;
import dao.UserDAO;
import model.User;

public class AuthenticationDAOTest {

	@Test
	public void testSucessAuthentication() {
		AuthenticationDAO authenticationDAO = new AuthenticationDAO();
		User user = new User();
		String email = "admin@admin.com";
		String password = "admin";
		
		user = authenticationDAO.authenticateUser(email, password);
		
		assertEquals("admin@admin.com", user.getEmail());
		assertEquals("admin", user.getPassword());
	}

}
