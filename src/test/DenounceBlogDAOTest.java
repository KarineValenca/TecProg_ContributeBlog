package test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import dao.DenounceBlogDAO;

public class DenounceBlogDAOTest {
	
	@Test
	public void testListDenounce() throws ParseException {
		DenounceBlogDAO denounceBlogDao = new DenounceBlogDAO();
		assertNotNull(denounceBlogDao.listDenounce());
	}

	@Test
	public void testDeleteDenounce() throws ParseException {
		DenounceBlogDAO denounceBlogDao = new DenounceBlogDAO();
		String idDenounce = "1";
		assertTrue(denounceBlogDao.deleteDenounce(idDenounce));
	}

	@Test
	public void testsearchBlogDenounce() throws ParseException {
		DenounceBlogDAO denounceBlogDao = new DenounceBlogDAO();
		String idDenounce = "1";
		assertNotNull(denounceBlogDao.searchBlogDenounce(idDenounce));
	}
	
}