package test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import dao.UserDAO;
import model.User;

public class UserDAOTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testSuccessCreateUser() throws ParseException {
		User user = new User();
		user.setName("test");
		user.setLastName("test");
		user.setEmail("test@test.com");
		user.setGender("Feminino");
		user.setPassword("test");
		user.setNickname("test");
		
		String date = "2014-10-03";
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = formatDate.parse(date);
		user.setBirthDate(birthDate);
		
		UserDAO userDAO = new UserDAO();
		boolean wasCreated = false;
		
		wasCreated = userDAO.createUser(user);
		
		assertTrue(wasCreated);
		
	}

	@Test
	public void testFailCreateUser() throws ParseException{
		User user = new User();
		user.setLastName("test");
		user.setEmail("test@test.com");
		user.setGender("Feminino");
		user.setPassword("test");
		user.setNickname("test");
		
		String date = "2014-10-03";
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = formatDate.parse(date);
		user.setBirthDate(birthDate);
		
		UserDAO userDAO = new UserDAO();
		boolean wasCreated = false;
		
		wasCreated = userDAO.createUser(user);
		
		assertFalse(wasCreated);
	}
	
	@Test
	public void testSuccessDeleteUser(){
		boolean wasDeleted = false;
		UserDAO userDAO = new UserDAO();
		
		wasDeleted = userDAO.deleteUser(1292);
		
		assertTrue(wasDeleted);	
	}
	
	@Test(expected = AssertionError.class)
	public void testFailDeleteUser(){
		boolean wasDeleted = false;
		UserDAO userDAO = new UserDAO();
		
		wasDeleted = userDAO.deleteUser(-1);
		
		assertFalse(wasDeleted);
		
	}
	
	@Test
	public void testSuccessEditUser() throws ParseException{
		User user = new User();
		user.setName("test");
		user.setLastName("test");
		user.setEmail("test@test.com");
		user.setGender("Feminino");
		user.setPassword("test");
		user.setNickname("test");
		
		String date = "2014-10-03";
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = formatDate.parse(date);
		user.setBirthDate(birthDate);
		
		UserDAO userDAO = new UserDAO();
		boolean wasEdited = false;
		wasEdited = userDAO.editUser(user, 1);
		
		assertTrue(wasEdited);
	}
	
	@Test
	public void testSuccessShowUser(){
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		user = userDAO.showUserProfile(1);
		
		assertEquals(user.getName(), "test");
	}
}
