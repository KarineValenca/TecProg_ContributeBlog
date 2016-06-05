/**
 * File name:PublicationGeneral.java
 * Purpose of file: This file contains the PublicationGeneral DAO class and its methods.
 * Copyright: This software follows GPL license.
 */

package dao;

import model.Publication;

/**
 * Class name: PublicationGeneral
 * Purpose of class: This class is used to createPublication and listPublication, about Generals Publications.
 * This class that implements interface standard.
 */
public interface PublicationGeneral {
            /**
             * Method name: createPublication
             * Purpose of method: Represents the association of a text publication with a blog.
             * @param idBlog: used to identify the blog.
             * @param publicacao: The text of the publication that will be associated with the blog
             * @param idPublication: the text identifier in the system
             * @return 
             */
	public boolean createPublication(int idBlog, Publication publication);

            /**
             * Method name: listPublication
             * Purpose of method: Matches the publication of Data Display you want to input the
             * identification attribute it.
             * @param idPublication: used to identify the publication.
             * @return: Returns a list of publications
             */
	public Publication  listPublication(String idPublication);
}
