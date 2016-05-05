/*
 * Class name: Publication.java
 * Purpose of class: This class is used to store all attributes from publication.
 * Copyright: This software follows GPL license.
 */

package model;

/**
 * Class name: Publication
 * Purpose of class: This class is used to store all attributes from a publication.
 **/
public class Publication {
	private int idPublication;
	private String titlePublication;
	private String categoryPublication;
	private String contentPublication;
	private Blog idBlog;
	private int gradePublication;
	private boolean statusPublication; //VERIFY THE NEED AND USE OF THIS ATTRIBUTE

	public Publication(){

	}

	public Publication(int idPublication, String titlePublication, String categoryPublication,
			   String contentPublication, Blog idBlog, int gradePublication, boolean  statusPublication){
		this.idPublication = idPublication;
		this.titlePublication = titlePublication;
		this.categoryPublication = categoryPublication;
		this.contentPublication = contentPublication;
		this.idBlog = idBlog;
		this.gradePublication = gradePublication;
		this. statusPublication =  statusPublication;
	}

	public int getIdPublication() {
		return idPublication;
	}
	public void setIdPublication(int idPublication) {
		this.idPublication = idPublication;
	}

	public String getTitlePublication() {
		return titlePublication;
	}
	public void setTitlePublication(String titlePublication) {
		this.titlePublication = titlePublication;
	}

	public String getCategoryPublication() {
		return categoryPublication;
	}
	public void setCategoryPublication(String categoryPublication) {
		this.categoryPublication = categoryPublication;
	}

	public String getContentPublication() {
		return contentPublication;
	}
	public void setContentPublication(String contentPublication) {
		this.contentPublication = contentPublication;
	}

	public int getGradePublication() {
		return gradePublication;
	}
	public void setGradePublication(int gradePublication) {
		this.gradePublication = gradePublication;
	}

	public boolean getStatusPublication() {
		return statusPublication;
	}
	public void setStatusPublication(boolean statusPublication) {
		this.statusPublication = statusPublication;
	}
}
