/*
 * Class name: PublicationGeneral.java
 * Purpose of class: This file corresponds to persistence class Publication.
 * Copyright: This software follows GPL license.
 */

package dao;

import model.Publication;

public interface PublicationGeneral {

	public void createPublication(int idBlog, Publication publicacao);
	public Publication  listPublication(String idPublication);

}
