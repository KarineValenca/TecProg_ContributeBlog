/** 
 * File name: CollaborativePublication.java
 * Purpose of file: this file contains the class CollaborativePublication and its methods.   
 * Copyright: This software follows GPL license.
 */

package model;

public class CollaborativePublication extends Publication {

	boolean statusPublication;
	User user;

	public CollaborativePublication() {
		// TODO Auto-generated constructor stub
	}

	public CollaborativePublication(int idPublication, String titlePublication,
			String categoryPublication, String contentPublication, Blog idBlog,
			int gradePublication) {
		super(idPublication, titlePublication, categoryPublication,
			  contentPublication,	idBlog, gradePublication);
		// TODO Auto-generated constructor stub
	}
}
