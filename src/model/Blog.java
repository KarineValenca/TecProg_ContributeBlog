/**
 * Class name: Blog.java
 * Purpose of file: This file contains the Blog class and its methods.
 * Copyright: This software follows GPL license.
 **/

package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Class name: Blog
 * Purpose of class: This class is used to store all attributes from a blog.
 **/
public class Blog {
	private int idBlog;
	private String title;
	private String categorie;
	private Date creationDate;
	private BlogOwner idOwnerBlog;
	private List<Publication> publications;

	public Blog() {
	}

	public Blog(int idBlog, String title, String categorie, Date creationDate,
		      BlogOwner idOwnerBlog, List<Publication> publications) {
		this.idBlog = idBlog;
		this.title = title;
		this.categorie = categorie;
		this.creationDate = creationDate;
		this.idOwnerBlog = idOwnerBlog;
		this.publications = publications;
	}

	public int getIdBlog() {
		return idBlog;
	}
	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public BlogOwner getIdOwnerBlog() {
		return idOwnerBlog;
	}
	public void setIdOwnerBlog(BlogOwner idOwnerBlog) {
		this. idOwnerBlog = idOwnerBlog;
	}

	public List<Publication> getPublications() {
		return publications;
	}
	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

}

