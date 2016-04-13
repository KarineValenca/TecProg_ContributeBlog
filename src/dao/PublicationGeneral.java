package dao;

import model.Publication;

public interface PublicationGeneral {

	public void createPublication(int idBlog, Publication publicacao);
	public Publication  listPublication(String idPublication);

}
