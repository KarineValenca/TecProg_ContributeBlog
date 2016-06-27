package test;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;
import dao.DenouncePublicationDAO;

public class DenouncePublicationDAOTest {
	
	@Test
	public void testListDenounce() throws ParseException {
		DenouncePublicationDAO denouncePublicationDao = new DenouncePublicationDAO();
		assertNotNull(denouncePublicationDao.listDenounce());
	}

	@Test
	public void testDeleteDenounce() throws ParseException {
		DenouncePublicationDAO denouncePublicationDao = new DenouncePublicationDAO();
		String idDenounce = "1";
		assertTrue(denouncePublicationDao.deleteDenounce(idDenounce));
	}
	
}