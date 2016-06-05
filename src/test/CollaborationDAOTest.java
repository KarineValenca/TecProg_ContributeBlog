package test;

import static org.junit.Assert.*;

import org.junit.Test;
	
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.Publication;
import dao.CollaborationDAO;

public class CollaborationDAOTest {

	Publication publication = new Publication();
	List<Publication>  pubCollaborative = new ArrayList<>();

	
	@Test
	public void testListCollaborationApprove() throws ParseException {
		CollaborationDAO colaborationDAO = new CollaborationDAO();
		pubCollaborative = colaborationDAO.listCollaborationApprove(1);
		assertEquals(true, pubCollaborative.isEmpty());
	}
	
	@Test
	public void testlistPublication() throws ParseException {
		CollaborationDAO colaborationDAO = new CollaborationDAO();
		String idPublication = "1";
		assertNotNull(colaborationDAO.listPublication(idPublication));
	}

}
